package com.musala.demo.service;

import com.musala.demo.model.DeviceCreateRequest;

public interface DeviceService {
    String saveGateway(DeviceCreateRequest createRequest);
}
