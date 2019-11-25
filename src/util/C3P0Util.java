package util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Util {
    private static ComboPooledDataSource comboPooledDataSource;

    static {
        comboPooledDataSource = new ComboPooledDataSource();
    }

    /**
     * 获取数据源方法
     * @return
     */
    public static DataSource getDataSource(){
        return comboPooledDataSource;
    }
    /**
     * 获取连接方法
     */
    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = comboPooledDataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
