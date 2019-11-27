package service;

import pojo.Product;

import java.util.List;

public interface SearchService {
    List<Product> getProductListByKey(String key);
}
