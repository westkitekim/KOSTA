package step3;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class TestListener
 *
 */
// 어노테이션 기반 ServletContextListener 설정 
// webstudy08 web.xml 의 <listener>과 같은 기능 
@WebListener
public class TestListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public TestListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * 웹어플리케이션 종료 직전 or ServletContext가 해제되기 직전에 호출
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
         System.out.println("contextDestroyed");
    }

	/**
     * 웹 어플리케이션 시작 시점 or ServletContext가 생성되고 난 직후에 호출 
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         System.out.println("contextInitialized");
    }
	
}
