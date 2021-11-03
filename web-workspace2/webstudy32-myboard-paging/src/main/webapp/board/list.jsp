<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<table class="table table-hover table-bordered boardlist">
    <thead>
      <tr style="background-color: #d6f5d6">
        <th>번호</th>
        <th class="title">제목</th>
        <th>작성자</th>
        <th>작성일</th>
        <th>조회</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.list }" var="pvo">
      <tr>
        <td>${pvo.no }</td>
<%-- 	
		1. 로그인한 상태이면 글제목에 링크를 부여해서 상세글보기를 제공하고
		   비로그인 상태이면 글제목만 제공한다
 --%>
        <td>
        <c:choose>
        	<c:when test="${sessionScope.mvo != null }">
        		<a href="PostDetailController.do?no=${pvo.no}">${pvo.title }</a>
        	</c:when>
        	<c:otherwise>
        		${pvo.title }
        	</c:otherwise>
        </c:choose>
        </td>
        <td>${pvo.memberVO.name }</td>
        <td>${pvo.timePosted }</td>
        <td>${pvo.hits }</td>
      </tr>
       </c:forEach>
    </tbody>
  </table>