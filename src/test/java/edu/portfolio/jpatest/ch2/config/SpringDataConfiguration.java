//package edu.portfolio.jpatest.ch2.config;
//
//import jakarta.persistence.EntityManagerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.JpaVendorAdapter;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.Database;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//
//
//import javax.sql.DataSource;
//import java.util.Properties;
//
//@EnableJpaRepositories("com.manning.javapersistence.ch02.repositories")
//public class SpringDataConfiguration {
//    @Bean
//    public DataSource dataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/CH02?serverTimezone=UTC");
//        dataSource.setUsername("root");
//        dataSource.setPassword("");
//        return dataSource;
//    }
//
//    @Bean
//    public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
//        return new JpaTransactionManager(emf);
//    }
//
//    @Bean
//    public JpaVendorAdapter jpaVendorAdapter() {
//        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
//        jpaVendorAdapter.setDatabase(Database.MYSQL);
//        jpaVendorAdapter.setShowSql(true);
//        return jpaVendorAdapter;
//    }
//
//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean =
//                new LocalContainerEntityManagerFactoryBean();
//        localContainerEntityManagerFactoryBean.setDataSource(dataSource());
//        Properties properties = new Properties();
//        properties.put("hibernate.hbm2ddl.auto", "create");
//        localContainerEntityManagerFactoryBean.setJpaProperties(properties);
//        localContainerEntityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
//        localContainerEntityManagerFactoryBean.setPackagesToScan("com.manning.javapersistence.ch02");
//        return localContainerEntityManagerFactoryBean;
//    }
//}
//스프링 데이터 JPA 표준 구성은,
//스프링 데이터에서 필요로 하는 빈을 생성하고 설정하는 자바 클래스
//구성은 1. XML 파일(그래들) 의존성 추가 2. 자바 코드 사용 인데
//        이 파일은 두번째 방법으로 진행함

// 나는 프로퍼티스 파일에 디비 연결 + 그래들 의존성 추가로 이를 대신하였다.
// 결과 -> 사용자는 "리포지토리 인터페이스" 하나만 구현하면 된다. (정의)