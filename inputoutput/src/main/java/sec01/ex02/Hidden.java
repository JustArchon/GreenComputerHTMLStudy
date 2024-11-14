package sec01.ex02;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Hidden
 */
@WebServlet("/hidden")
public class Hidden extends HttpServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hidden() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user_id=request.getParameter("user_id");
		String user_pw=request.getParameter("user_pw");
		String grade=request.getParameter("grade");
		request.setAttribute("user_id", user_id);
		request.setAttribute("user_pw", user_pw);
		request.setAttribute("grade", grade);
		RequestDispatcher dispatch = request.getRequestDispatcher("/hidden.jsp");
		dispatch.forward(request, response);
	}

}
