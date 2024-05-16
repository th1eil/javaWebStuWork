package cdu.ljh.controller;
import cdu.ljh.model.AdminUser;
import cdu.ljh.service.AdminUserService;
import cdu.ljh.service.impl.AdminUserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
//后台：添加管理员用户
@WebServlet(urlPatterns = {"/admin/adminUser/add"})
public class AdminUserAddServlet extends HttpServlet {
    AdminUserService adminUserService = new AdminUserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从客户端获取新用户信息
        req.setCharacterEncoding("utf-8");
        AdminUser adminUser = new AdminUser();
        adminUser.setName(req.getParameter("name"));
        adminUser.setPassword(req.getParameter("password"));
        //从服务层调用方法处理添加用户的业务逻辑
        adminUserService.add(adminUser);
        //管理员添加用户成功，返回管理员用户管理页面
        resp.sendRedirect("list");
    }
}