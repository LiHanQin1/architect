package com.dao;

import com.entity.Vip;
import org.yaml.snakeyaml.events.Event;

import java.util.List;

/**
 * @Author HongSiDa
 * @Description:
 * @Date 2020/12/9 10:10
 **/
public interface VipDao {
    int insert(Vip vip);
    int delete(int id);
    int update(Vip vip);
    int updateByUsername(Vip vip);
    List<Vip> queryAll();
    Vip queryUserByNameAndPassword(Vip vip);
    Vip queryUserByName(Vip vip);
    Vip query(int id);
    //查询当前表的总记录条数
    Integer queryCounts();

    //分页查询
    List<Vip> queryUserBypage(int begin,int pageSize);
    List<Vip> queryUserByKeywordForPage(Vip vip,int begin, int pageSize);
    List<Vip>  vipList(Vip vip);

}
