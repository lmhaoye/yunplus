package com.yunplus.demo.jmf;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("JMF")
public interface JmfServiceClient {

    /**
     * 获取订单列表示例
     * @param req
     * @return
     */
    @PostMapping(value = "/com/yunplus/credit/loan/service/ILoanOrderListQueryService", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    JSONObject listByLoanOrder(@RequestBody JSONObject req);
}
