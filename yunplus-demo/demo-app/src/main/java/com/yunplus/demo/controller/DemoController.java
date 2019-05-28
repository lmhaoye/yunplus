package com.yunplus.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.yunplus.cloud.base.dto.ServiceResultDto;
import com.yunplus.cloud.base.exception.ApiException;
import com.yunplus.demo.jmf.JmfServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    @GetMapping("")
    public ServiceResultDto index(){
        return ServiceResultDto.ok();
    }

    @Autowired
    private JmfServiceClient jmfServiceClient;

    @GetMapping(value = "/loan/order")
    public ServiceResultDto jmfIndex(@RequestParam(value = "page", defaultValue = "1") Integer page, @RequestParam(value = "page_size", defaultValue = "10") Integer pageSize) {
        ServiceResultDto serviceResultDto = null;
        if (page == 0) {
            throw new ApiException("aaa");
        }
        if (page == 10) {
            throw new SecurityException("xxx");
        }
        try {
            JSONObject req = new JSONObject();
            req.put("page", page);
            req.put("page_size", pageSize);
            JSONObject jsonObject = jmfServiceClient.listByLoanOrder(req);
            serviceResultDto = ServiceResultDto.ok(jsonObject != null ? jsonObject.get("data") : null);
        } catch (Exception e) {
            e.printStackTrace();
            serviceResultDto = ServiceResultDto.error("12", e.getMessage());
        }
        return serviceResultDto;
    }
}
