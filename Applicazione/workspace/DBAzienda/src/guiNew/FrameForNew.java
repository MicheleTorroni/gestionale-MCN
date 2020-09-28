package guiNew;

import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entita.Cliente;
import entita.Prodotto;
import guiHome.FrameForWorker;
import utility.Images;

public class FrameForNew extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panelProdotto = new PanelNewProdotto(this);
	JPanel panelLavoratore = new PanelNewLavoratore(this);
	JPanel panelCliente = new PanelNewCliente(this);
	JPanel panelOrdine;

	FrameForWorker creatore;

	public FrameForNew(String tabella, FrameForWorker creatore) throws ClassNotFoundException, SQLException {
		panelOrdine = new PanelNewOrdine(this);
		sceltaTabella(tabella);
		this.creatore = creatore;
		dimensioni();

		Images.impostaIcona(this);
		this.setLocationRelativeTo(null);
		this.setTitle("MCN - new " + tabella);
		this.setVisible(true);
		this.pack();
	}

	private void sceltaTabella(String tabella) {
		switch (tabella) {
		case "prodotto":
			this.add(panelProdotto);
			break;
		case "lavoratore":
			this.add(panelLavoratore);
			break;
		case "ordine":
			this.add(panelOrdine);
			this.pack();
			break;
		case "cliente":
			this.add(panelCliente);
			break;
		default:
			System.out.println("errore scelta new tabella");
		}
	}

	private void dimensioni() {
		this.setMinimumSize(new Dimension(800, 400));
		this.setResizable(false);
	}

	public void cambiaPanel(JPanel panel, String tabella, String tipo, Object entita) {
		this.setVisible(false);
		this.remove(panel);

		switch (tabella) {
		case "prodotto":
			this.add(new PanelNewProdottoDettagliato(tipo, this, (Prodotto) entita));
			break;
		case "cliente":
			this.add(new PanelNewClienteDettagliato(tipo, this, (Cliente) entita));
			break;
		default:
			System.out.println("new - tabella sbagliata");
		}
		this.setVisible(true);
	}

	public void aggiornaCreatore() throws ClassNotFoundException, SQLException {
		creatore.aggiornaFrame();
		this.dispose();
	}

	public FrameForWorker getCreatore() {
		return this.creatore;
	}
}
