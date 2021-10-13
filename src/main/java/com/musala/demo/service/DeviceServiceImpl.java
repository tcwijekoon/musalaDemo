package com.musala.demo.service;

import com.musala.demo.domain.Device;
import com.musala.demo.domain.Gateway;
import com.musala.demo.enums.ApplicationError;
import com.musala.demo.exception.MusalaException;
import com.musala.demo.model.DeviceCreateRequest;
import com.musala.demo.model.DeviceResponse;
import com.musala.demo.model.GatewayCreateRespose;
import com.musala.demo.repository.DeviceRepository;
import com.musala.demo.repository.GatewaRepository;
import com.musala.demo.util.MusalaUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private GatewayService gatewayService;

    @Autowired
    private GatewaRepository gatewaRepository;

    @Override
    public String saveDevice(DeviceCreateRequest createRequest) {
        if (createRequest.getGatewayId() != null) {
            if (getDeviceByGatewayId(createRequest.getGatewayId()).size() <= 10) {
                if (MusalaUtill.isStringNullOrEmpty(createRequest.getVendor())) {
                    if (MusalaUtill.isStringNullOrEmpty(createRequest.getCreatedDate())) {
                        if (MusalaUtill.isStringNullOrEmpty(createRequest.getStatus())) {
                            if (createRequest.getStatus().equalsIgnoreCase("ON") || createRequest.getStatus().equalsIgnoreCase("OFF")) {
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
                                throw new MusalaException(ApplicationError.INVALID_STATUS);
                            }
                        } else {
                            throw new MusalaException(ApplicationError.STATUS_REQUIRED);
                        }
                    } else {
                        throw new MusalaException(ApplicationError.CREATED_DATE_REQUIRED);
                    }
                } else {
                    throw new MusalaException(ApplicationError.VENDOR_REQUIRED);
                }
            } else {
                throw new MusalaException(ApplicationError.MAX_DEVICES_ADDED);
            }
        } else {
            throw new MusalaException(ApplicationError.INVALID_GATEWAY_ID);
        }
    }

    @Override
    public List<DeviceResponse> getDeviceByGatewayId(int gatewayId) {

        Gateway gateway = gatewaRepository.getById(gatewayId);

        if (gateway != null) {

            List<Device> devices = deviceRepository.findDevicesBygateway(gateway);

            if (devices != null && devices.size() > 0) {
                List<DeviceResponse> deviceResponses = new ArrayList<DeviceResponse>();
                for (Device device : devices) {
                    DeviceResponse deviceResponse = new DeviceResponse();
                    deviceResponse.setId(device.getId());
                    deviceResponse.setStatus(device.getStatus());
                    deviceResponse.setUid(device.getUid());
                    deviceResponse.setVendor(device.getVendor());

                    SimpleDateFormat createdDate = new SimpleDateFormat("yyyy-MM-dd");

                    deviceResponse.setCreatedDate(createdDate.format(device.getCreatedDate()));

                    deviceResponses.add(deviceResponse);
                }

                return deviceResponses;

            } else {
                throw new MusalaException(ApplicationError.GATEWAY_NOT_SAVED);
            }
        } else {
            throw new MusalaException(ApplicationError.GATEWAY_NOT_SAVED);
        }
    }

    @Override
    @Transactional
    public String deleteDevice(int deviceId) {
        Device device = deviceRepository.getById(deviceId);

        if(device!=null) {
            deviceRepository.delete(device);
            return "SUCCESS";
        }else {
            throw new MusalaException(ApplicationError.GATEWAY_NOT_SAVED);
        }
    }
}
