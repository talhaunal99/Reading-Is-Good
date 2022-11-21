package com.example.RiG.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @NotNull(message = "Customer email is required.")
    @Basic(optional = false)
    private String email;

    private String phone;
    private String address;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "order_id")
    @JoinTable( name = "customer_order",
                joinColumns = {@JoinColumn(name = "customer_id")},
                inverseJoinColumns = {@JoinColumn(name = "order_id")})
    private List<Order> orders;
}
