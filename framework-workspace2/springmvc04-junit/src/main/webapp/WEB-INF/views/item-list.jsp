<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>아이템 리스트</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>아이템 리스트 조회</h2>
  <table class="table table-hover">
    <thead>
      <tr>
        <th>ItemNo</th>
        <th>Name</th>
        <th>Maker</th>
        <th>Price</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${itemList }" var="item">
      <tr>
        <td>${item.itemNo }</td>
        <td>${item.name }</td>
        <td>${item.maker }</td>
        <td>${item.price }</td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>

</body>
</html>
