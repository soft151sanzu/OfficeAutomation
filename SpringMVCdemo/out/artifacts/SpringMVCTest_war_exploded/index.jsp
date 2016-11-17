<%--
  Created by IntelliJ IDEA.
  User: 青葉
  Date: 2016/11/16
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<p>学生添加<br/>
    <!-- pageContext.request.contextPath代表绝对路径,报404先检查有没有加上绝对路径，限JSP使用 -->
    <!-- 将页码page用get方式传到后台，在后台方法里加入参数接收 -->
    <a href="${pageContext.request.contextPath}/studentlimit.action?page=1">查询所有学生信息</a>
</p>

<p>学生添加<br/>
    <!-- post方式表单提交数据，后台只需要在方法参数里加入实体类Student的对象，提交到后台会自动装配入对象中，此处name需与实体类里属性名对应 -->
<form action="${pageContext.request.contextPath}/studentcreate.action" method="post">
    学生ID:<input type="text" name="sid"><br/>
    学生姓名:<input type="text" name="sname"><br/>
    学生年龄:<input type="text" name="age"><br/>
    <input type="submit" value="添加">
</form>
</p>

<p>学生修改<br/>
    <!-- 与添加同理 -->
<form action="${pageContext.request.contextPath}/studentupdate.action" method="post">
    学生ID:<input type="text" name="sid"><br/>
    学生姓名:<input type="text" name="sname"><br/>
    学生年龄:<input type="text" name="age"><br/>
    <input type="submit" value="修改">
</form>
</p>

<p>学生查询<br/>
    <!-- 表单通过get方式提交，效果同studentbyid.action?sid=，参数为表单内值 -->
<form action="${pageContext.request.contextPath}/studentbyid.action" method="get">
    学生ID:<input type="text" name="sid"><br/>
    <input type="submit" value="查询">
</form>
</p>
</body>
</html>
