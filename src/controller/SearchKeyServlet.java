package controller;

import com.alibaba.fastjson.JSON;
import pojo.Product;
import service.SearchService;
import service.impl.SearchServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchKeyServlet extends HttpServlet {
    private SearchService searchService;

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String key = req.getParameter("key");
        System.out.println(key);
        searchService = new SearchServiceImpl();
        List<Product> productList = searchService.getProductListByKey(key);
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(JSON.toJSONString(productList));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request ,response);
    }
}
