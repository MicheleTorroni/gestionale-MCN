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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entita.Insegna;
import entita.Prodotto;
import utility.ColorView;
import utility.DbHelper;

public class PanelNewInsegna extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel quantita = new JLabel("quantit�");
	JTextField areaQuantita = new JTextField(15);
	JLabel altezza = new JLabel("altezza");
	JTextField areaAltezza = new JTextField(15);
	JLabel larghezza = new JLabel("larghezza");
	JTextField areaLarghezza = new JTextField(15);
	JLabel lunghezzaNeon = new JLabel("lunghezza neon");
	JTextField areaLunghezzaNeon = new JTextField(15);
	JLabel numeroLed = new JLabel("numero di led");
	JTextField areaNumeroLed = new JTextField(15);
	JLabel prezzo = new JLabel("PREZZO FINALE");
	JTextField areaPrezzo = new JTextField(15);

	ArrayList<Prodotto> listaProdotti = new ArrayList<>();
	ArrayList<Prodotto> listaTelaio = new ArrayList<>();
	ArrayList<Prodotto> listaNeon = new ArrayList<>();
	ArrayList<Prodotto> listaLed = new ArrayList<>();

	JLabel telaio = new JLabel("scelta telaio");
	JComboBox<String> areaTelaio = new JComboBox<>();
	JLabel prezzoTelaio = new JLabel("prezzo telaio");
	JTextField areaPrezzoTelaio = new JTextField(15);
	JLabel neon = new JLabel("scelta neon");
	JComboBox<String> areaNeon = new JComboBox<>();
	JLabel prezzoNeon = new JLabel("prezzo neon");
	JTextField areaPrezzoNeon = new JTextField(15);
	JLabel led = new JLabel("scelta led");
	JComboBox<String> areaLed = new JComboBox<>();
	JLabel prezzoLed = new JLabel("prezzo led");
	JTextField areaPrezzoLed = new JTextField(15);

	JButton salva = new JButton("salva");

	JPanel grid = new JPanel(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();
	JLabel placeholder = new JLabel(" ");

	public PanelNewInsegna(FrameForNewTappetoInsegna padre) throws ClassNotFoundException, SQLException {

		inizializzazione();
		riempiGriglia();

		this.setLayout(new BorderLayout());
		this.add(grid);

		funzioniBottoni(padre);
		colori();
		dimensioni();

		this.setVisible(true);
	}

	private void inizializzazione() throws ClassNotFoundException, SQLException {
		listaProdotti = DbHelper.getProdotti();

		for (Prodotto p : listaProdotti) {
			switch (p.getTipologiaProdotto()) {
			case "materialetelaio":
				listaTelaio.add(p);
				break;
			case "neon":
				listaNeon.add(p);
				break;
			case "led":
				listaLed.add(p);
				break;
			}
		}

		for (Prodotto t : listaTelaio) {
			areaTelaio.addItem(t.getBottone().getText());
		}

		for (Prodotto n : listaNeon) {
			areaNeon.addItem(n.getBottone().getText());
		}

		for (Prodotto l : listaLed) {
			areaLed.addItem(l.getBottone().getText());
		}
	}

	private void riempiGriglia() {
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(7, 7, 7, 7);

		grid.add(quantita, gbc);
		gbc.gridx++;
		grid.add(areaQuantita, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		grid.add(altezza, gbc);
		gbc.gridx++;
		grid.add(areaAltezza, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		grid.add(larghezza, gbc);
		gbc.gridx++;
		grid.add(areaLarghezza, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		grid.add(telaio, gbc);
		gbc.gridx++;
		grid.add(areaTelaio, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		grid.add(prezzoTelaio, gbc);
		gbc.gridx++;
		grid.add(areaPrezzoTelaio, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		grid.add(neon, gbc);
		gbc.gridx++;
		grid.add(areaNeon, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		grid.add(lunghezzaNeon, gbc);
		gbc.gridx++;
		grid.add(areaLunghezzaNeon, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		grid.add(prezzoNeon, gbc);
		gbc.gridx++;
		grid.add(areaPrezzoNeon, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		grid.add(led, gbc);
		gbc.gridx++;
		grid.add(areaLed, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		grid.add(numeroLed, gbc);
		gbc.gridx++;
		grid.add(areaNumeroLed, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		grid.add(prezzoLed, gbc);
		gbc.gridx++;
		grid.add(areaPrezzoLed, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		grid.add(prezzo, gbc);
		gbc.gridx++;
		grid.add(areaPrezzo, gbc);
		gbc.gridx = 0;
		gbc.gridy++;

		grid.add(placeholder, gbc);
		gbc.gridy++;
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridwidth = 2;
		grid.add(salva, gbc);
	}

	private void colori() {
		this.setBackground(ColorView.myGray());
		grid.setBackground(ColorView.myGray());
		salva.setBackground(ColorView.myOrange());

		quantita.setForeground(Color.WHITE);
		altezza.setForeground(Color.WHITE);
		larghezza.setForeground(Color.WHITE);
		lunghezzaNeon.setForeground(Color.WHITE);
		numeroLed.setForeground(Color.WHITE);
		salva.setForeground(Color.WHITE);
		prezzo.setForeground(Color.WHITE);
		telaio.setForeground(Color.WHITE);
		prezzoTelaio.setForeground(Color.WHITE);
		neon.setForeground(Color.WHITE);
		prezzoNeon.setForeground(Color.WHITE);
		led.setForeground(Color.WHITE);
		prezzoLed.setForeground(Color.WHITE);
	}

	private void dimensioni() {
		this.setMinimumSize(new Dimension(500, 300));

		quantita.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaQuantita.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		altezza.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaAltezza.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		larghezza.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaLarghezza.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		lunghezzaNeon.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaLunghezzaNeon.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		numeroLed.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaNumeroLed.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		prezzo.setFont(new Font("TimesRoman", Font.BOLD, 20));
		areaPrezzo.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		telaio.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaTelaio.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		prezzoTelaio.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaPrezzoTelaio.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		neon.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaNeon.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		prezzoNeon.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaPrezzoNeon.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		led.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaLed.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		prezzoLed.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaPrezzoLed.setFont(new Font("TimesRoman", Font.ITALIC, 20));

		salva.setFont(new Font("TimesRoman", Font.BOLD, 25));
	}

	private void funzioniBottoni(FrameForNewTappetoInsegna padre) {

		salva.addActionListener(e -> {

			String codice_insegna = "0";
			Insegna i;
			Prodotto telaio;
			Prodotto neon;
			Prodotto led;
			try {
				codice_insegna = DbHelper.maxInsegne();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			try {
				i = new Insegna(codice_insegna, "DA INIZIARE", areaQuantita.getText(), areaAltezza.getText(),
						areaLarghezza.getText(), "0000-01-01", areaLunghezzaNeon.getText(), areaNumeroLed.getText(),
						areaPrezzo.getText(), DbHelper.maxOrdini(), padre.getCreatore().getCodiceLavoratore());

				telaio = new Prodotto(listaTelaio.get(areaTelaio.getSelectedIndex()).getCodiceProdotto(), "", "",
						"materialetelaio", "", "", "", "", "", "", "", "", "", "");
				telaio.setPrezzo(areaPrezzoTelaio.getText());
				telaio.setCodiceInsegna(i.getCodiceInsegna());
				neon = new Prodotto(listaNeon.get(areaNeon.getSelectedIndex()).getCodiceProdotto(), "", "", "neon", "",
						"", "", "", "", "", "", "", "", "");
				neon.setPrezzo(areaPrezzoNeon.getText());
				neon.setCodiceInsegna(i.getCodiceInsegna());
				led = new Prodotto(listaLed.get(areaLed.getSelectedIndex()).getCodiceProdotto(), "", "", "led", "", "",
						"", "", "", "", "", "", "", "");
				led.setPrezzo(areaPrezzoLed.getText());
				led.setCodiceInsegna(i.getCodiceInsegna());

				padre.aggiungiInsegna(i);
				padre.aggiungiProdottoOrdinato(telaio);
				padre.aggiungiProdottoOrdinato(neon);
				padre.aggiungiProdottoOrdinato(led);

			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});

	};
}