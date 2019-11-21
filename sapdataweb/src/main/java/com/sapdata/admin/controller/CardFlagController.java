package com.sapdata.admin.controller;

import com.sapdata.admin.bean.CardFlag;
import com.sapdata.admin.oracleService.CardFlagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: wuhonghui
 * @Description:
 * @Date: 2019/11/9 14:21
 * @Modified: wuhonghui
 **/
@Controller
public class CardFlagController {
    @Autowired
    private CardFlagService cardFlagService;
    @RequestMapping("/findCardFlag")
    @ResponseBody
    public CardFlag findCardFlag(){
        CardFlag cardFlag=cardFlagService.selectByPrimaryKey();
        return cardFlag;
    }
}
