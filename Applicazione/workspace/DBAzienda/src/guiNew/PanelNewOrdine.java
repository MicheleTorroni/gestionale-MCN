package guiNew;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import entita.Cliente;
import entita.Insegna;
import entita.Ordine;
import entita.Prodotto;
import entita.Tappeto;
import utility.ColorView;
import utility.DbHelper;

public class PanelNewOrdine extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel grid;
	GridBagConstraints gbc;

	JLabel cliente = new JLabel("Cliente: ");
	ArrayList<Cliente> listaClienti = new ArrayList<>();
	JComboBox<String> areaCliente = new JComboBox<>();
	JLabel prezzo = new JLabel("Prezzo: ");
	JTextField areaPrezzo = new JTextField(15);
	JLabel listatappeto;
	JLabel listainsegna;
	JScrollPane scrolltappeto;
	JScrollPane scrollinsegna;
	JButton newtappeto;
	JButton newinsegna;
	JButton salva = new JButton("SALVA");
	JLabel placeholder;

	JPanel paneltappeto;
	JPanel panelinsegna;

	ArrayList<Tappeto> listaTappeti = new ArrayList<>();
	ArrayList<Insegna> listaInsegne = new ArrayList<>();
	ArrayList<Prodotto> listaProdottiOrdinati = new ArrayList<>();
	ArrayList<Prodotto> prodottidaeliminare = new ArrayList<>();

	ArrayList<JButton> listaJLabelTappeti = new ArrayList<>();
	ArrayList<JButton> listaJLabelInsegne = new ArrayList<>();

	FrameForNew padre;

	public PanelNewOrdine(FrameForNew padre) throws ClassNotFoundException, SQLException {
		this.padre = padre;
		inizializzaVariabili();

		this.setLayout(new BorderLayout());
		this.add(grid);

		funzioniBottoni(padre);
		dimensioni();
		settaggioScroll();
		riempiGriglia();
		colori();
	}

	private void inizializzaVariabili() throws ClassNotFoundException, SQLException {

		listaClienti = DbHelper.getClienti();
		for (Cliente c : listaClienti) {
			areaCliente.addItem(c.getBottone().getText());
		}

		grid = new JPanel(new GridBagLayout());
		gbc = new GridBagConstraints();
		listatappeto = new JLabel("Lista tappeto");
		listainsegna = new JLabel("Lista insegna");
		scrolltappeto = new JScrollPane();
		scrollinsegna = new JScrollPane();
		newtappeto = new JButton("nuovo tappeto");
		newinsegna = new JButton("nuova insegna");
		placeholder = new JLabel("");

		paneltappeto = new JPanel(new GridLayout(0, 1));
		panelinsegna = new JPanel(new GridLayout(0, 1));
	}

	private void funzioniBottoni(FrameForNew padre) {

		newtappeto.addActionListener(e -> {
			try {
				new FrameForNewTappetoInsegna("tappeto", this);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		newinsegna.addActionListener(e -> {
			try {
				new FrameForNewTappetoInsegna("insegna", this);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		salva.addActionListener(e -> {

			for (Prodotto p : listaProdottiOrdinati) {
				DbHelper.aggiungiProdottoOrdinato(p);
			}

			for (Insegna i : listaInsegne)
				try {
					DbHelper.aggiungiInsegna(i);
				} catch (ClassNotFoundException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				} catch (SQLException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			for (Tappeto t : listaTappeti)
				try {
					DbHelper.aggiungiTappeto(t);
				} catch (ClassNotFoundException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}

			String codice_ordine = "0";
			try {
				codice_ordine = DbHelper.maxOrdini();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			Ordine o = new Ordine(codice_ordine, "x", areaPrezzo.getText(),
					listaClienti.get(areaCliente.getSelectedIndex()).getCodiceCliente(),
					padre.getCreatore().getCodiceLavoratore());
			try {
				DbHelper.aggiungiOrdine(o);
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
			
			try {
				DbHelper.aggiornaIndiceVenditore(padre.getCreatore().getCodiceLavoratore());
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				DbHelper.aggiornaIndiceCliente(listaClienti.get(areaCliente.getSelectedIndex()).getCodiceCliente());
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});

	}
	
	private void funzioniBottoniTappetiEInsegne() {
		for(JButton button : listaJLabelTappeti) {
			for( ActionListener al : button.getActionListeners() ) {
		        button.removeActionListener( al );
		    }
			button.addActionListener(e->{
				 int dialogResult = JOptionPane.showConfirmDialog (null, "vuoi eliminare questo tappeto dall'ordine?","Warning",JOptionPane.YES_NO_OPTION);
					if(dialogResult == JOptionPane.YES_OPTION) {
						Tappeto tappeto = listaTappeti.get(listaJLabelTappeti.indexOf(button));
						String codiceTappeto = tappeto.getCodiceTappeto();
						for(Prodotto p : listaProdottiOrdinati) {
							if(p.getCodiceTappeto().equals(codiceTappeto)) {
								prodottidaeliminare.add(p);
							}
						}
						for(Prodotto p:prodottidaeliminare) {
							listaProdottiOrdinati.remove(p);
						}
						prodottidaeliminare.clear();
						listaTappeti.remove(tappeto);
						listaJLabelTappeti.remove(button);
						paneltappeto.remove(button);
						this.refresh();
					} else {
						
					}
			});
		}
		
		for(JButton button : listaJLabelInsegne) {
			for( ActionListener al : button.getActionListeners() ) {
		        button.removeActionListener( al );
		    }
			button.addActionListener(e->{
				 int dialogResult = JOptionPane.showConfirmDialog (null, "vuoi eliminare questa insegna dall'ordine?","Warning",JOptionPane.YES_NO_OPTION);
					if(dialogResult == JOptionPane.YES_OPTION) {
						Insegna insegna = listaInsegne.get(listaJLabelInsegne.indexOf(button));
						String codiceInsegna = insegna.getCodiceInsegna();
						for(Prodotto p : listaProdottiOrdinati) {
							if(p.getCodiceTappeto().equals(codiceInsegna)) {
								prodottidaeliminare.add(p);
							}
						}
						for(Prodotto p:prodottidaeliminare) {
							listaProdottiOrdinati.remove(p);
						}
						prodottidaeliminare.clear();
						listaInsegne.remove(insegna);
						listaJLabelInsegne.remove(button);
						panelinsegna.remove(button);
						this.refresh();
					} else {
						
					}
			});
		}
	}

	private void settaggioScroll() {
		scrolltappeto.setPreferredSize(new Dimension(600, 500));
		scrollinsegna.setPreferredSize(new Dimension(600, 500));
		scrolltappeto.setViewportView(paneltappeto);
		scrollinsegna.setViewportView(panelinsegna);
		scrolltappeto.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollinsegna.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	}

	private void riempiGriglia() {
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10, 10, 10, 10);

		grid.add(cliente, gbc);
		gbc.gridx++;
		grid.add(areaCliente, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		grid.add(prezzo, gbc);
		gbc.gridx++;
		grid.add(areaPrezzo, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		grid.add(listatappeto, gbc);
		gbc.gridx++;
		grid.add(listainsegna, gbc);
		gbc.gridx = 0;
		gbc.gridy++;

		grid.add(scrolltappeto, gbc);
		gbc.gridx++;
		grid.add(scrollinsegna, gbc);
		gbc.gridx = 0;
		gbc.gridy++;

		grid.add(newtappeto, gbc);
		gbc.gridx++;
		grid.add(newinsegna, gbc);
		gbc.gridx = 0;
		gbc.gridy++;

		gbc.gridwidth = 5;
		grid.add(salva, gbc);
	}

	private void colori() {
		this.setBackground(ColorView.myGray());
		grid.setBackground(ColorView.myGray());

		newtappeto.setBackground(ColorView.myOrange());
		newinsegna.setBackground(ColorView.myOrange());
		salva.setBackground(ColorView.myOrange());

		listatappeto.setForeground(Color.WHITE);
		listainsegna.setForeground(Color.WHITE);
		newtappeto.setForeground(Color.WHITE);
		newinsegna.setForeground(Color.WHITE);
		prezzo.setForeground(Color.WHITE);
		salva.setForeground(Color.WHITE);

		cliente.setForeground(Color.WHITE);
	}

	private void dimensioni() {

		listatappeto.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		listainsegna.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		cliente.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaCliente.setFont(new Font("TimesRoman", Font.ITALIC, 20));
		prezzo.setFont(new Font("TimesRoman", Font.PLAIN, 20));
		areaPrezzo.setFont(new Font("TimesRoman", Font.ITALIC, 20));

		areaCliente.setPreferredSize(new Dimension(500, 50));
		areaPrezzo.setPreferredSize(new Dimension(500, 50));

		newtappeto.setFont(new Font("TimesRoman", Font.BOLD, 25));
		newinsegna.setFont(new Font("TimesRoman", Font.BOLD, 25));
		salva.setFont(new Font("TimesRoman", Font.BOLD, 25));

	}

	public void refresh() {
		this.setVisible(false);

		for (JButton label : listaJLabelTappeti)
			paneltappeto.add(label);
		for (JButton label : listaJLabelInsegne)
			panelinsegna.add(label);
		settaggioScroll();
		funzioniBottoniTappetiEInsegne();

		this.setVisible(true);
	}

	public void aggiungiTappeto(Tappeto t) {
		listaTappeti.add(t);
		listaJLabelTappeti.add(new JButton(t.getBottone().getText()));
		refresh();
	}

	public void aggiungiInsegna(Insegna i) {
		listaInsegne.add(i);
		listaJLabelInsegne.add(new JButton(i.getBottone().getText()));
		refresh();
	}

	public void aggiungiProdottoOrdinato(Prodotto p) {
		listaProdottiOrdinati.add(p);
	}

	public String getCodiceLavoratore() {
		return padre.getCreatore().getCodiceLavoratore();
	}

}
