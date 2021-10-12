package com.musala.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musala.demo.domain.Device;

public interface DeviceRepository extends JpaRepository<Device, Integer> {
	
}
