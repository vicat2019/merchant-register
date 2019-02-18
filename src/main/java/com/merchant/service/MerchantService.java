package com.merchant.service;

import com.merchant.entity.ResultData;
import com.merchant.entity.RuiShengUserInfo;

/**
 * @Description: 商户服务接口类
 * @Author: Vincent
 * @Date: 2019/2/12
 */
public interface MerchantService {

    /**
     * 商户进件 - 接口测试
     *
     * @param userInfo 商户信息
     * @return ResultData
     * @throws Exception 异常
     */
    ResultData add(RuiShengUserInfo userInfo) throws Exception;

    /**
     * 商户进件
     *
     * @param userInfo 商户信息
     * @return ResultData
     * @throws Exception 异常
     */
    ResultData insert(RuiShengUserInfo userInfo) throws Exception;

    /**
     * 修改费率
     *
     * @param rate                    费率
     * @param mchId                   代理商户号
     * @param submchId                商户编号
     * @param channelRatePropertyName 渠道费率属性名称
     * @return ResultData
     * @throws Exception 异常
     */
    ResultData modifyRate(double rate, String mchId, String submchId, String channelRatePropertyName) throws Exception;

}
