package com.example.demo.service;

import com.example.demo.entity.RequestTemplateEntity;
import com.example.demo.model.RequestTemplateReq;
import com.example.demo.model.RequestTemplateResp;
import com.example.demo.repository.RequestTemplateRepository;
import jakarta.transaction.Transactional;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Log4j2
public class RequestService {
    private RequestTemplateRepository requestTemplateRepository;

    public RequestService(RequestTemplateRepository requestTemplateRepository) {
        this.requestTemplateRepository = requestTemplateRepository;
    }

    @Transactional
    public RequestTemplateResp saveRequestTemplate(RequestTemplateReq request) {
        log.info("Saving request template");
        RequestTemplateEntity requestTemplateEntity = new RequestTemplateEntity();
        requestTemplateEntity.setRequestType(request.getRequestType());
        requestTemplateEntity.setCreatedBy(request.getCreatedBy());
        requestTemplateEntity.setTemplateStatus(request.getTemplateStatus());
        requestTemplateEntity.setCreationDate(LocalDateTime.now());
        requestTemplateEntity.setEnabled(true);
        RequestTemplateEntity saved = requestTemplateRepository.save(requestTemplateEntity);
        log.info("Request template saved");

        RequestTemplateResp response = new RequestTemplateResp();
        response.setRequestTemplateId(saved.getRequestTemplateId());
        log.info("Request template response created");
        return response;
    }
}
