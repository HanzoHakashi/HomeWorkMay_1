package edu.attractor.homeworkMay_1.homeworkMay_1.controllers;

import edu.attractor.homeworkMay_1.homeworkMay_1.dtos.ProductDto;
import edu.attractor.homeworkMay_1.homeworkMay_1.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class HomePageController {
    private final ProductService productService;
    @GetMapping("/")
    public String index(ModelMap model) {
        Page<ProductDto> productsPage = productService.getProducts(0, 10);

        model.put("products", productsPage);
        return "products";
    }
}
