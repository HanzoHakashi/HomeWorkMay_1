package edu.attractor.homeworkMay_1.homeworkMay_1.services;

import edu.attractor.homeworkMay_1.homeworkMay_1.entitys.Cart;
import edu.attractor.homeworkMay_1.homeworkMay_1.repositories.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@AllArgsConstructor
public class CartService {

    private final CartRepository cartRepository;



    public void addToCart(Long productId, int quantity, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }

        session.setAttribute("cart", cart);
    }


    public void checkout(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null) {
            session.removeAttribute("cart");
        }
    }
}
