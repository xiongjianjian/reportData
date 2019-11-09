package com.sapdata.admin.mysqlservice.impl;

import com.sapdata.admin.bean.AdminUser;
import com.sapdata.admin.mapper.AdminUserMapper;
import com.sapdata.admin.mysqlservice.AdminUserService;
import com.sapdata.admin.util.DynamicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
