package com.hbnu.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author chendikai
 * @date 2023-02-22 11:00
 */
public class HibernateUtil {

    private static Configuration configuration;
    private static SessionFactory sessionFactory;

    static {
        configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static Session getSession() {
        return sessionFactory.getCurrentSession();  // 获取与本地线程绑定的session对象
    }

    public static void main(String[] args) {

    }
}
