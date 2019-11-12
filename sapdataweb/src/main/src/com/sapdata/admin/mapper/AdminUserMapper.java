package com.sapdata.admin.mapper;

import com.sapdata.admin.bean.AdminUser;

import java.util.List;

public interface AdminUserMapper {

    void deleteByPrimaryKey(Long userId);

    void insert(AdminUser adminUser);

    AdminUser selectByPrimaryKey(Long userId);

    void updateByPrimaryKey(AdminUser adminUser);

    List<AdminUser> findAll(AdminUser adminUser);

    AdminUser checkUserBysSale(AdminUser adminUser);

    AdminUser checkUserByCustom(AdminUser adminUser);
}