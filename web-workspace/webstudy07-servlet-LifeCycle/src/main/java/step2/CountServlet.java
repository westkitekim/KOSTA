package step2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CountServlet
 */
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//txt파일은 datainputstream 에 사용 
	private String path = "C:\\kosta224\\iotest\\count";
    private int count;
    public CountServlet() {
        super();
        System.out.println("CountServlet 객체생성");
    }

	@Override
	public void init() throws ServletException {
		File countFile = new File(path);
		if(countFile.isFile()) {
		
			try {
				DataInputStream dis = new DataInputStream(new FileInputStream(countFile));
				count = dis.readInt();
				dis.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		}else {
			count++;
		}
		
		System.out.println("init 실행 "+ count);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//count++; 는 안됨 - 서버 재시작시 count가 안된 상태로 진행
		System.out.println("service() 실행");//요청시마다 실행 
		response.setContentType("text/html;charset=utf-8");//응답시 한글처리를 위해 charset utf-8을 지정한다
		//													 charset="utf-8"해야 한글반영
		PrintWriter out = response.getWriter();//소켓에서 new printWriter와 같은 역할
		out.println("<h3>CountServlet service 계열 메서드 doGet method 실행");//404 BasicServlet 설정정보 없기 때문
		out.println(" 접속수:"+ count + "</h3>");
		count++;//3
		out.close();
		//다른 브라우저로 실행해도 count++ 실행 - 하나의 객체이기 때문에 데이터가 공유된다
		//count 값을 유지하려면 destroy에서 io로 outputStream
	}
	@Override
	public void destroy() {//Server tab에서 중지했을 때 실행됨, 다시 시작될 때 로드하여 이전의 데이터 그대로 사용 
		
		try {
			DataOutputStream dos = new DataOutputStream(new FileOutputStream(path));
			dos.writeInt(count);
			dos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("destroy 실행 - 조회수 백업");
	}
}







































