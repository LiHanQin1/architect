package com.service.impl;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.entity.User;
import com.entity.Vip;
import com.service.UserService;
import com.utils.Page;

import java.util.List;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-12-08 16:14
 **/
public class UserSerciceImpl implements UserService {
    UserDao userDao=new UserDaoImpl();
    @Override
    public int insert(User user) {
        return userDao.insert(user);
    }

    @Override
    public int delete(int id) {
        return userDao.delete(id);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }

    @Override
    public List<User> queryAll() {
        return userDao.queryAll();
    }

    @Override
    public User queryUserByNameAndPassword(User user) {
        return userDao.queryUserByNameAndPassword(user);
    }

    @Override
    public User queryUserByUsername(User user) {
        return userDao.queryUserByUsername(user);
    }

    @Override
    public Integer queryCounts() {
        return userDao.queryCounts();
    }

    @Override
    public Page<User> queryByPage(int pageNo, int pageSize) {
        Page<User> page=new Page<>();
        //设置当前页码
        page.setPageNo(pageNo);
        //设置每页展示的数量
        page.setPageSize(pageSize);
        //求总记录数
        Integer pageTotalCount= userDao.queryCounts();
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
        List<User> items=userDao.queryUserBypage(begin,pageSize);
        page.setItems(items);
        return page;
    }

}
