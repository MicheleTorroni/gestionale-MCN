package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MysqlDelete {

	static Query q = new Query();
	static ResultSet rs = null;

	public static void eliminaProdotto(String codice) throws ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.DEL_PRODOTTO);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codice));
			pstmt.execute();
		} catch (SQLException ex) {
			Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void eliminaMaterialeTop(String codice) throws ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.DEL_MATERIALETOP);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codice));
			pstmt.execute();
		} catch (SQLException ex) {
			Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void eliminaBase(String codice) throws ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.DEL_BASE);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codice));
			pstmt.execute();
		} catch (SQLException ex) {
			Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void eliminaAntinciampo(String codice) throws ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.DEL_ANTINCIAMPO);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codice));
			pstmt.execute();
		} catch (SQLException ex) {
			Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void eliminaMaterialeTelaio(String codice) throws ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.DEL_MATERIALETELAIO);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codice));
			pstmt.execute();
		} catch (SQLException ex) {
			Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void eliminaNeon(String codice) throws ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.DEL_NEON);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codice));
			pstmt.execute();
		} catch (SQLException ex) {
			Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void eliminaLed(String codice) throws ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.DEL_LED);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codice));
			pstmt.execute();
		} catch (SQLException ex) {
			Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void eliminaLavoratore(String codice) throws ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.DEL_LAVORATORE);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codice));
			pstmt.execute();
		} catch (SQLException ex) {
			Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void eliminaAmministratore(String codice) throws ClassNotFoundException {

		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.DEL_AMMINISTRATORE);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codice));
			pstmt.execute();
		} catch (SQLException ex) {
			Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public static void eliminaVenditore(String codice) throws ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.DEL_VENDITORE);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codice));
			pstmt.execute();
		} catch (SQLException ex) {
			Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void eliminaArtigiano(String codice) throws ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.DEL_ARTIGIANO);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codice));
			pstmt.execute();
		} catch (SQLException ex) {
			Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void eliminaCliente(String codice) throws ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.DEL_CLIENTE);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codice));
			pstmt.execute();
		} catch (SQLException ex) {
			Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void eliminaPrivato(String codice) throws ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.DEL_PRIVATO);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codice));
			pstmt.execute();
		} catch (SQLException ex) {
			Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static void eliminaPartitaIva(String codice) throws ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.DEL_PARTITAIVA);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codice));
			pstmt.execute();
		} catch (SQLException ex) {
			Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
