import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class TesteInsert {
	
	public static void main(String[] args) {
		
		try {
			String jdbc = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(jdbc, "rm94267", "230304");	
			Statement stmt = con.createStatement();
			String ins = "insert into tbl_paciente(nome, email) values('Joao'," + " 'joao@hotmail.com')";
			
			int i = stmt.executeUpdate(ins);
			System.out.println("Retorno do executeUpdate" + i);
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
