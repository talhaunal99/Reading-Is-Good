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

//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    OrderDetail orderDetail;

    @NotNull(message = "Product name is required.")
    @Basic(optional = false)
    private String name;

    @Builder.Default
    private int stock = 1;

    private Double price;
}
