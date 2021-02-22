package service.impl;

import dao.UserDao;
import entry.User;
import service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao = new UserDao();


    @Override
    public User login(User user) {
        return userDao.queryUserBynameAndPwd(user.getUserName(),user.getUserPassword());
    }

    @Override
    public boolean existsUserName(String username) {
        if(userDao.queryUserByName(username)==null){
            return false;
        }
        return true;
    }

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public Object queryPassowrdByName(String password){
        return userDao.queryPassowrdByName(password);
    }

    @Override
    public int modifyPassword(String userPassword, String userName) {
        return userDao.modifyPassword(userPassword, userName);
    }
}
