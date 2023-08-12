import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;

public class TesteSelect {
	
	public static void main(String[] args) {
		
		try {
			String jdbc = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(jdbc, "rm94267", "230304");
			String sql = "select * from tbl_paciente";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				long id = rs.getLong("id");
				String nome = rs.getString("nome");
				String email = rs.getString("email");
				LocalDate nasc = rs.getDate("nascimento").toLocalDate();
				System.out.println(id + "\n" + nome + "\n" + email + "\n" + nasc);
			}
			con.close();
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("se fudeu");
		}
	}

}
