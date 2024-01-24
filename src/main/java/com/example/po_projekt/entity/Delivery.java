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
@Table(name = "deliveries")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "clientName")
    private String name;

    @Column(name = "clientLastname")
    private String lastname;

    @Column(name = "street")
    private String street;

    @Column(name = "numberOfHouse")
    private String numberOfHouse;

    @Column(name = "numberOfApartment")
    private String numberOfApartment;

    @Column(name = "zipCode")
    private String zipCode;

    @Column(name = "city")
    private String city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private DevStatus status;



}

