package com.example.RiG.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @OneToMany
    private List<OrderDetail> orderDetails;

    @CreationTimestamp
    private LocalDateTime orderDate;

    @Transient
    public Double getTotalOrderPrice() {
        double sum = 0D;
        List<OrderDetail> orderDetails = getOrderDetails();
        for (OrderDetail od : orderDetails) {
            sum += od.getSubtotal();
        }
        return sum;
    }

}
