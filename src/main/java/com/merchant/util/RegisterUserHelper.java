package com.merchant.util;

import com.merchant.entity.RuiShengUserInfo;

/**
 * @program: merchant-register
 * @description: 提供进件用户信息
 * @author: Vincent
 * @create: 2019-02-15 09:21
 **/
public class RegisterUserHelper {

    // 代理商户编号
    private static final String MCH_ID = "00020019";


    public static RuiShengUserInfo getChenZhuo(String merchantName, String province, String city, String area, String address,
                                               String doorpic, String pname, String cname, String aname, String phone,
                                               String email, String originalName) {
        RuiShengUserInfo userInfo = new RuiShengUserInfo();
        userInfo.setMchid(MCH_ID);

        userInfo.setName(merchantName);
        userInfo.setProvince(province);
        userInfo.setCity(city);
        userInfo.setArea(area);
        userInfo.setAddress(address);
        userInfo.setLegelname("陈焯");
        userInfo.setLegelcertno("510108198911160623");
        userInfo.setEmail(email);
        userInfo.setPhone(phone);

        userInfo.setBankno("1020000");
        userInfo.setBranchno("102651007079");
        userInfo.setCardno("6222084402009336307");
        userInfo.setEcardno("6231099101000642010");
        userInfo.setPayname("陈焯");
        userInfo.setCertno("510108198911160623");

        userInfo.setPayphone("18683611150");
        userInfo.setCardprovince("510000");
        userInfo.setCardcity("510100");
        userInfo.setCardarea("510104");
        userInfo.setType("1");
        userInfo.setCerttype("1");

        userInfo.setBuslicpic("/uploads/19/1227b063fa8b54b5db7bdd4d20d404.jpg");
        userInfo.setLegfrontpic("/uploads/19/1227b063fa8b54b5db7bdd4d20d404.jpg");
        userInfo.setLegbackpic("/uploads/ac/9394769860fefe1cc8074403e8cc5b.jpg");
        userInfo.setHandpic("/uploads/70/116b9c294482f3d1fe2a6f09967b47.jpg");
        userInfo.setDoorpic(doorpic);

        userInfo.setRate("31");
        userInfo.setRemark(originalName);


        userInfo.setProvincename(pname);
        userInfo.setCityname(cname);
        userInfo.setAreaname(aname);

        userInfo.setCardprovincename("四川省");
        userInfo.setCardcityname("成都市");
        userInfo.setCardareaname("锦江区");
        userInfo.setBankname("工商银行");
        userInfo.setBranchname("中国工商银行成都春熙静康路分理处");

        return userInfo;
    }

    public static RuiShengUserInfo getPengCheng(String merchantName, String province, String city, String area, String address,
                                                String doorpic, String pname, String cname, String aname, String phone,
                                                String email, String originalName) {
        RuiShengUserInfo userInfo = new RuiShengUserInfo();
        userInfo.setMchid(MCH_ID);

        userInfo.setName(merchantName);
        userInfo.setProvince(province);
        userInfo.setCity(city);
        userInfo.setArea(area);
        userInfo.setAddress(address);
        userInfo.setLegelname("彭丞");
        userInfo.setLegelcertno("622123198909270074");
        userInfo.setEmail(email);
        userInfo.setPhone(phone);

        userInfo.setBankno("1020000");
        userInfo.setBranchno("102651007079");
        userInfo.setCardno("6222084402007746325");
        userInfo.setEcardno("6231099101000642283");
        userInfo.setPayname("彭丞");
        userInfo.setCertno("622123198909270074");

        userInfo.setPayphone("18081127827");
        userInfo.setCardprovince("510000");
        userInfo.setCardcity("510100");
        userInfo.setCardarea("510104");
        userInfo.setType("1");
        userInfo.setCerttype("1");

        userInfo.setBuslicpic("/uploads/07/0c840a038c3fe6ea35e7996dc7da93.jpg");
        userInfo.setLegfrontpic("/uploads/07/0c840a038c3fe6ea35e7996dc7da93.jpg");
        userInfo.setLegbackpic("/uploads/52/5c91091221a95a423643550d212961.jpg");
        userInfo.setHandpic("/uploads/95/1640ee74bdf9ad60811dd5c609350a.jpg");
        userInfo.setDoorpic(doorpic);

        userInfo.setRate("31");
        userInfo.setRemark(originalName);

        userInfo.setProvincename(pname);
        userInfo.setCityname(cname);
        userInfo.setAreaname(aname);

        userInfo.setCardprovincename("四川省");
        userInfo.setCardcityname("成都市");
        userInfo.setCardareaname("锦江区");
        userInfo.setBankname("工商银行");
        userInfo.setBranchname("中国工商银行成都龙舟路支行");

        return userInfo;
    }

