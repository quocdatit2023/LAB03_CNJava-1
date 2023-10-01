package dao;

import config.HibernateConfig;
import model.Phone;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import java.util.List;

public class PhoneDao {
    Session session = HibernateConfig.getSessionFactory().openSession();
    public List<Phone> getPhone(){
        //open session
        List<Phone> phones = null;
        try
        {
            final String sql = "select e from Phone e";
            Query query = session.createQuery(sql);

            phones = query.list();

        }catch (HibernateException e){
        } finally {
            session.close();
        }
        return phones;
    }

    //get phone from id
    public Phone getPhoneId(String id){
        try{
            return (Phone) session.createQuery("from Phone e where e.id="+id).list().get(0);
        }catch (Exception e){
            return null;
        }
    }
    public boolean addPhone(Phone phone) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(phone);
            transaction.commit();
            return true;
        }catch (Exception e) {
            // TODO: handle exception
            if (transaction != null) {
                transaction.rollback();
            }
            System.out.println(e.getMessage());
            return false;
        }
    }

    //Xóa
    public boolean removePhone(String id)
    {
        Transaction transaction = null;
        transaction = session.getTransaction();
        transaction.begin();
        try {
            Phone phone = session.get(Phone.class,id);
            if(phone!=null)
            {
                session.delete(phone);
                System.out.println("Xóa thành công sản phẩm id= "+id);
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

    //update
    public boolean updatePhone(Phone phone)
    {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Phone item = getPhoneId(phone.getId());
            System.out.println(item);
            if(item!=null){
                item.setName(phone.getName());
                item.setColor(phone.getColor());
                item.setPrice(phone.getPrice());
                item.setCountry(phone.getCountry());
                item.setQuantity(phone.getQuantity());
                session.update(item);
                transaction.commit();
                session.close();
                return true;
            }
            else
                return false;
        }catch(Exception e)
        {
            return false;
        }
    }
    //Điện thoại có giá cao nhât
    public Phone getHighestPhone(){
        try{
            return (Phone) session.createQuery("from Phone order by price desc").list().get(0);
        }catch(Exception e)
        {
            return null;
        }
    }

    //ds điện thoại saows xếp theo tên quốc gia, nếu cùng qg thì sắp xếp giảm dần theo giá bán
    public List<Phone> getPhoneByCountry(){
        try {
            return session.createCriteria(Phone.class).addOrder(Order.asc("country")).addOrder(Order.desc("price")).list();
        }catch (Exception e) {
            // TODO: handle exception
            return null;
        }
    }

    //Kiểm tra điện thoại có mức giá trên 50trieu
    public List<Phone> get50(){
        try {
            return session.createQuery("from Phone where price>=50000000").list();
        }catch(Exception e){
            return null;
        }
    }
    public Phone getFirstPhoneByColor(String color)
    {
        try {
            Criteria ctr = session.createCriteria(Phone.class);
            ctr.add(Restrictions.like("color","Pink")).add(Restrictions.gt("price",15000000));
            List result = ctr.list();
            return (Phone) result.get(0);
        }catch (Exception e){
            return null;
        }

    }
}
