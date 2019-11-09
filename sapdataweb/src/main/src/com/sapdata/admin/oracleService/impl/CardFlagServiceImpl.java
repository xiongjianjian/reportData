package com.sapdata.admin.oracleService.impl;

import com.sapdata.admin.bean.CardFlag;
import com.sapdata.admin.mapper.CardFlagMapper;
import com.sapdata.admin.oracleService.CardFlagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: wuhonghui
 * @Description:
 * @Date: 2019/11/9 9:37
 * @Modified: wuhonghui
 **/
@Service
public class CardFlagServiceImpl implements CardFlagService {
    @Autowired
    private CardFlagMapper cardFlagMapper;
    @Override
    public CardFlag selectByPrimaryKey() {
        return cardFlagMapper.selectByPrimaryKey();
    }
}
