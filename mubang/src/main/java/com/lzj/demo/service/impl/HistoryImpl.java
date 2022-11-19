package com.lzj.demo.service.impl;

import com.lzj.demo.dao.HistoryDao;
import com.lzj.demo.entity.History;
import com.lzj.demo.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 林子键
 * @version 1.0
 */


@Service
public class HistoryImpl implements HistoryService {

    @Autowired
    private HistoryDao historyDao;

    @Override
    public List<History> queryHistory(){
        return historyDao.queryHistory();
    }

    @Override
    public List<History> queryHistoryByUID(String UID){
        return historyDao.queryHistoryByUID(UID);
    }
    @Override
    public List<History> queryHistoryByUIDAndDate(String UID,String date){
        return historyDao.queryHistoryByUIDAndDate(UID,date);
    }

    @Transactional
    @Override
    public boolean insertHistory(History history){
        if (history.getUID() != null && !"".equals(history.getUID())) {
            try {
                int effectedNum = historyDao.insertHistory(history);;
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("UID不能为空!");
        }
    }

    @Transactional
    @Override
    public boolean deleteHistoryByUID(String UID){
        if (UID != null && !"".equals(UID)) {
            try {
                int effectedNum = historyDao.deleteHistoryByUID(UID);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("UID不能为空!");
        }
    }

    @Transactional
    @Override
    public boolean deleteHistoryByUIDAndDate(String UID,String date){
        if (UID != null && !"".equals(UID) && date != null) {
            try {
                int effectedNum = historyDao.deleteHistoryByUIDAndDate(UID,date);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除失败");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除失败" + e.getMessage());
            }
        } else {
            throw new RuntimeException("UID或date不能为空!");
        }
    }

}
