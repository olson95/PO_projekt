package com.example.po_projekt.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "offers")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "QuantityInStock", nullable = false)
    private int quantityInStock;

    @Column(name = "discount")
    private double discount;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
