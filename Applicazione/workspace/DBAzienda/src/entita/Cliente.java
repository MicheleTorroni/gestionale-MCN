package entita;

import javax.swing.JButton;

public class Cliente {

	String codiceCliente;
	String numeroOrdini;
	String numeroTelefono;
	String email;
	String codiceLavoratore;
	String tipologiaCliente;
	// ----------------------PRIVATO
	String nome;
	String cognome;
	String codiceFiscale;
	// ----------------------PARTITAIVA
	String partitaIva;
	String nomeAzienda;

	JButton bottone = new JButton();

	public Cliente(String codiceCliente, String numeroOrdini, String numeroTelefono, String email,
			String codiceLavoratore, String tipologiaCliente, String nome, String cognome, String codiceFiscale,
			String partitaIva, String nomeAzienda) {
		super();
		this.codiceCliente = codiceCliente;
		this.numeroOrdini = numeroOrdini;
		this.numeroTelefono = numeroTelefono;
		this.email = email;
		this.codiceLavoratore = codiceLavoratore;
		this.tipologiaCliente = tipologiaCliente;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.partitaIva = partitaIva;
		this.nomeAzienda = nomeAzienda;
	}

	public JButton getBottone() {
		String contenutoBottone = email + " | " + numeroTelefono + " | N.ORDINI:" + numeroOrdini + " | ";
		switch (tipologiaCliente) {

		case "privato":
			contenutoBottone = contenutoBottone + "NOME: " + nome + " | COGNOME:" + cognome + " | CF:" + codiceFiscale;
			break;
		case "partitaiva":
			contenutoBottone = contenutoBottone + "PIVA:" + partitaIva + " | NOME SOCIET�" + nomeAzienda;
			break;
		}
		bottone.setText(contenutoBottone);
		return this.bottone;
	}

	public String getCodiceCliente() {
		return codiceCliente;
	}

	public void setCodiceCliente(String codiceCliente) {
		this.codiceCliente = codiceCliente;
	}

	public String getNumeroOrdini() {
		return numeroOrdini;
	}

	public void setNumeroOrdini(String numeroOrdini) {
		this.numeroOrdini = numeroOrdini;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodiceLavoratore() {
		return codiceLavoratore;
	}

	public void setCodiceLavoratore(String codiceLavoratore) {
		this.codiceLavoratore = codiceLavoratore;
	}

	public String getTipologiaCliente() {
		return tipologiaCliente;
	}

	public void setTipologiaCliente(String tipologiaCliente) {
		this.tipologiaCliente = tipologiaCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public String getNomeAzienda() {
		return nomeAzienda;
	}

	public void setNomeAzienda(String nomeAzienda) {
		this.nomeAzienda = nomeAzienda;
	}

}
