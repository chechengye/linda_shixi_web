package dao;

import org.apache.commons.dbutils.QueryRunner;
import pojo.User;
import util.C3P0Util;

import java.sql.SQLException;

/**
 * 负责访问数据库
 */
public class UserDao {


    public void registerUser(User user) {
        //创建访问数据库的QueryRunner对象
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        //编写sql语句
        String sql = "insert into user (uid , username , password) values(?,?,?)";
        try {
            //执行数据库插入操作
            qr.update(sql , user.getUid() , user.getUsername() , user.getPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
