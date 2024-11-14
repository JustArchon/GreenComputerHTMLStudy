package sec01.ex021;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class signup
 */
@WebServlet("/signup")
public class signup extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user_id=request.getParameter("user_id");
		String user_pwd1=request.getParameter("pwd1");
		String user_pwd2=request.getParameter("pwd2");
		String user_name=request.getParameter("user-name");
		String user_email=request.getParameter("email");
		String user_phone=request.getParameter("phone");
		String user_bloghome=request.getParameter("bloghome");
		request.setAttribute("user_id", user_id);
		request.setAttribute("user_pwd1", user_pwd1);
		request.setAttribute("user_pwd2", user_pwd2);
		request.setAttribute("user_name", user_name);
		request.setAttribute("user_email", user_email);
		request.setAttribute("user_phone", user_phone);
		request.setAttribute("user_bloghome", user_bloghome);
		RequestDispatcher dispatch = request.getRequestDispatcher("/signup.jsp");
		dispatch.forward(request, response);
	}
}
