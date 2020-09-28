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
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import entita.Insegna;
import entita.Prodotto;
import utility.ColorView;
import utility.DbHelper;

public class PanelDetailsInsegna extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JLabel codiceInsegna = new JLabel("codice insegna");
	JLabel areaCodiceInsegna = new JLabel();
	JLabel stato = new JLabel("stato");
	JTextField areaStato = new JTextField();
	JCheckBox areaCompletamento = new JCheckBox("COMPLETATO");
	
	JLabel telaio = new JLabel("Telaio: ");
	JLabel areaTelaio = new JLabel();
	JLabel neon = new JLabel("Neon: ");
	JLabel areaNeon = new JLabel();
	JLabel led = new JLabel("Led: ");
	JLabel areaLed = new JLabel();

	JButton salva = new JButton("salva");

	JPanel grid = new JPanel(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();
	JLabel placeholder = new JLabel(" ");

	private Insegna insegna;

	PanelDetailsInsegna(Insegna insegna, FrameForDetails padre) throws ClassNotFoundException, SQLException {
		this.insegna = insegna;

		inizializzazione(insegna);
		riempiGriglia();

		this.setLayout(new BorderLayout());
		this.add(grid);

		funzioniBottoni(padre);
		colori();
		dimensioni();

		this.setVisible(true);
	}

	private void inizializzazione(Insegna i) throws ClassNotFoundException, SQLException {
		Prodotto telaio = DbHelper.getTelaioOrdinato(i.getCodiceInsegna());
		areaTelaio.setText(telaio.getBottone().getText());
		Prodotto neon = DbHelper.getBaseOrdinata(i.getCodiceInsegna());
		areaNeon.setText(neon.getBottone().getText());
		Prodotto led = DbHelper.getLedOrdinato(i.getCodiceInsegna());
		areaLed.setText(led.getBottone().getText());
		
		areaCodiceInsegna.setText(i.getCodiceInsegna());
		areaStato.setText(i.getStato());
	}

	private void riempiGriglia() {
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(7, 7, 7, 7);

		grid.add(codiceInsegna, gbc);
		gbc.gridx++;
		grid.add(areaCodiceInsegna, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		
		grid.add(telaio, gbc);
		gbc.gridx++;
		grid.add(areaTelaio, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		grid.add(neon, gbc);
		gbc.gridx++;
		grid.add(areaNeon, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		grid.add(led, gbc);
		gbc.gridx++;
		grid.add(areaLed, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		
		grid.add(stato, gbc);
		gbc.gridx++;
		grid.add(areaStato, gbc);
		gbc.gridx = 0;
		gbc.gridy++;

		gbc.fill = GridBagConstraints.NONE;
		gbc.gridwidth = 2;
		grid.add(areaCompletamento, gbc);
		gbc.gridx = 0;
		gbc.gridy++;

		gbc.fill = GridBagConstraints.NONE;
		gbc.gridwidth = 2;
		grid.add(salva, gbc);
		;
	}

	private void colori() {
		this.setBackground(ColorView.myGray());
		grid.setBackground(ColorView.myGray());
		areaCompletamento.setBackground(ColorView.myGray());
		salva.setBackground(ColorView.myOrange());

		codiceInsegna.setForeground(Color.WHITE);
		areaCodiceInsegna.setForeground(Color.WHITE);
		telaio.setForeground(Color.WHITE);
		areaTelaio.setForeground(Color.WHITE);
		neon.setForeground(Color.WHITE);
		areaNeon.setForeground(Color.WHITE);
		led.setForeground(Color.WHITE);
		areaLed.setForeground(Color.WHITE);
		stato.setForeground(Color.WHITE);
		salva.setForeground(Color.WHITE);
		areaCompletamento.setForeground(Color.WHITE);
	}

	private void dimensioni() {
		this.setMinimumSize(new Dimension(500, 300));

		codiceInsegna.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaCodiceInsegna.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		telaio.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaTelaio.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		neon.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaNeon.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		led.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaLed.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		stato.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaStato.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		areaCompletamento.setFont(new Font("TimesRoman", Font.BOLD, 22));

		salva.setFont(new Font("TimesRoman", Font.BOLD, 25));

		areaStato.setPreferredSize(new Dimension(200, 30));
	}

	private void funzioniBottoni(FrameForDetails padre) {

		salva.addActionListener(e -> {

			insegna.setStato(areaStato.getText());

			DbHelper.aggiornaInsegna(insegna, areaCompletamento.isSelected());
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
