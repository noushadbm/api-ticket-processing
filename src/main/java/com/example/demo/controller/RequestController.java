package com.example.demo.controller;

import com.example.demo.model.ApiResponse;
import com.example.demo.model.RequestTemplateReq;
import com.example.demo.model.RequestTemplateRecord;
import com.example.demo.service.RequestService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RestController
@RequestMapping("/api/request")
public class RequestController {
    private RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("/list")
    public ApiResponse<List<RequestTemplateRecord>> listTemplated() {
        log.info("Request received for listing templates");
        ApiResponse<List<RequestTemplateRecord>> response = new ApiResponse<>();
        List<RequestTemplateRecord> resp = requestService.listTemplates();
        response.setStatus("SUCCESS");
        response.setMessage("Request templates fetched successfully");
        response.setData(resp);
        log.info("Request template created successfully");
        return response;
    }

    @PostMapping("/create")
    public ApiResponse<RequestTemplateRecord> createRequest(@RequestBody RequestTemplateReq request) {
        log.info("Request received for creating request template");
        ApiResponse<RequestTemplateRecord> response = new ApiResponse<>();
        RequestTemplateRecord resp = requestService.saveRequestTemplate(request);
        response.setStatus("SUCCESS");
        response.setMessage("Request template created successfully");
        response.setData(resp);
        log.info("Request template created successfully");
        return response;
    }
}
