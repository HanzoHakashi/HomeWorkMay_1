package edu.attractor.homeworkMay_1.homeworkMay_1.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ProductDto {
    private String name;
    private String image;
    private Integer quantity;
    private String description;
    private Double price;
}
