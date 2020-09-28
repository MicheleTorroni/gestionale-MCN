package entita;

import javax.swing.JButton;

public class Prodotto {
	String codiceProdotto;
	String descrizione;
	String codiceLavoratore;
	String tipologiaProdotto;
	// ----------------------MATERIALETOP
	String tipologiaTop;
	String colore;
	String tipoLama;
	String costoM2;
	// ----------------------BASE
	String tipologiaBase;
	// tipoLama
	// costoM2
	// ----------------------ANTINCIAMPO
	String tipologiaAntinciampo;
	// tipoLama
	String costoM;
	// ----------------------MATERIALETELAIO
	String tipologiaTelaio;
	String tipoFresa;
	// costoM2
	// ----------------------NEON
	// costoM
	// ----------------------LED
	String costoUnitario;

	// ORDINATI

	String prezzo;
	String codiceTappeto;
	String codiceInsegna;

	JButton bottone = new JButton();

	public Prodotto(String codiceProdotto, String descrizione, String codiceLavoratore, String tipologiaProdotto,
			String tipologiaTop, String colore, String tipoLama, String costoM2, String tipologiaBase,
			String tipologiaAntinciampo, String costoM, String tipologiaTelaio, String tipoFresa,
			String costoUnitario) {
		super();
		this.codiceProdotto = codiceProdotto;
		this.descrizione = descrizione;
		this.codiceLavoratore = codiceLavoratore;
		this.tipologiaProdotto = tipologiaProdotto;
		this.tipologiaTop = tipologiaTop;
		this.colore = colore;
		this.tipoLama = tipoLama;
		this.costoM2 = costoM2;
		this.tipologiaBase = tipologiaBase;
		this.tipologiaAntinciampo = tipologiaAntinciampo;
		this.costoM = costoM;
		this.tipologiaTelaio = tipologiaTelaio;
		this.tipoFresa = tipoFresa;
		this.costoUnitario = costoUnitario;
		this.prezzo = "0";
		this.codiceTappeto = "0";
		this.codiceInsegna = "0";
	}

	public JButton getBottone() {
		String contenutoBottone = descrizione + " | " + tipologiaProdotto;
		switch (tipologiaProdotto) {

		case "materialetop":
			contenutoBottone = contenutoBottone + " | " + tipologiaTop + " | " + colore + " | " + "LAMA:" + tipoLama
					+ " | " + "COSTO MQ:" + costoM2 + "€";
			break;
		case "base":
			contenutoBottone = contenutoBottone + " | " + tipologiaBase + " | " + "LAMA:" + tipoLama + " | "
					+ "COSTO MQ:" + costoM2 + "€";
			break;
		case "antinciampo":
			contenutoBottone = contenutoBottone + " | " + tipologiaAntinciampo + " | " + "LAMA:" + tipoLama + " | "
					+ "COSTO M:" + costoM + "€";
			break;
		case "materialetelaio":
			contenutoBottone = contenutoBottone + " | " + tipologiaTelaio + " | " + "FRESA:" + tipoFresa + " | "
					+ "COSTO MQ:" + costoM2 + "€";
			break;
		case "neon":
			contenutoBottone = contenutoBottone + " | " + "COSTO M:" + costoM + "€";
			break;
		case "led":
			contenutoBottone = contenutoBottone + " | " + "COSTO U:" + costoUnitario + "€";
			break;
		}
		bottone.setText(contenutoBottone);
		return this.bottone;
	}

	public String getCodiceProdotto() {
		return codiceProdotto;
	}

	public void setCodiceProdotto(String codiceProdotto) {
		this.codiceProdotto = codiceProdotto;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCodiceLavoratore() {
		return codiceLavoratore;
	}

	public void setCodiceLavoratore(String codiceLavoratore) {
		this.codiceLavoratore = codiceLavoratore;
	}

	public String getTipologiaTop() {
		return tipologiaTop;
	}

	public void setTipologiaTop(String tipologiaTop) {
		this.tipologiaTop = tipologiaTop;
	}

	public String getColore() {
		return colore;
	}

	public void setColore(String colore) {
		this.colore = colore;
	}

	public String getTipoLama() {
		return tipoLama;
	}

	public void setTipoLama(String tipoLama) {
		this.tipoLama = tipoLama;
	}

	public String getCostoM2() {
		return costoM2;
	}

	public void setCostoM2(String costoM2) {
		this.costoM2 = costoM2;
	}

	public String getTipologiaBase() {
		return tipologiaBase;
	}

	public void setTipologiaBase(String tipologiaBase) {
		this.tipologiaBase = tipologiaBase;
	}

	public String getTipologiaAntinciampo() {
		return tipologiaAntinciampo;
	}

	public void setTipologiaAntinciampo(String tipologiaAntinciampo) {
		this.tipologiaAntinciampo = tipologiaAntinciampo;
	}

	public String getCostoM() {
		return costoM;
	}

	public void setCostoM(String costoM) {
		this.costoM = costoM;
	}

	public String getTipologiaTelaio() {
		return tipologiaTelaio;
	}

	public void setTipologiaTelaio(String tipologiaTelaio) {
		this.tipologiaTelaio = tipologiaTelaio;
	}

	public String getTipoFresa() {
		return tipoFresa;
	}

	public void setTipoFresa(String tipoFresa) {
		this.tipoFresa = tipoFresa;
	}

	public String getCostoUnitario() {
		return costoUnitario;
	}

	public void setCostoUnitario(String costoUnitario) {
		this.costoUnitario = costoUnitario;
	}

	public String getTipologiaProdotto() {
		return tipologiaProdotto;
	}

	public void setTipologiaProdotto(String tipologiaProdotto) {
		this.tipologiaProdotto = tipologiaProdotto;
	}

	public String getPrezzo() {
		return this.prezzo;
	}

	public void setPrezzo(String prezzo) {
		this.prezzo = prezzo;
	}

	public String getCodiceTappeto() {
		return this.codiceTappeto;
	}

	public void setCodiceTappeto(String codiceTappeto) {
		this.codiceTappeto = codiceTappeto;
	}

	public String getCodiceInsegna() {
		return this.codiceInsegna;
	}

	public void setCodiceInsegna(String codiceInsegna) {
		this.codiceInsegna = codiceInsegna;
	}
}
