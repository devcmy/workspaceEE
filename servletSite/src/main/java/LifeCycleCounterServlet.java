

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleCounterServlet
 */
@WebServlet("/lifeCycle_Counter.do")
public class LifeCycleCounterServlet extends HttpServlet {
    public LifeCycleCounterServlet() {
    	System.out.println("0.LifeCycleCounterServlet() 기본생성자호출[최초요청시 단 한번호출]객체 주소"+this);
    }
    
    @Override
    	public void init(ServletConfig config) throws ServletException {
    		super.init();
    		System.out.println("1.init()메쏘드 생성자 호출 직후에 단한번 호출[객체 초기화]");
    	}
    
    

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("2.service메쏘드가 실행");
	}

}
