package com.rico.util;

import com.rico.dao.MemberDao;
import com.rico.dao.MemberImpl;
import com.rico.dao.TransactionDao;
import com.rico.dao.TransactionImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Rico
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static MemberDao memberDao;
    private static TransactionDao transactionDao;
//    private static MemberDao memberDao;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            Logger.getLogger(HibernateUtil.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static MemberDao getMemberDao() {
            memberDao = new MemberImpl(getSessionFactory().openSession());
        return memberDao;
    }
    
    public static TransactionDao getTransactionDao() {
            transactionDao = new TransactionImpl(getSessionFactory().openSession());
        return transactionDao;
    }

    private static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static void shutdown(){
        try {
            sessionFactory.close();
        } catch (HibernateException e) {
            Logger.getLogger(HibernateUtil.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
