package com.sapdata.admin.mysqlservice;

import com.github.pagehelper.PageInfo;
import com.sapdata.admin.bean.AdminUser;

import java.util.List;

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

    PageInfo<AdminUser> findAll(AdminUser adminUser,Integer pageNo,Integer pageSize);

    AdminUser checkUserBysSale(String saleCode, String salePassword);

    AdminUser checkUserByCustom(String customerCode, String customerPassword);
}
