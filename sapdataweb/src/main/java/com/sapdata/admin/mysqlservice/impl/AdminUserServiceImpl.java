package com.sapdata.admin.mysqlservice.impl;

import com.sapdata.admin.bean.AdminUser;
import com.sapdata.admin.bean.AdminUserVo;
import com.sapdata.admin.mapper.AdminUserMapper;
import com.sapdata.admin.mysqlservice.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: wuhonghui
 * @Description:
 * @Date: 2019/11/9 9:37
 * @Modified: wuhonghui
 **/
@Service
public class AdminUserServiceImpl implements AdminUserService {


    @Autowired
    private AdminUserMapper adminUserMapper;

    @Override
    public void deleteByPrimaryKey(Long userId) {

        adminUserMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public void insert(AdminUser adminUser) {
        adminUserMapper.insert(adminUser);
    }

    @Override
    public AdminUser selectByPrimaryKey(Long userId) {
        return adminUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public void updateByPrimaryKey(AdminUserVo adminUserVo) {
        adminUserMapper.updateByPrimaryKey(adminUserVo);
    }


    @Override
    public AdminUserVo findAll(AdminUserVo adminUserVo) {
        //默认当当前页pageNo,每页数据量pageSize为空时,值为1,5
        Integer pageSize = adminUserVo.getPageSize() == null ? 5 : adminUserVo.getPageSize();
        Integer pageNum = adminUserVo.getPageNo() == null ? 1 : adminUserVo.getPageNo();

        adminUserVo.setPageNo((pageNum - 1) * pageSize);

        adminUserVo.setPageSize(pageSize);
        AdminUserVo usersList = new AdminUserVo();

        usersList.setPageNo(pageNum);

        usersList.setPageSize(pageSize);
        usersList.setList(adminUserMapper.findAll(adminUserVo));
        return usersList;
    }

    @Override
    public AdminUser checkUserBysSale(String saleCode, String salePassword) {
        AdminUser adminUser = new AdminUser();
        adminUser.setSaleCode(saleCode);
        adminUser.setSalePassword(salePassword);
        return adminUserMapper.checkUserBysSale(adminUser);
    }

    @Override
    public AdminUser checkUserByCustom(String customerCode, String customerPassword) {
        AdminUser adminUser = new AdminUser();
        adminUser.setCustomerCode(customerCode);
        adminUser.setCustomerPassword(customerPassword);
        return adminUserMapper.checkUserByCustom(adminUser);
    }

    @Override
    public Long countAll(AdminUserVo adminUserVo) {
        return adminUserMapper.countAll(adminUserVo);
    }

    @Override
    public int checkAccount(String account) {
        String[] acc = account.split(":");
        AdminUser info = new AdminUser();
        //判断是否存在相同编号，存在返回1
        int index=0;
        if ("customerCode".equals(acc[0])){
            info.setCustomerCode(acc[1]);
            index=adminUserMapper.checkUserByCustom(info) == null? -1 : 1 ;
        }else{
            info.setSaleCode(acc[1]);
            index=adminUserMapper.checkUserBysSale(info) == null? -1 : 1 ;
        }
        return index;
    }
}
