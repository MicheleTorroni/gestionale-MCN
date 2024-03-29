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

import entita.Cliente;
import utility.ColorView;
import utility.DbHelper;

public class PanelDetailsCliente extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cliente cliente;

	JLabel numeroTelefono = new JLabel("numero di telefono");
	JTextField areaNumeroTelefono = new JTextField(15);
	JLabel email = new JLabel("email");
	JTextField areaEmail = new JTextField(15);

	JLabel tipologia = new JLabel("tipologia");
	JLabel areaTipologia = new JLabel("tipologia");
	// -------------------------privato
	JLabel codiceFiscale = new JLabel("codice fiscale");
	JLabel areaCodiceFiscale = new JLabel();
	JLabel nome = new JLabel("nome");
	JLabel areaNome = new JLabel();
	JLabel cognome = new JLabel("cognome");
	JLabel areaCognome = new JLabel();
	// -------------------------partitaIva
	JLabel partitaIva = new JLabel("partita iva");
	JLabel areaPartitaIva = new JLabel();
	JLabel nomeAzienda = new JLabel("nome societ�");
	JLabel areaNomeAzienda = new JLabel();

	JButton salva = new JButton("salva");
	JButton elimina = new JButton("elimina");

	JPanel grid = new JPanel(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();
	JLabel placeholder = new JLabel(" ");

	PanelDetailsCliente(Cliente cliente, FrameForDetails padre) {
		this.cliente = cliente;

		riempiGriglia(cliente.getTipologiaCliente());
		inizializzazione(cliente);

		this.setLayout(new BorderLayout());
		this.add(grid);

		funzioniBottoni(padre);
		colori();
		dimensioni();

		this.setVisible(true);
	}

	private void inizializzazione(Cliente cliente) {
		this.areaNumeroTelefono.setText(cliente.getNumeroTelefono());
		this.areaEmail.setText(cliente.getEmail());
		this.areaTipologia.setText(cliente.getTipologiaCliente());
		this.areaNome.setText(cliente.getNome());
		this.areaCognome.setText(cliente.getCognome());
		this.areaCodiceFiscale.setText(cliente.getCodiceFiscale());
		this.areaPartitaIva.setText(cliente.getPartitaIva());
		this.areaNomeAzienda.setText(cliente.getNomeAzienda());
	}

	private void riempiGriglia(String tipo) {
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10, 10, 10, 10);

		grid.add(numeroTelefono, gbc);
		gbc.gridx++;
		grid.add(areaNumeroTelefono, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		grid.add(email, gbc);
		gbc.gridx++;
		grid.add(areaEmail, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		grid.add(tipologia, gbc);
		gbc.gridx++;
		grid.add(areaTipologia, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		grid.add(placeholder, gbc);
		gbc.gridy++;
		switch (tipo) {
		case "privato":
			grid.add(codiceFiscale, gbc);
			gbc.gridx++;
			grid.add(areaCodiceFiscale, gbc);
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
			break;
		case "partitaiva":
			grid.add(partitaIva, gbc);
			gbc.gridx++;
			grid.add(areaPartitaIva, gbc);
			;
			gbc.gridx = 0;
			gbc.gridy++;
			grid.add(nomeAzienda, gbc);
			gbc.gridx++;
			grid.add(areaNomeAzienda, gbc);
			gbc.gridx = 0;
			gbc.gridy++;
			break;
		default:
			System.out.println("errore scelta tipo cliente");

		}

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
		nome.setForeground(Color.WHITE);
		cognome.setForeground(Color.WHITE);
		partitaIva.setForeground(Color.WHITE);
		nomeAzienda.setForeground(Color.WHITE);
		numeroTelefono.setForeground(Color.WHITE);
		email.setForeground(Color.WHITE);
		tipologia.setForeground(Color.WHITE);
		areaTipologia.setForeground(Color.WHITE);
		elimina.setForeground(Color.WHITE);
		salva.setForeground(Color.WHITE);

		areaCodiceFiscale.setForeground(Color.WHITE);
		areaNome.setForeground(Color.WHITE);
		areaCognome.setForeground(Color.WHITE);
		areaPartitaIva.setForeground(Color.WHITE);
		areaNomeAzienda.setForeground(Color.WHITE);
		areaTipologia.setForeground(Color.WHITE);
	}

	private void dimensioni() {
		this.setMinimumSize(new Dimension(500, 300));

		codiceFiscale.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaCodiceFiscale.setFont(new Font("TimesRoman", Font.BOLD, 20));
		nome.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaNome.setFont(new Font("TimesRoman", Font.BOLD, 20));
		cognome.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaCognome.setFont(new Font("TimesRoman", Font.BOLD, 20));
		partitaIva.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaPartitaIva.setFont(new Font("TimesRoman", Font.BOLD, 20));
		nomeAzienda.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaNomeAzienda.setFont(new Font("TimesRoman", Font.BOLD, 20));
		numeroTelefono.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaNumeroTelefono.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		email.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaEmail.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		tipologia.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaTipologia.setFont(new Font("TimesRoman", Font.PLAIN, 24));

		salva.setFont(new Font("TimesRoman", Font.BOLD, 25));
		elimina.setFont(new Font("TimesRoman", Font.BOLD, 25));
	}

	private void funzioniBottoni(FrameForDetails padre) {

		salva.addActionListener(e -> {

			cliente.setNumeroTelefono(areaNumeroTelefono.getText());
			cliente.setEmail(areaEmail.getText());

			DbHelper.aggiornaCliente(cliente);
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
			String codice = cliente.getCodiceCliente();
			String tipologia = cliente.getTipologiaCliente();
			try {
				DbHelper.eliminaCliente(codice);
			} catch (ClassNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}

			switch (tipologia) {

			case "privato":
				try {
					DbHelper.eliminaPrivato(codice);
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				break;
			case "partitaiva":
				try {
					DbHelper.eliminaPartitaIva(codice);
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
	}
}
