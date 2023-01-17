

import java.io.IOException;
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
    	System.out.println("0.LifeCycleCounterServlet() 기본생성자호출[최초요청시 단 한번]");
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
