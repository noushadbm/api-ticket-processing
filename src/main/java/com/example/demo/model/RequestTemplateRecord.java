package com.example.demo.model;

import lombok.Data;

@Data
public class RequestTemplateRecord {
    private Long templateId;
    private String requestType;
    private String createdBy;
    private String creationDate;
    private String templateStatus;
    private Boolean enabled;
}
