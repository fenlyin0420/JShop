<%--
  Created by IntelliJ IDEA.
  User: Fenlyin
  Date: 9/27/2024
  Time: 3:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>网上商城</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
</head>
<body>
<!-- 顶部导航栏 -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">网上商城</a>
    <form class="form-inline my-2 my-lg-0">
        <input class="form-control mr-sm-2" type="search" placeholder="搜索商品" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">搜索</button>
    </form>
    <!-- 分类下拉菜单 -->
    <div class="dropdown">
        <button class="btn btn-secondary dropdown-toggle" type="button" id="categoryMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
            分类
        </button>
        <div class="dropdown-menu" aria-labelledby="categoryMenu">
            <c:forEach var="category" items="${categories}">
                <a class="dropdown-item" href="ProductServlet?categoryId=${category.id}">${category.category_name}</a>
            </c:forEach>
        </div>
    </div>
</nav>

<!-- 广告轮播区域 -->
<div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img class="d-block w-100" src="../Assets/ad1.jpg" alt="广告1">
        </div>
        <div class="carousel-item">
            <img class="d-block w-100" src="../Assets/ad2.jpg" alt="广告2">
        </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">上一页</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">下一页</span>
    </a>
</div>

<!-- 商品展示区域 -->
<div class="container">
    <div class="row">
        <c:forEach var="product" items="${products}">
            <div class="col-md-3">
                <div class="card">
                    <img class="card-img-top" src="${product.product_image}" alt="${product.product_name}">
                    <div class="card-body">
                        <h5 class="card-title">${product.product_name}</h5>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

    <!-- 换页功能 -->
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="#">上一页</a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">下一页</a></li>
        </ul>
    </nav>
</div>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
</body>
</html>
