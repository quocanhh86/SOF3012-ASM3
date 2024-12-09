<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: abc
  Date: 4/12/24
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/san-pham/add" method="post">
    Mã <input type="text" name="ma" > ${message}
    <br>
    Hoá đơn chi tiết
    <select name="" >
        <c:forEach items="${listCombobox}" var="hdct">
            <option value="${hdct.id}"> ${hdct.id}</option>

        </c:forEach>
    </select>
    <br>
    Giá bán <input type="text" name="giaBan" > <br>
    Số lượng <input type="text" name="soLuong" > <br>
    <button onclick="" type="submit">Add</button>
</form>
<table>
    <thead>
    <tr>
        <th>#</th>
        <th>Mã sản phẩm</th>
        <th>Giá bán</th>
        <th>Số lượng</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listProduct}" var="sp" varStatus="i">
        <tr>
            <td>${i.index + 1}</td>
            <td>${sp.ma}</td>
            <td>${sp.giaBan}</td>
            <td>${sp.soLuong}</td>
            <td>
                <a href="/san-pham/remove?id=${sp.id}">
                    <button>Remove</button>
                </a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<table border="1">
    <thead>
        <tr>
            <th>#</th>
            <th>Mã Sản Pham</th>
            <th>Giá bán</th>
            <th>Số lượng Sản Phẩm</th>
            <th>Số lượng Bảng Hoá đơn Chi tiết</th>
            <th>Đơn giá</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${listCombobox}" var="hdct" varStatus="i">
            <tr>
                <td>${i.index + 1}</td>
                <td>${hdct.idSp.ma}</td>
                <td>${hdct.idSp.giaBan}</td>
                <td>${hdct.idSp.soLuong}</td>
                <td>${hdct.soLuong}</td>
                <td>${hdct.donGia}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>



</body>
</html>
