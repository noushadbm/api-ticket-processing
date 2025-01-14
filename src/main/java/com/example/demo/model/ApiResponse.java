package com.example.demo.model;

import lombok.Data;

@Data
public class ApiResponse<T> {
    private String status;
    private String message;
    private String errorMessage;
    private T data;
}
