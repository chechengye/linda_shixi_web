package dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pojo.Product;
import util.C3P0Util;

import java.sql.SQLException;
import java.util.List;

public class ProductListDao {

    private QueryRunner qr;

    public ProductListDao() {
        //创建访问数据库的QueryRunner对象
        qr = new QueryRunner(C3P0Util.getDataSource());
    }
    /**
     * 获取所有的商品
     * @return
     */
    public List<Product> getProductList() {
        String sql = "select p.pid , p.pname,p.market_price , p.shop_price , p.pimage from product p";
        List<Product> productList = null;
        try {
            productList = qr.query(sql, new BeanListHandler<>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public List<Product> getProductListByLimit(int index, int maxCount) {
        String sql = "select p.pid , p.pname,p.market_price , p.shop_price , p.pimage from product p limit  ?, ?";
        List<Product> products = null;
        try {
            products = qr.query(sql, new BeanListHandler<>(Product.class), index, maxCount);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product getProductByPid(String pid) {
        String sql = "select p.pid , p.pname,p.market_price , p.shop_price , p.pimage , p.pdesc from product p where pid = ?";
        Product product = null;
        try {
            product = qr.query(sql, new BeanHandler<>(Product.class), pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
