/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author ACE
 */
public class DbHandler {
    
        private Session session; 
//                = NewHibernateUtil.getSessionFactory().getCurrentSession();
        
        
    
    public void insert(Object object){
       //session = NewHibernateUtil.getSessionFactory().openSession();
        session =NewHibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        //session.close();
    }
    
    public void update(Object object){
        session =NewHibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        //session.close();
    }
    
    public void delete(Object object){
        session =NewHibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        //session.close();
    }
    
    public List select(String string){
        session =NewHibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
        Query q=session.createQuery(string);
        List list=q.list();
        session.getTransaction().commit();
        //session.close();
        return list;
        
        
    }
}
