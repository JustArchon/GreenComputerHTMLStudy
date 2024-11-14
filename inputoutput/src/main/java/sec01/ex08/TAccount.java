package sec01.ex08;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TAccount
 */
@WebServlet("/TAccount")
public class TAccount extends HttpServlet {
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String new_id=request.getParameter("new_id");
		String new_pw1=request.getParameter("new_pw1");
		String new_pw2=request.getParameter("new_pw2");
		String user_name=request.getParameter("user_name");
		String user_mail=request.getParameter("user_mail");
		String user_tel=request.getParameter("user_tel");
		String message = "";
		if(new_pw1.equals(new_pw2)) {
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
				
				//매개변수화된 SQL 문 작성
				String sql = "" + 
						"INSERT INTO AccountTable (ID, PASSWORD, NAME, EMAIL, PHONENUMBER, REGDATE)" + 
						"VALUES (?, ?, ?, ?, ?, SYSDATE)";
			//PreparedStatement 얻기 및 값 지정
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, new_id);
			pstmt.setString(2, new_pw1);
			pstmt.setString(3, user_name);
			pstmt.setString(4, user_mail);
			pstmt.setString(5, user_tel);
			
			//SQL 문 실행
			pstmt.executeUpdate();
			
			message = "정상적으로 가입이 완료되었습니다.";
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
			if(conn != null) {
				try {
					conn.close();
					}catch(SQLException e) {}
				}
			}
		} else {
			message = "비밀번호가 일치하지 않습니다.";
			
		}
		request.setAttribute("message", message);
		RequestDispatcher dispatch = request.getRequestDispatcher("/Taccount.jsp");
		dispatch.forward(request, response);
	}
}
