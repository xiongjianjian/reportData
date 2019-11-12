package com.sapdata.admin.mysqlservice.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sapdata.admin.bean.AdminUser;
import com.sapdata.admin.mapper.AdminUserMapper;
import com.sapdata.admin.mysqlservice.AdminUserService;
import com.sapdata.admin.util.DynamicDataSource;
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
    public void updateByPrimaryKey(AdminUser adminUser) {
        adminUserMapper.updateByPrimaryKey(adminUser);
    }

    @Override
    public PageInfo<AdminUser> findAll(AdminUser adminUser,Integer pageNo,Integer pageSize) {
        pageNo = pageNo == null?1:pageNo;
        pageSize = pageSize == null?8:pageSize;
        PageHelper.startPage(pageNo, pageSize);
        List<AdminUser> list=adminUserMapper.findAll(adminUser);
        PageInfo<AdminUser> page = new PageInfo<AdminUser>(list);
        return page;
    }

    @Override
    public AdminUser checkUserBysSale(String saleCode, String salePassword) {
        AdminUser adminUser=new AdminUser();
        adminUser.setSaleCode(saleCode);
        adminUser.setSalePassword(salePassword);
        return adminUserMapper.checkUserBysSale(adminUser);
    }

    @Override
    public AdminUser checkUserByCustom(String customerCode, String customerPassword) {
        AdminUser adminUser=new AdminUser();
        adminUser.setCustomerCode(customerCode);
        adminUser.setCustomerPassword(customerPassword);
        return adminUserMapper.checkUserByCustom(adminUser);
    }
}
