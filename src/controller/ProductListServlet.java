package controller;

import pojo.Product;
import service.ProductListService;
import service.impl.ProductListServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ProductListServlet extends HttpServlet {

    private ProductListService productListService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        productListService = new ProductListServiceImpl();
        List<Product> productList = productListService.getProductList();
        req.setAttribute("productList" , productList);
        req.getRequestDispatcher("/product_list.jsp").forward(req , resp);
        System.out.println(productList.size());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}
