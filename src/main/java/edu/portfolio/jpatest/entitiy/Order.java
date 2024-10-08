package edu.portfolio.jpatest.entitiy;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "email", nullable = false)
    private String email;


    @Column(name = "address", length = 200, nullable = false)
    private String address;

    @Column(name = "postcode", length = 200, nullable = false)
    private String postcode;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status", length = 50, nullable = false)
    private OrderStatus orderStatus;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}