package entita;

import javax.swing.JButton;

public class Ordine {

	String codiceOrdine;
	String data;
	String importoOrdine;
	String codiceCliente;
	String codiceLavoratore;

	JButton bottone = new JButton();

	public Ordine(String codiceOrdine, String data, String importoOrdine, String codiceCliente,
			String codiceLavoratore) {
		super();
		this.codiceOrdine = codiceOrdine;
		this.data = data;
		this.importoOrdine = importoOrdine;
		this.codiceCliente = codiceCliente;
		this.codiceLavoratore = codiceLavoratore;

	}

	public JButton getBottone() {
		String contenutoBottone = 
				"n.ordine: "+ codiceOrdine + "  |  " 
				+ data + " | " 
				+ importoOrdine + "€ | " 
				+"codice cliente: "+ codiceCliente + " | "
				+"codice venditore: "+ codiceLavoratore;
		bottone.setText(contenutoBottone);
		return this.bottone;
	}

	public String getCodiceOrdine() {
		return codiceOrdine;
	}

	public void setCodiceOrdine(String codiceOrdine) {
		this.codiceOrdine = codiceOrdine;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getImportoOrdine() {
		return importoOrdine;
	}

	public void setImportoOrdine(String importoOrdine) {
		this.importoOrdine = importoOrdine;
	}

	public String getCodiceCliente() {
		return codiceCliente;
	}

	public void setCodiceCliente(String codiceCliente) {
		this.codiceCliente = codiceCliente;
	}

	public String getCodiceLavoratore() {
		return codiceLavoratore;
	}

	public void setCodiceLavoratore(String codiceLavoratore) {
		this.codiceLavoratore = codiceLavoratore;
	}

}
