package com.merchant.controller;

import com.alibaba.fastjson.JSONObject;
import com.merchant.entity.ResultData;
import com.merchant.entity.RuiShengUserInfo;
import com.merchant.service.impl.MerchantServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @program: muse-pay
 * @description:
 * @author: Vincent
 * @create: 2019-02-12 12:51
 **/
@RequestMapping("/merchant/p/")
@Controller
public class PageController {
    private Logger log = LoggerFactory.getLogger("PageController");

    @Autowired
    private MerchantServiceImpl merchantService;


    /**
     * 进入商户进件界面
     *
     * @return String
     */
    @RequestMapping("/index")
    public String index() {
        return "user/register";
    }

    /**
     * 进入列表界面
     *
     * @return String
     */
    @RequestMapping("/list")
    public String merchantIndex() {
        return "user/index";
    }

    /**
     * 进入商户进件界面
     *
     * @return String
     */
    @RequestMapping("/s")
    public String index_succ(ModelMap modelMap) {

        modelMap.put("submchid", "00020019000000000004");
        return "user/register_succ";
    }

    /**
     * 商户进件操作
     *
     * @param userInfo 商户信息
     * @param modelMap 模型
     * @return String
     */
    @RequestMapping("/register")
    public String register(RuiShengUserInfo userInfo, ModelMap modelMap) {
        try {
            modelMap.put("submchid", "");
            ResultData result = merchantService.insert(userInfo);
            if (!result.whetherOk()) {
                modelMap.put("user", userInfo);
                modelMap.put("msg", result.getMessage());
            } else {
                JSONObject json = JSONObject.parseObject((String) result.getData());
                if (json.get("code").equals(1)) {
                    JSONObject jsonData = json.getJSONObject("data");
                    if (jsonData != null) {
                        modelMap.put("submchid", jsonData.get("submchid"));
                    }
                    return "user/register_succ";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error("商户进件异常=" + e.getMessage());
        }
        return "user/register";
    }

}
