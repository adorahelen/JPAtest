package edu.portfolio.jpatest.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 재네레이션 타입은, 디비마다 다르다, 일단 마이에스큐엘은 이거 사용
    private Long id;
    @Column(name = "name", nullable = false, length = 30)
    private String name;
    @Column(name = "nick_name", nullable = false, length = 30, unique = true)
    private String nikName;
    @Column(name = "age", nullable = false)
    private int age;
    @Column(name = "address", nullable = false)
    private String address;
    @Column(name = "description", nullable = true)
    private String description;
}
