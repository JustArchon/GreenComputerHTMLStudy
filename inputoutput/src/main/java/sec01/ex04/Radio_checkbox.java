package sec01.ex04;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Radio_checkbox
 */
@WebServlet("/Radio_checkbox")
public class Radio_checkbox extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Radio_checkbox() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String subject=request.getParameter("subject");
		String[] mailings=request.getParameterValues("mailing");
		System.out.print(subject+"\t");
		for(int i=0; i<mailings.length; i++) {
			if(mailings[i] == null) continue;
			else {
				System.out.print(mailings[i] +"\t");
			}
		}
		RequestDispatcher dispatch = request.getRequestDispatcher("/Radio_checkbox.jsp");
		dispatch.forward(request, response);
	}

}
