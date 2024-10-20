<%--
  Created by IntelliJ IDEA.
  User: Fenlyin
  Date: 9/27/2024
  Time: 8:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Login</title>
    <!-- 引入 Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
</head>

<body>
<div class="container mt-5">
    <h1 class="text-center">登录</h1>
    <form action="${pageContext.request.contextPath}/user" method="post">
        <div class="mb-3">
            <label for="username" class="form-label">用户名</label>
            <input type="text" class="form-control" id="username" name="username" required>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">密码</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <input type="hidden" name="option" value="login">
        <div class="text-center">
            <button type="submit" class="btn btn-primary">登录</button>
            <button type="button" class="btn btn-primary" onclick="goToRegister()">注册</button>
        </div>
    </form>
</div>
<!-- 引入 Bootstrap JavaScript（如果需要使用 Bootstrap 的 JavaScript 功能） -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
        crossorigin="anonymous"></script>
<script>
    function goToRegister(){
        window.location.href = "${pageContext.request.contextPath}/view/register.jsp";
    }
</script>
</body>

</html>