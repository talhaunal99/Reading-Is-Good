//package com.example.RiG.model;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.*;
//
//import javax.persistence.*;
//
//@Builder
//@Setter
//@Getter
//@Entity
//@AllArgsConstructor
//@NoArgsConstructor
//public class OrderDetail {
//
//    @Id
//    @Column(name = "order_detail_id")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @JsonIgnore
//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private Order order;
//
//    @ManyToOne
//    @JoinColumn(name = "book_id")
//    private Book book;
//
//    private Integer quantity;
//
//    @Transient
//    public Double getSubtotal() {
//        return quantity * book.getPrice();
//    }
//}
