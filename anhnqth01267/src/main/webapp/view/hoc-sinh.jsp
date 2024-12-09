<%--
  Created by IntelliJ IDEA.
  User: abc
  Date: 4/12/24
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/jquery.js"></script>
        <script>
            function showData() {
                $.ajax({
                    url: "/api/sinh-vien/get-list",
                    type: "get",
                    dataType: "json",
                    success: function (response){
                        console.log(response);
                    },
                    error: function () {
                        console.log("Lỗi")
                    }
                })
            }

        </script>
</head>
<body>
    <button onclick="showData()">Show data</button>
</body>
</html>
