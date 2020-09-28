package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import entita.Cliente;
import entita.Lavoratore;
import entita.Prodotto;

public class MysqlGet {

	static Query q = new Query();
	static ResultSet rs = null;
	static String ruolo = "errore";
	static Prodotto p = new Prodotto("", "", "", "", "", "", "", "", "", "", "", "", "", "");
	static Cliente c = new Cliente("", "", "", "", "", "", "", "", "", "", "");
	static Lavoratore l = new Lavoratore("", "", "", "", "", "", "", "", "", "");

	public static Prodotto getMaterialeTop(String codice) throws SQLException, ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.GET_MATERIALETOP);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codice));
			try (ResultSet temp = pstmt.executeQuery()) {

				rs = temp;
				while (rs.next()) {
					p.setTipologiaProdotto("materialetop");
					p.setTipologiaTop(rs.getString(2));
					p.setColore(rs.getString(3));
					p.setTipoLama(rs.getString(4));
					p.setCostoM2(rs.getString(5));
				}
			} catch (SQLException ex) {
				Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return p;
	}

	public static Prodotto getBase(String codice) throws SQLException, ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.GET_BASE);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codice));
			try (ResultSet temp = pstmt.executeQuery()) {

				rs = temp;
				while (rs.next()) {
					p.setTipologiaProdotto("base");
					p.setTipologiaBase(rs.getString(2));
					p.setTipoLama(rs.getString(3));
					p.setCostoM2(rs.getString(4));
				}
			} catch (SQLException ex) {
				Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return p;
	}

	public static Prodotto getAntinciampo(String codice) throws SQLException, ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.GET_ANTINCIAMPO);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codice));
			try (ResultSet temp = pstmt.executeQuery()) {

				rs = temp;
				while (rs.next()) {
					p.setTipologiaProdotto("antinciampo");
					p.setTipologiaAntinciampo(rs.getString(2));
					p.setTipoLama(rs.getString(3));
					p.setCostoM(rs.getString(4));
				}
			} catch (SQLException ex) {
				Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return p;
	}

	public static Prodotto getMaterialeTelaio(String codice) throws SQLException, ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.GET_MATERIALETELAIO);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codice));
			try (ResultSet temp = pstmt.executeQuery()) {

				rs = temp;
				while (rs.next()) {
					p.setTipologiaProdotto("materialetelaio");
					p.setTipologiaTelaio(rs.getString(2));
					p.setTipoFresa(rs.getString(3));
					p.setCostoM2(rs.getString(4));
				}
			} catch (SQLException ex) {
				Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return p;
	}

	public static Prodotto getNeon(String codice) throws SQLException, ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.GET_NEON);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codice));
			try (ResultSet temp = pstmt.executeQuery()) {

				rs = temp;
				while (rs.next()) {
					p.setTipologiaProdotto("neon");
					p.setCostoM(rs.getString(2));
				}
			} catch (SQLException ex) {
				Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return p;
	}

	public static Prodotto getLed(String codice) throws SQLException, ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.GET_LED);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codice));
			try (ResultSet temp = pstmt.executeQuery()) {

				rs = temp;
				while (rs.next()) {
					p.setTipologiaProdotto("led");
					p.setCostoUnitario(rs.getString(2));
				}
			} catch (SQLException ex) {
				Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return p;
	}

	public static Cliente getPrivato(String codice) throws SQLException, ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.GET_PRIVATO);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codice));
			try (ResultSet temp = pstmt.executeQuery()) {

				rs = temp;
				while (rs.next()) {
					c.setTipologiaCliente("privato");
					c.setCodiceFiscale(rs.getString(1));
					c.setNome(rs.getString(3));
					c.setCognome(rs.getString(4));
				}
			} catch (SQLException ex) {
				Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return c;
	}

	public static Cliente getPartitaIva(String codice) throws SQLException, ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.GET_PARTITAIVA);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codice));
			try (ResultSet temp = pstmt.executeQuery()) {

				rs = temp;
				while (rs.next()) {
					c.setTipologiaCliente("partitaiva");
					c.setPartitaIva(rs.getString(1));
					c.setNomeAzienda(rs.getString(3));
				}
			} catch (SQLException ex) {
				Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return c;
	}

	public static String login(String codice, String password) throws SQLException, ClassNotFoundException {
		ruolo = "errore";
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.LOGIN);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codice));
			try (ResultSet temp = pstmt.executeQuery()) {

				rs = temp;
				while (rs.next()) {
					if (password.equals(rs.getString(8))) {
						ruolo = rs.getString(7);
					}
				}
			} catch (SQLException ex) {
				Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		return ruolo;
	}

	public static Prodotto getTopOrdinato(String codiceTappeto) throws NumberFormatException, SQLException, ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.GET_TOPORDINATO);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codiceTappeto));
			try (ResultSet temp = pstmt.executeQuery()) {

				rs = temp;
				while (rs.next()) {
					p.setCodiceProdotto(rs.getString(3));
				}
			} catch (SQLException ex) {
				Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return p;
	}
	
	public static Prodotto getBaseOrdinata(String codiceTappeto) throws NumberFormatException, SQLException, ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.GET_BASEORDINATA);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codiceTappeto));
			try (ResultSet temp = pstmt.executeQuery()) {

				rs = temp;
				while (rs.next()) {
					p.setCodiceProdotto(rs.getString(3));
					
				}
			} catch (SQLException ex) {
				Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return p;
	}
	
	public static Prodotto getAntinciampoOrdinato(String codiceTappeto) throws NumberFormatException, SQLException, ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.GET_ANTINCIAMPOORDINATO);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codiceTappeto));
			try (ResultSet temp = pstmt.executeQuery()) {

				rs = temp;
				while (rs.next()) {
					p.setCodiceProdotto(rs.getString(3));
					
				}
			} catch (SQLException ex) {
				Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return p;
	}
	
	public static Prodotto getTelaioOrdinato(String codiceInsegna) throws NumberFormatException, SQLException, ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.GET_TELAIOORDINATO);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codiceInsegna));
			try (ResultSet temp = pstmt.executeQuery()) {

				rs = temp;
				while (rs.next()) {
					p.setCodiceProdotto(rs.getString(3));
					
				}
			} catch (SQLException ex) {
				Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return p;
	}
	
	public static Prodotto getNeonOrdinato(String codiceInsegna) throws NumberFormatException, SQLException, ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.GET_NEONORDINATO);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codiceInsegna));
			try (ResultSet temp = pstmt.executeQuery()) {

				rs = temp;
				while (rs.next()) {
					p.setCodiceProdotto(rs.getString(3));
					
				}
			} catch (SQLException ex) {
				Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return p;
	}
	
	public static Prodotto getLedOrdinato(String codiceInsegna) throws NumberFormatException, SQLException, ClassNotFoundException {
		try (Connection conn = DriverManager.getConnection(q.URL, q.USER, q.PASSWORD);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(q.GET_LEDORDINATO);

		) {
			Class.forName(q.DRIVER);
			pstmt.setInt(1, Integer.valueOf(codiceInsegna));
			try (ResultSet temp = pstmt.executeQuery()) {

				rs = temp;
				while (rs.next()) {
					p.setCodiceProdotto(rs.getString(3));
					
				}
			} catch (SQLException ex) {
				Logger.getLogger(Mysql.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		return p;
	}

}
