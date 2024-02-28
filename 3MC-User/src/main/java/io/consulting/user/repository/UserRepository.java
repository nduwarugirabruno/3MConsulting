package io.consulting.user.repository;

import io.consulting.user.entity.metier.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	@Query("select u from User u where u.name like %?1%")
	List<User> findByName(String name);

	@Query("select u from User u where u.mail like %?1%")
	List<User> findByMail(String mail);

	@Query("select u from User u where concat(u.number, u.number) like %?1%")
	List<User> findByNumber(Long number);
}
