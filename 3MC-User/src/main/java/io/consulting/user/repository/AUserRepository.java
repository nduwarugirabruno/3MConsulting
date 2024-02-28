package io.consulting.user.repository;

import io.consulting.user.entity.metier.AUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AUserRepository extends JpaRepository<AUser, Long>{
	@Query("select u from AUser u where u.name like %?1%")
	List<AUser> findByName(String name);

	@Query("select u from AUser u where u.mail like %?1%")
	List<AUser> findByMail(String mail);

	@Query("select u from AUser u where concat(u.number, u.number) like %?1%")
	List<AUser> findByNumber(Long number);
}
