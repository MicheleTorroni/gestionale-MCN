package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MysqlMax {

	static Query q = new Query();
	static ResultSet rs = null;
	static String codice = "errore";

	public static String maxProdotti() throws SQLException, ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();) {
			Class.forName(q.DRIVER);
			try (ResultSet temp = stmt.executeQuery(q.MAX_PRODOTTI);) {
				rs = temp;

				while (rs.next()) {
					codice = rs.getString(1);
				}

			} catch (SQLException ex) {
				Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return codice;
	}

	public static String maxLavoratori() throws SQLException, ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();) {
			Class.forName(q.DRIVER);
			try (ResultSet temp = stmt.executeQuery(q.MAX_LAVORATORI);) {
				rs = temp;

				while (rs.next()) {
					codice = rs.getString(1);
				}

			} catch (SQLException ex) {
				Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return codice;
	}

	public static String maxOrdini() throws SQLException, ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();) {
			Class.forName(q.DRIVER);
			try (ResultSet temp = stmt.executeQuery(q.MAX_ORDINI);) {
				rs = temp;

				while (rs.next()) {
					codice = rs.getString(1);
				}

			} catch (SQLException ex) {
				Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return codice;
	}

	public static String maxClienti() throws SQLException, ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();) {
			Class.forName(q.DRIVER);
			try (ResultSet temp = stmt.executeQuery(q.MAX_CLIENTI);) {
				rs = temp;

				while (rs.next()) {
					codice = rs.getString(1);
				}

			} catch (SQLException ex) {
				Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return codice;
	}

	public static String maxTappeti() throws SQLException, ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();) {
			Class.forName(q.DRIVER);
			try (ResultSet temp = stmt.executeQuery(q.MAX_TAPPETI);) {
				rs = temp;

				while (rs.next()) {
					codice = rs.getString(1);
				}

			} catch (SQLException ex) {
				Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return codice;
	}

	public static String maxInsegne() throws SQLException, ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();) {
			Class.forName(q.DRIVER);
			try (ResultSet temp = stmt.executeQuery(q.MAX_INSEGNE);) {
				rs = temp;

				while (rs.next()) {
					codice = rs.getString(1);
				}

			} catch (SQLException ex) {
				Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return codice;
	}

}
