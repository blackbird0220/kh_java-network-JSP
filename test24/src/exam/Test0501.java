package exam;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sun.jdi.connect.spi.Connection;

public class Test0501 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");		//url 이 잘못되어 
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "1234");
			
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet rs = st.executeUpdate();
			while(rs) {
				System.out.println(rs.getString("empId")+);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 
	}

}
