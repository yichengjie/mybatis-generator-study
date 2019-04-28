package com.yicj.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
/**
 */
public class SessionFactoryUtil {
    private static SqlSessionFactory sessionFactory;
    private SessionFactoryUtil(){}
    public static SqlSession getSession() throws IOException{
        InputStream stream = Resources.getResourceAsStream("mybatis-config.xml");
        if(sessionFactory==null){
            sessionFactory = new SqlSessionFactoryBuilder().build(stream);
        }
        return sessionFactory.openSession();
    }


}