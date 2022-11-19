package com.lzj.demo.service;

import com.lzj.demo.entity.History;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 林子键
 * @version 1.0
 */

public interface HistoryService {
    List<History> queryHistory();
    List<History> queryHistoryByUID(String UID);
    List<History> queryHistoryByUIDAndDate(String UID,String date);
    boolean insertHistory(History history);
    boolean deleteHistoryByUID(String UID);
    boolean deleteHistoryByUIDAndDate(String UID,String date);
}
