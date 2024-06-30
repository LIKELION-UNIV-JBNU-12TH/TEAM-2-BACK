package com.mysite.lion.repository;

import com.mysite.lion.entity.ProductThumbnail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductThumbnailRepository extends JpaRepository<ProductThumbnail, Long> {
}
