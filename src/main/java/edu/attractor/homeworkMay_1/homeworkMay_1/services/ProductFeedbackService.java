package edu.attractor.homeworkMay_1.homeworkMay_1.services;

import edu.attractor.homeworkMay_1.homeworkMay_1.entitys.ProductFeedback;
import edu.attractor.homeworkMay_1.homeworkMay_1.repositories.ProductFeedbackRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductFeedbackService {
    private final ProductFeedbackRepository feedbackRepository;

    public ProductFeedbackService(ProductFeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public ProductFeedback createFeedback(ProductFeedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public List<ProductFeedback> getAllFeedbacks() {
        List<ProductFeedback> productList = new ArrayList<>();
        feedbackRepository.findAll().forEach(productList::add);
        return productList;
    }
}