    public static RuiShengUserInfo getLiJuan(String merchantName, String province, String city, String area, String address,
                                             String doorpic, String pname, String cname, String aname, String phone,
                                             String email, String originalName) {
        RuiShengUserInfo userInfo = new RuiShengUserInfo();
        userInfo.setMchid(MCH_ID);

        userInfo.setName(merchantName);
        userInfo.setProvince(province);
        userInfo.setCity(city);
        userInfo.setArea(area);
        userInfo.setAddress(address);
        userInfo.setLegelname("李娟");
        userInfo.setLegelcertno("513426199704054728");
        userInfo.setEmail(email);
        userInfo.setPhone(phone);

        userInfo.setBankno("1020000");
        userInfo.setBranchno("102651007079");
        userInfo.setCardno("6212264402081271946");
        userInfo.setEcardno("6231099101000642507");
        userInfo.setPayname("李娟");
        userInfo.setCertno("513426199704054728");

        userInfo.setPayphone("15828658959");
        userInfo.setCardprovince("510000");
        userInfo.setCardcity("510100");
        userInfo.setCardarea("510107");
        userInfo.setType("1");
        userInfo.setCerttype("1");

        userInfo.setBuslicpic("/uploads/d5/b4ac1153da2987a90854cd8f23de10.jpg");
        userInfo.setLegfrontpic("/uploads/d5/b4ac1153da2987a90854cd8f23de10.jpg");
        userInfo.setLegbackpic("/uploads/fb/b7f152eaea0966ee8c60bf4c377186.jpg");
        userInfo.setHandpic("/uploads/78/72eec44708d2c97b5549848956a755.jpg");
        userInfo.setDoorpic(doorpic);

        userInfo.setRate("31");
        userInfo.setRemark(originalName);

        userInfo.setProvincename(pname);
        userInfo.setCityname(cname);
        userInfo.setAreaname(aname);

        userInfo.setCardprovincename("四川省");
        userInfo.setCardcityname("成都市");
        userInfo.setCardareaname("武侯区");
        userInfo.setBankname("工商银行");
        userInfo.setBranchname("中国工商银行成都滨江红牌楼支行");

        return userInfo;
    }

    @Deprecated
    public static RuiShengUserInfo getYiChengCheng(String merchantName, String province, String city, String area, String address,
                                                   String doorpic, String pname, String cname, String aname, String phone, String email) {
        RuiShengUserInfo userInfo = new RuiShengUserInfo();
        userInfo.setMchid(MCH_ID);

        userInfo.setName(merchantName);
        userInfo.setProvince(province);
        userInfo.setCity(city);
        userInfo.setArea(area);
        userInfo.setAddress(address);
        userInfo.setLegelname("尹程程");
        userInfo.setLegelcertno("500227199410275227");
        userInfo.setEmail(email);
        userInfo.setPhone(phone);

        userInfo.setBankno("1020000");
        userInfo.setBranchno("102651007079");
        userInfo.setCardno("6212264402056125986");
        userInfo.setEcardno("6231099101000645179");
        userInfo.setPayname("尹程程");
        userInfo.setCertno("500227199410275227");

        userInfo.setPayphone("15025347071");
        userInfo.setCardprovince("510000");
        userInfo.setCardcity("510100");
        userInfo.setCardarea("510107");
        userInfo.setType("1");
        userInfo.setCerttype("1");

        userInfo.setBuslicpic("/uploads/2b/6fa3bfbac663bca38901c5c4050d7e.jpg");
        userInfo.setLegfrontpic("/uploads/2b/6fa3bfbac663bca38901c5c4050d7e.jpg");
        userInfo.setLegbackpic("/uploads/44/dbe9f8c07e863a1a88cd29dd2fda57.jpg");
        userInfo.setHandpic("/uploads/ec/1deb16167aa69088ea904ae68f77a0.jpg");
        userInfo.setDoorpic(doorpic);

        userInfo.setRate("31");

        userInfo.setProvincename(pname);
        userInfo.setCityname(cname);
        userInfo.setAreaname(aname);

        userInfo.setCardprovincename("四川省");
        userInfo.setCardcityname("成都市");
        userInfo.setCardareaname("武侯区");
        userInfo.setBankname("工商银行");
        userInfo.setBranchname("中国工商银行成都东大金兴支行");

        return userInfo;
    }

