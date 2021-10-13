package com.musala.demo.repository;

import com.musala.demo.domain.Gateway;
import com.musala.demo.model.DeviceResponse;
import com.musala.demo.model.GatewayCreateRespose;
import org.springframework.data.jpa.repository.JpaRepository;

import com.musala.demo.domain.Device;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Integer> {

    List<Device> findDevicesBygateway(Gateway gateway);
}
