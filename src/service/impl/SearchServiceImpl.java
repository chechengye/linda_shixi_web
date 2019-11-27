package service.impl;

import dao.SearchDao;
import pojo.Product;

import java.util.List;

public class SearchServiceImpl implements service.SearchService {
    private SearchDao searchDao;

    public SearchServiceImpl() {
        searchDao=new SearchDao();
    }

    @Override
    public List<Product> getProductListByKey(String key) {
        return searchDao.getProductListByKey(key);
    }
}
