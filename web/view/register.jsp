<%--
  Created by IntelliJ IDEA.
  User: Fenlyin
  Date: 9/27/2024
  Time: 3:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">注册</h1>
        <form action="${pageContext.request.contextPath}/user" method="post">
            <div class="mb-3">
                <label for="username" class="form-label">用户名</label>
                <input type="text" id="username" name="username" class="form-control" required><br>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">用户名</label>
                <input type="password" id="password" name="password" class="form-control" required><br>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">邮箱</label>
                <input type="email" id="email" name="email" class="form-control" required><br>
            </div>
            <input type="hidden" name="option" value="register"> <br>
            <input type="submit" class="btn btn-primary" value="注册">
        </form>
    </div>
</body>
