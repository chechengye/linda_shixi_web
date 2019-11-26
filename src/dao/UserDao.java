package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import pojo.User;
import util.C3P0Util;

import java.sql.SQLException;

/**
 * 负责访问数据库
 */
public class UserDao {

    private QueryRunner qr;

    public UserDao() {
        //创建访问数据库的QueryRunner对象
        qr = new QueryRunner(C3P0Util.getDataSource());
    }

    public void registerUser(User user) {
        //编写sql语句
        String sql = "insert into user (uid , username , password , name , email , birthday , sex) values(?,?,?,?,?,?,?)";
        try {
            //执行数据库插入操作
            qr.update(sql , user.getUid() , user.getUsername() , user.getPassword(), user.getName() , user.getEmail() , user.getBirthday() , user.getSex());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User checkLogin(String username, String password) {
        String sql = "select u.username from user u where username = ? and password = ?";
        User user = null;
        try {
            user = qr.query(sql, new BeanHandler<>(User.class), username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
