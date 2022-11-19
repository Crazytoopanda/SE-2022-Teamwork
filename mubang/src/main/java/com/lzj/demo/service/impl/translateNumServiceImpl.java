package com.lzj.demo.service.impl;
import com.lzj.demo.dao.HistoryDao;
import com.lzj.demo.entity.History;
import com.lzj.demo.service.translateNumService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class translateNumServiceImpl implements translateNumService{

    @Autowired
    HistoryDao historyDao;


    public String translateToword(String num){
        return trNum.numberToChinese(num);
    }
    public String translateTonum(String num){
        return trNum.chineseToNumber(num);
    }
    public String translateTocap(String num){
        return trNum.figuresToWords(num);
    }
    public String translateTolow(String num){
        return trNum.wordsToFigures(num);
    }
}

