package oracledaoimplementation;

import java.util.ArrayList;
import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.CameriereDAO;
import database.ConnessioneDatabase;
import dto.Cameriere;
import dto.Tavolo;

import dao.RistoranteDAO;
import dto.Ristorante;
import oracledaoimplementation.RistoranteOracleImplementation;

import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CameriereOracleImplementation implements CameriereDAO {
	
	private Connection connessione = null;
	
	public CameriereOracleImplementation() {
		try {
			connessione = ConnessioneDatabase.getIstanzaConnessione().getConnessione();
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
	}

	@Override
	public ArrayList<Cameriere> getCamerieriRistorante(int codRistorante) {
		
		ArrayList<Cameriere> camerieri = new ArrayList<>();
		String codiceRistorante = String.valueOf(codRistorante);
		
		try {
			
			String queryCamerieriRistorante = "SELECT * FROM Cameriere C JOIN Ristorante R ON C.Ristorante=R.CodRistorante WHERE R.CodRistorante = ?";
			PreparedStatement stmtCamerieriRistorante = connessione.prepareStatement(queryCamerieriRistorante);
			stmtCamerieriRistorante.setString(1, codiceRistorante);
			ResultSet rs = stmtCamerieriRistorante.executeQuery();
			
			while(rs.next()) {
				Cameriere c = new Cameriere(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
				camerieri.add(c);
			}
			
			rs.close();
			stmtCamerieriRistorante.close();
			
		} catch (SQLException e) {
			
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
			
		}
		
		return camerieri;
	}

	@Override
	public Cameriere getCameriereByCodTavoloAndDataTavolata(int codTavolo, Date dataTavolata) {
		Cameriere c = null;
		try {
			String queryGetCameriere = "SELECT C.numcid,C.nome,C.cognome,C.datan,C.sesso,C.cittan,C.provn,C.cittares,C.provres,C.telefono,C.email "
					+ "FROM CAMERIERE C JOIN TAVOLATA T ON C.Numcid = T.Cameriere WHERE T.Tavolo = ? AND t.dataarrivo = ?";
			PreparedStatement stmtGetCameriere = connessione.prepareStatement(queryGetCameriere);
			stmtGetCameriere.setInt(1, codTavolo);
			stmtGetCameriere.setDate(2, dataTavolata);
			
			ResultSet rs = stmtGetCameriere.executeQuery();
			
			if(rs.next()) {
				c = new Cameriere(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));
			}
			
			rs.close();
			stmtGetCameriere.close();	
			    
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		
		return c;
	}

	@Override
	public String getNumcidCameriereByNomeAndCognomeAndRistorante(String nome, String cognome, int codRistorante) {
		String numCid = null;
		try {
			String queryGetNumcid = "SELECT C.Numcid FROM CAMERIERE C WHERE C.Nome=? AND C.Cognome=? AND C.Ristorante=?";
			PreparedStatement stmtGetNumcid = connessione.prepareStatement(queryGetNumcid);
			stmtGetNumcid.setString(1, nome);
			stmtGetNumcid.setString(2, cognome);
			stmtGetNumcid.setInt(3, codRistorante);
			
			ResultSet rs = stmtGetNumcid.executeQuery();
			
			if(rs.next()) {
				numCid = rs.getString(1);
			}
			
			rs.close();
			stmtGetNumcid.close();	
			    
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		
		return numCid;
	}
	
	@Override
	public ArrayList<Cameriere> getAllCamerieri(){
		ArrayList<Cameriere> listaCamerieri = new ArrayList<>();
		Ristorante ristorante = null;
		RistoranteDAO ristoranteDAO = new RistoranteOracleImplementation();
		try {
			String queryAllCamerieri = "SELECT * FROM Cameriere C";
			PreparedStatement stmtAllCamerieri = connessione.prepareStatement(queryAllCamerieri);
			ResultSet rsCamerieri = stmtAllCamerieri.executeQuery();
			
			while (rsCamerieri.next()) {
				Cameriere c = new Cameriere(rsCamerieri.getString(1), rsCamerieri.getString(2), rsCamerieri.getString(3), rsCamerieri.getDate(4), rsCamerieri.getString(5), rsCamerieri.getString(6), rsCamerieri.getString(7), rsCamerieri.getString(8), rsCamerieri.getString(9), rsCamerieri.getString(10), rsCamerieri.getString(11));
				ristorante = ristoranteDAO.getRistoranteByCode(rsCamerieri.getInt(12));
				c.setLavoratoreRistorante(ristorante);
				listaCamerieri.add(c);
			}
			
			rsCamerieri.close();
			stmtAllCamerieri.close();
			
		} catch (SQLException e) {
			
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
			
		}
		
		return listaCamerieri;
	}

	@Override
	public boolean insertCameriere(String numeroCid, String nome, String cognome, String dataNascita, String sesso,
			String cittaDiNascita, String provinciaDiNascita, String cittaDiResidenza, String provinciaDiResidenza,
			String telefono, String email, int codRistorante) {
		
		DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("dd/MM/yyyy").toFormatter(Locale.ITALIAN);
		LocalDate dataDiNascita = LocalDate.parse(dataNascita, formatter);

		
		try {
			String queryInsertCameriere = "INSERT INTO CAMERIERE (NumCid, Nome, Cognome, DataN, Sesso, CittaN, ProvN, CittaRes, ProvRes, Telefono, Email, Ristorante) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement stmtInsertCameriere = connessione.prepareStatement(queryInsertCameriere);
			stmtInsertCameriere.setString(1, numeroCid);
			stmtInsertCameriere.setString(2, nome);
			stmtInsertCameriere.setString(3, cognome);
			stmtInsertCameriere.setObject(4, dataDiNascita);
			stmtInsertCameriere.setString(5, sesso);
			stmtInsertCameriere.setString(6, cittaDiNascita);
			stmtInsertCameriere.setString(7, provinciaDiNascita);
			stmtInsertCameriere.setString(8, cittaDiResidenza);
			stmtInsertCameriere.setString(9, provinciaDiResidenza);
			stmtInsertCameriere.setString(10, telefono);
			stmtInsertCameriere.setString(11, email);
			stmtInsertCameriere.setInt(12, codRistorante);
			
			int esitoInsert = stmtInsertCameriere.executeUpdate();
			
			if (esitoInsert == 1) {
				return true;
			}
			
			stmtInsertCameriere.close();
		} catch (SQLException e) {
			gestisciErroriInserimentoDati(e);
			

		}
		
		return false;
	}
	

	@Override
	public boolean deleteCameriere(String numeroCid) {
		
		int esitoDelete;
		
		try {
			String queryDeleteCameriere = "DELETE FROM Cameriere C WHERE C.NumCid=?";
			PreparedStatement stmtDeleteCameriere = connessione.prepareStatement(queryDeleteCameriere);
			stmtDeleteCameriere.setString(1, numeroCid);
			
			esitoDelete = stmtDeleteCameriere.executeUpdate();
			
			if (esitoDelete==1) {
				return true;
			}
			
			stmtDeleteCameriere.close();
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		
		return false;
	}
	
	@Override
	public boolean updateCameriere(String numeroCid, String nome, String cognome, String dataNascita, String sesso,
			String cittaDiNascita, String provinciaDiNascita, String cittaDiResidenza, String provinciaDiResidenza,
			String telefono, String email, int codRistorante) {
		
		DateTimeFormatter formatter = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("dd/MM/yyyy").toFormatter(Locale.ITALIAN);
		LocalDate dataDiNascita = LocalDate.parse(dataNascita, formatter);	
		
		
		try {
			
			String queryUpdateCameriere = "UPDATE Cameriere SET Nome=?, Cognome=?, DataN=?, Sesso=?,  CittaN=?, ProvN=?, CittaRes=?, ProvRes=?, Telefono=?, Email=?, Ristorante=? WHERE NumCid=?";
			PreparedStatement stmtUpdateCameriere = connessione.prepareStatement(queryUpdateCameriere);
			stmtUpdateCameriere.setString(1, nome);
			stmtUpdateCameriere.setString(2, cognome);
			stmtUpdateCameriere.setObject(3, dataDiNascita);
			stmtUpdateCameriere.setString(4, sesso);
			stmtUpdateCameriere.setString(5, cittaDiNascita);
			stmtUpdateCameriere.setString(6, provinciaDiNascita);
			stmtUpdateCameriere.setString(7, cittaDiResidenza);
			stmtUpdateCameriere.setString(8, provinciaDiResidenza);
			stmtUpdateCameriere.setString(9, telefono);
			stmtUpdateCameriere.setString(10, email);
			stmtUpdateCameriere.setInt(11, codRistorante);
			stmtUpdateCameriere.setString(12, numeroCid);
			
			int esitoUpdate = stmtUpdateCameriere.executeUpdate();
			
			if(esitoUpdate==1) 
				return true;
			
			
			stmtUpdateCameriere.close();
			
		} catch (SQLException e) {
			gestisciErroriInserimentoDati(e);
		}
		
		return false;
	}
	
	private void gestisciErroriInserimentoDati(SQLException e) {
		if(e.getErrorCode()==20010) 
		{
			JLabel lblErrore = new JLabel("Numero di telefono non valido! Sono ammesse cifre numeriche ed il carattere +. Riprova.");
			lblErrore.setFont(new Font("Segoe UI", Font.BOLD, 15));
			JOptionPane.showMessageDialog(null,lblErrore,"Errore inserimento dati",JOptionPane.ERROR_MESSAGE);	
		} 
		else if (e.getErrorCode()==20012) 
		{
			JLabel lblErrore = new JLabel("CAP non valido! Sono ammesse al massimo 5 cifre numeriche. Riprova.");
			lblErrore.setFont(new Font("Segoe UI", Font.BOLD, 15));
			JOptionPane.showMessageDialog(null,lblErrore,"Errore inserimento dati",JOptionPane.ERROR_MESSAGE);	
		} 
		else if (e.getMessage().toString().contains("SITO_WEB_LEGALE"))
		{
			JLabel lblErrore = new JLabel("Sito web non valido! Non rispetta la forma 'www.example.domain'. Riprova.");
			lblErrore.setFont(new Font("Segoe UI", Font.BOLD, 15));
			JOptionPane.showMessageDialog(null,lblErrore,"Errore inserimento dati",JOptionPane.ERROR_MESSAGE);
		} 
		else if (e.getMessage().toString().contains("EMAIL_LEGALE"))
		{
			JLabel lblErrore = new JLabel("Email non valida! Non rispetta la forma 'example@mail.domain'. Riprova.");
			lblErrore.setFont(new Font("Segoe UI", Font.BOLD, 15));
			JOptionPane.showMessageDialog(null,lblErrore,"Errore inserimento dati",JOptionPane.ERROR_MESSAGE);	
		} 
		else 
		{
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
	}
}
