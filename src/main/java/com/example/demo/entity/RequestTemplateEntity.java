package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "REQUEST_TEMPLATE")
public class RequestTemplateEntity {
    @Id
    @GeneratedValue(generator="REQUEST_ID_SEQ")
    @SequenceGenerator(name="REQUEST_ID_SEQ",sequenceName="REQUEST_ID_SEQ", allocationSize=1)
    @Column(name = "REQUEST_TEMPLATE_ID")
    private Long requestTemplateId;
    @Column(name = "REQUEST_TYPE")
    private String requestType;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @Column(name = "CREATION_DATE")
    private LocalDateTime creationDate;
    @Column(name = "TEMPLATE_STATUS")
    private String templateStatus;
    @Column(name = "ENABLED")
    private Boolean enabled;
}
