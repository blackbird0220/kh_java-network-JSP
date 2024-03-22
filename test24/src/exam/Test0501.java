package exam;

public class Test0501 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");		//url 이 잘못되어 
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "1234");
			String query = select emp_from
			PreparedStatement st = conn.prepareStatement(query);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
