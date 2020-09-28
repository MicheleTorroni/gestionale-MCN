package guiNew;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entita.Prodotto;
import utility.ColorView;
import utility.DbHelper;

public class PanelNewProdotto extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel grid = new JPanel(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();
	JLabel descrizione = new JLabel("descrizione");
	JLabel tipo = new JLabel("tipo");
	JTextField areaDescrizione = new JTextField(15);
	JComboBox<String> areaTipo;
	JButton dettagli = new JButton("dettagli");
	JLabel placeholder = new JLabel(" ");

	// DA CAMBIARE
	ArrayList<String> listaTipologieProdotti = DbHelper.getTipologieProdotti();
	String[] array = listaTipologieProdotti.toArray(new String[listaTipologieProdotti.size()]);
	//

	public PanelNewProdotto(JFrame padre) {

		areaTipo = new JComboBox<String>(array);

		this.setLayout(new BorderLayout());
		this.add(grid);

		funzioniBottoni(padre);
		riempiGriglia();
		colori();
		dimensioni();

	}

	private void riempiGriglia() {
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(3, 3, 3, 3);

		grid.add(descrizione, gbc);
		gbc.gridx++;
		grid.add(areaDescrizione, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		grid.add(tipo, gbc);
		gbc.gridx++;
		grid.add(areaTipo, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		grid.add(placeholder, gbc);
		gbc.gridy++;
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridwidth = 2;
		grid.add(dettagli, gbc);
	}

	private void colori() {
		this.setBackground(ColorView.myGray());
		grid.setBackground(ColorView.myGray());
		dettagli.setBackground(ColorView.myOrange());
		descrizione.setForeground(Color.WHITE);
		tipo.setForeground(Color.WHITE);
		dettagli.setForeground(Color.WHITE);
		areaTipo.setBackground(Color.WHITE);
	}

	private void dimensioni() {
		this.setMinimumSize(new Dimension(500, 300));

		descrizione.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaDescrizione.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		tipo.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaTipo.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		dettagli.setFont(new Font("TimesRoman", Font.BOLD, 25));
	}

	private void funzioniBottoni(JFrame padre) {
		dettagli.addActionListener(e -> {

			String codice_prodotto = "0";
			try {
				codice_prodotto = DbHelper.maxProdotti();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Prodotto prodotto = new Prodotto(codice_prodotto, areaDescrizione.getText(),
					((FrameForNew) padre).getCreatore().getCodiceLavoratore(), areaTipo.getSelectedItem().toString(),
					"x", "x", "x", "x", "x", "x", "x", "x", "x", "x");
			((FrameForNew) padre).cambiaPanel(this, "prodotto", areaTipo.getSelectedItem().toString(), prodotto);
		});
	}

}