    @Deprecated
    public static RuiShengUserInfo getPuXingMei(String merchantName, String province, String city, String area, String address,
                                                String doorpic, String pname, String cname, String aname, String phone, String email) {
        RuiShengUserInfo userInfo = new RuiShengUserInfo();
        userInfo.setMchid(MCH_ID);

        userInfo.setName(merchantName);
        userInfo.setProvince(province);
        userInfo.setCity(city);
        userInfo.setArea(area);
        userInfo.setAddress(address);
        userInfo.setLegelname("蒲星媚");
        userInfo.setLegelcertno("511321199701010341");
        userInfo.setEmail(email);
        userInfo.setPhone(phone);

        userInfo.setBankno("1020000");
        userInfo.setBranchno("102651007079");
        userInfo.setCardno("6212262313001836639");
        userInfo.setEcardno("6231099101000652977");
        userInfo.setPayname("蒲星媚");
        userInfo.setCertno("511321199701010341");

        userInfo.setPayphone("15583986048");
        userInfo.setCardprovince("510000");
        userInfo.setCardcity("511400");
        userInfo.setCardarea("511402");
        userInfo.setType("1");
        userInfo.setCerttype("1");

        userInfo.setBuslicpic("/uploads/a9/611485415557eda7bab2626664bfe2.jpg");
        userInfo.setLegfrontpic("/uploads/a9/611485415557eda7bab2626664bfe2.jpg");
        userInfo.setLegbackpic("/uploads/11/aea31c71bfc76d6e59c28300be3ece.jpg");
        userInfo.setHandpic("/uploads/6d/b864c1343d47922fa76f23881769cb.jpg");
        userInfo.setDoorpic(doorpic);

        userInfo.setRate("31");

        userInfo.setProvincename(pname);
        userInfo.setCityname(cname);
        userInfo.setAreaname(aname);

        userInfo.setCardprovincename("四川省");
        userInfo.setCardcityname("眉山市");
        userInfo.setCardareaname("东坡区");
        userInfo.setBankname("工商银行");
        userInfo.setBranchname("中国工商银行四川省眉山市分行眉山新区大市场分行");

        return userInfo;
    }

    public static RuiShengUserInfo getHuangJie(String merchantName, String province, String city, String area, String address,
                                               String doorpic, String pname, String cname, String aname, String phone,
                                               String email, String remark) {
        RuiShengUserInfo userInfo = new RuiShengUserInfo();
        userInfo.setMchid(MCH_ID);

        userInfo.setName(merchantName);
        userInfo.setProvince(province);
        userInfo.setCity(city);
        userInfo.setArea(area);
        userInfo.setAddress(address);
        userInfo.setLegelname("黄捷");
        userInfo.setLegelcertno("440982199410272970");
        userInfo.setEmail(email);
        userInfo.setPhone(phone);

        userInfo.setBankno("3020000");
        userInfo.setBranchno("302584044085");
        userInfo.setCardno("6217680302304188");
        userInfo.setEcardno("6231099101000685852");
        userInfo.setPayname("黄捷");
        userInfo.setCertno("440982199410272970");

        userInfo.setPayphone("13430485782");
        userInfo.setCardprovince("440000");
        userInfo.setCardcity("440300");
        userInfo.setCardarea("440306");
        userInfo.setType("1");
        userInfo.setCerttype("1");

        userInfo.setBuslicpic("/uploads/e8/10cc0327b9125d2764db499c67736e.jpg");
        userInfo.setLegfrontpic("/uploads/e8/10cc0327b9125d2764db499c67736e.jpg");
        userInfo.setLegbackpic("/uploads/81/2deedb564f349f9fa52e38b9756812.jpg");
        userInfo.setHandpic("/uploads/ce/000bb90d28f36a9d73c40bdde7c9cd.jpg");
        userInfo.setDoorpic(doorpic);

        userInfo.setRate("31");
        userInfo.setRemark(remark);

        userInfo.setProvincename(pname);
        userInfo.setCityname(cname);
        userInfo.setAreaname(aname);

        userInfo.setCardprovincename("广东省");
        userInfo.setCardcityname("深圳市");
        userInfo.setCardareaname("西乡区");
        userInfo.setBankname("中信银行");
        userInfo.setBranchname("中信银行西乡支行");

        return userInfo;
    }

