package sec01.ex08;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Tlogin
 */
@WebServlet("/Tlogin")
public class Tlogin extends HttpServlet {
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Tlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String user_id=request.getParameter("user_id");
		String user_pw=request.getParameter("user_pw");
		String message = "";
		Connection conn = null;
		try {
			//JDBC Driver 등록
			Class.forName("oracle.jdbc.OracleDriver");
			
			//연결하기
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521/xe",
					"SYSTEM",
					"oracle"
					);
			
			// 매개변수화된 호출문 작성과 CallableStatement 얻기
			String sql = "{? = call T_USER_LOGIN(?, ?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			
			//? 값 지정 및 리턴 타입 지정
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.setString(2, user_id);
			cstmt.setString(3, user_pw);
			
			// 함수 실행 및 리턴값 얻기
			cstmt.execute();
			int result = cstmt.getInt(1);
			
			//CallableStatement 닫기
			cstmt.close();
		if(result == 0) {
			message = "로그인 성공";
		} else if(result == 1) {
			message = "비밀번호 틀림";
		} else {
			message = "아이디 존재하지 않음";
		}
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
		if(conn != null) {
			try {
				conn.close();
				}catch(SQLException e) {}
			}
		}
		request.setAttribute("user_id", user_id);
		request.setAttribute("user_pw", user_pw);
		request.setAttribute("message", message);
		RequestDispatcher dispatch = request.getRequestDispatcher("/Tlogin.jsp");
		dispatch.forward(request, response);
	}

}
