package service.impl;

import dao.ProductListDao;
import pojo.Product;

import java.util.List;

public class ProductListServiceImpl implements service.ProductListService {
    private ProductListDao productListDao;

    public ProductListServiceImpl() {
        productListDao = new ProductListDao();
    }

    @Override
    public List<Product> getProductList() {
        return productListDao.getProductList();
    }

    @Override
    public List<Product> getProductListByLimit(int index, int maxCount) {
        return productListDao.getProductListByLimit(index , maxCount);
    }
}
