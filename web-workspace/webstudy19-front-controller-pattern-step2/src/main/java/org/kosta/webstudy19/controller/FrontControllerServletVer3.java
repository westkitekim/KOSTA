package org.kosta.webstudy19.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 여러가지 요청을 하나의 서블릿 안에서 처리하기
 * Front Controller Design Pattern 적용 모든 클라이언트의 요청을 하나의 진입점으로 통합하여 처리하는 디자인 패턴
 * FrontControllerServlet : 모든 클라이언트 요청을 처리하는 서블릿
 * 
 * 서블릿 입장에서 누구의 요청인지 알아야 한다 차 정보 조회, 차 리스트 조회 모두 하나의 서블릿으로 가는데 어떻게 구분하지? ->
 * hidden 을 이용해서 구분한다(나는 누구요!!)
 * 
 * 작성하다보면 FrontController가 매우 커지는 것을 확인할 수 있다 - 점점 늘어나는 코드라인.. 
 * 클라이언트의 요구사항이 많아질수록 코드의 길이도 비례하여 길어진다
 * 
 * 클래스명은 달라도 url-pattern은 이전버전과 같아서 이전버전으로 동일하게 실행됨
 * 
 * ★★Refactoring Ver2 작업★★
 * 
 * 		doDispatch 메서드의 처리 작업이 많으므로 
 * 		기능별로 메서드를 분할하여 호출해 요청을 처리하는 방식으로 구조를 개선한다
 * 
 * 		하지만 FrontControllerServlet 전체적인 코드양은 변하지 않고 
 * 		요구사항에 따라 비례하여 증가한다는 점은 Ver1과 동일하다
 * 		하나의 클래스가 점점 증대된다면 처리하는 작업량도 많고 업무 변경양도 많을텐데 
 * 		이것들을 하나의 서블릿에서 처리하는 것은 어렵다! 
 * 		-->> 그래서 또 refactoring.. 아래의 Ver3 참고 
 * 		
 * 
 * ★★Refactoring Ver3 작업★★
 * 
 * 		-->> Ver3: 각 메서드들을 별도의 class에서 처리하도록 구조를 개선해본다
 * 		-->> Command Design Pattern ; 요구사항들을 캡슐화
 * 		콜센터를 별도의 건물, 부서로 분화 
 * 
 * 		Ver3에서는 컨트롤러 로직을 담당하는 메서드를 별도의 클래스로 분화시키고 
 * 		요청처리에 대한 캡슐화, 인터페이스를 통한 업무의 표준화, FrontControllerServletVer3 와 개별 컨트롤러 객체와의 
 * 		결합도를 낮추기 위해(유지보수성 향상과 직결) Controller Interface를 추가하고 개별 컨트롤러 로직을 담당하는 객체들은
 * 		Controller Interface 계층구조의 하위로 편입되도록 한다
 *  
 *  	FrontControllerServletVer3 은 개별 컨트롤러 클래스가 아니라 
 *  	상위 인터페이스인 Controller의 abstract method를 이용해 컨트롤러 로직을 실행한다
 *  
 */

@WebServlet("/FrontControllerServlet")
public class FrontControllerServletVer3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//doDispatch : 발송, 배송 , 이 메서드가 다 처리한다(스프링을 위해 친숙해질것)
	//cf) spring에 doDispatch()가 있음
	
	//Interface 생성 전의 코드 구현체들
	/*
	protected void findCarByNo(HttpServletRequest request, HttpServletResponse response)
			throws Exception {//Exception을 전체범위로 지정 
		
		// 차량번호로 차 정보 검색
		String carNo = request.getParameter("carNo");// findcar-form.jsp의 name값 인자
		String carInfo = MockDAO.getInstance().findCarInfo(carNo);
		String path = null;
		// 예외를 발생시켜 본다, error.jsp페이지가 실행되는 것을 확인
		// String str = null;
		// System.out.println(str.length());

		if (carInfo != null) {
			request.setAttribute("carInfo", carInfo);
			path = "findcar-ok.jsp";
		} else {
			path = "findcar-fail.jsp";
		}
		
		request.getRequestDispatcher(path).forward(request, response);
		
	}
	
	protected void findCarListByMaker(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String maker = request.getParameter("maker");
		ArrayList<String> list = MockDAO.getInstance().findCarListByMaker(maker);
		request.setAttribute("carList", list);
		request.getRequestDispatcher("findcarlist-result.jsp").forward(request, response);
	}
	
	protected void registerCar(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String carInfo = request.getParameter("carInfo");
		MockDAO.getInstance().registerCar(carInfo);
		response.sendRedirect("registercar-result.jsp");
	}
	
	//doDispatch에서는 위 메섣들을 호출만해서 사용함
	protected void doDispatch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//try 맨 위로 끌어올리기
		try {
			//다양한 클라이언트의 요청을 구분하기 위해 command를 받아온다
			String command = request.getParameter("command");// hidden
			//hidden에서 if로 구분해준다음 다시 안에서 jsp 찾는 코드 구현
			if (command.equals("findCarByNo")) {
				//this.findCarByNo(request, response);
			} else if(command.equals("findCarListByMaker")) {
				//this.findCarListByMaker(request, response);
			} else if(command.equals("registerCar")) {
				//this.registerCar(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// Exception 발생할 경우 FrontController로 여러 클라이언트에게 error.jsp를 제공한다
			// 에러상황이 발생하면 콘솔을 확인한다
			response.sendRedirect("error.jsp");
		}
	}
	*/
	
	
	//doDispatch에서는 위 메섣들을 호출만해서 사용함
	protected void doDispatch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//try 맨 위로 끌어올리기
		try {
			//다양한 클라이언트의 요청을 구분하기 위해 command를 받아온다
			String command = request.getParameter("command");// hidden
			//hidden에서 if로 구분해준다음 다시 안에서 jsp 찾는 코드 구현
			Controller controller = null;
			if (command.equals("findCarByNo")) {
				//컨트롤러 객체를 만들고 
				controller = new FindCarByNoController();
				
			} else if(command.equals("findCarListByMaker")) {
				controller = new FindCarListByMakerController();
				
			} else if(command.equals("registerCar")) {
				controller = new RegisterCarController();
			}
			//인터페이스를 통한 계층구조 형성으로 단일한 메세지 방식 ( execute() )으로 
			//다양한 컨트롤러 구현체들을 실행할 수 있다
			String path = controller.execute(request, response);
			//path가 redirect: 으로 시작되면 redirect 방식으로 응답한다
			if(path.startsWith("redirect:"))
				response.sendRedirect(path.substring(9));//redirect: 제외한 문자열 출력하여 해당 path로 이동시킨다
			else//아니면 forward
				request.getRequestDispatcher(path).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			// Exception 발생할 경우 FrontController로 여러 클라이언트에게 error.jsp를 제공한다
			// 에러상황이 발생하면 콘솔을 확인한다
			response.sendRedirect("error.jsp");
		}
	}
	//get과 post에서는 doDispatch() 메서드로 요청에 대한 응답을 보낸다
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doDispatch(request, response);
	}
	//자동차 등록은 Post 요청들을 하나로 모을 것임 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//post방식은 http request body 영역의 별도의 인코딩 처리가 필요
		request.setCharacterEncoding("utf-8");
		doDispatch(request, response);
	}

}













