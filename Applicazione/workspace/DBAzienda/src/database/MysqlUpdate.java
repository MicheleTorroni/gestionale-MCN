package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

import entita.Cliente;
import entita.Insegna;
import entita.Lavoratore;
import entita.Tappeto;

public class MysqlUpdate {

	static Query q = new Query();

	public static void aggiornaLavoratore(Lavoratore l) {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.UPDATE_LAVORATORE);) {
			Class.forName(q.DRIVER);

			pstmt.setFloat(1, Float.parseFloat(l.getStipendio()));
			pstmt.setString(2, l.getPassword());
			pstmt.setInt(3, Integer.valueOf(l.getCodiceLavoratore()));

			pstmt.execute();

		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void aggiornaCliente(Cliente c) {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.UPDATE_CLIENTE);) {

			Class.forName(q.DRIVER);

			pstmt.setString(1, c.getNumeroTelefono());
			pstmt.setString(2, c.getEmail());
			pstmt.setInt(3, Integer.valueOf(c.getCodiceCliente()));

			pstmt.execute();

		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void aggiornaTappeto(Tappeto t, Boolean stato) {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.UPDATE_TAPPETO);) {

			Class.forName(q.DRIVER);

			pstmt.setString(1, t.getStato());
			if (stato == true) {
				pstmt.setString(2, LocalDateTime.now().toString());
			} else {
				pstmt.setString(2, t.getDataCompletamento());
			}
			pstmt.setInt(3, Integer.valueOf(t.getCodiceTappeto()));

			pstmt.execute();

		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void aggiornaInsegna(Insegna i, Boolean stato) {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.UPDATE_INSEGNA);) {

			Class.forName(q.DRIVER);

			pstmt.setString(1, i.getStato());
			if (stato == true) {
				pstmt.setString(2, LocalDateTime.now().toString());
			} else {
				pstmt.setString(2, i.getDataCompletamento());
			}
			pstmt.setInt(3, Integer.valueOf(i.getCodiceInsegna()));

			pstmt.execute();

		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static void aggiornaIndiceVenditore(String codice) {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.INCREASE_VENDITORE);) {

			Class.forName(q.DRIVER);

			pstmt.setInt(1,Integer.parseInt(codice));
			
			pstmt.execute();

		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static void aggiornaIndiceArtigiano(String codice) {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.INCREASE_ARTIGIANO);) {

			Class.forName(q.DRIVER);

			pstmt.setInt(1,Integer.parseInt(codice));
			
			pstmt.execute();

		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static void aggiornaIndiceCliente(String codice) {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.INCREASE_CLIENTE);) {

			Class.forName(q.DRIVER);

			pstmt.setInt(1,Integer.parseInt(codice));
			
			pstmt.execute();

		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
