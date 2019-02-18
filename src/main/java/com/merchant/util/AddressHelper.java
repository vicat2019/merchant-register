package com.merchant.util;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;

/**
 * @program: merchant-register
 * @description: 随机生成地址
 * @author: Vincent
 * @create: 2019-02-15 11:08
 **/
public class AddressHelper {

    private static final String street = "莲花社区北一巷10号,大业路8号,滨江中路13号,三圣街33号407室,三元巷51号,光华街1栋,牛沙路15号附1号,东顺城中街邮电五所,昭忠祠街8号侧,桂五桥西街52号,海椒市街60号,东光东怡街79号,东光街5号院内,水碾河南一街15栋院内,川师北大门,均隆街,秀水园,成龙路皇经社区内,洗面桥横街社区居委会建国巷1号,洗面桥东一街3号,洗面桥街7号,武侯祠横街12号2楼,武侯祠大街63号,一环路西一段11号,国学巷34号,小天东街4号附1号,南虹村,电信南街12号,临江路8号1单元2楼,一环路南二段7号附4号,十一街9号,致民路21号,十七街9号,郭家桥南街5号,郭家桥北街10号,玉林横街,玉林一巷茶园,玉林下横巷8号,玉洁巷16号,玉林五巷3号,人民南路4段9号,磨子巷4号,棕南西街1号,科院街4号附2号,南站派出所旁,长寿路53号,科华中路5号7楼,人南4段38号长寿桥干休所旁,棕树2组大院,高攀路,双楠路239号,双楠路61号,双楠街259号,少陵横街68号大院,大石南路36号,百吉街23号,董家湾北街2号-801,双丰西路17幢15号,红牌楼北街社区居委会红牌楼北街15号,簇桥乡福锦路239号乡政府内,机投正街,金花镇金花桥街28号镇政府内,晋阳路422号物业公司4楼,花径路138号,新鸿路77号,跳蹬河北路2号,猛追湾10号,二仙桥路1号,双建路70号,府青路三段府青巷4号,双桥路南2街90号,长天路28号,建设南街9号,建设路北三街58号,龙潭寺中街29号,蜀都大道五桂桥,云龙路115号,桂溪街道和平社区,肖家河东1巷花园,肖家河4巷6号,兴蓉东1号,二环路南四段16号,元通一巷,蓓蕾街中巷5号,芳草街24号长信公寓附24号,新能巷6号,荆竹北街27号,紫竹北路58号,新光路60号,石羊街道新街社区,百花潭路8号,横小南街2号,东门街69号,清江西路1号,石人西路36号,西御河沿街12号,双新科创园光明苑内,王家塘巷1号,白云寺街65号,忠烈祠西街53号,苏坡中路8号,文家场正街224号,光荣路19号,青西路98号,西体路5号,泰宏路9号,肖二巷2号,商贸大道一段7号,星辰路一街8号,银河北街3号交大吾家八期五楼,茶店子安蓉路8号,黄忠街8号,蜀西路26号,政通路（社区服务中心）,天回镇明月路,土桥金周路999号";

    private static final String province = "四川省";

    private static final String city = "成都市,自贡市,攀枝花市,泸州市,德阳市,绵阳市,广元市,遂宁市,内江市,乐山市,南充市,眉山市,宜宾市,广安市,达州市,雅安市,巴中市,资阳市,阿坝藏族羌族自治州,甘孜藏族自治州,凉山彝族自治州";

    private static final String area = "锦江区,青羊区,金牛区,武侯区,成华区,龙泉驿区,青白江区,新都区,温江区,金堂县,双流县,郫县,大邑县,蒲江县,新津县,都江堰市,彭州市,邛崃市,崇州市";

    private static List<String> cityList;
    private static List<String> areaList;
    private static List<String> streetList;

    static {
        cityList = Lists.newArrayList(Splitter.on(",").split(city));
        areaList = Lists.newArrayList(Splitter.on(",").split(area));
        streetList = Lists.newArrayList(Splitter.on(",").split(street));
    }

    /**
     * 生成地址
     *
     * @return String
     */
    public static String getAddress() {
        String[] addressInfo = getAddressInfo();
        return Joiner.on("").join(addressInfo);
    }

    /**
     * 生成省市区街道
     *
     * @return String[]
     */
    public static String[] getAddressInfo() {
        String[] address = new String[4];

        address[0] = province;

        // 城市
        String cityName = "成都市";
        /*Random random = new Random();
        String cityName = cityList.get(random.nextInt(cityList.size()));
        if (random.nextInt(5) % 5 < 2) {
            cityName = "成都市";
        }*/
        address[1] = cityName;

        // 区县
        Random random2 = new Random();
        String areaName = areaList.get(random2.nextInt(areaList.size()));
        address[2] = areaName;

        // 街道
        Random random3 = new Random();
        String streetName = streetList.get(random3.nextInt(streetList.size()));

        // 号、栋、楼、室
        Random streetRandom = new Random();
        streetName = streetName.replaceAll("\\d+号", streetRandom.nextInt(100) + "号");
        streetName = streetName.replaceAll("\\d+栋", streetRandom.nextInt(10) + "号");
        streetName = streetName.replaceAll("\\d+楼", streetRandom.nextInt(10) + "楼");
        streetName = streetName.replaceAll("\\d+室", streetRandom.nextInt(10) + "0" + streetRandom.nextInt(10) + "室");
        address[3] = streetName;

        return address;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getAddress());
        }
    }


}
