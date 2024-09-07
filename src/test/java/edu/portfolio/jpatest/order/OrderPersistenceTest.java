package edu.portfolio.jpatest.order;

import edu.portfolio.jpatest.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderPersistenceTest {

    @Autowired
    EntityManagerFactory em;

    @Test
    void member_insert(){
        Member member = new Member();
        member.setName("John Doe");
        member.setAddress("123 Main St");
        member.setAge(333);
        member.setNikName("John Doe");
        member.setDescription("John Doe");

        EntityManager entityManager = em.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(member);
        transaction.commit();
        entityManager.close();


    }
}
