package com.musala.demo.service;

import com.musala.demo.model.DeviceCreateRequest;
import com.musala.demo.model.DeviceResponse;

import java.util.List;

public interface DeviceService {
    String saveDevice(DeviceCreateRequest createRequest);

    List<DeviceResponse> getDeviceByGatewayId(int gatewayId);

    String deleteDevice(int deviceId);
}
