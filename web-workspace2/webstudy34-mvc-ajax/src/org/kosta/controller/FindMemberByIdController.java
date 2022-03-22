package org.kosta.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.model.MemberDAO;
import org.kosta.model.MemberVO;

public class FindMemberByIdController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		MemberVO vo = MemberDAO.getInstance().findMemberById(id);
		String info = null;
		if(vo == null) {
			info = "아이디에 대한 회원정보가 없습니다";
		}else {
			info = id + "아이디 회원정보 조회결과 이름:" + vo.getName() + " 주소:" + vo.getAddress();
		}
		request.setAttribute("responsebody", info);
		//Ajax 방식의 응답을 위해 FrontControllerServlet에 아래와 같이 path를 리턴한다
		return "AjaxView";
	}

}
