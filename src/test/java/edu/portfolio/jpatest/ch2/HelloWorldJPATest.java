package edu.portfolio.jpatest.ch2;

import edu.portfolio.jpatest.persistence.Message;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloWorldJPATest {

    @Test
    public void storeLoadMessage() {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("ch02");

        try {
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Message message = new Message();
            message.setText("Hello World!");

            em.persist(message);

            em.getTransaction().commit();
            //INSERT into MESSAGE (ID, TEXT) values (1, 'Hello World!')

            em.getTransaction().begin();

            List<Message> messages =
                    em.createQuery("select m from Message m", Message.class).getResultList();
            //SELECT * from MESSAGE

            messages.get(messages.size() - 1).setText("Hello World from JPA!");

            em.getTransaction().commit();
            //UPDATE MESSAGE set TEXT = 'Hello World from JPA!' where ID = 1

            assertAll(
                    () -> assertEquals(3, messages.size()),
                    () -> assertEquals("Hello World from JPA!", messages.get(0).getText())
            );

            em.close();

        } finally {
            emf.close();
        }
    }
    // 스프링 부트 JPA 대신 순수한 JPA(Java Persistence API)를 사용하여 데이터베이스에 데이터를 저장하고 조회
    // Spring Data JPA는 JPA를 더 편리하게 사용하도록 도와주지만, 기본적으로는 JPA 위에 구축된 기술

}