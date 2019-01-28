/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

//import org.hibernate.cfg.AnnotationConfiguration;
import Model.Employee;
import Model.Inventory;
import org.hibernate.SessionFactory;
//import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author ACE
 */
public class NewHibernateUtil {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            //sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
             Configuration configuration=new Configuration().configure();
            configuration.addAnnotatedClass(Employee.class);
            configuration.addAnnotatedClass(Inventory.class);
            configuration.addAnnotatedClass(Transcation.class);
            configuration.addAnnotatedClass(Billproduct.class);
            configuration.addAnnotatedClass(Supplier.class);
            configuration.addAnnotatedClass(StaffLog.class);
            configuration.addAnnotatedClass(Company.class);
           
//            configuration.addAnnotatedClass(InventoryTranscation.class);
           //configuration.addAnnotatedClass(InventoryTransactionPK.class);
            
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.buildSessionFactory(builder.build());            
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
