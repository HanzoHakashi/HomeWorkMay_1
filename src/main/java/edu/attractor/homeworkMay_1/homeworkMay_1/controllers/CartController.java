package edu.attractor.homeworkMay_1.homeworkMay_1.controllers;

import edu.attractor.homeworkMay_1.homeworkMay_1.entitys.Cart;
import edu.attractor.homeworkMay_1.homeworkMay_1.services.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;



    @PostMapping("/add")
    public void addToCart(@RequestParam Long productId, @RequestParam int quantity, HttpSession session) {
        cartService.addToCart(productId, quantity, session);
    }



    @PostMapping("/checkout")
    public void checkout(HttpSession session) {
        cartService.checkout(session);
    }
}