    public static RuiShengUserInfo getChenYuMing(String merchantName, String province, String city, String area, String address,
                                                 String doorpic, String pname, String cname, String aname, String phone,
                                                 String email, String remark) {
        RuiShengUserInfo userInfo = new RuiShengUserInfo();
        userInfo.setMchid(MCH_ID);


        userInfo.setLegelname("陈裕明");
        userInfo.setLegelcertno("441424199701112272");
        userInfo.setPayname("陈裕明");
        userInfo.setCertno("441424199701112272");

        userInfo.setCardno("6217852000009016547");
        userInfo.setEcardno("6231099101000685779");

        userInfo.setPayphone("13160721607");


        userInfo.setBankno("1040000");
        userInfo.setBranchno("104584002488");

        userInfo.setCardprovince("440000");
        userInfo.setCardcity("440300");
        userInfo.setCardarea("440307");


        userInfo.setCardprovincename("广东省");
        userInfo.setCardcityname("深圳市");
        userInfo.setCardareaname("龙岗区");
        userInfo.setBankname("中国银行");
        userInfo.setBranchname("中国银行深圳大鹏支行");


        userInfo.setBuslicpic("/uploads/d4/be019a041da29c12024a44f50c9f80.jpg");
        userInfo.setLegfrontpic("/uploads/2a/26c0255ca232da5b4df46ea8c3a02a.jpg");
        userInfo.setLegbackpic("/uploads/d4/be019a041da29c12024a44f50c9f80.jpg");
        userInfo.setHandpic("/uploads/71/136506f35b7ef41db1a2ceae118719.jpg");

        userInfo.setName(merchantName);
        userInfo.setProvince(province);
        userInfo.setCity(city);
        userInfo.setArea(area);
        userInfo.setAddress(address);
        userInfo.setEmail(email);
        userInfo.setPhone(phone);

        userInfo.setType("1");
        userInfo.setCerttype("1");
        userInfo.setDoorpic(doorpic);

        userInfo.setRate("31");
        userInfo.setRemark(remark);

        userInfo.setProvincename(pname);
        userInfo.setCityname(cname);
        userInfo.setAreaname(aname);

        return userInfo;
    }

    public static RuiShengUserInfo getYuJiaYan(String merchantName, String province, String city, String area, String address,
                                               String doorpic, String pname, String cname, String aname, String phone,
                                               String email, String remark) {
        RuiShengUserInfo userInfo = new RuiShengUserInfo();
        userInfo.setMchid(MCH_ID);


        userInfo.setLegelname("余家燕");
        userInfo.setLegelcertno("510112199704281229");
        userInfo.setPayname("余家燕");
        userInfo.setCertno("510112199704281229");

        userInfo.setCardno("6214921605840707");
        userInfo.setEcardno("6231099101000651417");

        userInfo.setPayphone("17348081850");


        userInfo.setBankno("3030000");
        userInfo.setBranchno("303651000206");

        userInfo.setCardprovince("510000");
        userInfo.setCardcity("510100");
        userInfo.setCardarea("510107");


        userInfo.setCardprovincename("四川省");
        userInfo.setCardcityname("成都市");
        userInfo.setCardareaname("武侯区");
        userInfo.setBankname("光大银行");
        userInfo.setBranchname("中国光大银行成都高新支行");


        userInfo.setBuslicpic("/uploads/7d/cb002c7ecfdb15aff949b9fc87317b.jpg");
        userInfo.setLegfrontpic("/uploads/db/f4b6b5c5324d4b826d14c36a5caf83.jpg");
        userInfo.setLegbackpic("/uploads/7d/cb002c7ecfdb15aff949b9fc87317b.jpg");
        userInfo.setHandpic("/uploads/78/79109b76123b904227ae34501d88c7.jpg");

        userInfo.setName(merchantName);
        userInfo.setProvince(province);
        userInfo.setCity(city);
        userInfo.setArea(area);
        userInfo.setAddress(address);
        userInfo.setEmail(email);
        userInfo.setPhone(phone);

        userInfo.setType("1");
        userInfo.setCerttype("1");
        userInfo.setDoorpic(doorpic);

        userInfo.setRate("31");
        userInfo.setRemark(remark);

        userInfo.setProvincename(pname);
        userInfo.setCityname(cname);
        userInfo.setAreaname(aname);

        return userInfo;
    }

