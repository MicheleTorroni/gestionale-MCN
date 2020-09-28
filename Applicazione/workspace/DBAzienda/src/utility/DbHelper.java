package utility;

import java.sql.SQLException;
import java.util.ArrayList;

import database.Mysql;
import entita.Cliente;
import entita.Insegna;
import entita.Lavoratore;
import entita.Ordine;
import entita.Prodotto;
import entita.Tappeto;

//DA CAMBIARE: TUTTI I RIEMPIMENTI
public class DbHelper {

	public static String login(String codiceLavoratore, String password) throws ClassNotFoundException, SQLException {
		return Mysql.login(codiceLavoratore, password);
	}

	public static ArrayList<Prodotto> getProdotti() throws ClassNotFoundException, SQLException {
		ArrayList<Prodotto> al = Mysql.getProdotti();
		for (Prodotto p : al) {
			String tipo = p.getTipologiaProdotto();
			String codice = p.getCodiceProdotto();
			switch (tipo) {
			case "materialetop":
				Prodotto tmp = Mysql.getMaterialeTop(codice);
				p.setTipologiaTop(tmp.getTipologiaTop());
				p.setColore(tmp.getColore());
				p.setTipoLama(tmp.getTipoLama());
				p.setCostoM2(tmp.getCostoM2());
				break;
			case "base":
				Prodotto tmp1 = Mysql.getBase(codice);
				p.setTipologiaBase(tmp1.getTipologiaBase());
				p.setTipoLama(tmp1.getTipoLama());
				p.setCostoM2(tmp1.getCostoM2());
				break;
			case "antinciampo":
				Prodotto tmp2 = Mysql.getAntinciampo(codice);
				p.setTipologiaAntinciampo(tmp2.getTipologiaAntinciampo());
				p.setTipoLama(tmp2.getTipoLama());
				p.setCostoM(tmp2.getCostoM());
				break;
			case "materialetelaio":
				Prodotto tmp3 = Mysql.getMaterialeTelaio(codice);
				p.setTipologiaTelaio(tmp3.getTipologiaTelaio());
				p.setTipoFresa(tmp3.getTipoFresa());
				p.setCostoM2(tmp3.getCostoM2());
				break;
			case "neon":
				Prodotto tmp4 = Mysql.getNeon(codice);
				p.setCostoM(tmp4.getCostoM());
				break;
			case "led":
				Prodotto tmp5 = Mysql.getLed(codice);
				p.setCostoUnitario(tmp5.getCostoUnitario());
				break;
			}
		}

		return al;
	}

	public static ArrayList<Lavoratore> getLavoratori() throws ClassNotFoundException, SQLException {
		return Mysql.getLavoratori();
	}

	public static ArrayList<Ordine> getOrdini() throws ClassNotFoundException, SQLException {
		return Mysql.getOrdini();
	}

	public static ArrayList<Cliente> getClienti() throws ClassNotFoundException, SQLException {
		ArrayList<Cliente> al = Mysql.getClienti();
		for (Cliente c : al) {
			String tipo = c.getTipologiaCliente();
			String codice = c.getCodiceCliente();
			switch (tipo) {
			case "privato":
				Cliente tmp = Mysql.getPrivato(codice);
				c.setNome(tmp.getNome());
				c.setCognome(tmp.getCognome());
				c.setCodiceFiscale(tmp.getCodiceFiscale());
				break;
			case "partitaiva":
				Cliente tmp1 = Mysql.getPartitaIva(codice);
				c.setPartitaIva(tmp1.getPartitaIva());
				c.setNomeAzienda(tmp1.getNomeAzienda());
				break;
			}
		}
		return al;
	}

	public static ArrayList<Tappeto> getTappeti() throws ClassNotFoundException, SQLException {
		return Mysql.getTappeti();
	}

	public static ArrayList<Insegna> getInsegne() throws ClassNotFoundException, SQLException {
		return Mysql.getInsegne();
	}

	public static Prodotto getTopOrdinato(String codiceTappeto) throws ClassNotFoundException, SQLException{
		Prodotto topOrdinato  = Mysql.getTopOrdinato(codiceTappeto);
		return Mysql.getMaterialeTop(topOrdinato.getCodiceProdotto());
	}
	
	public static Prodotto getBaseOrdinata(String codiceTappeto) throws ClassNotFoundException, SQLException{
		Prodotto baseOrdinata = Mysql.getBaseOrdinata(codiceTappeto);
		return Mysql.getBase(baseOrdinata.getCodiceProdotto());
	}
	
	public static Prodotto getAntinciampoOrdinato(String codiceTappeto) throws ClassNotFoundException, SQLException{
		Prodotto antinciampoOrdinato = Mysql.getAntinciampoOrdinato(codiceTappeto);
		return Mysql.getAntinciampo(antinciampoOrdinato.getCodiceProdotto());
	}
	
