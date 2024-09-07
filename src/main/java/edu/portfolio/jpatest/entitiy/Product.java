package edu.portfolio.jpatest.entitiy;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    // 문제를 일으킨 부분은 product_id 필드에 대해 BINARY(16)와 AUTO_INCREMENT를 동시에 사용하려고 한 것입니다.
    // 	•	BINARY(16): 이 데이터 타입은 고정 길이의 이진 데이터를 저장합니다. UUID와 같은 이진 데이터를 저장할 때 사용되며, 일반적으로는 기본 키로 사용하지 않습니다.
    //	•	AUTO_INCREMENT: AUTO_INCREMENT는 MySQL에서 정수 타입(INT, BIGINT 등)에만 사용할 수 있습니다. 이 기능은 새로운 레코드가 추가될 때 자동으로 증가하는 정수 값을 기본 키로 지정합니다.

    @Column(name = "product_name", length = 20, nullable = false)
    private String productName;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", length = 50, nullable = false)
    private Category category;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}