package com.musala.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.musala.demo.domain.Gateway;
import com.musala.demo.enums.ApplicationError;
import com.musala.demo.exception.MusalaException;
import com.musala.demo.model.GatewayCreateRequest;
import com.musala.demo.model.GatewayCreateRespose;
import com.musala.demo.repository.GatewaRepository;
import com.musala.demo.util.MusalaUtill;

@Service
public class GatewayServiceImpl implements GatewayService {

    @Autowired
    private GatewaRepository gatewaRepository;

    @Override
    public String saveGateway(GatewayCreateRequest createRequest) {
        if (MusalaUtill.isStringNullOrEmpty(createRequest.getIp()) && MusalaUtill.validateIp(createRequest.getIp())) {
            if (MusalaUtill.isStringNullOrEmpty(createRequest.getSerial())) {
                if (MusalaUtill.isStringNullOrEmpty(createRequest.getName())) {
                    Gateway gateway = gatewaRepository.findByserial(createRequest.getSerial());
                    if (gateway == null) {
                        Gateway sGateway = new Gateway();
                        sGateway.setIp(createRequest.getIp());
                        sGateway.setName(createRequest.getName());
                        sGateway.setSerial(createRequest.getSerial());
                        sGateway = gatewaRepository.save(sGateway);
                        if (sGateway != null) {
                            return "SUCCESS";
                        } else {
                            throw new MusalaException(ApplicationError.GATEWAY_NOT_SAVED);
                        }
                    } else {
                        throw new MusalaException(ApplicationError.SERIAL_ALREADY_EXISTS);
                    }
                } else {
                    throw new MusalaException(ApplicationError.NAME_REQUIRED);
                }
            } else {
                throw new MusalaException(ApplicationError.INVALID_SERIAL);
            }
        } else {
            throw new MusalaException(ApplicationError.INVALID_IP_ADDRESS);
        }
    }

    @Override
    public String updateGateway(GatewayCreateRequest createRequest) {
        if (createRequest.getId() != null) {
            Gateway sGateway = gatewaRepository.getById(createRequest.getId());

            if (sGateway != null) {
                sGateway.setIp(createRequest.getIp());
                sGateway.setName(createRequest.getName());
                sGateway.setSerial(createRequest.getSerial());

                sGateway = gatewaRepository.save(sGateway);
                if (sGateway != null) {
                    return "SUCCESS";
                } else {
                    throw new MusalaException(ApplicationError.GATEWAY_NOT_SAVED);
                }
            } else {
                throw new MusalaException(ApplicationError.INVALID_GATEWAY_ID);
            }
        } else {
            throw new MusalaException(ApplicationError.INVALID_GATEWAY_ID);
        }
    }

    @Override
    public List<GatewayCreateRespose> getAll() {
        List<GatewayCreateRespose> getResposes = gatewaRepository.getAll();
        if (getResposes != null) {
            return getResposes;
        } else {
            throw new MusalaException(ApplicationError.NO_DATA);
        }
    }

    @Override
    public GatewayCreateRespose getById(int id) {
        Optional<Gateway> gatewayOp = gatewaRepository.findById(id);

        if (gatewayOp != null) {
            Gateway gateway = gatewayOp.get();
            GatewayCreateRespose createRespose = new GatewayCreateRespose();
            createRespose.setId(gateway.getId());
            createRespose.setIp(gateway.getIp());
            createRespose.setName(gateway.getName());
            createRespose.setSerial(gateway.getSerial());

            return createRespose;
        } else {
            throw new MusalaException(ApplicationError.NO_DATA);
        }
    }
}
