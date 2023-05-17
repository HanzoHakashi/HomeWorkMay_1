package edu.attractor.homeworkMay_1.homeworkMay_1.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;


import javax.sql.DataSource;

@Configuration
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final DataSource dataSource;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {


//                .formLogin()
//                .loginPage("/login")
//                .successHandler(successHandler()) // Set the magnificent success handler
//                .permitAll()
//                .and()
//                .logout()
//                .logoutSuccessUrl("/")
//                .permitAll()
//                .and()
//                .authorizeRequests()
        http.formLogin(Customizer.withDefaults());
//                .loginPage("/login")
//                .failureUrl("/login?error=true");

        http.logout(Customizer.withDefaults());
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/")
//                .clearAuthentication(true)
//                .invalidateHttpSession(true);
//                http.authorizeRequests().antMatchers("/profile").authenticated()
//                .anyRequest().permitAll()
//                .and()
//                .csrf().disable();

        http.authorizeRequests()
                .antMatchers("/profile")
                .authenticated()
                .and()
                .authorizeRequests()
                .anyRequest()
                .permitAll();

        http.csrf().disable();
    }


    private AuthenticationSuccessHandler successHandler() {
        SimpleUrlAuthenticationSuccessHandler handler = new SimpleUrlAuthenticationSuccessHandler();
        handler.setDefaultTargetUrl("/profile");
        return handler;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        String fetchUsersQuery = "select email, password,active"
                + " from usr"
                + " where email = ?";

        String fetchRolesQuery = "select email,role"
                + " from usr"
                + " where email = ?";

        auth.jdbcAuthentication()
                .usersByUsernameQuery(fetchUsersQuery)
                .authoritiesByUsernameQuery(fetchRolesQuery)
                .dataSource(dataSource);
    }
}
