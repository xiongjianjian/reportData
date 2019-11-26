package com.sapdata.admin.controller;

import com.sapdata.admin.bean.AdminUser;
import com.sapdata.admin.bean.AdminUserVo;
import com.sapdata.admin.mysqlservice.AdminUserService;
import com.sapdata.admin.util.TokenProccessor;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: wuhonghui
 * @Description:用户列表
 * @Date: 2019/11/9 9:41
 * @Modified: wuhonghui
 **/
@Controller
@RequestMapping("/user")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;

    /**
     * @Author: xiongjianjian
     * @Description: 获取用户列表
     * @Date: 2019/11/15 10:16
     * @Modified: xiongjianjian
     **/
    @RequestMapping("/findAll")
    @ResponseBody
    public ModelAndView findAll(AdminUserVo adminUserVo) {
        AdminUserVo userList = adminUserService.findAll(adminUserVo);
        Long total = adminUserService.countAll(adminUserVo);
        //总页数
        userList.setLastPage(Math.toIntExact(total), userList.getPageSize());
        //总条数
        userList.setTotal(Math.toIntExact(total));
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/findAll");
        //模糊查询条件返回前端
        modelAndView.addObject("adminUserVo", adminUserVo);
        modelAndView.addObject("userList", userList);

        return modelAndView;
    }

    /**
     * @Author: wuhonghui
     * @Description: 跳转修改密码页面
     * @Date: 2019/11/12 13:46
     * @Modified: wuhonghui
     **/
    @RequestMapping("/toUpdatePass")
    @ResponseBody
    public ModelAndView toUpdatePass() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/updatePass");
        return modelAndView;
    }

    /**
     * @Author: xiongjianjian
     * @Description: 跳转添加用户页面
     * @Date: 2019/11/15 10:16
     * @Modified: xiongjianjian
     **/
    @RequestMapping("/userAdd")
    @ResponseBody
    public ModelAndView userAdd(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user/userAdd");
        String token = TokenProccessor.getInstance().makeToken();//创建令牌
        request.getSession().setAttribute("token", token);
        return modelAndView;
    }

    /**
     * @Author: xiongjianjian
     * @Description: 新增用户
     * @Date: 2019/11/13 10:35
     * @Modified: xiongjianjian
     **/
    @RequestMapping("/userInsert")
    public String userInsert(AdminUser adminUser, HttpServletRequest request) {
        //判断是否表单传递的token与设置的值相同，true即为第一次提交
        if (request.getSession().getAttribute("token").equals(request.getParameter("token"))) {
            //用户默认密码123456（加密存储）
            if (!StringUtils.isEmpty(adminUser.getCustomerCode())) {
                adminUser.setCustomerPassword(DigestUtils.md5Hex("123456"));
            } else {
                adminUser.setSalePassword(DigestUtils.md5Hex("123456"));
            }
            adminUserService.insert(adminUser);
            request.getSession().removeAttribute("token");//移除session中的token
        }else {
            throw new RuntimeException("多次提交表单问题");
        }
        return "redirect:/user/findAll";
    }

    /**
     * @Author: xiongjianjian
     * @Description: 删除用户
     * @Date: 2019/11/14 9:31
     * @Modified: xiongjianjian
     **/
    @RequestMapping("/delete")
    public String userDelete(AdminUserVo adminUserVo, Long userId) {
        adminUserService.deleteByPrimaryKey(userId);
        //返回分页，模糊查询信息以便定位到删除数据所在位置（分页位置）
        return "redirect:/user/findAll?pageNo=" + adminUserVo.getPageNo() +
                "&&pageSize=" + adminUserVo.getPageSize()
                + "&&customerCode=" + adminUserVo.getCustomerCode() + "&&saleCode=" + adminUserVo.getSaleCode()
                + "&&mobile=" + adminUserVo.getMobile() + "&&realName=" + adminUserVo.getRealName();
    }

    /**
     * @Author: xiongjianjian
     * @Description: 跳转用户修改页面
     * @Date: 2019/11/14 10:09
     * @Modified: xiongjianjian
     **/
    @RequestMapping("/update")
    @ResponseBody
    public ModelAndView update(Long userId, AdminUserVo adminUserVo) {
        ModelAndView modelAndView = new ModelAndView();
        //当前修改的数据,返回前端展示
        AdminUser adminUser = adminUserService.selectByPrimaryKey(userId);
        //分页，模糊查询信息传递
        modelAndView.addObject("adminUserVo", adminUserVo);
        modelAndView.addObject("adminUser", adminUser);
        modelAndView.setViewName("user/userAdd");
        return modelAndView;
    }

    /**
     * @Author: xiongjianjian
     * @Description: 用户修改信息入库
     * @Date: 2019/11/14 10:57
     * @Modified: xiongjianjian
     **/
    @RequestMapping("/updateUser")
    public String updateUser(AdminUserVo adminUserVo, String customerCodeKey, String saleCodeKey, String mobileKey, String realNameKey) {
        //修改信息插入数据库
        adminUserService.updateByPrimaryKey(adminUserVo);
        //返回分页，模糊查询信息以便定位到修改数据所在位置（分页位置）
        return "redirect:/user/findAll?pageNo=" + adminUserVo.getPageNo() + "&&pageSize=" + adminUserVo.getPageSize()
                + "&&customerCode=" + customerCodeKey + "&&saleCode=" + saleCodeKey + "&&mobile=" + mobileKey + "&&realName=" + realNameKey;
    }

    /**
     * @Author: xiongjianjian
     * @Description: 检查新增用户时，输入客户编号，销售员编号是否存在
     * @Date: 2019/11/15 16:14
     * @Modified: xiongjianjian
     **/
    @RequestMapping("/checkAccount")
    @ResponseBody
    public int checkAccount(String account) {
        ModelAndView modelAndView = new ModelAndView();
        //String MSG = "已存在！";
        int i = adminUserService.checkAccount(account);
        //if (i == 1){
        //   modelAndView.addObject("MSG",MSG);
        //}
        //modelAndView.setViewName("user/userAdd");
        return i;
    }
}
