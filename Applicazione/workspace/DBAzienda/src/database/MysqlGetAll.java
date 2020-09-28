package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import entita.Cliente;
import entita.Insegna;
import entita.Lavoratore;
import entita.Ordine;
import entita.Prodotto;
import entita.Tappeto;

public class MysqlGetAll {
	static Query q = new Query();

	public static ArrayList<Prodotto> getProdotti() throws SQLException, ClassNotFoundException {
		ResultSet rs = null;
		ArrayList<Prodotto> al = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();) {
			Class.forName(q.DRIVER);
			try (ResultSet temp = stmt.executeQuery(q.GET_PRODOTTI);) {
				rs = temp;

				while (rs.next()) {
					Prodotto p = new Prodotto(rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(3), "",
							"", "", "", "", "", "", "", "", "");
					al.add(p);
				}

			} catch (SQLException ex) {
				Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return al;
	}

	public static ArrayList<Lavoratore> getLavoratori() throws SQLException, ClassNotFoundException {
		ResultSet rs = null;
		ArrayList<Lavoratore> al = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();) {
			Class.forName(q.DRIVER);
			try (ResultSet temp = stmt.executeQuery(q.GET_LAVORATORI);) {
				rs = temp;

				while (rs.next()) {
					al.add(new Lavoratore(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), "0", "0"));
				}

			} catch (SQLException ex) {
				Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return al;
	}

	public static ArrayList<Ordine> getOrdini() throws SQLException, ClassNotFoundException {
		ResultSet rs = null;
		ArrayList<Ordine> al = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();) {
			Class.forName(q.DRIVER);
			try (ResultSet temp = stmt.executeQuery(q.GET_ORDINI);) {
				rs = temp;

				while (rs.next()) {
					al.add(new Ordine(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5)));
				}

			} catch (SQLException ex) {
				Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return al;
	}

	public static ArrayList<Cliente> getClienti() throws SQLException, ClassNotFoundException {
		ResultSet rs = null;
		ArrayList<Cliente> al = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();) {
			Class.forName(q.DRIVER);
			try (ResultSet temp = stmt.executeQuery(q.GET_CLIENTI);) {
				rs = temp;

				while (rs.next()) {
					Cliente c = new Cliente(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), "", "", "", "", "");

					al.add(c);
				}

			} catch (SQLException ex) {
				Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return al;
	}

	public static ArrayList<Tappeto> getTappeti() throws SQLException, ClassNotFoundException {
		ResultSet rs = null;
		ArrayList<Tappeto> al = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();) {
			Class.forName(q.DRIVER);
			try (ResultSet temp = stmt.executeQuery(q.GET_TAPPETI);) {
				rs = temp;

				while (rs.next()) {
					Tappeto t = new Tappeto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
					al.add(t);
				}

			} catch (SQLException ex) {
				Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return al;
	}

	public static ArrayList<Insegna> getInsegne() throws SQLException, ClassNotFoundException {
		ResultSet rs = null;
		ArrayList<Insegna> al = new ArrayList<>();

		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();) {
			Class.forName(q.DRIVER);
			try (ResultSet temp = stmt.executeQuery(q.GET_INSEGNE);) {
				rs = temp;

				while (rs.next()) {
					Insegna i = new Insegna(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
							rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
							rs.getString(10), rs.getString(11));
					al.add(i);
				}

			} catch (SQLException ex) {
				Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return al;
	}

}
