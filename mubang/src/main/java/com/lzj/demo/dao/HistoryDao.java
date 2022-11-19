package com.lzj.demo.dao;


import com.lzj.demo.entity.History;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author 林子键
 * @version 1.0
 */
@Mapper
@Repository
public interface HistoryDao {
    List<History> queryHistory();
    List<History> queryHistoryByUID(String UID);
    List<History> queryHistoryByUIDAndDate(String UID,String date);
    int insertHistory(History history);
    int deleteHistoryByUID(String UID);
    int deleteHistoryByUIDAndDate(String UID,String date);
}
