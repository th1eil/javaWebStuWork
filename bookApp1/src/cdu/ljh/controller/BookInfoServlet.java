package cdu.ljh.controller;
import cdu.ljh.model.Book;
import cdu.ljh.service.BookService;
import cdu.ljh.service.impl.BookServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
// 前台：获取某图书的详情
@WebServlet("/customer/book/info")
public class BookInfoServlet extends HttpServlet {
    BookService bookService = new BookServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid = req.getParameter("id");
        if (sid != null && !sid.isEmpty()) {
            // 调用服务层方法使用客户端传递的id值处理查询图书的业务逻辑
            Book book = bookService.get(Integer.parseInt(sid));
            // 在请求范围内保存查询到的图书对象
            req.setAttribute("book", book);
            // 请求转发到图书详情页面
            req.getRequestDispatcher("info.jsp").forward(req, resp);
        } else {
            // 未获取到id参数，则无法获取图书信息，重定向到图书列表界面
            resp.sendRedirect("list");
        }
    }
}