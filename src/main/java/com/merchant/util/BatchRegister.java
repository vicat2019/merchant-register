package com.merchant.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.merchant.entity.ResultData;
import com.merchant.entity.RuiShengUserInfo;
import com.merchant.service.RsMerchantInfoService;
import com.merchant.service.impl.MerchantServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.thymeleaf.util.StringUtils;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: merchant-register
 * @description: 批量录入
 * @author: Vincent
 * @create: 2019-02-14 09:00
 **/
@Component("batchRegister")
public class BatchRegister {
    private Logger log = LoggerFactory.getLogger("BatchRegister");

    @Autowired
    private HttpUtils httpUtils;

    private static Map<String, String> provinceMap;

    @Autowired
    private MerchantServiceImpl merchantService;

    @Autowired
    private RsMerchantInfoService rsMerchantInfoService;

    // 生成客服点好
    private static int pp = 601;
    private static String phoneStr = "17790848";
    // 要进件的个数
    private static final int REGIST_COUNT = 97;


    /**
     * 执行批量进件
     *
     * @return ResultData
     */
    public ResultData execute() {

        // 查询已经进件的商铺
        List<String> alreadyRegister = null;
        try {
            alreadyRegister = rsMerchantInfoService.getAllName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (alreadyRegister == null || alreadyRegister.size() == 0) {
            log.error("查询已经进件的商铺名称列表为空");
            return ResultData.getErrResult("查询已经进件的商铺名称列表为空");
        }

        // 获取店铺信息(名称)
        String path = "C:\\Users\\Administrator\\Desktop\\滨农进件资料\\20190214天津滨海进件资料2\\20190214天津滨海进件资料2";
        List<String> shopInfoList = getShopNameFromFile(path);

        // 遍历前N条
        int count = 0;
        int i = 0;
        while (count < REGIST_COUNT) {
            if (i >= shopInfoList.size()) {
                log.info("已经轮询到结尾=" + i);
                break;
            }

            // 商户名称
            String name = shopInfoList.get(i);
            // 初始商户名称
            String originalName = name;
            i = i + 1;

            // 过滤关键词
            if (name.contains("车臣")) {
                name = name.replaceAll("车臣", "CC");
            }
            if (name.contains("武侯祠")) {
                name = name.replaceAll("武侯祠", "WHC");
            }
            if (name.contains("大师")) {
                name = name.replaceAll("大师", "DS");
            }
            if (name.contains("按摩")) {
                name = name.replaceAll("按摩", "AM");
            }
            if (name.contains("无界")) {
                name = name.replaceAll("无界", "WJ");
            }
            if (name.contains("&")) {
                name = name.replaceAll("\\&", "");
            }

            // 截取字母
            if (name.length() >= 10) {
                name = handleLetter(name);
            }
            // 去掉"直营店"
            if (name.length() >= 10) {
                name = name.replaceAll("直营店", "");
            }
            // 去掉"店"
            if (name.length() >= 10) {
                name = name.replaceAll("店", "");
            }
            // 去掉"中心"
            if (name.length() >= 10) {
                name = name.replaceAll("中心", "");
            }
            // 去掉括号，截取字母
            if (name.length() >= 10) {
                String temp = name.replaceAll("（", "");
                temp = temp.replaceAll("（", "");
                temp = temp.replaceAll("）", "");
                temp = temp.replaceAll("\\(", "");
                temp = temp.replaceAll("\\)", "");
                if (temp.length() < 10) {
                    name = temp;
                }
            }

            // 去掉括号和里面内容，
            if (name.length() >= 10) {
                name = originalName.replaceAll("（.+）", "");
                name = name.replaceAll("\\(.+\\)", "");
            }
            // 截取名称中的前9个字符
            if (name.length() >= 10) {
                name = name.substring(0, 9);
            }

            // 特殊处理
            if (name.equals("7天连锁酒店")) name = "7天连锁酒店二";
            if (name.equals("SELECTED")) name = "SELECTED2";
            if (name.equals("starfish蓝")) name = "starfis2蓝";
            if (name.equals("Superdry")) name = "Superdry2";
            if (name.toUpperCase().equals("UCC国际洗衣")) {
                if (originalName.length() > 7) {
                    name = originalName.replaceAll("洗衣", "");
                    if (name.length() >= 10) {
                        name = name.replaceAll("\\(", "");
                        name = name.replaceAll("\\)", "");
                        name = name.substring(0, 9);
                    }
                }
            }
            // 去掉空格
            name = name.replaceAll("\\s+", "");

            // 最终检查商铺名称是否超过10个字符
            if (name.length() >= 10) {
                log.error("该商铺名称超过或等于10个字符=" + originalName);
                continue;
            }


            // 是否已经进件
            if (alreadyRegister.contains(name)) {
                //log.info("该商铺已进件=======" + name);
                try {
                    FileUtils.removeDoneFile(getDoorPicFile(originalName, path), path);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                continue;
            }

            // 获取门头照图片，检查是否存在
            File doorPicFile = getDoorPicFile(originalName, path);
            if (doorPicFile == null) {
                log.error("根据名称=" + originalName + "找不到对应的图片文件");
                continue;
            }

            // 获取省市区编码
            String[] addressInfo = AddressHelper.getAddressInfo();
            String provinceName = addressInfo[0];
            String cityName = addressInfo[1];
            String areaName = addressInfo[2];
            String address = addressInfo[3];

            String province = getProvinceCode(provinceName);
            String city = getCityCode(province, cityName);
            String area = getAreaCode(city, areaName);

            if (StringUtils.isEmpty(province) || StringUtils.isEmpty(city) || StringUtils.isEmpty(area)) {
                log.error("没有获取到对应的省市区编号=" + addressInfo);
                continue;
            }

            // 上传门头照
            String doorPicUrl = "";
            String urlStr = "http://www.ruishengglass.cn//api-v1-user/upload.html";
            String content = FileUploadHandler.uplad(doorPicFile.getAbsolutePath(), urlStr);
            if (StringUtils.isEmpty(content)) {
                log.error("上传门头照，返回内容为空");
                continue;
            }
            JSONObject json = JSONObject.parseObject(content);
            if (json.getInteger("code") == 1) {
                JSONObject data = json.getJSONObject("data");
                if (data != null) {
                    doorPicUrl = data.getString("file");
                }
            }
            if (StringUtils.isEmpty(doorPicUrl)) {
                log.error("上传门头照，返回图片地址为空=" + originalName);
                continue;
            }

            // 生成客服号码
            String phone = phoneStr + (pp + count);
            // 生成邮箱
            String email = phone + "@126.com";


            // 生成完整商户信息
            RuiShengUserInfo userInfo = RegisterUserHelper.getZhangXuLiang(name, province, city, area, address, doorPicUrl, provinceName,
                    cityName, areaName, phone, email, originalName);
            try {
                // 调用进件接口
                ResultData addResult = merchantService.insert(userInfo);

                // 解析进件返回结果
                String addContent = (String) addResult.getData();
                JSONObject addJson = JSONObject.parseObject(addContent);
                int registerRet = addJson.getInteger("code");
                // 添加成功
                if (registerRet == 1) {
                    // 计数
                    count += 1;
                }
                log.info("批量商户进件结果[" + count + "]=" + registerRet + ", " + addResult.getData());

            } catch (Exception e) {
                e.printStackTrace();
                log.error("商户进件异常=" + e.getMessage());
            }

            // 睡眠时间
            try {
                TimeUnit.SECONDS.sleep(6);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        log.info("成功" + count + "个。");
        return ResultData.getSuccessResult(count);
    }

    /**
     * 压缩商铺名称中的字母
     *
     * @param name 名称
     * @return String
     */
    private String handleLetter(String name) {
        Pattern pattern = Pattern.compile("([a-zA-Z]+)");
        Matcher matcher = pattern.matcher(name);
        String result = name;
        if (matcher.find()) {
            result = name.replaceAll("\\s+", "");
            String temp = matcher.group(1);
            if (temp.length() > 2) {
                temp = temp.substring(0, 2);
            }
            result = result.replaceAll("[a-zA-Z]+|\\.+|\\&+", temp.toUpperCase());
        }
        return result;
    }

    /**
     * 从Excel中读取商铺信息
     *
     * @return List
     */
    public List<List<String>> getShop() {
        String excelFile = "C:\\Users\\Administrator\\Desktop\\滨农进件资料\\20190213天津滨海进件资料\\20190213入件资料 表格.xlsx";
        List<List<String>> merchantInfoList = Lists.newArrayList();

        try {
            List<Object> dataList = ExcelUtils.readExcel(excelFile, 1, 2, "ALL");
            dataList.forEach(item -> {
                List<String> itemInfo = (List<String>) item;
                if (itemInfo.size() > 2) {
                    List<String> temp = Lists.newArrayList();
                    temp.add(itemInfo.get(1));
                    if ("null".equals(itemInfo.get(2)) || itemInfo.get(2) == null) {
                        temp.add(itemInfo.get(3));
                    } else {
                        temp.add(itemInfo.get(2));
                    }
                    merchantInfoList.add(temp);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            log.error("读取商铺信息异常=" + e.getMessage());
        }

        return merchantInfoList;
    }

    /**
     * 根据名称获取门头照文件
     *
     * @param name 名称
     * @param path 门头照文件夹路径
     * @return File
     */
    public File getDoorPicFile(String name, String path) {
        File root = new File(path);
        File[] fileAr = root.listFiles();
        if (fileAr == null) {
            return null;
        }
        List<File> fileList = Lists.newArrayList(fileAr);
        for (File item : fileList) {
            if (item.getName().contains(name.trim())) {
                return item;
            }
        }
        return null;
    }

    /**
     * 从门头照图片文件夹中获取商铺名称
     *
     * @param path 头照图片文件夹
     * @return
     */
    public List<String> getShopNameFromFile(String path) {
        List<String> shopNameList = Lists.newArrayList();
        File root = new File(path);
        if (!root.exists()) {
            return shopNameList;
        }
        File[] fileAr = root.listFiles();
        if (fileAr == null) {
            return shopNameList;
        }
        List<File> fileList = Lists.newArrayList(fileAr);
        fileList.forEach(item -> {
            String fileName = item.getName();
            if (fileName.contains(".xlsx")) {
                return;
            }
            fileName = fileName.substring(0, fileName.lastIndexOf("."));
            shopNameList.add(fileName);
        });

        return shopNameList;
    }

    /**
     * 根据银行获取银行编码
     *
     * @param content
     * @return
     */
    public String getBankCode(String content) {
        Map<String, String> bankCodeMap = getBankData();

        // 获取银行名称
        Pattern pattern = Pattern.compile("(.*银行)");
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            String key = matcher.group(1);
            if (bankCodeMap.containsKey(key)) {
                return bankCodeMap.get(key);
            }
            key = key.replaceAll("中国", "");
            if (bankCodeMap.containsKey(key)) {
                return bankCodeMap.get(key);
            }
        }
        return "";
    }


    /**
     * 获取银行列表
     *
     * @return Map
     */
    public Map<String, String> getBankData() {
        ResultData resultData = ResultData.getSuccessResult();
        resultData.setData("{\"code\":1,\"msg\":\"获取银行列表成功\",\"data\":[{\"value\":\"1009999\",\"text\":\"邮政储蓄银行\",\"code\":\"PSBC\",\"typecode\":\"9006\"},{\"value\":\"1020000\",\"text\":\"工商银行\",\"code\":\"ICBC\",\"typecode\":\"9040\"},{\"value\":\"1030000\",\"text\":\"农业银行\",\"code\":\"ABC\",\"typecode\":\"9009\"},{\"value\":\"1040000\",\"text\":\"中国银行\",\"code\":\"BOC\",\"typecode\":\"9021\"},{\"value\":\"1050000\",\"text\":\"建设银行\",\"code\":\"CCB\",\"typecode\":\"9008\"},{\"value\":\"3010000\",\"text\":\"交通银行\",\"code\":\"BCM\",\"typecode\":\"9005\"},{\"value\":\"3020000\",\"text\":\"中信银行\",\"code\":\"ECITIC\",\"typecode\":\"9001\"},{\"value\":\"3030000\",\"text\":\"光大银行\",\"code\":\"CEB\",\"typecode\":\"9002\"},{\"value\":\"3040000\",\"text\":\"华夏银行\",\"code\":\"HXB\",\"typecode\":\"9003\"},{\"value\":\"3050000\",\"text\":\"民生银行\",\"code\":\"CMBC\",\"typecode\":\"9010\"},{\"value\":\"3060000\",\"text\":\"广发银行股份有限公司\",\"code\":\"GDB\",\"typecode\":\"9012\"},{\"value\":\"3070010\",\"text\":\"平安银行\",\"code\":\"PAB\",\"typecode\":\"9013\"},{\"value\":\"3080000\",\"text\":\"招商银行\",\"code\":\"CMB\",\"typecode\":\"9004\"},{\"value\":\"3090000\",\"text\":\"兴业银行\",\"code\":\"CIB\",\"typecode\":\"9015\"},{\"value\":\"3100000\",\"text\":\"浦东发展银行\",\"code\":\"SPDB\",\"typecode\":\"9020\"}]}");

        Map<String, String> resultMap = parseBankResult(resultData);

        return resultMap;
    }

    /**
     * 获取支行列表
     *
     * @param parent 银行编号
     * @return Map
     */
    public Map<String, String> getBranchBankData(String parent) {
        String url = "http://www.ruishengglass.cn/api-v1-bank/getBranchList?parent=" + parent;
        ResultData resultData = httpUtils.get(url, Maps.newHashMap());

        Map<String, String> resultMap = parseBankResult(resultData);
        return resultMap;
    }

    /**
     * 解析查询银行返回的内容
     *
     * @param resultData
     * @return Map
     */
    private Map<String, String> parseBankResult(ResultData resultData) {
        Map<String, String> resultMap = Maps.newHashMap();
        if (resultData.whetherOk()) {
            String content = (String) resultData.getData();
            JSONObject json = JSONObject.parseObject(content);
            JSONArray dataJson = json.getJSONArray("data");

            for (int i = 0; i < dataJson.size(); i++) {
                JSONObject tempJson = (JSONObject) dataJson.get(i);
                resultMap.put((String) tempJson.get("text"), (String) tempJson.get("value"));
            }
        }
        return resultMap;
    }

    /**
     * 根据省份名称获取编号
     *
     * @param province
     * @return Map
     */
    private String getProvinceCode(String province) {
        if (provinceMap == null || provinceMap.size() == 0) {
            provinceMap = getProvince();
        }
        return provinceMap.get(province);
    }

    /**
     * 获取省份
     *
     * @return Map
     */
    private Map<String, String> getProvince() {
        // String url = "http://www.ruishengglass.cn/api-v1-zone/getProvince";
        // ResultData resultData = httpUtils.get(url, Maps.newHashMap());
        ResultData resultData = ResultData.getSuccessResult();
        resultData.setData("{\"code\":1,\"msg\":\"获取省份列表成功\",\"data\":[{\"value\":\"110000\",\"text\":\"北京市\"},{\"value\":\"120000\",\"text\":\"天津市\"},{\"value\":\"130000\",\"text\":\"河北省\"},{\"value\":\"140000\",\"text\":\"山西省\"},{\"value\":\"150000\",\"text\":\"内蒙古自治区\"},{\"value\":\"210000\",\"text\":\"辽宁省\"},{\"value\":\"220000\",\"text\":\"吉林省\"},{\"value\":\"230000\",\"text\":\"黑龙江省\"},{\"value\":\"310000\",\"text\":\"上海市\"},{\"value\":\"320000\",\"text\":\"江苏省\"},{\"value\":\"330000\",\"text\":\"浙江省\"},{\"value\":\"340000\",\"text\":\"安徽省\"},{\"value\":\"350000\",\"text\":\"福建省\"},{\"value\":\"360000\",\"text\":\"江西省\"},{\"value\":\"370000\",\"text\":\"山东省\"},{\"value\":\"410000\",\"text\":\"河南省\"},{\"value\":\"420000\",\"text\":\"湖北省\"},{\"value\":\"430000\",\"text\":\"湖南省\"},{\"value\":\"440000\",\"text\":\"广东省\"},{\"value\":\"450000\",\"text\":\"广西壮族自治区\"},{\"value\":\"460000\",\"text\":\"海南省\"},{\"value\":\"500000\",\"text\":\"重庆市\"},{\"value\":\"510000\",\"text\":\"四川省\"},{\"value\":\"520000\",\"text\":\"贵州省\"},{\"value\":\"530000\",\"text\":\"云南省\"},{\"value\":\"540000\",\"text\":\"西藏自治区\"},{\"value\":\"620000\",\"text\":\"甘肃省\"},{\"value\":\"630000\",\"text\":\"青海省\"},{\"value\":\"640000\",\"text\":\"宁夏回族自治区\"},{\"value\":\"650000\",\"text\":\"新疆维吾尔自治区\"},{\"value\":\"660000\",\"text\":\"新疆生产建设兵团\"},{\"value\":\"710000\",\"text\":\"台湾省\"},{\"value\":\"810000\",\"text\":\"香港特别行政区\"},{\"value\":\"820000\",\"text\":\"澳门特别行政区\"},{\"value\":\"610000\",\"text\":\"陕西省\"}]}");

        Map<String, String> provinceMap = parseBankResult(resultData);
        return provinceMap;
    }

    /**
     * 获取城市编码
     *
     * @param provinceCode 省份编码
     * @param cityName     城市名称
     * @return String
     */
    private String getCityCode(String provinceCode, String cityName) {
        Map<String, String> cityMap = getCityByProvince(provinceCode);
        return cityMap.get(cityName);
    }

    /**
     * 获取城市
     *
     * @param provinceCode 省份编码
     * @return Map
     */
    private Map<String, String> getCityByProvince(String provinceCode) {
        String url = "http://www.ruishengglass.cn/api-v1-zone/getCity?parent=" + provinceCode;
        // ResultData resultData = httpUtils.get(url, Maps.newHashMap());

        ResultData resultData = ResultData.getSuccessResult();
        resultData.setData("{\"code\":1,\"msg\":\"获取城市列表成功\",\"data\":[{\"value\":\"510100\",\"text\":\"成都市\"},{\"value\":\"510300\",\"text\":\"自贡市\"},{\"value\":\"510400\",\"text\":\"攀枝花市\"},{\"value\":\"510500\",\"text\":\"泸州市\"},{\"value\":\"510600\",\"text\":\"德阳市\"},{\"value\":\"510700\",\"text\":\"绵阳市\"},{\"value\":\"510800\",\"text\":\"广元市\"},{\"value\":\"510900\",\"text\":\"遂宁市\"},{\"value\":\"511000\",\"text\":\"内江市\"},{\"value\":\"511100\",\"text\":\"乐山市\"},{\"value\":\"511300\",\"text\":\"南充市\"},{\"value\":\"511400\",\"text\":\"眉山市\"},{\"value\":\"511500\",\"text\":\"宜宾市\"},{\"value\":\"511600\",\"text\":\"广安市\"},{\"value\":\"511700\",\"text\":\"达州市\"},{\"value\":\"511800\",\"text\":\"雅安市\"},{\"value\":\"511900\",\"text\":\"巴中市\"},{\"value\":\"512000\",\"text\":\"资阳市\"},{\"value\":\"513200\",\"text\":\"阿坝藏族羌族自治州\"},{\"value\":\"513300\",\"text\":\"甘孜藏族自治州\"},{\"value\":\"513400\",\"text\":\"凉山彝族自治州\"}]}");

        Map<String, String> cityMap = parseBankResult(resultData);
        return cityMap;
    }

    /**
     * 获取区域编码
     *
     * @param cityCode 城市编码
     * @param areaName 区县名称
     * @return String
     */
    private String getAreaCode(String cityCode, String areaName) {
        Map<String, String> areaMap = getAreaByCity(cityCode);
        return areaMap.get(areaName);
    }

    /**
     * 获取区域
     *
     * @param cityCode
     * @return Map
     */
    private Map<String, String> getAreaByCity(String cityCode) {
        // String url = "http://www.ruishengglass.cn/api-v1-zone/getArea?parent=" + cityCode;
        // ResultData resultData = httpUtils.get(url, Maps.newHashMap());
        ResultData resultData = ResultData.getSuccessResult();
        resultData.setData("{\"code\":1,\"msg\":\"获取区县列表成功\",\"data\":[{\"value\":\"510101\",\"text\":\"市辖区\"},{\"value\":\"510104\",\"text\":\"锦江区\"},{\"value\":\"510105\",\"text\":\"青羊区\"},{\"value\":\"510106\",\"text\":\"金牛区\"},{\"value\":\"510107\",\"text\":\"武侯区\"},{\"value\":\"510108\",\"text\":\"成华区\"},{\"value\":\"510112\",\"text\":\"龙泉驿区\"},{\"value\":\"510113\",\"text\":\"青白江区\"},{\"value\":\"510114\",\"text\":\"新都区\"},{\"value\":\"510115\",\"text\":\"温江区\"},{\"value\":\"510121\",\"text\":\"金堂县\"},{\"value\":\"510122\",\"text\":\"双流县\"},{\"value\":\"510124\",\"text\":\"郫县\"},{\"value\":\"510129\",\"text\":\"大邑县\"},{\"value\":\"510131\",\"text\":\"蒲江县\"},{\"value\":\"510132\",\"text\":\"新津县\"},{\"value\":\"510181\",\"text\":\"都江堰市\"},{\"value\":\"510182\",\"text\":\"彭州市\"},{\"value\":\"510183\",\"text\":\"邛崃市\"},{\"value\":\"510184\",\"text\":\"崇州市\"}]}");

        Map<String, String> areaMap = parseBankResult(resultData);
        return areaMap;
    }


}
