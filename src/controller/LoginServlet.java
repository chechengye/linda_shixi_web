package controller;

import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService userService = new UserServiceImpl();
        User user = userService.checkLogin(username , password);
        if(user != null){
            request.setAttribute("username" , user.getUsername());
            //内部转发
            request.getRequestDispatcher("/index.jsp").forward(request , response);
        }else{
            request.setAttribute("errortips" , "用户名或密码错误!!!");
            //内部转发
            request.getRequestDispatcher("/login.jsp").forward(request , response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request , response);
    }
}
