package com.mysite.lion.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Getter
@Setter
@Builder
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NonNull
    private Long id;

    @NonNull
    private String name;

    private String description;

    @NonNull
    private Long price;
    private Long stock;

    @Column(name = "seller_id", nullable=false)
    private String sellerId;

    @OneToOne
    @JoinColumn(name = "thumbnail_id", referencedColumnName = "id")
    private ProductThumbnail thumbnailId; // FK


}
