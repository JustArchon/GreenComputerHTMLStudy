package sec01.ex071;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class attribute
 */
@WebServlet("/attribute")
public class attribute extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public attribute() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String subj=request.getParameter("subj");
		String uname=request.getParameter("uname");
		String uid=request.getParameter("uid");
		String uclass=request.getParameter("uclass");
		String book=request.getParameter("book");
		String wsheet=request.getParameter("wsheet");
		String group=request.getParameter("group");
		request.setAttribute("subj", subj);
		request.setAttribute("uname", uname);
		request.setAttribute("uid", uid);
		request.setAttribute("uclass", uclass);
		request.setAttribute("book", book);
		request.setAttribute("wsheet", wsheet);
		request.setAttribute("group", group);
		RequestDispatcher dispatch = request.getRequestDispatcher("/attribute.jsp");
		dispatch.forward(request, response);
	}

}
