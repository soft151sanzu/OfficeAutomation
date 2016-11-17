<%--
  Created by IntelliJ IDEA.
  User: 青葉
  Date: 2016/11/16
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.zhangly.modules.models.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //接收后台存入session的studentList集合，用于遍历
    List<Student> studentList = (List<Student>) session.getAttribute("studentList");
%>
<table border="1">
    <tr>
        <td align="center">学生ID</td>
        <td align="center">学生姓名</td>
        <td align="center">学生年龄</td>
        <td align="center">操作</td>
    </tr>
    <%
        for (int i = 0; i < studentList.size(); i++) {
    %>
    <tr>
        <td align="center"><%= studentList.get(i).getSid()%>
        </td>
        <td align="center"><%= studentList.get(i).getSname()%>
        </td>
        <td align="center"><%= studentList.get(i).getAge()%>
        </td>
        <td align="center">
            <a href="${pageContext.request.contextPath}/studentdelete.action?sid=<%= studentList.get(i).getSid()%>">删除</a>
        </td>
    </tr>
    <%
        }
    %>
    <tr>
        <!-- 用El表达式抓取session域中的page属性，并提交给后台作为页码,get方式提交 -->
        <td align="center"><a href="${pageContext.request.contextPath}/studentlimit.action?page=${sessionScope.page-1}">上一页</a></td>
        <td align="center"><a href="${pageContext.request.contextPath}/studentlimit.action?page=1">首页</a></td>
        <td align="center"><a href="${pageContext.request.contextPath}/studentlimit.action?page=${sessionScope.maxPage}">尾页</a></td>
        <td align="center"><a href="${pageContext.request.contextPath}/studentlimit.action?page=${sessionScope.page+1}">下一页</a></td>
    </tr>
    <tr>
        <td colspan="4" align="center"><a href="${pageContext.request.contextPath}/index.jsp">返回主页</a></td>
    </tr>
</table>
</body>
</html>
