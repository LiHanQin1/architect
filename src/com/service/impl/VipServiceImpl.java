package com.service.impl;

import com.dao.VipDao;
import com.dao.impl.VipDaoImpl;
import com.entity.Vip;
import com.service.VipService;
import com.utils.Page;

import java.util.List;

/**
 * @Author HongSiDa
 * @Description:
 * @Date 2020/12/9 15:17
 **/
public class VipServiceImpl implements VipService {
    VipDao vipDao=new VipDaoImpl();
    @Override
    public int insert(Vip vip) {
        return vipDao.insert(vip);
    }

    @Override
    public int delete(int id) {
        return vipDao.delete(id);
    }

    @Override
    public int update(Vip vip) {
        return vipDao.update(vip);
    }

    @Override
    public List<Vip> queryAll() {
        return vipDao.queryAll();
    }

    @Override
    public Vip query(int id) {
        return vipDao.query(id);
    }

    @Override
    public Vip queryUserByNameAndPassword(Vip vip) {
        return vipDao.queryUserByNameAndPassword(vip);
    }

    @Override
    public Vip queryUserByName(Vip vip) {
        return vipDao.queryUserByName(vip);
    }

    @Override
    public List<Vip> vipList(Vip vip) {
        return vipDao.vipList(vip);
    }


    @Override
    public Page<Vip> queryByPage(int pageNo, int pageSize) {
        Page<Vip> page=new Page<>();
        //设置当前页码
        page.setPageNo(pageNo);
        //设置每页展示的数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount= vipDao.queryCounts();
        //设置总记录数
        page.setPageTotalCount(Math.toIntExact(pageTotalCount));
        //求总页码数
        Integer pageTotal=pageTotalCount/pageSize;
        if (pageTotalCount%pageSize>0){
            pageTotal+=1;
        }
        //配置总页码
        page.setPageTotal(pageTotal);
        //求当前的页数据的开始索引
        int begin=(page.getPageNo()-1)*pageSize;
        List<Vip> items=vipDao.queryUserBypage(begin,pageSize);
        page.setItems(items);
        return page;
    }

    @Override
    public Page<Vip> queryKeyWordByPage(Vip vip, int pageNo, int pageSize) {
        Page<Vip> page=new Page<>();
        //设置当前页码
        page.setPageNo(pageNo);
        //设置每页展示的数量
        page.setPageSize(pageSize);
        //求总记录数
        List<Vip> vipList=vipDao.vipList(vip);

        Integer pageTotalCount= vipList.size();
        //设置总记录数
        page.setPageTotalCount(Math.toIntExact(pageTotalCount));
        //求总页码数
        Integer pageTotal=pageTotalCount/pageSize;
        if (pageTotalCount%pageSize>0){
            pageTotal+=1;
        }
        //配置总页码
        page.setPageTotal(pageTotal);
        //求当前的页数据的开始索引
        int begin=(page.getPageNo()-1)*pageSize;
        List<Vip> items=vipDao.queryUserByKeywordForPage(vip,begin,pageSize);
        page.setItems(items);
        return page;
    }
}
