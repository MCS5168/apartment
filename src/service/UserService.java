package service;

import entry.User;

public interface UserService {
    /**
     * 登录;
     *
     * @param user
     * @return
     */
    User login(User user);

    boolean existsUserName(String username);

    void registUser(User user);

    Object queryPassowrdByName(String password);

    int modifyPassword(String userPassword, String userName);
}
