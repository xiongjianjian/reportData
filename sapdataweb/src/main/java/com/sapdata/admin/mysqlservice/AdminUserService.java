package com.sapdata.admin.mysqlservice;

import com.sapdata.admin.bean.AdminUser;
import com.sapdata.admin.bean.AdminUserVo;

/**
 * @Author: wuhonghui
 * @Description:
 * @Date: 2019/11/9 9:34
 * @Modified: wuhonghui
 **/
public interface AdminUserService {
    /**
     * 通过用户id删除用户信息
     * @param userId
     */
    void deleteByPrimaryKey(Long userId);

    /**
     * 插入一条用户信息
     * @param adminUser
     */
    void insert(AdminUser adminUser);

    /**
     * 通过用户id查询信息
     * @param userId
     * @return
     */
    AdminUser selectByPrimaryKey(Long userId);

    /**
     * 修改用户信息
     * @param adminUserVo
     */
    void updateByPrimaryKey(AdminUserVo adminUserVo);

    /**
     * 查询用户列表信息（模糊查询分页）
     * @param adminUserVo
     * @return
     */
    AdminUserVo findAll(AdminUserVo adminUserVo);

    AdminUser checkUserBysSale(String saleCode, String salePassword);

    AdminUser checkUserByCustom(String customerCode, String customerPassword);

    /**
     * 计算总记录数（分页,模糊查询）
     * @param adminUserVo
     * @return
     */
    Long countAll(AdminUserVo adminUserVo);

    /**
     * 新增时查找是否存在相同编号
     * @param account
     * @return
     */
    int checkAccount(String account);
}
