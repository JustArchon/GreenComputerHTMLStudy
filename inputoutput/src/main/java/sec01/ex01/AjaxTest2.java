package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AjaxTest2
 */
@WebServlet("/AjaxTest2")
public class AjaxTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTest2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandler(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandler(request, response);
	}
	
	private void doHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		String result = "";
		PrintWriter writer = response.getWriter();
		result = "<main><book>"+
				"<title><![CDATA[초보자를 위한 자바 프로그래밍]]></title>"+
				"<writer><![CDATA[인포북스 저 | 이병승]]></writer>"+
				"<image><![CDATA[http://localhost:8090/inputoutput/images/book1.jpg]]></image>"+
				"</book>"+
				"<book>"+
				"<title><![CDATA[모두의 파이썬]]></title>"+
				"<writer><![CDATA[길벗 저 | 이승찬]]></writer>"+
				"<image><![CDATA[http://localhost:8090/inputoutput/images/book2.jpg]]></image>"+
				"</book></main>";
		System.out.println(result);
		writer.print(result);
	}

}