    public static RuiShengUserInfo getZhouTing(String merchantName, String province, String city, String area, String address,
                                               String doorpic, String pname, String cname, String aname, String phone,
                                               String email, String remark) {
        RuiShengUserInfo userInfo = new RuiShengUserInfo();
        userInfo.setMchid(MCH_ID);


        userInfo.setLegelname("周婷");
        userInfo.setLegelcertno("511126199609074044");
        userInfo.setPayname("周婷");
        userInfo.setCertno("511126199609074044");

        userInfo.setCardno("6228480468753815876");
        userInfo.setEcardno("6231099101000642093");

        userInfo.setPayphone("18784508142");


        userInfo.setBankno("1030000");
        userInfo.setBranchno("103651086780");

        userInfo.setCardprovince("510000");
        userInfo.setCardcity("510100");
        userInfo.setCardarea("510184");


        userInfo.setCardprovincename("四川省");
        userInfo.setCardcityname("成都市");
        userInfo.setCardareaname("武侯区");
        userInfo.setBankname("农业银行");
        userInfo.setBranchname("中国农业银行崇州街子分理处");


        userInfo.setBuslicpic("/uploads/fb/63f0acfb993361adb695bfc4a9eece.jpg");
        userInfo.setLegfrontpic("/uploads/9c/f2b655f22936381dd935acd0dd45a6.jpg");
        userInfo.setLegbackpic("/uploads/fb/63f0acfb993361adb695bfc4a9eece.jpg");
        userInfo.setHandpic("/uploads/43/07865aeb11c985e1522d7f27fd2e3f.jpg");

        userInfo.setName(merchantName);
        userInfo.setProvince(province);
        userInfo.setCity(city);
        userInfo.setArea(area);
        userInfo.setAddress(address);
        userInfo.setEmail(email);
        userInfo.setPhone(phone);

        userInfo.setType("1");
        userInfo.setCerttype("1");
        userInfo.setDoorpic(doorpic);

        userInfo.setRate("31");
        userInfo.setRemark(remark);

        userInfo.setProvincename(pname);
        userInfo.setCityname(cname);
        userInfo.setAreaname(aname);

        return userInfo;
    }

    public static RuiShengUserInfo getMaBo(String merchantName, String province, String city, String area, String address,
                                           String doorpic, String pname, String cname, String aname, String phone,
                                           String email, String remark) {
        RuiShengUserInfo userInfo = new RuiShengUserInfo();
        userInfo.setMchid(MCH_ID);


        userInfo.setLegelname("马博");
        userInfo.setLegelcertno("510104199010151470");
        userInfo.setPayname("马博");
        userInfo.setCertno("510104199010151470");

        userInfo.setCardno("6222620530010430478");
        userInfo.setEcardno("6231099101000642465");

        userInfo.setPayphone("18628197575");


        userInfo.setBankno("3010000");
        userInfo.setBranchno("301651000023");

        userInfo.setCardprovince("510000");
        userInfo.setCardcity("510100");
        userInfo.setCardarea("510105");


        userInfo.setCardprovincename("四川省");
        userInfo.setCardcityname("成都市");
        userInfo.setCardareaname("青羊区");
        userInfo.setBankname("农业银行");
        userInfo.setBranchname("交通银行四川分行营业部");


        userInfo.setBuslicpic("/uploads/e2/47b1f98f23c4341c84e4ae3451036b.jpg");
        userInfo.setLegfrontpic("/uploads/73/421d68988a4e6e8ec5f71f540ca248.jpg");
        userInfo.setLegbackpic("/uploads/e2/47b1f98f23c4341c84e4ae3451036b.jpg");
        userInfo.setHandpic("/uploads/ca/341c33291d6a9be6f3cbc0ac393140.jpg");

        userInfo.setName(merchantName);
        userInfo.setProvince(province);
        userInfo.setCity(city);
        userInfo.setArea(area);
        userInfo.setAddress(address);
        userInfo.setEmail(email);
        userInfo.setPhone(phone);

        userInfo.setType("1");
        userInfo.setCerttype("1");
        userInfo.setDoorpic(doorpic);

        userInfo.setRate("31");
        userInfo.setRemark(remark);

        userInfo.setProvincename(pname);
        userInfo.setCityname(cname);
        userInfo.setAreaname(aname);

        return userInfo;
    }

