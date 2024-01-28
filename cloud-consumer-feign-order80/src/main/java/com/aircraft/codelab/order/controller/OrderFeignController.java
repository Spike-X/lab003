package com.aircraft.codelab.order.controller;

import com.aircraft.codelab.core.entities.CommonResult;
import com.aircraft.codelab.core.entities.Payment;
import com.aircraft.codelab.order.config.InMemoryMultipartFile;
import com.aircraft.codelab.order.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.*;
import java.nio.file.Files;

/**
 * 2021-09-12
 *
 * @author tao.zhang
 * @since 1.0
 */
@Slf4j
@RestController
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/payment/feign/timeout", produces = MediaType.APPLICATION_JSON_VALUE)
    public String paymentFeignTimeout() {
        // OpenFeign客户端一般默认等待1秒钟
        return paymentFeignService.paymentFeignTimeout();
    }

    @GetMapping(value = "/consumer/payment/feign/multipart", produces = MediaType.APPLICATION_JSON_VALUE)
    public String paymentFeignMultipart() throws IOException {
//        String filePath = "D:\\home\\导入派单模板.xlsx";
        String filePath = "D:\\home\\2022-12-15.log";
        File file = new File(filePath);
        MultipartFile multipartFile = convert(file);
//        return paymentFeignService.multipart(multipartFile);
        return paymentFeignService.multipart2(multipartFile, "NewName");
    }

    public MultipartFile convert(File file) throws IOException {
        byte[] fileContent = Files.readAllBytes(file.toPath());
//        return new InMemoryMultipartFile(file.getName(), file.getName(), MediaType.MULTIPART_FORM_DATA_VALUE, fileContent);
        return new InMemoryMultipartFile(file.getName(), file.getName(), MediaType.APPLICATION_OCTET_STREAM_VALUE, fileContent);
    }
}
