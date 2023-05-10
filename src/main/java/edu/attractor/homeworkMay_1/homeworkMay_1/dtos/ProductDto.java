package edu.attractor.homeworkMay_1.homeworkMay_1.dtos;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Data
public class ProductDto {
    @NotNull
    @Size(min = 3, max = 30)
    private String name;
    private String image;
    private Integer quantity;
    private String description;
    private Double price;
}
