import dao.ManufaceDao;
import dao.PhoneDao;
import model.Manufacture;
import model.Phone;

public class Main {
    public static void main(String[] args) throws Exception {
        PhoneDao phoneDao = new PhoneDao();
        ManufaceDao manufaceDao = new ManufaceDao();

//        System.out.println(phoneDao.getPhone().get(0).toString());
//        phoneDao.addPhone(new Phone("ss","samsung",1000,"white","VN",1));
//        System.out.println(phoneDao.addPhone(phone));
//        manufaceDao.add(new Manufacture("001","samsung","korean",10));

//          System.out.println(manufaceDao.getIdManufacture("001"));
      manufaceDao.check100Employee();

    }
}
