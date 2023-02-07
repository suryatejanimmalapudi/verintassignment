package com.verint.ecommerce.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="product")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private ProductCategory category;

    @Column(name = "sku")
    private String sku;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "unit_price")
    private BigDecimal unitPrice;
    @Column(name = "discount")
    private int discountpercentage;
    @Column(name = "finalprice")
    @Setter(value = AccessLevel.NONE)
    private BigDecimal finalPrice;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "active")
    private boolean active;

    @Column(name = "units_in_stock")
    private int unitsInStock;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;

    public void setFinalPrice(BigDecimal finalPrice) {
        this.finalPrice = this.unitPrice.subtract(
            (this.unitPrice.multiply(BigDecimal.valueOf(discountpercentage))).divide(BigDecimal.valueOf(100)));
    }
}
