package config;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
    private static SessionFactory sessionFactory;
    static{
        try{
            Configuration configuration = new Configuration();
            configuration.configure();

            sessionFactory = configuration.buildSessionFactory();
        }catch(HibernateException e){
            System.out.println("Error connect session hibernate");
        }
    }
    public static SessionFactory getSessionFactory(){

        return sessionFactory;
    }
}
