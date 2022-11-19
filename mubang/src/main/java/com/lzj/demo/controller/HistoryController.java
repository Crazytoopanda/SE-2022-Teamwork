package com.lzj.demo.controller;

import com.lzj.demo.entity.History;
import com.lzj.demo.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 林子键
 * @version 1.0
 */

@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;
    @CrossOrigin
    @RequestMapping(value = "/listhistory", method = RequestMethod.GET)
    private Map<String,Object> listHistory(){
        Map<String,Object> modelMap = new HashMap<>();
        List<History> list = historyService.queryHistory();
        modelMap.put("historylist",list);
        return modelMap;
    }
    @CrossOrigin
    @RequestMapping(value = "/queryhistorybyuid",method = RequestMethod.GET)
    private Map<String,Object> queryHistoryByUID(String UID){
        Map<String,Object> modelMap = new HashMap<>();
        List<History> historylist = historyService.queryHistoryByUID(UID);
        modelMap.put("historylist",historylist);
        return modelMap;
    }
    @CrossOrigin
    @RequestMapping(value = "/queryhistorybyuidanddate",method = RequestMethod.GET)
    private Map<String,Object> queryHistoryByUIDAndDate(@RequestParam(value = "UID")String UID, @RequestParam(value = "date")String date){
        Map<String,Object> modelMap = new HashMap<>();
        List<History> historylist = historyService.queryHistoryByUIDAndDate(UID,date);
        modelMap.put("historylist",historylist);
        return modelMap;
    }
    @CrossOrigin
    @RequestMapping(value = "/inserthistory",method = RequestMethod.POST)
    private Map<String,Object> insertHistory(@RequestBody History history){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",historyService.insertHistory(history));
        return modelMap;
    }
    @CrossOrigin
    @RequestMapping(value = "/deletehistorybyuid",method = RequestMethod.GET)
    private Map<String,Object> deleteHistoryByUID(String UID){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",historyService.deleteHistoryByUID(UID));
        return modelMap;
    }
    @CrossOrigin
    @RequestMapping(value = "/deletehistorybyuidanddate",method = RequestMethod.GET)
    private Map<String,Object> deleteHistoryByUIDAndDate(@RequestParam(value = "UID")String UID, @RequestParam(value = "date")String date){
        Map<String,Object> modelMap = new HashMap<>();
        modelMap.put("success",historyService.deleteHistoryByUIDAndDate(UID,date));
        return modelMap;
    }
}
