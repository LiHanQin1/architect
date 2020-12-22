package com.tset;

import com.dao.FilmDao;
import com.dao.UserDao;
import com.dao.VipDao;
import com.dao.impl.FilmDaoImpl;
import com.dao.impl.UserDaoImpl;
import com.dao.impl.VipDaoImpl;
import org.junit.Test;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-12-15 10:15
 **/
public class Viptest {
    VipDao vipDao=new VipDaoImpl();
    UserDao userDao=new UserDaoImpl();
    FilmDao filmDao=new FilmDaoImpl();
//    @Test
//    public void test(){
//        System.out.println(vipDao.queryUserBypage(0,5));
//    }
//    @Test
//    public void test1(){
//        System.out.println(userDao.queryUserBypage(0,5));
//    }
    @Test
    public void tese2(){
        System.out.println(filmDao.queryUserBypage(0,5));
    }

}
