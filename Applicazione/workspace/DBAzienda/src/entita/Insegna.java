package entita;

import javax.swing.JButton;

public class Insegna {
	String codiceInsegna;
	String stato;
	String quantita;
	String altezza;
	String larghezza;
	String dataCompletamento;
	String lunghezzaNeon;
	String numeroLed;
	String prezzo;
	String codiceOrdine;
	String codiceLavoratore;

	JButton bottone = new JButton();

	public Insegna(String codiceInsegna, String stato, String quantita, String altezza, String larghezza,
			String dataCompletamento, String lunghezzaNeon, String numeroLed, String prezzo, String codiceOrdine,
			String codiceLavoratore) {
		super();
		this.codiceInsegna = codiceInsegna;
		this.stato = stato;
		this.quantita = quantita;
		this.altezza = altezza;
		this.larghezza = larghezza;
		this.dataCompletamento = dataCompletamento;
		this.lunghezzaNeon = lunghezzaNeon;
		this.numeroLed = numeroLed;
		this.prezzo = prezzo;
		this.codiceOrdine = codiceOrdine;
		this.codiceLavoratore = codiceLavoratore;
	}

	public JButton getBottone() {
		String contenutoBottone = stato + " | " + "DATA COMPLETAMENTO: " + dataCompletamento + " | " + "N:" + quantita
				+ " | " + "ALTEZZA: " + altezza + "cm | " + "LARGHEZZA: " + larghezza + "cm | " + "NEON:"
				+ lunghezzaNeon + "cm | " + "LED:" + numeroLed + "cm | " + prezzo + "€ | ";
		bottone.setText(contenutoBottone);
		return this.bottone;
	}

	public String getCodiceInsegna() {
		return codiceInsegna;
	}

	public void setCodiceInsegna(String codiceInsegna) {
		this.codiceInsegna = codiceInsegna;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getQuantita() {
		return quantita;
	}

	public void setQuantita(String quantita) {
		this.quantita = quantita;
	}

	public String getAltezza() {
		return altezza;
	}

	public void setAltezza(String altezza) {
		this.altezza = altezza;
	}

	public String getLarghezza() {
		return larghezza;
	}

	public void setLarghezza(String larghezza) {
		this.larghezza = larghezza;
	}

	public String getDataCompletamento() {
		return dataCompletamento;
	}

	public void setDataCompletamento(String dataCompletamento) {
		this.dataCompletamento = dataCompletamento;
	}

	public String getLunghezzaNeon() {
		return lunghezzaNeon;
	}

	public void setLunghezzaNeon(String lunghezzaNeon) {
		this.lunghezzaNeon = lunghezzaNeon;
	}

	public String getNumeroLed() {
		return numeroLed;
	}

	public void setNumeroLed(String numeroLed) {
		this.numeroLed = numeroLed;
	}

	public String getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(String prezzo) {
		this.prezzo = prezzo;
	}

	public String getCodiceOrdine() {
		return codiceOrdine;
	}

	public void setCodiceOrdine(String codiceOrdine) {
		this.codiceOrdine = codiceOrdine;
	}

	public String getCodiceLavoratore() {
		return codiceLavoratore;
	}

	public void setCodiceLavoratore(String codiceLavoratore) {
		this.codiceLavoratore = codiceLavoratore;
	}

}
