package dao;

import entry.User;

public class UserDao extends BaseDao {
    /**
     * 登录验证
     *
     * @param username
     * @param password
     * @return
     */
    public User queryUserBynameAndPwd(String username, String password) {
        String sql = "select `username`,`userpassword` from user where username = ? and userpassword = ?";
        return queryForOne(User.class, sql, username, password);
    }

    /**
     * 通过名字查找
     *
     * @param username
     * @return
     */
    public User queryUserByName(String username) {
        String sql = "select * from user where username = ?";
        return queryForOne(User.class, sql, username);
    }

    /**
     * 保存用户
     *
     * @param user
     * @return
     */
    public int saveUser(User user) {
        String sql = "insert into user(`username`,`userpassword`) values(?,?)";
        return update(sql, user.getUserName(), user.getUserPassword());

    }

    /**
     * 查询用户对应的密码
     *
     * @param password
     * @return
     */
    public Object queryPassowrdByName(String password) {
        String sql = "select userpassword from user where username = ?";
        return queryForSingleValue(sql, password);
    }

    public int modifyPassword(String userPassword, String userName) {
        String sql = "update user set userpassword = ? where username = ?";
        return update(sql, userPassword, userName);
    }
}
