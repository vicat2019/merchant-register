package com.merchant.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @program: merchant-register
 * @description:
 * @author: Vincent
 * @create: 2019-02-15 16:56
 **/
public class AccountAssistant {

    private static final String BANK_STR = "{\"code\":1,\"msg\":\"获取银行列表成功\",\"data\":[{\"value\":\"1009999\",\"text\":\"邮政储蓄银行\",\"code\":\"PSBC\",\"typecode\":\"9006\"},{\"value\":\"1020000\",\"text\":\"工商银行\",\"code\":\"ICBC\",\"typecode\":\"9040\"},{\"value\":\"1030000\",\"text\":\"农业银行\",\"code\":\"ABC\",\"typecode\":\"9009\"},{\"value\":\"1040000\",\"text\":\"中国银行\",\"code\":\"BOC\",\"typecode\":\"9021\"},{\"value\":\"1050000\",\"text\":\"建设银行\",\"code\":\"CCB\",\"typecode\":\"9008\"},{\"value\":\"3010000\",\"text\":\"交通银行\",\"code\":\"BCM\",\"typecode\":\"9005\"},{\"value\":\"3020000\",\"text\":\"中信银行\",\"code\":\"ECITIC\",\"typecode\":\"9001\"},{\"value\":\"3030000\",\"text\":\"光大银行\",\"code\":\"CEB\",\"typecode\":\"9002\"},{\"value\":\"3040000\",\"text\":\"华夏银行\",\"code\":\"HXB\",\"typecode\":\"9003\"},{\"value\":\"3050000\",\"text\":\"民生银行\",\"code\":\"CMBC\",\"typecode\":\"9010\"},{\"value\":\"3060000\",\"text\":\"广发银行股份有限公司\",\"code\":\"GDB\",\"typecode\":\"9012\"},{\"value\":\"3070010\",\"text\":\"平安银行\",\"code\":\"PAB\",\"typecode\":\"9013\"},{\"value\":\"3080000\",\"text\":\"招商银行\",\"code\":\"CMB\",\"typecode\":\"9004\"},{\"value\":\"3090000\",\"text\":\"兴业银行\",\"code\":\"CIB\",\"typecode\":\"9015\"},{\"value\":\"3100000\",\"text\":\"浦东发展银行\",\"code\":\"SPDB\",\"typecode\":\"9020\"}]}";

    private static Map<String, String> bankMap;

    static {
        bankMap = Maps.newHashMap();

        JSONObject data = JSONObject.parseObject(BANK_STR);
        JSONArray valueJson = data.getJSONArray("data");

        for (int i=0; i<valueJson.size(); i++) {
            JSONObject temp = valueJson.getJSONObject(i);
            bankMap.put(temp.getString("text"), temp.getString("value"));
        }
    }

















































}
