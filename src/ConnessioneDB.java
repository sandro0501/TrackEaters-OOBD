import java.sql.*;

public class ConnessioneDB {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");  
		
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:SANTOLO/orcl@localhost:1521:orcl");
		}catch (SQLException throwables) {
			throwables.printStackTrace();
		}
		
		System.out.println("Connessione Ok\n");
		
		try {
			stmt = conn.createStatement();
			String sql = "SELECT * FROM museo";
			rs = stmt.executeQuery(sql);
			int i = 0;
			
			while(rs.next())
			{
				System.out.println(i+1+" record:");
				System.out.println(rs.getString(1)+"|"+rs.getString(2)+"|"+rs.getString(3)+"|"+rs.getString(4)+"|"+rs.getString(5)+
						"|"+rs.getString(6)+"|"+rs.getString(7)+"|"+rs.getString(8)+"|"+rs.getString(9));
				System.out.println();
				i++;
			}                                                                                                                                                          
			
			stmt.close();
			rs.close();
			conn.close();
		}
		catch(SQLException throwables){
			throwables.printStackTrace();
		}

	}

}
