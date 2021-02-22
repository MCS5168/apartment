package test;

import dao.UserDao;
import entry.User;
import org.junit.Test;

public class UserDaoTest extends UserDao {
    UserDao userDao = new UserDao();

    @Test
    public void testQueryUserBynameAndPwd() {
        User user = userDao.queryUserBynameAndPwd("admin", "111");
        System.out.println(user.getUserPassword());
    }

    @Test
    public void testQueryUserByName() {
        User user = userDao.queryUserByName("admin");
        System.out.println(user.toString());
    }
}