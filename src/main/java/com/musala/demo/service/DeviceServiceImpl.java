package com.musala.demo.service;

import com.musala.demo.domain.Device;
import com.musala.demo.domain.Gateway;
import com.musala.demo.enums.ApplicationError;
import com.musala.demo.exception.MusalaException;
import com.musala.demo.model.DeviceCreateRequest;
import com.musala.demo.model.GatewayCreateRespose;
import com.musala.demo.repository.GatewaRepository;
import com.musala.demo.util.MusalaUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musala.demo.repository.DeviceRepository;

import java.util.Date;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private GatewayService gatewayService;

    @Override
    public String saveGateway(DeviceCreateRequest createRequest) {
        if (createRequest.getGatewayId() != null) {
            if (MusalaUtill.isStringNullOrEmpty(createRequest.getVendor())) {
                if (MusalaUtill.isStringNullOrEmpty(createRequest.getCreatedDate())) {
                    Date cDate = MusalaUtill.getDateFromString(createRequest.getCreatedDate());
                    if (cDate != null) {
                        GatewayCreateRespose gateway = gatewayService.getById(createRequest.getGatewayId());
                        if (gateway != null) {
                            Device device = new Device();
                            device.setCreatedDate(cDate);
                            device.setStatus(createRequest.getStatus());
                            device.setUid(createRequest.getUid());
                            device.setVendor(createRequest.getVendor());

                            Gateway sGateway = new Gateway();
                            sGateway.setId(gateway.getId());
                            device.setGateway(sGateway);

                            device = deviceRepository.save(device);
                            if (device != null) {
                                return "SUCCESS";
                            } else {
                                throw new MusalaException(ApplicationError.DEVICE_NOT_SAVED);
                            }
                        } else {
                            throw new MusalaException(ApplicationError.INVALID_GATEWAY_ID);
                        }
                    } else {
                        throw new MusalaException(ApplicationError.INVALID_DATE);
                    }
                } else {
                    throw new MusalaException(ApplicationError.CREATED_DATE_REQUIRED);
                }
            } else {
                throw new MusalaException(ApplicationError.VENDOR_REQUIRED);
            }
        } else {
            throw new MusalaException(ApplicationError.INVALID_GATEWAY_ID);
        }
    }
}