    public static RuiShengUserInfo getWenXuan(String merchantName, String province, String city, String area, String address,
                                              String doorpic, String pname, String cname, String aname, String phone,
                                              String email, String remark) {
        RuiShengUserInfo userInfo = new RuiShengUserInfo();
        userInfo.setMchid(MCH_ID);


        userInfo.setLegelname("文旋");
        userInfo.setLegelcertno("51382519881012281X");
        userInfo.setPayname("文旋");
        userInfo.setCertno("51382519881012281X");

        userInfo.setCardno("6226192010644557");
        userInfo.setEcardno("6231099101000660137");

        userInfo.setPayphone("13980610794");


        userInfo.setBankno("3050000");
        userInfo.setBranchno("305651000288");

        userInfo.setCardprovince("510000");
        userInfo.setCardcity("510100");
        userInfo.setCardarea("510105");


        userInfo.setCardprovincename("四川省");
        userInfo.setCardcityname("成都市");
        userInfo.setCardareaname("青羊区");
        userInfo.setBankname("民生银行");
        userInfo.setBranchname("中国民生银行成都光华支行");


        userInfo.setBuslicpic("/uploads/b4/1d84a2dcf5eba5a14b7c4582a43ecb.jpg");
        userInfo.setLegfrontpic("/uploads/f9/453bcf1f490004e7649b7b150e2449.jpg");
        userInfo.setLegbackpic("/uploads/b4/1d84a2dcf5eba5a14b7c4582a43ecb.jpg");
        userInfo.setHandpic("/uploads/64/b4959416b81a3cc030686d1b4c2193.jpg");

        userInfo.setName(merchantName);
        userInfo.setProvince(province);
        userInfo.setCity(city);
        userInfo.setArea(area);
        userInfo.setAddress(address);
        userInfo.setEmail(email);
        userInfo.setPhone(phone);

        userInfo.setType("1");
        userInfo.setCerttype("1");
        userInfo.setDoorpic(doorpic);

        userInfo.setRate("31");
        userInfo.setRemark(remark);

        userInfo.setProvincename(pname);
        userInfo.setCityname(cname);
        userInfo.setAreaname(aname);

        return userInfo;
    }


    public static RuiShengUserInfo getTianXiaoWu(String merchantName, String province, String city, String area, String address,
                                                 String doorpic, String pname, String cname, String aname, String phone,
                                                 String email, String remark) {
        RuiShengUserInfo userInfo = new RuiShengUserInfo();
        userInfo.setMchid(MCH_ID);


        userInfo.setPayname("田笑吾");
        userInfo.setLegelname("田笑吾");
        userInfo.setLegelcertno("220524197306050192");
        userInfo.setCertno("220524197306050192");
        userInfo.setPayphone("15102802446");
        userInfo.setEcardno("6231099101000687767");
        userInfo.setCardno("6214624721000418820");

        userInfo.setBankno("3060000");
        userInfo.setBranchno("306651000059");
        userInfo.setBankname("广发银行");
        userInfo.setBankname("广发银行成都高升桥支行");

        userInfo.setCardprovince("510000");
        userInfo.setCardcity("510100");
        userInfo.setCardarea("510107");
        userInfo.setCardprovincename("四川省");
        userInfo.setCardcityname("成都市");
        userInfo.setCardareaname("武侯区");

        userInfo.setBuslicpic("/uploads/91/6ea223a87d34d47c9ed541b600edb2.jpg");
        userInfo.setLegfrontpic("/uploads/0d/5d8da830a92312073f11fc633a822f.jpg");
        userInfo.setLegbackpic("/uploads/91/6ea223a87d34d47c9ed541b600edb2.jpg");
        userInfo.setHandpic("/uploads/b7/854dace39a04a7dd0cfbad8a94d5b1.jpg");


        userInfo.setName(merchantName);
        userInfo.setProvince(province);
        userInfo.setCity(city);
        userInfo.setArea(area);
        userInfo.setAddress(address);
        userInfo.setEmail(email);
        userInfo.setPhone(phone);

        userInfo.setType("1");
        userInfo.setCerttype("1");
        userInfo.setDoorpic(doorpic);

        userInfo.setRate("31");
        userInfo.setRemark(remark);

        userInfo.setProvincename(pname);
        userInfo.setCityname(cname);
        userInfo.setAreaname(aname);

        return userInfo;
    }


