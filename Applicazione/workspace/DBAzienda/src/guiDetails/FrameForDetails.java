package guiDetails;

import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.JFrame;

import entita.Cliente;
import entita.Insegna;
import entita.Lavoratore;
import entita.Prodotto;
import entita.Tappeto;
import guiHome.FrameForWorker;
import utility.Images;

public class FrameForDetails extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FrameForWorker creatore;

	public FrameForDetails(String tabella, Object entita, FrameForWorker creatore) throws ClassNotFoundException, SQLException {

		this.creatore = creatore;
		inizializzazionePanels(tabella, entita);

		dimensioni();
		Images.impostaIcona(this);

		this.setLocationRelativeTo(null);
		this.setTitle("MCN - details " + tabella);
		this.setVisible(true);
		this.pack();
	}

	private void inizializzazionePanels(String tabella, Object entita) throws ClassNotFoundException, SQLException {
		switch (tabella) {
		case "prodotto":
			this.add(new PanelDetailsProdotto((Prodotto) entita, this));
			break;
		case "lavoratore":
			this.add(new PanelDetailsLavoratore((Lavoratore) entita, this));
			break;
		case "cliente":
			this.add(new PanelDetailsCliente((Cliente) entita, this));
			break;
		case "tappeto":
			this.add(new PanelDetailsTappeto((Tappeto) entita, this));
			break;
		case "insegna":
			this.add(new PanelDetailsInsegna((Insegna) entita, this));
			break;
		default:
			System.out.println("errore scelta details tabella");
		}
	}

	private void dimensioni() {
		this.setMinimumSize(new Dimension(800, 400));
		this.setResizable(false);
	}

	public void aggiornaCreatore() throws ClassNotFoundException, SQLException {
		creatore.aggiornaFrame();
		this.dispose();
	}

	public FrameForWorker getCreatore() {
		return this.creatore;
	}
}
