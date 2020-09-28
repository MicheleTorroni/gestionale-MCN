package database;

public class Query {
	public final String URL = "jdbc:mysql://localhost:3306/azienda_tappeti_e_insegne";
	public final String USER = "root";
	public final String PASSWORD = "";
	public final String DRIVER = "com.mysql.cj.jdbc.Driver";

	// ______________________________________________GET
	public final String LOGIN = "SELECT * from lavoratore WHERE codice_lavoratore = ?";

	// MAIN TABELLE
	public final String GET_PRODOTTI = "SELECT * from prodotto";
	public final String GET_LAVORATORI = "SELECT * from lavoratore";
	public final String GET_ORDINI = "SELECT * from ordine";
	public final String GET_CLIENTI = "SELECT * from cliente";
	public final String GET_TAPPETI = "SELECT * from tappetoordinato";
	public final String GET_INSEGNE = "SELECT * from insegnaordinata";

	// GERARCHIA PRODOTTI
	public final String GET_MATERIALETOP = "SELECT * from materialetop WHERE codice_prodotto = ?";
	public final String GET_BASE = "SELECT * from base WHERE codice_prodotto = ?";
	public final String GET_ANTINCIAMPO = "SELECT * from antinciampo WHERE codice_prodotto = ?";
	public final String GET_MATERIALETELAIO = "SELECT * from materialetelaio WHERE codice_prodotto = ?";
	public final String GET_NEON = "SELECT * from neon WHERE codice_prodotto = ?";
	public final String GET_LED = "SELECT * from led WHERE codice_prodotto = ?";
	
	// GERARCHIA PRODOTTI LAVORATI
	public final String GET_TOPORDINATO = "SELECT * from topOrdinato WHERE codice_tappeto = ?";
	public final String GET_BASEORDINATA = "SELECT * from baseordinata WHERE codice_tappeto = ?";
	public final String GET_ANTINCIAMPOORDINATO = "SELECT * from antinciampoordinato WHERE codice_tappeto = ?";
	public final String GET_TELAIOORDINATO = "SELECT * from telaioordinato WHERE codice_insegna = ?";
	public final String GET_NEONORDINATO = "SELECT * from neonordinato WHERE codice_insegna = ?";
	public final String GET_LEDORDINATO = "SELECT * from ledordinato WHERE codice_insegna = ?";

	// GERARCHIA CLIENTI
	public final String GET_PRIVATO = "SELECT * from privato WHERE codice_cliente = ?";
	public final String GET_PARTITAIVA = "SELECT * from partitaiva WHERE codice_cliente = ?";

	// ______________________________________________NEW

	// MAIN TABELLE
	public final String NEW_PRODOTTO = "INSERT INTO prodotto "
			+ "(codice_prodotto, descrizione, tipologia_prodotto, codice_lavoratore) values (?, ?, ?, ?)";
	public final String NEW_LAVORATORE = "INSERT INTO lavoratore "
			+ "(codice_lavoratore, codice_fiscale, stipendio, nome, cognome, data_nascita, tipologia_lavoratore, password) values (?, ?, ?, ?, ?, ?, ?, ?)";
	public final String NEW_ORDINE = "INSERT INTO ordine "
			+ "(codice_ordine, data, importo_ordine, codice_cliente, codice_lavoratore) values (?, ?, ?, ?, ?)";
	public final String NEW_CLIENTE = "INSERT INTO cliente "
			+ "(codice_cliente, numero_ordini, numero_telefono, email, codice_lavoratore, tipologia_cliente) values (?, ?, ?, ?, ?, ?)";
	public final String NEW_TAPPETO = "INSERT INTO tappetoordinato "
			+ "(codice_tappeto, stato, quantita, altezza, larghezza, data_completamento_tappeto, prezzo, codice_ordine, codice_lavoratore) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public final String NEW_INSEGNA = "INSERT INTO insegnaordinata "
			+ "(codice_insegna, stato, quantita, altezza, larghezza, data_completamento_insegna, lunghezza_neon, numero_led, prezzo, codice_ordine, codice_lavoratore) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	// GERARCHIA PRODOTTI
	public final String NEW_MATERIALETOP = "INSERT INTO materialetop "
			+ "(codice_prodotto, tipologia_top, colore, tipo_lama, costo_m2) values (?,?,?,?,?)";
	public final String NEW_BASE = "INSERT INTO base "
			+ "(codice_prodotto, tipologia_base, tipo_lama, costo_m2) values (?,?,?,?)";
	public final String NEW_ANTINCIAMPO = "INSERT INTO antinciampo "
			+ "(codice_prodotto, tipologia_antinciampo, tipo_lama, costo_m) values (?,?,?,?)";
	public final String NEW_MATERIALETELAIO = "INSERT INTO materialetelaio "
			+ "(codice_prodotto, tipologia_telaio, tipo_fresa, costo_m2) values (?,?,?,?)";
	public final String NEW_NEON = "INSERT INTO neon " + "(codice_prodotto, costo_m) values (?,?)";
	public final String NEW_LED = "INSERT INTO led " + "(codice_prodotto, costo_unitario) values (?,?)";

	// GERARCHIA LAVORATORI
	public final String NEW_AMMINISTRATORE = "INSERT INTO amministratore " + "(codice_lavoratore) values (?)";
	public final String NEW_VENDITORE = "INSERT INTO venditore " + "(codice_lavoratore, numero_vendite) values (?, ?)";
	public final String NEW_ARTIGIANO = "INSERT INTO artigiano " + "(codice_lavoratore, numero_prodotti) values (?, ?)";

