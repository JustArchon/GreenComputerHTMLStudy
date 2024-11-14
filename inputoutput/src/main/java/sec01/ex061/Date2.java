package sec01.ex061;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Date2
 */
@WebServlet("/Date2")
public class Date2 extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Date2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String start1 = request.getParameter("start1");
		String end1 = request.getParameter("end1");
		String start2 = request.getParameter("start2");
		String end2 = request.getParameter("end2");
		request.setAttribute("start1", start1);
		request.setAttribute("end1", end1);
		request.setAttribute("start2", start2);
		request.setAttribute("end2", end2);
		request.setAttribute("hotelname", "Gyujin");
		RequestDispatcher dispatch = request.getRequestDispatcher("/date2.jsp");
		dispatch.forward(request, response);
	}

}