	public static Prodotto getTelaioOrdinato(String codiceInsegna) throws ClassNotFoundException, SQLException{
		Prodotto telaioOrdinato = Mysql.getTelaioOrdinato(codiceInsegna);
		return Mysql.getMaterialeTelaio(telaioOrdinato.getCodiceProdotto());
	}
	
	public static Prodotto getNeonOrdinato(String codiceInsegna) throws ClassNotFoundException, SQLException{
		Prodotto neonOrdinato = Mysql.getNeonOrdinato(codiceInsegna);
		return Mysql.getNeon(neonOrdinato.getCodiceProdotto());
	}
	
	public static Prodotto getLedOrdinato(String codiceInsegna) throws ClassNotFoundException, SQLException{
		Prodotto ledOrdinato = Mysql.getLedOrdinato(codiceInsegna);
		return Mysql.getLed(ledOrdinato.getCodiceProdotto());
	}
	
	// ______________________________________________NEW

	public static void aggiungiProdotto(Prodotto p) throws ClassNotFoundException, SQLException {
		Mysql.aggiungiProdotto(p);
	}

	public static void aggiungiMaterialeTop(Prodotto p) throws ClassNotFoundException, SQLException {
		Mysql.aggiungiMaterialeTop(p);
	}

	public static void aggiungiBase(Prodotto p) throws ClassNotFoundException, SQLException {
		Mysql.aggiungiBase(p);
	}

	public static void aggiungiAntinciampo(Prodotto p) throws ClassNotFoundException, SQLException {
		Mysql.aggiungiAntinciampo(p);
	}

	public static void aggiungiMaterialeTelaio(Prodotto p) throws ClassNotFoundException, SQLException {
		Mysql.aggiungiMaterialeTelaio(p);
	}

	public static void aggiungiNeon(Prodotto p) throws ClassNotFoundException, SQLException {
		Mysql.aggiungiNeon(p);
	}

	public static void aggiungiLed(Prodotto p) throws ClassNotFoundException, SQLException {
		Mysql.aggiungiLed(p);
	}

	public static void aggiungiLavoratore(Lavoratore l) throws ClassNotFoundException, SQLException {
		Mysql.aggiungiLavoratore(l);
	}

	public static void aggiungiAmministratore(Lavoratore l) throws ClassNotFoundException, SQLException {
		Mysql.aggiungiAmministratore(l);
	}

	public static void aggiungiVenditore(Lavoratore l) throws ClassNotFoundException, SQLException {
		Mysql.aggiungiVenditore(l);
	}

	public static void aggiungiArtigiano(Lavoratore l) throws ClassNotFoundException, SQLException {
		Mysql.aggiungiArtigiano(l);
	}

	public static void aggiungiOrdine(Ordine o) throws ClassNotFoundException, SQLException {
		Mysql.aggiungiOrdine(o);
	}

	public static void aggiungiCliente(Cliente c) throws ClassNotFoundException, SQLException {
		Mysql.aggiungiCliente(c);
	}

	public static void aggiungiPrivato(Cliente c) throws ClassNotFoundException, SQLException {
		Mysql.aggiungiPrivato(c);
	}

	public static void aggiungiPartitaIva(Cliente c) throws ClassNotFoundException, SQLException {
		Mysql.aggiungiPartitaIva(c);
	}

	public static void aggiungiTappeto(Tappeto t) throws ClassNotFoundException, SQLException {
		Mysql.aggiungiTappeto(t);
	}

	public static void aggiungiInsegna(Insegna i) throws ClassNotFoundException, SQLException {
		Mysql.aggiungiInsegna(i);
	}

	// ______________________________________________UPDATE

	public static void aggiornaLavoratore(Lavoratore l) {
		Mysql.aggiornaLavoratore(l);
	}

	public static void aggiornaCliente(Cliente c) {
		Mysql.aggiornaCliente(c);
	}

	public static void aggiornaInsegna(Insegna i, Boolean stato) {
		Mysql.aggiornaInsegna(i, stato);
	}

	public static void aggiornaTappeto(Tappeto t, Boolean stato) {
		Mysql.aggiornaTappeto(t, stato);
	}

	// DA NON CAMBIARE
	public static ArrayList<String> getTipologieProdotti() {
		ArrayList<String> listaTipologieProdotti = new ArrayList<>();
		listaTipologieProdotti.add("materialetop");
		listaTipologieProdotti.add("base");
		listaTipologieProdotti.add("antinciampo");
		listaTipologieProdotti.add("neon");
		listaTipologieProdotti.add("led");
		listaTipologieProdotti.add("materialetelaio");
		return listaTipologieProdotti;
	}

	// DA NON CAMBIARE
	public static ArrayList<String> getTipologieDipendenti() {
		ArrayList<String> listaTipologieDipendenti = new ArrayList<>();
		listaTipologieDipendenti.add("amministore");
		listaTipologieDipendenti.add("venditore");
		listaTipologieDipendenti.add("artigiano");
		return listaTipologieDipendenti;
	}

