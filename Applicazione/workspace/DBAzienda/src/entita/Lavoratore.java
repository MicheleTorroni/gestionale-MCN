package entita;

import javax.swing.JButton;

public class Lavoratore{
	
	String codiceLavoratore;
	String codiceFiscale;
	String stipendio;
	String nome;
	String cognome;
	String dataNascita;
	String tipologiaLavoratore;
	String password;
	//----------------------VENDITORE
	String numeroVendite;
	//----------------------ARTIGIANO
	String numeroProdotti;
	
	JButton bottone = new JButton();
	
	public Lavoratore(String codiceLavoratore, String codiceFiscale, String stipendio, String nome, String cognome,
			String dataNascita, String tipologiaLavoratore, String password, String numeroVendite,
			String numeroProdotti) {
		super();
		this.codiceLavoratore = codiceLavoratore;
		this.codiceFiscale = codiceFiscale;
		this.stipendio = stipendio;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.tipologiaLavoratore = tipologiaLavoratore;
		this.password = password;
		this.numeroVendite = numeroVendite;
		this.numeroProdotti = numeroProdotti;
		
	}
	
	public JButton getBottone() {
		String contenutoBottone = 
				"CODICE:" +codiceLavoratore + "  |  " +
				"CF:" +codiceFiscale + " | " +
				stipendio + "� | " +
				nome + " | " +
				cognome + " | " +
				dataNascita + " | " +
				tipologiaLavoratore + " | " +
				"PSW:" +password;
		switch(tipologiaLavoratore) {
			
		case "venditore":
			contenutoBottone=contenutoBottone+"n.vendite: "+
					numeroVendite;
		break;
		case "partitaiva":
			contenutoBottone=contenutoBottone+"n.prodotti: "+
					numeroProdotti;
		break;
		} 
		bottone.setText(contenutoBottone);
		return this.bottone;
	}
	
	public String getTipologiaLavoratore() {
		return tipologiaLavoratore;
	}

	public void setTipologiaLavoratore(String tipologiaLavoratore) {
		this.tipologiaLavoratore = tipologiaLavoratore;
	}

	public String getCodiceLavoratore() {
		return codiceLavoratore;
	}		
	public void setCodiceLavoratore(String codiceLavoratore) {
		this.codiceLavoratore = codiceLavoratore;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getStipendio() {
		return stipendio;
	}
	public void setStipendio(String stipendio) {
		this.stipendio = stipendio;
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
	public String getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNumeroVendite() {
		return numeroVendite;
	}
	public void setNumeroVendite(String numeroVendite) {
		this.numeroVendite = numeroVendite;
	}
	public String getNumeroProdotti() {
		return numeroProdotti;
	}
	public void setNumeroProdotti(String numeroProdotti) {
		this.numeroProdotti = numeroProdotti;
	}

}
