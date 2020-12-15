package com.tset;

import com.dao.UserDao;
import com.dao.VipDao;
import com.dao.impl.VipDaoImpl;
import org.junit.Test;

/**
 * @author Lihanqin
 * @Description
 * @date 2020-12-15 10:15
 **/
public class Viptest {
    VipDao vipDao=new VipDaoImpl();
    @Test
    public void test(){
        System.out.println(vipDao.queryUserBypage(0,5));
    }
}
