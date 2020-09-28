package guiHome;

import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import utility.Images;

public class FrameForWorker extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String ruolo;
	int codiceDipendente;
	JPanel pannelloLavoratore;

	public FrameForWorker(String ruolo, int codiceDipendente) throws ClassNotFoundException, SQLException {

		pannelloLavoratore = new PanelWorker(codiceDipendente, ruolo, this);

		this.ruolo = ruolo;
		this.codiceDipendente = codiceDipendente;

		this.add(pannelloLavoratore);
		dimensioni();

		Images.impostaIcona(this);
		this.setLocationRelativeTo(null);
		this.setTitle("MCN - " + ruolo + " - " + codiceDipendente);
		this.setVisible(true);
		this.pack();
	}

	private void dimensioni() {
		this.setMinimumSize(new Dimension(1250, 800));
		this.setResizable(false);
	}

	public void aggiornaFrame() throws ClassNotFoundException, SQLException {
		this.remove(pannelloLavoratore);
		pannelloLavoratore = new PanelWorker(this.codiceDipendente, this.ruolo, this);
		this.add(pannelloLavoratore);
		this.setVisible(false);
		this.setVisible(true);
	}

	public String getCodiceLavoratore() {
		return Integer.toString(codiceDipendente);
	}
}
