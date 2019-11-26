package controller;

import pojo.Product;
import service.ProductListService;
import service.impl.ProductListServiceImpl;
import vo.PageBean;

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
        PageBean pageBean = new PageBean();
        String currentPage = req.getParameter("currentPage") == null ? "1" : req.getParameter("currentPage");
        //封装当前页
        pageBean.setCurrentPage(Integer.valueOf(currentPage));
        //封装每页总数量
        int maxCount = 12;
        pageBean.setMaxCount(maxCount);
        List<Product> productList = productListService.getProductList();
        //封装总页数
        Double totalPages = Math.ceil(1.0 * productList.size() / maxCount);
        pageBean.setTotalPages(totalPages.intValue());
        /**
         * 1   0   12
         * 2  12   12
         * 3  24   12
         */
        int index = (Integer.valueOf(currentPage) - 1) * maxCount;
        List<Product> products = productListService.getProductListByLimit(index , maxCount);
        pageBean.setProductList(products);
        //List<Product> productList = productListService.getProductList();
        req.setAttribute("pageBean" , pageBean);
        req.getRequestDispatcher("/product_list.jsp").forward(req , resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req , resp);
    }
}
