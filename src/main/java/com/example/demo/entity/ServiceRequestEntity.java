package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "SERVICE_REQUEST")
public class ServiceRequestEntity {
    @Id
    @GeneratedValue(generator="REQUEST_ID_SEQ")
    @SequenceGenerator(name="REQUEST_ID_SEQ",sequenceName="REQUEST_ID_SEQ", allocationSize=1)
    @Column(name = "REQUEST_ID")
    private Long requestId;
    @Column(name = "REQUEST_TYPE")
    private String requestType;
}
