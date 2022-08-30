package com.jungle.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public static Session session;
    public static Transaction transaction;
    public static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(){

        if(sessionFactory == null){
            
            // create a configuration based on hibernate.cfg.xml
            Configuration cfg = new Configuration();

            // connect configuration to file
            cfg.configure("hibernate.cfg.xml");

            // creates sessions
            sessionFactory = cfg.buildSessionFactory();

        }

        return sessionFactory;
    }

    // these methods can now be used in any DAOs!
    public static void beginTransaction(){
        session = getSessionFactory().openSession();
        transaction = session.beginTransaction();
    }

    public static void endTransaction(){
        transaction.commit();
        session.close();
    }

    public static Session getSession(){
        return session;
    }
    
    public static void saveTransaction(Object object) {
        session.save(object);
    }

    public static void persistandcomiit(Object object){
        session.persist(object);
        session.getTransaction().commit();
    }
}
