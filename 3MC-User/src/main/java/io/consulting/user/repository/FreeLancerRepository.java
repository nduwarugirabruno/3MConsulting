package com.digital.mcdigital.repository;

import com.digital.mcdigital.entity.metier.FreeLancer;
import com.digital.mcdigital.entity.metier.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FreeLancerRepository extends JpaRepository<FreeLancer, Long>{
	@Query("select fl from FreeLancer fl where fl.name like %?1%")
	List<FreeLancer> findByName(String name);

	@Query("select fl from FreeLancer fl where fl.mail like %?1%")
	List<FreeLancer> findByMail(String mail);

	@Query("select fl from FreeLancer fl where concat(fl.number, fl.number) like %?1%")
	List<FreeLancer> findByNumber(Long number);
}
