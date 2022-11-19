package com.lzj.demo.service.impl;
import com.lzj.demo.service.translateNumService;
import com.lzj.demo.service.impl.trNum;
public class translateNumServiceImpl implements translateNumService{
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

