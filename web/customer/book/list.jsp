<%@ page import="cdu.ljh.model.Book" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <base href="http://${header.host}${pageContext.request.contextPath}/customer/">
    <title>购书网站</title>
</head>
<body>
<div>
    <h1><a href="book/list">购书网站</a></h1>
    <a href="../admin/book/list">后台管理</a>
    <a href="book/list">首页</a> <a href="#">登录</a> <a href="#">注册</a>
</div>
<hr>
<%
    List<Book> books = (List<Book>) request.getAttribute("books");
    for (Book book : books) {
        out.print("<div>");
%>
<a href="book/info?id=<%=book.getId() %>"><img width="64px" src="<%=book.getCoverUrl() %>"></a>
<p>
    <a href="book/info?id=<%=book.getId() %>"><%=book.getTitle() %>
    </a><br>
    作者：<%=book.getAuthor() %><br>
    出版社：<%=book.getPress() %><br>
    价格：<%=book.getPrice() %><br>
    库存：<%=book.getStock() %><br>
</p>
<%
        out.print("</div>");
    }
%>
</body>
</html>