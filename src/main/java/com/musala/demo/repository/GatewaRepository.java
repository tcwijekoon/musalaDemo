package com.musala.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.musala.demo.domain.Gateway;
import com.musala.demo.model.GatewayCreateRespose;

public interface GatewaRepository extends JpaRepository<Gateway, Integer> {
	
	Gateway findByserial(String serial);
	
	@Query("SELECT new com.musala.demo.model.GatewayCreateRespose(g.id,g.serial,g.name,g.ip) " +
			"FROM Gateway g")
	List<GatewayCreateRespose> getAll();
	
}
