package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.Product;
import util.C3P0Util;

import java.sql.SQLException;
import java.util.List;

public class SearchDao {
    private QueryRunner qr;

    public SearchDao() {
        //创建访问数据库的QueryRunner对象
        qr = new QueryRunner(C3P0Util.getDataSource());
    }
    public List<Product> getProductListByKey(String key) {
        String sql = "select p.pname from product p where pname like ? limit 0 , 5";
        List<Product> productList = null;
        try {
            productList = qr.query(sql, new BeanListHandler<>(Product.class), "%" + key + "%");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
