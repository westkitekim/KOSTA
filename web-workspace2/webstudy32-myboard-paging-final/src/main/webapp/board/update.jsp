<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- import 대상이므로 선언부 필요없음 --%>
<form action="UpdatePostController.do" method="post">
	<table class="table">
		<tr>
			<td>
				<input type="hidden" name="no" value="${pvo.no }">
				<input type="text" name="title" value="${pvo.title }" required="required">
			</td>
		</tr>
		<tr>
			<td>
				<%-- cols=""는 반응형으로 하기 위해 사용X, form-control: bootstrap --%>
				<textarea rows="10" class="form-control" name="content" required="required">${pvo.content }</textarea>
			</td>
		</tr>
	</table>
	<div class="text-center">
		<button type="submit" class="btn warning">수정</button>
		<button type="reset" class="btn warning">취소</button><%-- form 내용 지우기 --%>
	</div>
</form>