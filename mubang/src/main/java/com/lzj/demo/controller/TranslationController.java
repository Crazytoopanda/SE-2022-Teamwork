package com.lzj.demo.controller;

import com.lzj.demo.service.HistoryService;
import com.lzj.demo.service.translateNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author frf
 * @version 1.0
 */
@RestController
@RequestMapping("/translation")
public class TranslationController {

    @Autowired(required = false)
    private translateNumService translationService;

    @Autowired
    private HistoryService historyService;

    @RequestMapping(value = "/translationFromCapitalToSmall",method = RequestMethod.GET)
    private Map<String,Object> translationFromCapitalToSmall(String string){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("result",translationService.translateTolow(string));
        return modelMap;
    }
    @RequestMapping(value = "/translationFromSmallToCapital",method = RequestMethod.GET)
    private Map<String,Object> translationFromSmallToCapital(String string){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("result",translationService.translateTocap(string));
        return modelMap;
    }
}
