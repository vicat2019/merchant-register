package com.merchant.controller;

import com.merchant.entity.ResultData;
import com.merchant.util.BatchRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: merchant-register
 * @description:
 * @author: Vincent
 * @create: 2019-02-14 09:32
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private BatchRegister batchRegister;


    /**
     * 批量进件
     * @return ResultData
     */
    @RequestMapping("/batch")
    public ResultData batch() {
        return batchRegister.execute();
    }












}
