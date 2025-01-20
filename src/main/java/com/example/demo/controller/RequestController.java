package com.example.demo.controller;

import com.example.demo.model.ApiResponse;
import com.example.demo.model.MyModel;
import com.example.demo.model.ServiceRequest;
import com.example.demo.service.RequestService;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/request")
@Log4j2
public class RequestController {

    private RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping
    public ApiResponse<List<ServiceRequest>> getAllRequests() {
        log.info("Request received for listing requests");
        ApiResponse<List<ServiceRequest>> response = new ApiResponse<>();
        List<ServiceRequest> items = requestService.getAllRequests();
        response.setStatus("SUCCESS");
        response.setMessage("Request templates fetched successfully");
        response.setData(items);
        log.info("Requests fetched successfully");
        return response;
    }

    @PostMapping
    public ApiResponse<ServiceRequest> createServiceRequest(@RequestBody ServiceRequest request) {
        ApiResponse<ServiceRequest> response = new ApiResponse<>();
        ServiceRequest serviceRequest = requestService.createServiceRequest(request);
        response.setStatus("SUCCESS");
        response.setMessage("Service request created successfully");
        response.setData(serviceRequest);
        return response;
    }
}
