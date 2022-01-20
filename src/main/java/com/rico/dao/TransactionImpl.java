package com.rico.dao;

import com.rico.model.FeMember;
import com.rico.model.FeTransaction;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Rico
 */
public class TransactionImpl implements TransactionDao {

    private final Session session;

    public TransactionImpl(Session session) {
        this.session = session;
    }

    @Override
    public boolean insert(FeTransaction feTransaction) {
        try {
            session.beginTransaction();
            String nim = (String) session.save(feTransaction);
            session.getTransaction().commit();
            return nim != null;
        } catch (Exception e) {
            Logger.getLogger(TransactionImpl.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean update(FeTransaction feTransaction) {
        try {
            session.beginTransaction();
            session.update(feTransaction);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            Logger.getLogger(TransactionImpl.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(FeTransaction feTransaction) {
        try {
            session.beginTransaction();
            session.delete(feTransaction);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            Logger.getLogger(TransactionImpl.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public List<FeTransaction> getAllTransaction() {
        try {
            return session.createQuery("FROM FeTransaction", FeTransaction.class).list();
        } catch (Exception e) {
            Logger.getLogger(TransactionImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            session.close();
        }
        return null;
    }

}
