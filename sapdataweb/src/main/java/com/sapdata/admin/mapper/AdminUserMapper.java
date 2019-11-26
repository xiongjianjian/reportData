package com.sapdata.admin.mapper;

import com.sapdata.admin.bean.AdminUser;
import com.sapdata.admin.bean.AdminUserVo;

import java.util.List;

public interface AdminUserMapper {

    void deleteByPrimaryKey(Long userId);

    void insert(AdminUser adminUser);

    AdminUser selectByPrimaryKey(Long userId);

    void updateByPrimaryKey(AdminUserVo adminUserVo);

    List<AdminUserVo> findAll(AdminUserVo adminUserVo);

    AdminUser checkUserBysSale(AdminUser adminUser);

    AdminUser checkUserByCustom(AdminUser adminUser);

    Long countAll(AdminUserVo adminUserVo);
}