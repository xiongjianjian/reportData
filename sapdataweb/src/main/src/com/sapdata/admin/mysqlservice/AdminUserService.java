package com.sapdata.admin.mysqlservice;

import com.sapdata.admin.bean.AdminUser;

/**
 * @Author: wuhonghui
 * @Description:
 * @Date: 2019/11/9 9:34
 * @Modified: wuhonghui
 **/
public interface AdminUserService {

    void deleteByPrimaryKey(Long userId);

    void insert(AdminUser adminUser);

    AdminUser selectByPrimaryKey(Long userId);

    void updateByPrimaryKey(AdminUser adminUser);
}
