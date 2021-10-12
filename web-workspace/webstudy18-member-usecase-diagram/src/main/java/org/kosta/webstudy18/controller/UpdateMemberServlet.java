package org.kosta.webstudy18.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.webstudy18.model.MemberDAO;
import org.kosta.webstudy18.model.MemberVO;

/**
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/UpdateMemberServlet")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*1차 풀이
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		String url = "update-result.jsp";
		try {
			MemberDAO dao = MemberDAO.getInstance();
			dao.update(password, name, address);

			HttpSession session = request.getSession(false);
			session.setAttribute("mvo", dao.findMemberById(id));
			url = "update-result.jsp";

		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect(url);
	}
	*/
	
	/* 2차 풀이(성공) 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		try {
		
			MemberDAO dao = MemberDAO.getInstance();
			

			HttpSession session = request.getSession();
			MemberVO vo = (MemberVO) session.getAttribute("mvo");
			vo = new MemberVO(id, password, name, address);
			dao.updateMember(vo);
			session.setAttribute("mvo", vo);
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("update-result.jsp");
	}
	*/
	//강사님
	//회원정보가 공개돼서는 안되기 때문에 doPost로 작성
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		//오랜시간 작업을 하지 않아 세션이 사라졌을 경우 등 세션이 없는 경우의 수를 미리 체크해준다
		//if는 로그인 상태가 아닌 경우 = session 객체가 없는 경우
		//애초에 세션이 생성되지 않았거나, mvo라는 이름의 세션객체가 없는 경우 구현
		if(session == null || session.getAttribute("mvo") == null) {
			response.sendRedirect("index.jsp");//index로 보낸다
			return;//return; keyword는 메서드 실행을 종료
			//else와 똑같다. else로 묶어주거나 return 사용하거나,
			//아래는 진행하지 않고 doPost 메서드를 종료	
		}
		//post 방식으로 전송한 데이터는 http request body에 저장되어 별도의 한글처리가 필요하다
		request.setCharacterEncoding("utf-8");
		//각각 jsp에서 입력한 데이터들을 가져와 변수에 할당
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		try {
			//먼저 update된 VO객체 생성후 DAO 객체의 updateMember()메서드를 통해 db업데이트
			MemberVO vo = new MemberVO(id, password, name, address);
			//DAO에서 왜 exception 처리를 해줄까? 
			MemberDAO.getInstance().updateMember(vo);//db에 회원정보를 수정한다
			
			//세션에 저장된 회원정보를 수정한다
			//getSession(false)로 인자값있는 메서드
			//만약 회원이 회원 수정폼 해놓고 오랜 시간동안 작업을 안했다면 - 
			
			//같은이름의 세션이름으로 저장하면 업데이트가 된다 
			//mvo 세션은 LoginServlet에서 생성한 세션이다
			session.setAttribute("mvo", vo);//로그인 시에 저장되었던 세션을 업데이트
			response.sendRedirect("update-result.jsp");//업데이트 정보를 페이지에 출력하기위해 이동시키기 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}









