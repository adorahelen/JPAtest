package edu.portfolio.jpatest.ch2;

import edu.portfolio.jpatest.persistence.Message;
import edu.portfolio.jpatest.repository.MessageRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
// @ExtendWith(SpringExtension.class) : 테스트를 확장하는 어노테이션 JUnit5
//@ContextConfiguration(classes = {SpringDataConfiguration.class}) : 컨피그, 빈 스캔
public class HelloWorldSpringDataJPATest {

    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void storeLoadMessage() {
        Message message = new Message();
        message.setText("Hello World from Spring Data JPA!");

        messageRepository.save(message);

        List<Message> messages = (List<Message>) messageRepository.findAll();

        assertAll(
                () -> assertEquals(1, messages.size()),
                () -> assertEquals("Hello World from Spring Data JPA!", messages.get(0).getText())
        );

    }
}// 이전까지 진행 한 방식들
// 1. JDBC (쿼리문을 그대로 작성한다, 단지 자바로 작성할 뿐 )

// 2. 쌩 JPA 사용 ( 엔티티매니저, 엔티티팩토리 등 사용)
// 3. 하이버네이트 사용 (잘 모르겠음)
// 4. 스프링 데이터 JPA 사용 (리포지토리 사용하는 방식)  *****