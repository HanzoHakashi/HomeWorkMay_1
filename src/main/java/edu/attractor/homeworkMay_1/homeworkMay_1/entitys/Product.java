package edu.attractor.homeworkMay_1.homeworkMay_1.entitys;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@Setter(value = AccessLevel.PACKAGE)
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private Integer quantity;
    private String description;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}
