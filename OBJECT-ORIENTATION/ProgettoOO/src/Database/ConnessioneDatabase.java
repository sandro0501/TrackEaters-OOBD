package Database;
import java.sql.*;

//Connessione al database implementata mediante singleton pattern
public class ConnessioneDatabase {
	
	private static ConnessioneDatabase istanzaConnessione;
	private Connection connessione = null;
	private String url = "";
	private String username = "";
	private String password = "";
	private String driver = "d";
	
	private ConnessioneDatabase() throws SQLException {
		try {
			Class.forName(driver);
			connessione = DriverManager.getConnection(url, username, password);
			System.out.println("Connessione riuscita");
		} catch(ClassNotFoundException eccezioneConnDbFallita) {
			System.out.println("Connessione al database non riuscita:"+eccezioneConnDbFallita.getMessage());	
		}
	}
	
	public Connection getConnessione() {
		return connessione;
	}
	
	public static ConnessioneDatabase getIstanzaConnessione() throws SQLException {
		if (istanzaConnessione == null) {
			istanzaConnessione = new ConnessioneDatabase();
		} else if (istanzaConnessione.getConnessione().isClosed()) {
			istanzaConnessione = new ConnessioneDatabase();
		}
		return istanzaConnessione;
	}
	
}