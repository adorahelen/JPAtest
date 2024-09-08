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
        // 각 단위가 가지는 고유한 이름을 가지고 팩토리(영속성 단위-단위 각각에 대해 하나의 팩토리가 있다)를 호출한다.

        try {
            EntityManager em = emf.createEntityManager(); // 팩토리 불렀으면, 매니저 생성
            em.getTransaction().begin(); // 표준 트랜잭션 에이피아이 접근, 트랜잭션 시작

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
//	•	순수 JPA를 사용하여 트랜잭션을 직접 관리하고 쿼리를 명시적으로 작성합니다.
//	•	Spring Data JPA나 Hibernate와 같은 라이브러리를 사용하지 않고, JPA의 기본 API를 활용합니다.