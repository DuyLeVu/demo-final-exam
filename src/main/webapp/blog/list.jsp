<%--
  Created by IntelliJ IDEA.
  User: Duy Le Vu
  Date: 12/2/2021
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Blog Management Application</title>
</head>
<body>
<center>
    <h1>Blog Management</h1>
    <h2>
        <a href="/blogs?action=create">Add New Blog</a>
    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Blogs</h2></caption>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Content</th>
            <th>Category</th>
        </tr>
        <c:forEach var="i" begin="0" end="${blogs.size()-1}">
            <tr>
                <td><c:out value="${blogs.get(i).id}"/></td>
                <td><c:out value="${blogs.get(i).title}"/></td>
                <td><c:out value="${blogs.get(i).content}"/></td>
                <td><c:out value="${categories.get(i).name}"/></td>
                <td>
                    <a href="/blogs?action=edit&id=${blog.id}">Edit</a>
                    <a href="/blogs?action=delete&id=${blog.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
