package com.lzj.demo.controller;

import com.lzj.demo.entity.Translation;
import com.lzj.demo.service.TranslationService;
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
    @Autowired
    private TranslationService translationService;

    @RequestMapping(value = "/translationFromCapitalToSmall",method = RequestMethod.GET)
    private Map<String,Object> translationFromCapitalToSmall(@RequestBody String string){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("result",translationService.translationFromCapitalToSmall(string));
        return modelMap;
    }
    @RequestMapping(value = "/translationFromSmallToCapital",method = RequestMethod.GET)
    private Map<String,Object> translationFromSmallToCapital(@RequestBody String string){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("result",translationService.translationFromSmallToCapital(string));
        return modelMap;
    }
}
