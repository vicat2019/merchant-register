package com.merchant.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.merchant.dao.RsMerchantInfoMapper;
import com.merchant.entity.ResultData;
import com.merchant.entity.RuiShengUserInfo;
import com.merchant.service.BaseService;
import com.merchant.service.RsMerchantInfoService;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Description: 商户数据服务类
 * @Author: Vincent
 * @Date: 2019/2/16
 */
@Service("rsMerchantInfoService")
public class RuiShengUserInfoServiceImpl extends BaseService<RsMerchantInfoMapper, RuiShengUserInfo>
        implements RsMerchantInfoService {


    /**
     * 添加商户信息
     *
     * @param obj 商户信息
     * @return ResultData
     * @throws Exception 异常
     */
    @Override
    public ResultData add(RuiShengUserInfo obj) throws Exception {
        if (obj == null) {
            return ResultData.getErrResult("参数不能为空");
        }
        int result = mapper.insert(obj);
        return ResultData.getSuccessResult(result);
    }

    /**
     * 更新商户
     *
     * @param obj 商户信息
     * @return ResultData
     * @throws Exception 异常
     */
    @Override
    public ResultData update(RuiShengUserInfo obj) throws Exception {
        if (obj == null) {
            return ResultData.getErrResult("参数不能为空");
        }
        if (obj.getId() == 0) {
            return ResultData.getErrResult("ID不能为空");
        }

        int result = mapper.updateByPrimaryKey(obj);
        return ResultData.getSuccessResult(result);
    }

    /**
     * 根据ID查询商户
     *
     * @param id ID值
     * @return ResultData
     * @throws Exception 异常
     */
    @Override
    public ResultData get(Integer id) throws Exception {
        if (id == null || id == 0) {
            return ResultData.getErrResult("ID不能为空");
        }

        RuiShengUserInfo result = mapper.selectByPrimaryKey(id);
        return ResultData.getSuccessResult(result);
    }

    /**
     * 查询商户
     *
     * @param shengUserInfo 查询条件
     * @param pageNum       页码
     * @param size          每页记录数
     * @return ResultData
     * @throws Exception 异常
     */
    @Override
    public ResultData queryRuiShengUser(RuiShengUserInfo shengUserInfo, int pageNum, int size) throws Exception {
        PageHelper.startPage(pageNum, size);

        List<RuiShengUserInfo> userList = mapper.queryRuiShengUser(null);
        PageInfo page = new PageInfo(userList);
        return ResultData.getSuccessResult(page);
    }

    /**
     * 查询所有商户名称
     *
     * @return List
     * @throws Exception 异常
     */
    @Override
    public List<String> getAllName() throws Exception {
        return mapper.getAllName();
    }

    /**
     * 删除商户
     *
     * @param id ID
     * @return ResultData
     * @throws Exception 异常
     */
    @Override
    public ResultData del(Integer id) throws Exception {
        if (id == null || id == 0) {
            return ResultData.getErrResult("ID不能为空");
        }

        int result = mapper.deleteByPrimaryKey(id);
        return ResultData.getSuccessResult(result);
    }
}
