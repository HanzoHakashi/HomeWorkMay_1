package edu.attractor.homeworkMay_1.homeworkMay_1.controllers;

import edu.attractor.homeworkMay_1.homeworkMay_1.dtos.ProductDto;
import edu.attractor.homeworkMay_1.homeworkMay_1.entitys.Product;
import edu.attractor.homeworkMay_1.homeworkMay_1.entitys.ProductFeedback;
import edu.attractor.homeworkMay_1.homeworkMay_1.mappers.ProductMapper;
import edu.attractor.homeworkMay_1.homeworkMay_1.services.ProductFeedbackService;
import edu.attractor.homeworkMay_1.homeworkMay_1.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Random;

@Controller
@RequestMapping("/product/feedback")
@AllArgsConstructor
public class ProductFeedbackController {

    private final ProductFeedbackService feedbackService;
    private ProductService productService;
    private ProductMapper productMapper;


    @GetMapping("/{productId}")
    public String showFeedbackForm(@PathVariable Long productId, Model model) {

        model.addAttribute("productId", productId);
        model.addAttribute("feedback", new ProductFeedback());
        return "feedback_form";
    }

    @PostMapping("/{productId}")
    public String submitFeedback(@PathVariable Long productId, @ModelAttribute("feedback") ProductFeedback feedback) {
        Optional<Product> optionalProduct = productService.getProductById(productId);

        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            feedback.setProduct(product);
            feedback.getProduct().setId(product.getId());
            Long min = 1000L;
            Long max = 99999L;
            Long tokenValue = min + (long) (Math.random() * (max - min + 1));
            feedback.setId(tokenValue);
            System.out.println(feedback.getId());
            feedbackService.createFeedback(feedback);
        } else {

            return "redirect:/error";
        }

        return "redirect:/product/{productId}";
    }
}
