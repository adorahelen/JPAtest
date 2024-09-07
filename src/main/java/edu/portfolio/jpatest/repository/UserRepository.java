package edu.portfolio.jpatest.repository;

import edu.portfolio.jpatest.persistence.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {


}
