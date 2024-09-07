package edu.portfolio.jpatest;

import edu.portfolio.jpatest.persistence.User;
import edu.portfolio.jpatest.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
public class JpAtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpAtestApplication.class, args);
    }

    @Bean
    public ApplicationRunner configure(UserRepository userRepository) {
        return env -> {
            User user1 = new User("beth", LocalDate.of(2020, Month.AUGUST,3));
            User user2 = new User("beth", LocalDate.of(2020, Month.AUGUST,4));

            userRepository.save(user1);
            userRepository.save(user2);

            userRepository.findAll().forEach(System.out::println);
        };
        //User{id=1, username='beth', registrationDate=2020-08-03}
        //User{id=2, username='beth', registrationDate=2020-08-04}
    }

}
