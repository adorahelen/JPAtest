package edu.portfolio.jpatest.repository;

import edu.portfolio.jpatest.persistence.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {
    // 위에 처럼, 이렇게되면 -> 상속된 여러가지 메소드들을 통해 데이터를 다룰 수 있으며
    // 다른 추가 정보 없이도 이를 이용해 데이터베이스에 대한 일반적인 연산을 실행 할 수 있다.
    // * 또한 스프링 데이터 JPA 는 MessageRepository 인터페이스를 구현하는 프락시 클래스를 생성한다.
}
// 프락시 클래스는 눈에 보이지 않아?? ->

//맞습니다. Spring Data JPA가 MessageRepository 인터페이스를 구현하는 프록시 클래스를 자동으로 생성합니다.
//이 프록시 클래스는 인터페이스에서 선언한 메소드를 실제 데이터베이스 작업으로 변환합니다.
//
//프록시 클래스의 역할
//
//	1.	메소드 구현:
//        •	Spring Data JPA는 CrudRepository와 같은 인터페이스를 구현하는 프록시 클래스를 생성합니다. 이 프록시 클래스는 인터페이스에서 정의된 메소드의 실제 구현을 제공합니다. 예를 들어, findAll, save, findById, deleteById와 같은 메소드들이 자동으로 구현됩니다.
//        2.	쿼리 메소드 지원:
//        •	인터페이스에 메소드 이름만 정의해도, Spring Data JPA는 메소드 이름을 분석하여 쿼리를 자동으로 생성합니다. 예를 들어, findByText라는 메소드가 있으면, Spring Data JPA는 TEXT 필드로 데이터를 조회하는 쿼리를 생성합니다.
//        3.	트랜잭션 관리:
//        •	프록시 클래스는 트랜잭션 관리도 처리합니다. 데이터베이스 연산이 트랜잭션 범위 내에서 실행되도록 보장합니다.
//	4.	성능 최적화:
//        •	Spring Data JPA는 데이터베이스와의 상호작용을 효율적으로 처리하기 위해 여러 가지 최적화 기법을 사용합니다.
//
//프록시 클래스를 보는 방법
//
//프록시 클래스는 컴파일 시점에 생성되며, 일반적으로 IDE에서는 보이지 않습니다. 그러나 런타임에는 클래스 파일을 통해 생성된 프록시 클래스를 볼 수 있습니다. 몇 가지 방법으로 프록시 클래스를 확인할 수 있습니다: