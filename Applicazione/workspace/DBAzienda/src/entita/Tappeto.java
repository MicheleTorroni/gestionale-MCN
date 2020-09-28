package entita;

import javax.swing.JButton;

public class Tappeto {
	String codiceTappeto;
	String stato;
	String quantita;
	String altezza;
	String larghezza;
	String dataCompletamento;
	String prezzo;
	String codiceOrdine;
	String codiceLavoratore;

	JButton bottone = new JButton();

	public Tappeto(String codiceTappeto, String stato, String quantita, String altezza, String larghezza,
			String dataCompletamento, String prezzo, String codiceOrdine, String codiceLavoratore) {
		super();
		this.codiceTappeto = codiceTappeto;
		this.stato = stato;
		this.quantita = quantita;
		this.altezza = altezza;
		this.larghezza = larghezza;
		this.dataCompletamento = dataCompletamento;
		this.prezzo = prezzo;
		this.codiceOrdine = codiceOrdine;
		this.codiceLavoratore = codiceLavoratore;

	}

	public JButton getBottone() {
		String contenutoBottone = stato + " | " + "DATA COMPLETAMENTO: " + dataCompletamento + " | " + "N:" + quantita
				+ " | " + "ALTEZZA: " + altezza + "cm | " + "LARGHEZZA: " + larghezza + "cm | " + prezzo + "� | ";
		bottone.setText(contenutoBottone);
		return this.bottone;
	}

	public String getCodiceTappeto() {
		return codiceTappeto;
	}

	public void setCodiceTappeto(String codiceTappeto) {
		this.codiceTappeto = codiceTappeto;
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
