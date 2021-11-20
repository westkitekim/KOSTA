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
  
  <%-- 페이징 처리(bootstrap pagination --%>
  <ul class="pagination justify-content-center" style="margin:20px 0">
  <%-- is계열은 boolean 형으로 반환 --%>
  <c:if test="${pagingBean.previousPageGroup }">
  	<%-- querystring 방식으로 요청, 이전그룹의 마지막 번호로 이동 --%>
  	<li class="page-item"><a class="page-link" href="ListController.do?pageNo=${pagingBean.startPageOfPageGroup - 1}">Previous</a></li>
  </c:if>
  
  <c:forEach begin="${pagingBean.startPageOfPageGroup }" end="${pagingBean.endPageOfPageGroup }" var="page">
  	
  	<c:choose>
  	  <%-- 현재페이지와 같으면 --%>
  	  <c:when test="${page == pagingBean.nowPage }">
  	  	<li class="page-item active"><a class="page-link" href="ListController.do?pageNo=${page }">${page }</a></li>
  	  </c:when>
  	  <c:otherwise>
  	    <li class="page-item"><a class="page-link" href="ListController.do?pageNo=${page }">${page }</a></li>
  	  </c:otherwise>
  	</c:choose>
  	
  	
  </c:forEach>
  
  
  <c:if test="${pagingBean.nextPageGroup }">
  	<li class="page-item"><a class="page-link" href="ListController.do?pageNo=${pagingBean.endPageOfPageGroup + 1}">Next</a></li>
  </c:if>
  </ul>
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  