    public static RuiShengUserInfo getMaWeiBin(String merchantName, String province, String city, String area, String address,
                                               String doorpic, String pname, String cname, String aname, String phone,
                                               String email, String remark) {
        RuiShengUserInfo userInfo = new RuiShengUserInfo();
        userInfo.setMchid(MCH_ID);


        userInfo.setPayname("马伟斌");
        userInfo.setLegelname("马伟斌");
        userInfo.setLegelcertno("620123198805012714");
        userInfo.setCertno("620123198805012714");
        userInfo.setPayphone("18508281232");
        userInfo.setEcardno("6231099101000685365");
        userInfo.setCardno("6222084402013301891");

        userInfo.setBankno("1020000");
        userInfo.setBranchno("102651020906");
        userInfo.setBankname("工商银行");
        userInfo.setBankname("中国工商银行四川省成都市春熙支行营业室");

        userInfo.setCardprovince("510000");
        userInfo.setCardcity("510100");
        userInfo.setCardarea("510104");
        userInfo.setCardprovincename("四川省");
        userInfo.setCardcityname("成都市");
        userInfo.setCardareaname("锦江区");

        userInfo.setBuslicpic("/uploads/b9/7af56df52a855477a50397d2740d79.jpg");
        userInfo.setLegfrontpic("/uploads/5d/4ee0c4889c6977da9db70e55aad3fa.jpg");
        userInfo.setLegbackpic("/uploads/b9/7af56df52a855477a50397d2740d79.jpg");
        userInfo.setHandpic("/uploads/70/57fb01bda0d0503040402276487d8d.jpg");


        userInfo.setName(merchantName);
        userInfo.setProvince(province);
        userInfo.setCity(city);
        userInfo.setArea(area);
        userInfo.setAddress(address);
        userInfo.setEmail(email);
        userInfo.setPhone(phone);

        userInfo.setType("1");
        userInfo.setCerttype("1");
        userInfo.setDoorpic(doorpic);

        userInfo.setRate("31");
        userInfo.setRemark(remark);

        userInfo.setProvincename(pname);
        userInfo.setCityname(cname);
        userInfo.setAreaname(aname);

        return userInfo;
    }


    public static RuiShengUserInfo getZhouYue(String merchantName, String province, String city, String area, String address,
                                              String doorpic, String pname, String cname, String aname, String phone,
                                              String email, String remark) {
        RuiShengUserInfo userInfo = new RuiShengUserInfo();
        userInfo.setMchid(MCH_ID);


        userInfo.setPayname("邹岳");
        userInfo.setLegelname("邹岳");
        userInfo.setLegelcertno("211302196302060866");
        userInfo.setCertno("211302196302060866");
        userInfo.setPayphone("15566639188");
        userInfo.setEcardno("6231099101000689318");
        userInfo.setCardno("6217992340007203726");

        userInfo.setBankno("1009999");
        userInfo.setBranchno("403234000083");
        userInfo.setBankname("邮政储蓄银行");
        userInfo.setBankname("中国邮政储蓄银行股份有限公司朝阳市站前支行");

        userInfo.setCardprovince("210000");
        userInfo.setCardcity("211300");
        userInfo.setCardarea("211302");
        userInfo.setCardprovincename("辽宁省");
        userInfo.setCardcityname("朝阳市");
        userInfo.setCardareaname("双塔区");

        userInfo.setBuslicpic("/uploads/9e/d1dbe1b2ed7e93db002b6afadbce09.jpg");
        userInfo.setLegfrontpic("/uploads/e8/04c5718eec2d07d7bebbd461df9af1.jpg");
        userInfo.setLegbackpic("/uploads/9e/d1dbe1b2ed7e93db002b6afadbce09.jpg");
        userInfo.setHandpic("/uploads/e4/f2934c7d80d4f2baf40bb81f958975.jpg");


        userInfo.setName(merchantName);
        userInfo.setProvince(province);
        userInfo.setCity(city);
        userInfo.setArea(area);
        userInfo.setAddress(address);
        userInfo.setEmail(email);
        userInfo.setPhone(phone);

        userInfo.setType("1");
        userInfo.setCerttype("1");
        userInfo.setDoorpic(doorpic);

        userInfo.setRate("31");
        userInfo.setRemark(remark);

        userInfo.setProvincename(pname);
        userInfo.setCityname(cname);
        userInfo.setAreaname(aname);

        return userInfo;
    }


