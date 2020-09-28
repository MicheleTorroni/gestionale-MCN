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

import entita.Prodotto;
import utility.ColorView;
import utility.DbHelper;

public class PanelNewProdottoDettagliato extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// -------------------------materialetop
	JLabel tipologiaTop = new JLabel("tipologia top");
	JTextField areaTipologiaTop = new JTextField(15);
	JLabel colore = new JLabel("colore");
	JTextField areaColore = new JTextField(15);
	JLabel tipoLama = new JLabel("tipo lama");
	JTextField areaTipoLama = new JTextField(15);
	// costoM2
	// -------------------------base
	JLabel tipologiaBase = new JLabel("tipologia base");
	JTextField areaTipologiaBase = new JTextField(15);
	// tipoLama
	// costoM2
	// -------------------------antinciampo
	JLabel tipologiaAntinciampo = new JLabel("tipologia antinciampo");
	JTextField areaTipologiaAntinciampo = new JTextField(15);
	// tipoLama
	// costoM2
	// -------------------------neon
	JLabel costoM = new JLabel("costo m");
	JTextField areaCostoM = new JTextField(15);
	// -------------------------led
	JLabel costoUnitario = new JLabel("costo unitario");
	JTextField areaCostoUnitario = new JTextField(15);
	// -------------------------materialetelaio
	JLabel tipologiaTelaio = new JLabel("tipologia telaio");
	JTextField areaTipologiaTelaio = new JTextField(15);
	JLabel tipoFresa = new JLabel("tipo fresa");
	JTextField areaTipoFresa = new JTextField(15);
	JLabel costoM2 = new JLabel("costo mQ");
	JTextField areaCostoM2 = new JTextField(15);

	JButton salva = new JButton("salva");

	JPanel grid = new JPanel(new GridBagLayout());
	GridBagConstraints gbc = new GridBagConstraints();
	JLabel placeholder = new JLabel(" ");

	Prodotto prodotto;

	public PanelNewProdottoDettagliato(String tipo, FrameForNew padre, Prodotto prodotto) {

		this.prodotto = prodotto;
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
		case "materialetop":
			grid.add(tipologiaTop, gbc);
			gbc.gridx++;
			grid.add(areaTipologiaTop, gbc);
			gbc.gridx = 0;
			gbc.gridy++;
			grid.add(colore, gbc);
			gbc.gridx++;
			grid.add(areaColore, gbc);
			gbc.gridx = 0;
			gbc.gridy++;
			grid.add(tipoLama, gbc);
			gbc.gridx++;
			grid.add(areaTipoLama, gbc);
			gbc.gridx = 0;
			gbc.gridy++;
			grid.add(costoM2, gbc);
			gbc.gridx++;
			grid.add(areaCostoM2, gbc);
			gbc.gridx = 0;
			gbc.gridy++;
			break;
		case "base":
			grid.add(tipologiaBase, gbc);
			gbc.gridx++;
			grid.add(areaTipologiaBase, gbc);
			;
			gbc.gridx = 0;
			gbc.gridy++;
			grid.add(tipoLama, gbc);
			gbc.gridx++;
			grid.add(areaTipoLama, gbc);
			gbc.gridx = 0;
			gbc.gridy++;
			grid.add(costoM2, gbc);
			gbc.gridx++;
			grid.add(areaCostoM2, gbc);
			gbc.gridx = 0;
			gbc.gridy++;
			break;
		case "antinciampo":
			grid.add(tipologiaAntinciampo, gbc);
			gbc.gridx++;
			grid.add(areaTipologiaAntinciampo, gbc);
			;
			gbc.gridx = 0;
			gbc.gridy++;
			grid.add(tipoLama, gbc);
			gbc.gridx++;
			grid.add(areaTipoLama, gbc);
			gbc.gridx = 0;
			gbc.gridy++;
			grid.add(costoM, gbc);
			gbc.gridx++;
			grid.add(areaCostoM, gbc);
			gbc.gridx = 0;
			gbc.gridy++;
			break;
		case "neon":
			grid.add(costoM, gbc);
			gbc.gridx++;
			grid.add(areaCostoM, gbc);
			;
			gbc.gridx = 0;
			gbc.gridy++;
			break;
		case "led":
			grid.add(costoUnitario, gbc);
			gbc.gridx++;
			grid.add(areaCostoUnitario, gbc);
			;
			gbc.gridx = 0;
			gbc.gridy++;
			break;
		case "materialetelaio":
			grid.add(tipologiaTelaio, gbc);
			gbc.gridx++;
			grid.add(areaTipologiaTelaio, gbc);
			gbc.gridx = 0;
			gbc.gridy++;
			grid.add(tipoFresa, gbc);
			gbc.gridx++;
			grid.add(areaTipoFresa, gbc);
			gbc.gridx = 0;
			gbc.gridy++;
			grid.add(costoM2, gbc);
			gbc.gridx++;
			grid.add(areaCostoM2, gbc);
			gbc.gridx = 0;
			gbc.gridy++;
			break;
		default:
			System.out.println("errore scelta tipo materiale");

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

		tipologiaTop.setForeground(Color.WHITE);
		colore.setForeground(Color.WHITE);
		tipoLama.setForeground(Color.WHITE);
		tipologiaBase.setForeground(Color.WHITE);
		tipologiaAntinciampo.setForeground(Color.WHITE);
		costoM.setForeground(Color.WHITE);
		costoUnitario.setForeground(Color.WHITE);
		tipologiaTelaio.setForeground(Color.WHITE);
		tipoFresa.setForeground(Color.WHITE);
		costoM2.setForeground(Color.WHITE);
		salva.setForeground(Color.WHITE);
	}

	private void dimensioni() {
		this.setMinimumSize(new Dimension(500, 300));

		tipologiaTop.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaTipologiaTop.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		tipologiaAntinciampo.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaTipologiaAntinciampo.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		colore.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaColore.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		tipoLama.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaTipoLama.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		tipologiaBase.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaTipologiaBase.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		costoM.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaCostoM.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		costoUnitario.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaCostoUnitario.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		tipologiaTelaio.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaTipologiaTelaio.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		tipoFresa.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaTipoFresa.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		costoM2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaCostoM2.setFont(new Font("TimesRoman", Font.ITALIC, 20));

		salva.setFont(new Font("TimesRoman", Font.BOLD, 25));
	}

	private void funzioniBottoni(FrameForNew padre) {

		salva.addActionListener(e -> {
			String tipologiaProdotto = prodotto.getTipologiaProdotto();
			if (tipologiaProdotto == "materialetop") {
				prodotto.setTipologiaTop(areaTipologiaTop.getText());
				prodotto.setColore(areaColore.getText());
				prodotto.setTipoLama(areaTipoLama.getText());
				prodotto.setCostoM2(areaCostoM2.getText());
				try {
					DbHelper.aggiungiMaterialeTop(prodotto);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (tipologiaProdotto == "base") {
				prodotto.setTipologiaBase(areaTipologiaBase.getText());
				prodotto.setTipoLama(areaTipoLama.getText());
				prodotto.setCostoM2(areaCostoM2.getText());
				try {
					DbHelper.aggiungiBase(prodotto);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (tipologiaProdotto == "antinciampo") {
				prodotto.setTipologiaAntinciampo(areaTipologiaAntinciampo.getText());
				prodotto.setTipoLama(areaTipoLama.getText());
				prodotto.setCostoM(areaCostoM.getText());
				try {
					DbHelper.aggiungiAntinciampo(prodotto);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (tipologiaProdotto == "materialetelaio") {
				prodotto.setTipologiaTelaio(areaTipologiaTelaio.getText());
				prodotto.setTipoFresa(areaTipoFresa.getText());
				prodotto.setCostoM2(areaCostoM2.getText());
				try {
					DbHelper.aggiungiMaterialeTelaio(prodotto);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (tipologiaProdotto == "neon") {
				prodotto.setCostoM(areaCostoM.getText());
				try {
					DbHelper.aggiungiNeon(prodotto);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (tipologiaProdotto == "led") {
				prodotto.setCostoUnitario(areaCostoUnitario.getText());
				try {
					DbHelper.aggiungiLed(prodotto);
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			System.out.println(prodotto.getBottone().getText());

			try {
				DbHelper.aggiungiProdotto(prodotto);
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
