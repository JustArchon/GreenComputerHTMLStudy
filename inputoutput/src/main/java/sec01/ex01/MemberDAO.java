package sec01.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {
	public boolean overlappedID(String ID) {
		Connection conn = null;
		boolean result = false;
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
			String query = "select decode(count(*),1,'true','false')as result from t_member";
			query += " where id = ?";
			System.out.println("prepareStatememt: " + query);
		//PreparedStatement 얻기 및 값 지정
		PreparedStatement pstmt = conn.prepareStatement(query);
		pstmt.setString(1, ID);
		//SQL 문 실행
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		result = Boolean.parseBoolean(rs.getString("result"));
		pstmt.close();
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
		if(conn != null) {
			try {
				conn.close();
				}catch(SQLException e) {}
			}
		}
		return result;
	}
}
