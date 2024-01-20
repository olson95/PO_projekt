package com.example.po_projekt.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Max(255)
    @Column(name = "name")
    private String name;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "producer")
    @Max(255)
    private String producer;

    @Column(name = "image")
    private String imgPath;

    @Column(name = "description")
    @Max(255)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;




}
