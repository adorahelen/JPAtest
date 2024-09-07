package edu.portfolio.jpatest.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "USERS")
public class User {
    // 1. EntityManagerFactory
    // * 엔티티를 관리하는 엔티티 매니저를 생성하는 공장입니다.

    // 2. Entity Manager
    // - 엔티티 매니저는 엔티티를 저장하고, 수정하고, 삭제하고, 조회하는 CRUD 등 엔티티와 관련된 일 처

    // 영속성 컨텍스트 그리고 데이터 베이스 저장
    // JPA 는 트랜잭션을 커밋하는 순간 영속성 컨텍스트에 새로  저장된 엔티티를 반영한다



    @Id
    @GeneratedValue // 자동으로, 아이디를 생성해 준다.
    private Long id;

    private String username;

    private LocalDate registrationDate;

    public User() {}

    public User(String username) {
        this.username = username;
    }

    public User(String username, LocalDate registrationDate) {
        this.username = username;
        this.registrationDate = registrationDate;
    }

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", registrationDate=" + registrationDate +
                '}';
    }
}
