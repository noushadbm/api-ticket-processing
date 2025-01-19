package com.example.demo.service;

import com.example.demo.entity.RequestTemplateEntity;
import com.example.demo.model.RequestTemplateReq;
import com.example.demo.model.RequestTemplateRecord;
import com.example.demo.repository.RequestTemplateRepository;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Log4j2
public class RequestService {
    private RequestTemplateRepository requestTemplateRepository;

    public RequestService(RequestTemplateRepository requestTemplateRepository) {
        this.requestTemplateRepository = requestTemplateRepository;
    }

    public List<RequestTemplateRecord> listTemplates() {
        log.info("Fetching request templates");
        List<RequestTemplateEntity> requestTemplateEntities = requestTemplateRepository.findAll();
        log.info("Request templates fetched");

        List<RequestTemplateRecord> response = requestTemplateEntities.stream().map(requestTemplateEntity -> {
            RequestTemplateRecord record = new RequestTemplateRecord();
            record.setTemplateId(requestTemplateEntity.getRequestTemplateId());
            record.setRequestType(requestTemplateEntity.getRequestType());
            record.setCreatedBy(requestTemplateEntity.getCreatedBy());
            record.setCreationDate(requestTemplateEntity.getCreationDate().toString());
            record.setTemplateStatus(requestTemplateEntity.getTemplateStatus());
            record.setEnabled(requestTemplateEntity.getEnabled());
            return record;
        }).toList();
        log.info("Request templates response created");
        return response;
    }

    @Transactional
    public RequestTemplateRecord saveRequestTemplate(RequestTemplateReq request) {
        log.info("Saving request template");
        RequestTemplateEntity requestTemplateEntity = new RequestTemplateEntity();
        requestTemplateEntity.setRequestType(request.getRequestType());
        requestTemplateEntity.setCreatedBy(request.getCreatedBy());
        requestTemplateEntity.setTemplateStatus(request.getTemplateStatus());
        requestTemplateEntity.setCreationDate(LocalDateTime.now());
        requestTemplateEntity.setEnabled(true);
        RequestTemplateEntity saved = requestTemplateRepository.save(requestTemplateEntity);
        log.info("Request template saved");

        RequestTemplateRecord response = new RequestTemplateRecord();
        response.setTemplateId(saved.getRequestTemplateId());
        log.info("Request template response created");
        return response;
    }
}
