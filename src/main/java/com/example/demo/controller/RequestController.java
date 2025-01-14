package com.example.demo.controller;

import com.example.demo.model.ApiResponse;
import com.example.demo.model.RequestTemplateReq;
import com.example.demo.model.RequestTemplateResp;
import com.example.demo.service.RequestService;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/api/request")
public class RequestController {
    private RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }

    @PostMapping("/create")
    public ApiResponse<RequestTemplateResp> createRequest(@RequestBody RequestTemplateReq request) {
        log.info("Request received for creating request template");
        ApiResponse<RequestTemplateResp> response = new ApiResponse<>();
        RequestTemplateResp resp = requestService.saveRequestTemplate(request);
        response.setStatus("SUCCESS");
        response.setMessage("Request template created successfully");
        response.setData(resp);
        log.info("Request template created successfully");
        return response;
    }
}
