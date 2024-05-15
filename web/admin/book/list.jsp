<%@ page import="cdu.ljh.model.Book" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <base href="http://${header.host}${pageContext.request.contextPath}/admin/">
    <title>图书管理</title>
</head>
<body>
<div>
    <h1>购书网站后台管理平台</h1>
    <a href="../customer/book/list">前台首页</a>
    <a href="book/list">图书列表</a> <a href="book/add.jsp">添加图书</a>
</div>
<hr>
<h2>图书管理列表</h2>
<form action="book/query" method="post">
    书名：<input type="text" name="title">
    作者：<input type="text" name="author">
    出版社：<input type="text" name="press">
    <button type="submit">查 询</button>
</form>
<table>
    <tr>
        <th>封面</th>
        <th>id</th>
        <th>书名</th>
        <th>作者</th>
        <th>出版社</th>
        <th>价格</th>
        <th>折扣</th>
        <th>库存</th>
        <th>出版日期</th>
        <th>上架日期</th>
        <th>操作</th>

    </tr>
    <%
        List<Book> books = (List<Book>) request.getAttribute("books");
        for (Book book : books) {
            out.print("<tr>");
    %>
    <td><img width="64px" src="<%=book.getCoverUrl() %>"></td>
    <td><%=book.getId() %>
    </td>
    <td><%=book.getTitle() %>
    </td>
    <td><%=book.getAuthor() %>
    </td>
    <td><%=book.getPress() %>
    </td>
    <td><%=book.getPrice() %>
    </td>
    <td><%=book.getSale() %>
    </td>
    <td><%=book.getStock() %>
    </td>
    <td><%=book.getPublishDate() %>
    </td>
    <td><%=book.getMarketDate() %>
    </td>
    <td><a href="book/modPre?id=<%=book.getId() %>">修改</a>
        <a href="book/del?id=<%=book.getId() %>">删除</a>
    </td>
    <%
            out.print("</tr>");
        }
    %>
</table>
<%-- 分页导航--%>
<%
        int p = (int) request.getAttribute("p");
        int pCount = (int) request.getAttribute("pCount");
    if (p > 1) {
        out.print("<a href='book/list?p=" + (p - 1) + "'>上一页</a>");
    }
    if (p < pCount) {
        out.print("<a href='book/list?p=" + (p + 1) + "'>下一页</a>");
    }
%>
</body>
</html>
