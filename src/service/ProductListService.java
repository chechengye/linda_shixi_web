package service;

import pojo.Product;

import java.util.List;

public interface ProductListService {

    List<Product> getProductList();

    List<Product> getProductListByLimit(int index, int maxCount);

    Product getProductByPid(String pid);
}
