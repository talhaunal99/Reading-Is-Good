package com.example.RiG.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Builder
@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(  fetch = FetchType.LAZY,
                mappedBy = "book")
    @JoinColumn(name = "order_id")
    Order order;

    @NotNull(message = "Product name is required.")
    @Basic(optional = false)
    private String name;

    @Builder.Default
    private Integer stock = 1;

    private Double price;
}
