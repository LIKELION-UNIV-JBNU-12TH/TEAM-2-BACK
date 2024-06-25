package com.mysite.lion.dto;

import com.mysite.lion.entity.ProductThumbnail;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private String name;
    private String description;
    private Long price;
    private Long stock;
    private String sellerId;
    private ProductThumbnail productThumbnail;
}
