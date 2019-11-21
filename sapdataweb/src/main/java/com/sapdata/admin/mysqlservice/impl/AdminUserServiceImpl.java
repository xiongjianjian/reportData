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
    public void updateByPrimaryKey(AdminUser adminUser) {
        adminUserMapper.updateByPrimaryKey(adminUser);
    }

    @Override
    public List<AdminUser> findAll(AdminUserVo adminUserVo) {
        Integer pageNo = adminUserVo.getPageNo() == null?1:adminUserVo.getPageNo();
        Integer pageSize = adminUserVo.getPageSize() == null?8:adminUserVo.getPageSize();
        pageNo=(pageNo-1)*pageSize;
        adminUserVo.setPageNo(pageNo);
        adminUserVo.setPageSize(pageSize);
        List<AdminUser> list=adminUserMapper.findAll(adminUserVo);
        return list;
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

    @Override
    public Long countAll(AdminUserVo adminUserVo) {
        return adminUserMapper.countAll(adminUserVo);
    }
}
