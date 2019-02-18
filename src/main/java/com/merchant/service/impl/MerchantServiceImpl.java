package com.merchant.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.merchant.entity.ResultData;
import com.merchant.entity.RuiShengUserInfo;
import com.merchant.service.MerchantService;
import com.merchant.service.RsMerchantInfoService;
import com.merchant.util.HttpUtils;
import com.merchant.util.Rsaencrypt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.util.Map;
import java.util.TreeMap;

/**
 * @program: muse-pay
 * @description: 服务类
 * @author: Vincent
 * @create: 2019-02-12 11:28
 **/
@Service("merchantServiceImpl")
public class MerchantServiceImpl implements MerchantService {
    private Logger log = LoggerFactory.getLogger("MerchantServiceImpl");

    // 商户进件地址
    private static final String REGISTER_URL = "http://www.ruishengglass.cn/api-v1-user/register";

    // 修改费率地址
    private static final String MODIFY_RATE_URL = "http://www.ruishengglass.cn/api-v1-user/channel";

    @Autowired
    private HttpUtils httpUtils;

    @Autowired
    private RsMerchantInfoService rsMerchantInfoService;


    /**
     * 商户进件 - 测试接口是否通
     *
     * @param userInfo 商户信息
     * @return ResultData
     * @throws Exception 异常
     */
    @Override
    public ResultData add(RuiShengUserInfo userInfo) throws Exception {
        userInfo = new RuiShengUserInfo();
        userInfo.setMchid("00020019");
        userInfo.setName("首战信息科技2");
        userInfo.setProvince("440000");
        userInfo.setCity("440400");
        userInfo.setArea("440402");
        userInfo.setAddress("珠海市香洲区园林路1号32栋202房");
        userInfo.setLegelname("陈裕明");
        userInfo.setLegelcertno("441424199701112272");
        userInfo.setEmail("bm555111122@sohu.com");
        userInfo.setPhone("18374894616");

        userInfo.setBankno("1040000");
        userInfo.setBranchno("104584002488");
        userInfo.setCardno("6217852000009016547");
        userInfo.setEcardno("6231099101000685779");
        userInfo.setPayname("陈裕明");
        userInfo.setCertno("441424199701112272");

        userInfo.setPayphone("13160721607");
        userInfo.setCardprovince("440000");
        userInfo.setCardcity("440300");
        userInfo.setCardarea("440307");
        userInfo.setType("1");
        userInfo.setCerttype("1");

        userInfo.setBuslicpic("http://www.ruishengglass.cn/uploads/32/57c890dbe982e78fdba40f0141aff9.jpeg");
        userInfo.setLegfrontpic("http://www.ruishengglass.cn/uploads/dd/8e0add28977b1ceebea13989fb0343.jpeg");
        userInfo.setLegbackpic("http://www.ruishengglass.cn/uploads/32/57c890dbe982e78fdba40f0141aff9.jpeg");
        userInfo.setHandpic("http://www.ruishengglass.cn/uploads/bb/45449bfe41718a3f3a4483329f743e.jpeg");
        userInfo.setDoorpic("http://www.ruishengglass.cn/uploads/ac/13df50eac7e3e02b259b26422f711b.jpg");

        userInfo.setRate("31");


        userInfo.setProvincename("广东省");
        userInfo.setCityname("珠海市");
        userInfo.setAreaname("香洲区");

        userInfo.setCardprovincename("广东省");
        userInfo.setCardcityname("深圳市");
        userInfo.setCardareaname("龙岗区");

        userInfo.setBankname("中国银行");
        userInfo.setBranchname("中国银行股份有限公司深圳大鹏支行");


        Map<String, Object> params = userInfo.toMap();
        TreeMap<String, Object> signParam = new TreeMap<>(params);
        params.put("sign", Rsaencrypt.signByMap(signParam));

        log.info("商户进件，请求参数=" + JSONObject.toJSONString(params));
        ResultData data = httpUtils.post(REGISTER_URL, params);
        log.info("商户进件，返回内容=" + data);

        // 进件成功则保存
        handleResultForDB(userInfo, data);
        return data;
    }

    /**
     * 商户进件
     *
     * @param userInfo 商户信息
     * @return ResultData
     * @throws Exception 异常
     */
    @Override
    public ResultData insert(RuiShengUserInfo userInfo) throws Exception {
        // 检查参数
        if (userInfo == null) {
            return ResultData.getErrResult("参数不能为空");
        }
        userInfo.checkPropertiesEmpay();

        // 参数
        Map<String, Object> params = userInfo.toMap();
        // 签名
        params.put("sign", Rsaencrypt.signByMap(new TreeMap<>(params)));

        // 请求
        log.info("商户进件，请求参数=" + JSONObject.toJSONString(params));
        ResultData data = httpUtils.post(REGISTER_URL, params);
        log.info("商户进件，返回内容=" + data);


        // 进件成功则保存
        handleResultForDB(userInfo, data);
        return data;
    }

    /**
     * 检查进件是否成功，成功则保存
     *
     * @param userInfo 商户信息
     * @param data     进件返回结果
     * @throws Exception 异常
     */
    private void handleResultForDB(RuiShengUserInfo userInfo, ResultData data) throws Exception {
        if (data.whetherOk()) {
            String jsonStr = (String) data.getData();
            JSONObject json = JSONObject.parseObject(jsonStr);

            if (json.get("code").equals(1)) {
                JSONObject jsonData = json.getJSONObject("data");
                if (jsonData != null) {
                    userInfo.setSubmchid((String) jsonData.get("submchid"));
                    rsMerchantInfoService.add(userInfo);
                } else {
                    log.error("商户进件失败，解析结果，返回内容为空=" + data);
                }
            } else {
                log.error("商户进件失败，返回结果=" + data);
            }
        }
    }

    /**
     * 修改费率
     *
     * @param rate                    费率值
     * @param mchId                   代理商编号
     * @param submchId                商户编号
     * @param channelRatePropertyName 渠道费率属性名称
     * @return ResultData
     * @throws Exception 异常
     */
    @Override
    public ResultData modifyRate(double rate, String mchId, String submchId, String channelRatePropertyName) throws Exception {
        // 检查参数
        Preconditions.checkArgument(rate != 0, "费率不能为0");
        Preconditions.checkArgument(!StringUtils.isEmpty(mchId), "代理商编号不能为空");
        Preconditions.checkArgument(!StringUtils.isEmpty(submchId), "商户编号不能为空");

        if (StringUtils.isEmpty(channelRatePropertyName)) {
            channelRatePropertyName = "bnwxFix";
        }

        // 费率参数
        Map<String, Object> subParamMap = Maps.newHashMap();
        subParamMap.put("rate", rate);
        subParamMap.put("fee", 0);
        Map<String, Object> rateParamMap = Maps.newHashMap();
        rateParamMap.put(channelRatePropertyName, subParamMap);

        // 请求参数
        Map<String, Object> paramMap = Maps.newHashMap();
        paramMap.put("mchid", mchId);
        paramMap.put("submchid", submchId);
        paramMap.put("channelinfo", JSONObject.toJSONString(rateParamMap));

        // 生成签名
        String sign = Rsaencrypt.signByMap(new TreeMap<>(paramMap));
        paramMap.put("sign", sign);

        // 发送请求
        log.info("修改费率，请求参数=" + JSONObject.toJSONString(paramMap));
        ResultData resultData = httpUtils.post(MODIFY_RATE_URL, paramMap);
        log.info("修改费率，返回内容=" + resultData);

        return resultData;
    }
}