    public static RuiShengUserInfo getWangYang(String merchantName, String province, String city, String area, String address,
                                               String doorpic, String pname, String cname, String aname, String phone,
                                               String email, String remark) {
        RuiShengUserInfo userInfo = new RuiShengUserInfo();
        userInfo.setMchid(MCH_ID);


        userInfo.setPayname("王洋");
        userInfo.setLegelname("王洋");
        userInfo.setLegelcertno("510722199407301268");
        userInfo.setCertno("510722199407301268");
        userInfo.setPayphone("18030594726");
        userInfo.setEcardno("6231099101000685662");
        userInfo.setCardno("6217003650002801846");

        userInfo.setBankno("1050000");
        userInfo.setBranchno("105665086086");
        userInfo.setBankname("建设银行");
        userInfo.setBranchname("中国建设银行股份有限公司乐山直属支行");

        userInfo.setCardprovince("510000");
        userInfo.setCardcity("511100");
        userInfo.setCardarea("511102");
        userInfo.setCardprovincename("四川省");
        userInfo.setCardcityname("乐山市");
        userInfo.setCardareaname("市中区");

        userInfo.setBuslicpic("/uploads/8b/b834ded4ede13572c8143ba3fb3e17.jpg");
        userInfo.setLegfrontpic("/uploads/66/66ff32cfe3f333b008d777602d5e57.jpg");
        userInfo.setLegbackpic("/uploads/8b/b834ded4ede13572c8143ba3fb3e17.jpg");
        userInfo.setHandpic("/uploads/88/bf04e5149fc78a557e299285c2a8bf.jpg");


        userInfo.setName(merchantName);
        userInfo.setProvince(province);
        userInfo.setCity(city);
        userInfo.setArea(area);
        userInfo.setAddress(address);
        userInfo.setEmail(email);
        userInfo.setPhone(phone);

        userInfo.setType("1");
        userInfo.setCerttype("1");
        userInfo.setDoorpic(doorpic);

        userInfo.setRate("31");
        userInfo.setRemark(remark);

        userInfo.setProvincename(pname);
        userInfo.setCityname(cname);
        userInfo.setAreaname(aname);

        return userInfo;
    }



    public static RuiShengUserInfo getZhangXuLiang(String merchantName, String province, String city, String area, String address,
                                               String doorpic, String pname, String cname, String aname, String phone,
                                               String email, String remark) {
        RuiShengUserInfo userInfo = new RuiShengUserInfo();
        userInfo.setMchid(MCH_ID);


        userInfo.setPayname("张旭良");
        userInfo.setLegelname("张旭良");
        userInfo.setLegelcertno("422202198010245758");
        userInfo.setCertno("422202198010245758");
        userInfo.setPayphone("18823665392");

        userInfo.setEcardno("6231099101000691926");
        userInfo.setCardno("6217582000044136752");

        userInfo.setBankno("1040000");
        userInfo.setBranchno("104584001160");
        userInfo.setBankname("中国银行");
        userInfo.setBranchname("中国银行深圳布吉支行");

        userInfo.setCardprovince("440000");
        userInfo.setCardcity("440300");
        userInfo.setCardarea("440307");
        userInfo.setCardprovincename("广东省");
        userInfo.setCardcityname("深圳市");
        userInfo.setCardareaname("龙岗区");

        userInfo.setBuslicpic("/uploads/e8/9a63d6a1a05399d43424c9e070922b.jpg");
        userInfo.setLegfrontpic("/uploads/55/eb8a60b77120e875448d01dcb32fcb.jpg");
        userInfo.setLegbackpic("/uploads/e8/9a63d6a1a05399d43424c9e070922b.jpg");
        userInfo.setHandpic("/uploads/4c/b4e70a439d9b8f10758b7fa250314b.jpg");

        userInfo.setName(merchantName);
        userInfo.setProvince(province);
        userInfo.setCity(city);
        userInfo.setArea(area);
        userInfo.setAddress(address);
        userInfo.setEmail(email);
        userInfo.setPhone(phone);

        userInfo.setType("1");
        userInfo.setCerttype("1");
        userInfo.setDoorpic(doorpic);

        userInfo.setRate("31");
        userInfo.setRemark(remark);

        userInfo.setProvincename(pname);
        userInfo.setCityname(cname);
        userInfo.setAreaname(aname);

        return userInfo;
    }


}
