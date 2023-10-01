package dao;

import config.HibernateConfig;
import model.Manufacture;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ManufaceDao {
    Session session = HibernateConfig.getSessionFactory().openSession();

    public boolean add(Manufacture p) {
        Transaction transaction = null;

        try {
            // Begin transaction
            transaction = session.beginTransaction();
            // Save the Manufacture object
            session.save(p);
            // Commit the transaction
            transaction.commit();
            return true; // Addition successful
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); // Rollback the transaction if an exception occurs
            }
            e.printStackTrace(); // Print the exception stack trace for debugging purposes
            return false; // Addition failed
        } finally {
            session.close(); // Close the session
        }
    }

    public Manufacture getIdManufacture(String id){
        try{
            return (Manufacture) session.createQuery("from Manufacture e where e.id="+id).list().get(0);
        }catch (Exception e){
            return null;
        }
    }

    public List<Manufacture> getAllManufacture(){
        //open session
        List<Manufacture> manufactureList = null;
        try
        {
            final String sql = "select e from Manufacture e";
            Query query = session.createQuery(sql);

            //get all phone
            manufactureList= query.list();

        }catch (HibernateException e){
        } finally {
            session.close();
        }
        return manufactureList;
    }

    public boolean removeManufactureID(int id)
    {
        Transaction transaction = null;
        try{
            transaction = session.getTransaction();
            transaction.begin();
            Manufacture item = session.get(Manufacture.class,id);
            if(item!=null){
                session.delete(item);
                System.out.println("Xóa thành công");
                transaction.commit();
                return true;
            }
            else
                return false;
        }catch (Exception e)
        {
            return false;
        }
    }

    public boolean removeManufacture(Manufacture p) {
        try {
            session.remove(p);
            return true;
        } catch (Exception e) {
            // Handle any exceptions
            return false;
        }
    }

    public boolean updateManufacture(Manufacture p) {
        try {
            session.update(p);
            return true;
        } catch (Exception e) {
            // Handle any exceptions
            return false;
        }
    }

    public boolean check100Employee()
    {
        for(Manufacture item:getAllManufacture())
        {
            if (item.getEmployee()<100)
                return false;
        }
        return true;
    }
    public int countEmployee()
    {
        return getAllManufacture().size();
    }


    public Manufacture getManuByLocationLast() throws Exception {
        List<Manufacture> allManu = getAllManufacture();
        Manufacture lastUSAManu = null;

        for (Manufacture item : allManu) {
            if ("USA".equals(item.getLocation())) {
                lastUSAManu = item;
            }
        }

        if (lastUSAManu != null) {
            return lastUSAManu;
        } else {
            throw new Exception("InvalidOperationException");
        }
    }
}