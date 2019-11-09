package com.sapdata.admin.mapper;

import com.sapdata.admin.bean.AdminUser;

public interface AdminUserMapper {

    void deleteByPrimaryKey(Long userId);

    void insert(AdminUser adminUser);

    AdminUser selectByPrimaryKey(Long userId);

    void updateByPrimaryKey(AdminUser adminUser);
}