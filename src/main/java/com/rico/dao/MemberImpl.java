package com.rico.dao;

import com.rico.model.FeMember;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Rico
 */
public class MemberImpl implements MemberDao {

    private final Session session;

    public MemberImpl(Session session) {
        this.session = session;
    }

    @Override
    public boolean insert(FeMember feMember) {
        try {
            session.beginTransaction();
            String nim = (String) session.save(feMember);
            session.getTransaction().commit();
            return nim != null;
        } catch (Exception e) {
            Logger.getLogger(MemberImpl.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean update(FeMember feMember) {
        try {
            session.beginTransaction();
            session.update(feMember);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            Logger.getLogger(MemberImpl.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public boolean delete(FeMember feMember) {
        try {
            session.beginTransaction();
            session.delete(feMember);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            Logger.getLogger(MemberImpl.class.getName()).log(Level.SEVERE, null, e);
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return false;
    }

    @Override
    public List<FeMember> getAllMember() {
        try {
            return session.createQuery("FROM FeMember", FeMember.class).list();
        } catch (Exception e) {
            Logger.getLogger(MemberImpl.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            session.close();
        }
        return null;
    }

}
