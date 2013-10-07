package git.test.java;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletTest extends HttpServlet{

private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String url = req.getRequestURL().toString();
		String aStr = req.getParameter("a");
		String bStr = req.getParameter("b");
		if(aStr==null || bStr==null){
			resp.getWriter().println("<i>404 - Not found operation...</i>");
			return;
		}
		int a = Integer.parseInt(aStr);
		int b = Integer.parseInt(req.getParameter(bStr));
		if(url.contains("suma")){
			resp.getWriter().println("<h1>La suma de "+a+"+"+b+" es <strong>"+(a+b)+"</strong></h1>");
			return;
		}
		if(url.contains("resta")){
			resp.getWriter().println("<h1>La resta de "+a+"-"+b+" es <strong>"+(a+b)+"</strong></h1>");
			return;
		}
		if(url.contains("divicion")){
			resp.getWriter().println("<h1>La divicion de "+a+"/"+b+" es <strong>"+(a+b)+"</strong></h1>");
			return;
		}
		if(url.contains("multiplicacion")){
			resp.getWriter().println("<h1>La multiplicacion de "+a+"*"+b+" es <strong>"+(a+b)+"</strong></h1>");
			return;
		}
		resp.getWriter().println("<i>404 - Not found operation...</i>");
	}
}