	// ______________________________________________MAX_INDEX

	public static String maxProdotti() throws ClassNotFoundException, SQLException {
		String risultato = Mysql.maxProdotti();
		if (risultato == null) {
			risultato = "1";
		} else {
			risultato = Integer.toString(Integer.parseInt(risultato) + 1);
		}
		return risultato;
	}

	public static String maxLavoratori() throws ClassNotFoundException, SQLException {
		String risultato = Mysql.maxLavoratori();
		if (risultato == null) {
			risultato = "1";
		} else {
			risultato = Integer.toString(Integer.parseInt(risultato) + 1);
		}
		return risultato;
	}

	public static String maxOrdini() throws ClassNotFoundException, SQLException {
		String risultato = Mysql.maxOrdini();
		if (risultato == null) {
			risultato = "1";
		} else {
			risultato = Integer.toString(Integer.parseInt(risultato) + 1);
		}
		return risultato;
	}

	public static String maxClienti() throws ClassNotFoundException, SQLException {
		String risultato = Mysql.maxClienti();
		if (risultato == null) {
			risultato = "1";
		} else {
			risultato = Integer.toString(Integer.parseInt(risultato) + 1);
		}
		return risultato;
	}

	public static String maxTappeti() throws ClassNotFoundException, SQLException {
		String risultato = Mysql.maxTappeti();
		if (risultato == null) {
			risultato = "1";
		} else {
			risultato = Integer.toString(Integer.parseInt(risultato) + 1);
		}
		return risultato;
	}

	public static String maxInsegne() throws ClassNotFoundException, SQLException {
		String risultato = Mysql.maxInsegne();
		if (risultato == null) {
			risultato = "1";
		} else {
			risultato = Integer.toString(Integer.parseInt(risultato) + 1);
		}
		return risultato;
	}

	// ______________________________________________DELETE

	public static void eliminaProdotto(String codice) throws ClassNotFoundException {
		Mysql.eliminaProdotto(codice);
	}

	public static void eliminaMaterialeTop(String codice) throws ClassNotFoundException {
		Mysql.eliminaMaterialeTop(codice);
	}

	public static void eliminaBase(String codice) throws ClassNotFoundException {
		Mysql.eliminaBase(codice);
	}

	public static void eliminaAntinciampo(String codice) throws ClassNotFoundException {
		Mysql.eliminaAntinciampo(codice);
	}

	public static void eliminaMaterialeTelaio(String codice) throws ClassNotFoundException {
		Mysql.eliminaMaterialeTelaio(codice);
	}

	public static void eliminaNeon(String codice) throws ClassNotFoundException {
		Mysql.eliminaNeon(codice);
	}

	public static void eliminaLed(String codice) throws ClassNotFoundException {
		Mysql.eliminaLed(codice);
	}

	public static void eliminaLavoratore(String codice) throws ClassNotFoundException {
		Mysql.eliminaLavoratore(codice);
	}

	public static void eliminaAmministratore(String codice) throws ClassNotFoundException {
		Mysql.eliminaLavoratore(codice);
	}

	public static void eliminaVenditore(String codice) throws ClassNotFoundException {
		Mysql.eliminaLavoratore(codice);
	}

	public static void eliminaArtigiano(String codice) throws ClassNotFoundException {
		Mysql.eliminaLavoratore(codice);
	}

	public static void eliminaCliente(String codice) throws ClassNotFoundException {
		Mysql.eliminaCliente(codice);
	}

	public static void eliminaPrivato(String codice) throws ClassNotFoundException {
		Mysql.eliminaPrivato(codice);
	}

	public static void eliminaPartitaIva(String codice) throws ClassNotFoundException {
		Mysql.eliminaPartitaIva(codice);
	}

	public static void aggiungiProdottoOrdinato(Prodotto p) {
		switch (p.getTipologiaProdotto()) {

		case "materialetop":
			Mysql.aggiungiMaterialeTopOrdinato(p);
			break;
		case "base":
			Mysql.aggiungiBaseOrdinata(p);
			break;
		case "antinciampo":
			Mysql.aggiungiAntinciampoOrdinato(p);
			break;
		case "materialetelaio":
			Mysql.aggiungiMaterialeTelaioOrdinato(p);
			break;
		case "neon":
			Mysql.aggiungiNeonOrdinato(p);
			break;
		case "led":
			Mysql.aggiungiLedOrdinato(p);
			break;

		}

	}

	// ______________________________________________INCREASE INDICI
	
	public static void aggiornaIndiceVenditore(String codice) throws ClassNotFoundException{
		Mysql.aggiornaIndiceVenditore(codice);
	}
	
	public static void aggiornaIndiceArtigiano(String codice) throws ClassNotFoundException{
		Mysql.aggiornaIndiceArtigiano(codice);
	}
	
	public static void aggiornaIndiceCliente(String codice) throws ClassNotFoundException{
		Mysql.aggiornaIndiceCliente(codice);
	}
}
