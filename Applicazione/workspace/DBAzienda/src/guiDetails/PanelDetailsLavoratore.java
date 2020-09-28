package guiDetails;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entita.Lavoratore;
import utility.ColorView;
import utility.DbHelper;

public class PanelDetailsLavoratore extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JLabel codiceFiscale = new JLabel("codice fiscale");
	JLabel areaCodiceFiscale = new JLabel();
	JLabel stipendio = new JLabel("stipendio");
	JTextField areaStipendio = new JTextField(15);
	JLabel nome = new JLabel("nome");
	JLabel areaNome = new JLabel();
	JLabel cognome = new JLabel("cognome");
	JLabel areaCognome = new JLabel();
	JLabel dataNascita = new JLabel("data di nascita");
	JLabel areaDataNascita = new JLabel();
	JLabel ruolo = new JLabel("ruolo");
	JLabel areaRuolo = new JLabel("ruolo");
	JLabel password = new JLabel("password");
	JTextField areaPassword = new JTextField(15);

	JButton salva = new JButton("salva");
	JButton elimina = new JButton("elimina");

	JPanel grid = new JPanel(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();
	JLabel placeholder = new JLabel(" ");

	private Lavoratore lavoratore;

	PanelDetailsLavoratore(Lavoratore lavoratore, FrameForDetails padre) {
		this.lavoratore = lavoratore;

		riempiGriglia();
		inizializzazione(lavoratore);

		this.setLayout(new BorderLayout());
		this.add(grid);

		funzioniBottoni(padre);
		colori();
		dimensioni();

		this.setVisible(true);
	}

	private void inizializzazione(Lavoratore l) {
		areaCodiceFiscale.setText(l.getCodiceFiscale());
		areaStipendio.setText(l.getStipendio());
		areaNome.setText(l.getNome());
		areaCognome.setText(l.getCognome());
		areaDataNascita.setText(l.getDataNascita());
		areaPassword.setText(l.getPassword());
		areaRuolo.setText(l.getTipologiaLavoratore());
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
		gbc.gridwidth = 1;
		grid.add(elimina, gbc);
		gbc.gridx++;
		grid.add(salva, gbc);
	}

	private void colori() {
		this.setBackground(ColorView.myGray());
		grid.setBackground(ColorView.myGray());
		salva.setBackground(ColorView.myOrange());
		elimina.setBackground(ColorView.myOrange());

		codiceFiscale.setForeground(Color.WHITE);
		stipendio.setForeground(Color.WHITE);
		nome.setForeground(Color.WHITE);
		cognome.setForeground(Color.WHITE);
		dataNascita.setForeground(Color.WHITE);
		ruolo.setForeground(Color.WHITE);
		password.setForeground(Color.WHITE);
		salva.setForeground(Color.WHITE);
		elimina.setForeground(Color.WHITE);

		areaCodiceFiscale.setForeground(Color.WHITE);
		areaNome.setForeground(Color.WHITE);
		areaCognome.setForeground(Color.WHITE);
		areaDataNascita.setForeground(Color.WHITE);
		areaRuolo.setForeground(Color.WHITE);

	}

	private void dimensioni() {
		this.setMinimumSize(new Dimension(500, 300));

		codiceFiscale.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaCodiceFiscale.setFont(new Font("TimesRoman", Font.BOLD, 20));
		stipendio.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaStipendio.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		nome.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaNome.setFont(new Font("TimesRoman", Font.BOLD, 20));
		cognome.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaCognome.setFont(new Font("TimesRoman", Font.BOLD, 20));
		dataNascita.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaDataNascita.setFont(new Font("TimesRoman", Font.BOLD, 20));
		ruolo.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaRuolo.setFont(new Font("TimesRoman", Font.BOLD, 24));
		password.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaPassword.setFont(new Font("TimesRoman", Font.ITALIC, 20));

		salva.setFont(new Font("TimesRoman", Font.BOLD, 25));
		elimina.setFont(new Font("TimesRoman", Font.BOLD, 25));
	}

	private void funzioniBottoni(FrameForDetails padre) {

		salva.addActionListener(e -> {
			lavoratore.setCodiceFiscale(areaCodiceFiscale.getText());
			lavoratore.setStipendio(areaStipendio.getText());
			lavoratore.setNome(areaNome.getText());
			lavoratore.setCognome(areaCognome.getText());
			lavoratore.setDataNascita(areaDataNascita.getText());
			lavoratore.setPassword(areaPassword.getText());

			DbHelper.aggiornaLavoratore(lavoratore);
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

		elimina.addActionListener(e -> {
			String codice = lavoratore.getCodiceLavoratore();
			try {
				DbHelper.eliminaLavoratore(codice);
			} catch (ClassNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			switch (lavoratore.getTipologiaLavoratore()) {
			case "amministratore":
				try {
					DbHelper.eliminaAmministratore(codice);
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				break;
			case "venditore":
				try {
					DbHelper.eliminaVenditore(codice);
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				break;
			case "artigiano":
				try {
					DbHelper.eliminaArtigiano(codice);
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				break;
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
