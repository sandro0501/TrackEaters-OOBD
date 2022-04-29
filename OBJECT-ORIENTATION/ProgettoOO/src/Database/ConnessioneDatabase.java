package Database;
import java.sql.*;

//implementata mediante singleton pattern
public class ConnessioneDatabase {

    private static ConnessioneDatabase istanzaConnessione;
    private  Connection connessione = null;
    private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
    private String username = "santolo";
    private String password = "orcl";
    private String driver = "oracle.jdbc.driver.OracleDriver";

    private ConnessioneDatabase() throws SQLException {
        try {
            Class.forName(driver);
            connessione = DriverManager.getConnection(url, username, password);
            System.out.println("Connessione riuscita");
        } catch(ClassNotFoundException eccezioneConnDbFallita) {
            System.out.println("Connessione al database non riuscita: "+eccezioneConnDbFallita.getMessage());
        }
    }

    public Connection getConnessione() {
        return connessione;
    }

    public static ConnessioneDatabase getIstanzaConnessione() throws  SQLException {
        if (istanzaConnessione == null) {
            istanzaConnessione = new ConnessioneDatabase();
        } else if (istanzaConnessione.getConnessione().isClosed()) {
            istanzaConnessione = new ConnessioneDatabase();
        }
        return istanzaConnessione;
    }
}
