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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entita.Cliente;
import utility.ColorView;
import utility.DbHelper;

public class PanelNewCliente extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel numeroTelefono = new JLabel("numero di telefono");
	JTextField areaNumeroTelefono = new JTextField(15);
	JLabel email = new JLabel("email");
	JTextField areaEmail = new JTextField(15);

	JLabel tipologia = new JLabel("tipologia");
	String[] tipologie = { "privato", "partitaiva" };
	JComboBox<String> areaTipologia = new JComboBox<>(tipologie);

	JPanel grid = new JPanel(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();
	JButton dettagli = new JButton("dettagli");
	JLabel placeholder = new JLabel(" ");

	public PanelNewCliente(JFrame padre) {

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
		gbc.insets = new Insets(4, 4, 4, 4);

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
		gbc.fill = GridBagConstraints.NONE;
		gbc.gridwidth = 2;
		grid.add(dettagli, gbc);
	}

	private void colori() {
		this.setBackground(ColorView.myGray());
		grid.setBackground(ColorView.myGray());
		dettagli.setBackground(ColorView.myOrange());
		numeroTelefono.setForeground(Color.WHITE);
		email.setForeground(Color.WHITE);
		tipologia.setForeground(Color.WHITE);
		dettagli.setForeground(Color.WHITE);
		areaTipologia.setBackground(Color.WHITE);
	}

	private void dimensioni() {
		this.setMinimumSize(new Dimension(500, 300));

		numeroTelefono.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaNumeroTelefono.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		email.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaEmail.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		tipologia.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaTipologia.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		dettagli.setFont(new Font("TimesRoman", Font.BOLD, 25));
	}

	private void funzioniBottoni(JFrame padre) {
		dettagli.addActionListener(e -> {

			String codice_cliente = "0";
			try {
				codice_cliente = DbHelper.maxClienti();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Cliente cliente = new Cliente(codice_cliente, "0", areaNumeroTelefono.getText(), areaEmail.getText(),
					((FrameForNew) padre).getCreatore().getCodiceLavoratore(),
					areaTipologia.getSelectedItem().toString(), "x", "x", "x", "x", "x");

			((FrameForNew) padre).cambiaPanel(this, "cliente", areaTipologia.getSelectedItem().toString(), cliente);
		});
	}
}
