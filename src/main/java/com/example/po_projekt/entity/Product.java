package com.example.po_projekt.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import lombok.*;
import org.apache.tomcat.util.codec.binary.Base64;

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
    private long id;

//    @Max(255)
    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;


    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "producer")
//    @Max(255)
    private String producer;

    @Column(name = "description")
//    @Max(255)
    private String description;

//    @Column(name = "image")
//    private String image;

    @Column(name = "quantity")
    private Integer quantity;

    @Lob
    @Column
    private byte[] imageData;

    public String generateBase64Image() {
        return Base64.encodeBase64String(this.imageData);
    }

}
