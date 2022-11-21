package com.example.RiG.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

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

    @JsonIgnore
    @OneToMany(mappedBy = "customer")
    private Set<Order> orders;


//    @ManyToMany(cascade = CascadeType.MERGE)
//    @JoinColumn(name = "order_id")
//    @JoinTable( name = "customer_order",
//                joinColumns = {@JoinColumn(name = "customer_id")},
//                inverseJoinColumns = {@JoinColumn(name = "order_id")})
//    private List<Order> orders;
}
