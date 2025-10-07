package org.ex.ch14_email_java;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
public class UserDB {
    public static void insert(User user){
        EntityManager em = UserUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try {
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println("e");
            trans.rollback();
        } finally {
            em.close();
        }
    }

    public static User selectUser(String email){
        EntityManager em = UserUtil.getEmFactory().createEntityManager();
        String qString ="SELECT U FROM User U " + "Where U.email = :email";
        TypedQuery <User> q = em.createQuery(qString, User.class);
        q.setParameter("email",email);
        try{
            User user =q.getSingleResult();
            System.out.println("Thành công");
            return user;
        } catch (Exception e) {
            System.out.println(q);
            return null;
        } finally {
            em.close();
        }
    }
    public  static  boolean emailExists(String email){
        User u = selectUser(email);
        return u != null;
    }
}