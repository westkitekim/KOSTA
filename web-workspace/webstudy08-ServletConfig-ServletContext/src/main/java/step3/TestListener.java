package step3;
//Listener 생성시 Lifecycle 체크 
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class TestListener
 *
 */
public class TestListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public TestListener() {
        // TODO Auto-generated constructor stub
    }

	/**<메서드 확인하기 contextDestroyed , contextInitialized 
     * web application 종료 직전에 호출 (종료 직전에 백업작업 등 수행 )
     * server 종료시키면 console 창에 contextDestroyed 출력 
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         System.out.println("contextDestroyed");
    }

	/**
     * web application 시작 시점에 호출
     * Server 생성 시 console 창에서 contextInitialized 메세지 확인한다 
     */
    public void contextInitialized(ServletContextEvent event) { 
    	//만들어지고나서 실행 , ServletContext에 만들어진 정보 확인도 가능하고 set도 간으
    	String security = event.getServletContext().getInitParameter("appSecurity");
    	System.out.println("contextInitialized security info:" + security);
    }	
}











