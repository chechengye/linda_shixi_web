package controller;

import pojo.Product;
import service.ProductListService;
import service.impl.ProductListServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductInfoServlet extends HttpServlet {
    private ProductListService productListService;
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("pid");
        productListService = new ProductListServiceImpl();
        Product product = productListService.getProductByPid(pid);
        req.setAttribute("product",product);
        req.getRequestDispatcher("/product_info.jsp").forward(req , resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }
}