	// GERARCHIA CLIENTI
	public final String NEW_PRIVATO = "INSERT INTO privato "
			+ "(codice_fiscale, codice_cliente, nome, cognome) values (?, ?, ?, ?)";
	public final String NEW_PARTITAIVA = "INSERT INTO partitaiva "
			+ "(partita_iva, codice_cliente, nome_societa) values (?, ?, ?)";

	// ______________________________________________DELETE
	public final String DEL_PRODOTTO = "DELETE FROM prodotto WHERE codice_prodotto = ?";
	public final String DEL_LAVORATORE = "DELETE FROM lavoratore WHERE codice_lavoratore = ?";
	public final String DEL_CLIENTE = "DELETE FROM cliente WHERE codice_cliente = ?";

	// GERARCHIA PRODOTTI
	public final String DEL_MATERIALETOP = "DELETE FROM materialetop WHERE codice_prodotto = ?";
	public final String DEL_BASE = "DELETE FROM base WHERE codice_prodotto = ?";
	public final String DEL_ANTINCIAMPO = "DELETE FROM antinciampo WHERE codice_prodotto = ?";
	public final String DEL_MATERIALETELAIO = "DELETE FROM materialetelaio WHERE codice_prodotto = ?";
	public final String DEL_NEON = "DELETE FROM neon WHERE codice_prodotto = ?";
	public final String DEL_LED = "DELETE FROM led WHERE codice_prodotto = ?";

	// GERARCHIA CLIENTI
	public final String DEL_PRIVATO = "DELETE FROM privato WHERE codice_cliente = ?";
	public final String DEL_PARTITAIVA = "DELETE FROM partitaiva WHERE codice_cliente = ?";

	// GERARCHIA LAVORATORI
	public final String DEL_AMMINISTRATORE = "DELETE FROM amministratore WHERE codice_lavoratore = ?";
	public final String DEL_VENDITORE = "DELETE FROM venditore WHERE codice_lavoratore = ?";
	public final String DEL_ARTIGIANO = "DELETE FROM artigiano WHERE codice_lavoratore = ?";

	// ______________________________________________MAX_INDEX
	// MAIN TABELLE
	public final String MAX_PRODOTTI = "SELECT max(codice_prodotto) from prodotto";
	public final String MAX_LAVORATORI = "SELECT max(codice_lavoratore) from lavoratore";
	public final String MAX_ORDINI = "SELECT max(codice_ordine) from ordine";
	public final String MAX_CLIENTI = "SELECT max(codice_cliente) from cliente";
	public final String MAX_TAPPETI = "SELECT max(codice_tappeto) from tappetoordinato";
	public final String MAX_INSEGNE = "SELECT max(codice_insegna) from insegnaordinata";

	// ______________________________________________MAX_INDEX
	// MAIN TABELLE
	public final String UPDATE_LAVORATORE = "UPDATE lavoratore SET" + " stipendio = ?, password = ?"
			+ " WHERE codice_lavoratore = ?";
	public final String UPDATE_CLIENTE = "UPDATE cliente SET" + " numero_telefono = ?, email = ?"
			+ " WHERE codice_cliente = ?";
	public final String UPDATE_TAPPETO = "UPDATE tappetoordinato SET" + " stato = ?, data_completamento_tappeto = ?"
			+ " WHERE codice_tappeto = ?";
	public final String UPDATE_INSEGNA = "UPDATE insegnaordinata SET" + " stato = ?, data_completamento_insegna = ?"
			+ " WHERE codice_insegna = ?";

	// ______________________________________________NEW ORDINATO

	public final String NEW_MATERIALETOPORDINATO = "INSERT INTO topordinato "
			+ "(codice_tappeto, prezzo, codice_prodotto) values (?, ?, ?)";
	public final String NEW_BASEORDINATA = "INSERT INTO baseordinata "
			+ "(codice_tappeto, prezzo, codice_prodotto) values (?, ?, ?)";
	public final String NEW_ANTINCIAMPOORDINATO = "INSERT INTO antinciampoordinato "
			+ "(codice_tappeto, prezzo, codice_prodotto) values (?, ?, ?)";
	public final String NEW_MATERIALETELAIOORDINATO = "INSERT INTO telaioordinato "
			+ "(codice_insegna, prezzo, codice_prodotto) values (?, ?, ?)";
	public final String NEW_NEONORDINATO = "INSERT INTO neonordinato "
			+ "(codice_insegna, prezzo, codice_prodotto) values (?, ?, ?)";
	public final String NEW_LEDORDINATO = "INSERT INTO ledordinato "
			+ "(codice_insegna, prezzo, codice_prodotto) values (?, ?, ?)";
	
	// ______________________________________________INCREASE INDICI
	
	public final String INCREASE_VENDITORE= "UPDATE venditore SET "+
			"numero_vendite = numero_vendite+1 WHERE codice_lavoratore = ? ";
	
	public final String INCREASE_ARTIGIANO= "UPDATE artigiano SET "+
			"numero_prodotti = numero_prodotti+1 WHERE codice_lavoratore = ?";
	
	public final String INCREASE_CLIENTE= "UPDATE cliente SET "+
			"numero_ordini = numero_ordini+1 WHERE codice_cliente = ?";
}
