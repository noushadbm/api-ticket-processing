package com.example.demo.model;

import lombok.Data;

@Data
public class RequestTemplateReq {
    private String requestType;
    private String createdBy;
    private String templateStatus;
}
