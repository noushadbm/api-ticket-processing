package com.example.demo.service;

import com.example.demo.entity.ServiceRequestEntity;
import com.example.demo.model.ServiceRequest;
import com.example.demo.repository.ServiceRequestRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j2
public class RequestService {
    private ServiceRequestRepository serviceRequestRepository;

    public RequestService(ServiceRequestRepository serviceRequestRepository) {
        this.serviceRequestRepository = serviceRequestRepository;
    }
    public List<ServiceRequest> getAllRequests() {
        log.info("Fetching service requests");
        List<ServiceRequestEntity> serviceRequestEntities = serviceRequestRepository.findAll();
        List<ServiceRequest> serviceRequests = serviceRequestEntities.stream().map(entity -> toModel(entity)).toList();
        log.info("Service requests fetched");
        return serviceRequests;
    }

    public ServiceRequest createServiceRequest(ServiceRequest request) {
        ServiceRequestEntity entity = toEntity(request);
        log.info("Creating service request");
        ServiceRequestEntity newEntity = serviceRequestRepository.save(entity);
        log.info("Service request created");
        return toModel(newEntity);
    }

    private ServiceRequestEntity toEntity(ServiceRequest request) {
        ServiceRequestEntity entity = new ServiceRequestEntity();
        entity.setRequestType(request.getRequestType());
        return entity;
    }

    private ServiceRequest toModel(ServiceRequestEntity entity) {
        ServiceRequest request = new ServiceRequest();
        request.setRequestId(entity.getRequestId());
        request.setRequestType(entity.getRequestType());
        return request;
    }
}
