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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entita.Cliente;
import utility.ColorView;
import utility.DbHelper;

public class PanelNewClienteDettagliato extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// -------------------------privato
	JLabel codiceFiscale = new JLabel("codice fiscale");
	JTextField areaCodiceFiscale = new JTextField(15);
	JLabel nome = new JLabel("nome");
	JTextField areaNome = new JTextField(15);
	JLabel cognome = new JLabel("cognome");
	JTextField areaCognome = new JTextField(15);
	// -------------------------partitaIva
	JLabel partitaIva = new JLabel("partita iva");
	JTextField areaPartitaIva = new JTextField(15);
	JLabel nomeAzienda = new JLabel("nome societ�");
	JTextField areaNomeAzienda = new JTextField(15);

	JButton salva = new JButton("salva");

	JPanel grid = new JPanel(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();
	JLabel placeholder = new JLabel(" ");

	String tipo;
	Cliente cliente;

	public PanelNewClienteDettagliato(String tipo, FrameForNew padre, Cliente cliente) {

		this.tipo = tipo;
		this.cliente = cliente;

		riempiGriglia(tipo);

		this.setLayout(new BorderLayout());
		this.add(grid);

		funzioniBottoni(padre);
		colori();
		dimensioni();

		this.setVisible(true);
	}

	private void riempiGriglia(String tipo) {
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(4, 4, 4, 4);

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
		gbc.gridwidth = 2;
		grid.add(salva, gbc);
	}

	private void colori() {
		this.setBackground(ColorView.myGray());
		grid.setBackground(ColorView.myGray());
		salva.setBackground(ColorView.myOrange());

		codiceFiscale.setForeground(Color.WHITE);
		nome.setForeground(Color.WHITE);
		cognome.setForeground(Color.WHITE);
		partitaIva.setForeground(Color.WHITE);
		nomeAzienda.setForeground(Color.WHITE);
		salva.setForeground(Color.WHITE);
	}

	private void dimensioni() {
		this.setMinimumSize(new Dimension(500, 300));

		codiceFiscale.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaCodiceFiscale.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		nome.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaNome.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		cognome.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaCognome.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		partitaIva.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaPartitaIva.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		nomeAzienda.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaNomeAzienda.setFont(new Font("TimesRoman", Font.ITALIC, 20));

		salva.setFont(new Font("TimesRoman", Font.BOLD, 25));
	}

	private void funzioniBottoni(FrameForNew padre) {

		salva.addActionListener(e -> {

			if (cliente.getTipologiaCliente() == "privato") {
				cliente.setCodiceFiscale(areaCodiceFiscale.getText());
				cliente.setNome(areaNome.getText());
				cliente.setCognome(areaCognome.getText());
				try {
					DbHelper.aggiungiPrivato(cliente);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (cliente.getTipologiaCliente() == "partitaiva") {
				cliente.setPartitaIva(areaPartitaIva.getText());
				cliente.setNomeAzienda(areaNomeAzienda.getText());
				try {
					DbHelper.aggiungiPartitaIva(cliente);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			try {
				DbHelper.aggiungiCliente(cliente);
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
	}

}
