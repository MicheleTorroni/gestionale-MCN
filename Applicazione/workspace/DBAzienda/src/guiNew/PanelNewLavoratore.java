package guiNew;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entita.Lavoratore;
import utility.ColorView;
import utility.DbHelper;

public class PanelNewLavoratore extends JPanel {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	JLabel codiceFiscale = new JLabel("codice fiscale");
	JTextField areaCodiceFiscale = new JTextField(15);
	JLabel stipendio = new JLabel("stipendio");
	JTextField areaStipendio = new JTextField(15);
	JLabel nome = new JLabel("nome");
	JTextField areaNome = new JTextField(15);
	JLabel cognome = new JLabel("cognome");
	JTextField areaCognome = new JTextField(15);
	JLabel dataNascita = new JLabel("data di nascita");
	JTextField areaDataNascita = new JTextField(15);
	JLabel ruolo = new JLabel("ruolo");
	String[] ruoli = { "amministratore", "venditore", "artigiano" };
	JComboBox<String> areaRuolo = new JComboBox<>(ruoli);
	JLabel password = new JLabel("password");
	JTextField areaPassword = new JTextField(15);

	JButton salva = new JButton("salva");

	JPanel grid = new JPanel(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();
	JLabel placeholder = new JLabel(" ");

	public PanelNewLavoratore(FrameForNew padre) {

		riempiGriglia();

		this.setLayout(new BorderLayout());
		this.add(grid);

		funzioniBottoni(padre);
		colori();
		dimensioni();

		this.setVisible(true);
	}

	private void riempiGriglia() {
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(7, 7, 7, 7);

		grid.add(codiceFiscale, gbc);
		gbc.gridx++;
		grid.add(areaCodiceFiscale, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		grid.add(stipendio, gbc);
		gbc.gridx++;
		grid.add(areaStipendio, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		grid.add(nome, gbc);
		gbc.gridx++;
		grid.add(areaNome, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		grid.add(cognome, gbc);
		gbc.gridx++;
		grid.add(areaCognome, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		grid.add(dataNascita, gbc);
		gbc.gridx++;
		grid.add(areaDataNascita, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		grid.add(ruolo, gbc);
		gbc.gridx++;
		grid.add(areaRuolo, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		grid.add(password, gbc);
		gbc.gridx++;
		grid.add(areaPassword, gbc);
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

		codiceFiscale.setForeground(Color.WHITE);
		stipendio.setForeground(Color.WHITE);
		nome.setForeground(Color.WHITE);
		cognome.setForeground(Color.WHITE);
		dataNascita.setForeground(Color.WHITE);
		ruolo.setForeground(Color.WHITE);
		password.setForeground(Color.WHITE);
		salva.setForeground(Color.WHITE);
	}

	private void dimensioni() {
		this.setMinimumSize(new Dimension(500, 300));

		codiceFiscale.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaCodiceFiscale.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		stipendio.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaStipendio.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		nome.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaNome.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		cognome.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaCognome.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		dataNascita.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaDataNascita.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		ruolo.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaRuolo.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		password.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaPassword.setFont(new Font("TimesRoman", Font.ITALIC, 20));

		salva.setFont(new Font("TimesRoman", Font.BOLD, 25));
	}

	private void funzioniBottoni(FrameForNew padre) {

		salva.addActionListener(e -> {

			String codice_lavoratore = "0";
			try {
				codice_lavoratore = DbHelper.maxLavoratori();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Lavoratore l = new Lavoratore(codice_lavoratore, areaCodiceFiscale.getText(), areaStipendio.getText(),
					areaNome.getText(), areaCognome.getText(), areaDataNascita.getText(),
					(String) areaRuolo.getSelectedItem(), areaPassword.getText(), "0", "0");

			System.out.println(l.getBottone().getText());

			try {
				DbHelper.aggiungiLavoratore(l);
				switch (l.getTipologiaLavoratore()) {
				case "amministratore":
					DbHelper.aggiungiAmministratore(l);
					break;
				case "venditore":
					DbHelper.aggiungiVenditore(l);
					break;
				case "artigiano":
					DbHelper.aggiungiArtigiano(l);
					break;
				}
			} catch (ClassNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			try {
				padre.aggiornaCreatore();
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
