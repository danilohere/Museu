package boundary;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.AutorControl;
import control.EventoControl;
import control.ObraControl;
import entity.Autor;
import entity.Evento;
import entity.Obra;

public class MainPesq implements ActionListener, ListSelectionListener  {
	private ObraControl obraControl = new ObraControl();
	private AutorControl autorControl = new AutorControl();
	private EventoControl eventoControl = new EventoControl();
	private JFrame janela = new JFrame("Museu Digital");
	private JTable tabelaObra;
	private JTable tabelaAutor;
	private JTable tabelaEvento;
	private JTextField txtPesquisa = new JTextField();
	private JButton btnPesquisar = new JButton("Pesquisar");
	private JButton btnLogar = new JButton();
	private JButton btnVerDetalhes = new JButton("Ver detalhes");
	private JButton btnAdicionar = new JButton("Adicionar");
	private JButton btnAlterar = new JButton("Alterar");
	private JButton btnExcluir = new JButton("Excluir");
	private JRadioButton rdbtnObras = new JRadioButton("Obras");
	private JRadioButton rdbtnEventos = new JRadioButton("Eventos");
	private JRadioButton rdbtnAutores = new JRadioButton("Autores");
	private ButtonGroup grupo = new ButtonGroup();
	private JScrollPane panTableObra = new JScrollPane();
	private JScrollPane panTableAutor = new JScrollPane();
	private JScrollPane panTableEvento = new JScrollPane();
	private boolean logado = false; 
	private long id;

	public MainPesq(boolean log) {
		logado = log;
		JPanel panPrincipal = new JPanel();
		JPanel panFormulario = new JPanel();
		panFormulario.setBounds(0, 90, 784, 471);
		panFormulario.setLayout(null);
		JLabel lblDigiteONome = new JLabel("Digite o Nome da Obra:");
		lblDigiteONome.setForeground(Color.WHITE);
		lblDigiteONome.setBounds(100, 86, 146, 23);
		panFormulario.add(lblDigiteONome);
		txtPesquisa.setBounds(100, 104, 475, 23);
		panFormulario.add(txtPesquisa);
		btnPesquisar.setBounds(585, 104, 100, 23);
		panFormulario.add(btnPesquisar);
		btnPesquisar.addActionListener(this);
		panPrincipal.setLayout(null);

		// PANLOGO
		JPanel panLogo = new JPanel();
		panLogo.setBounds(0, 0, 784, 90);
		panLogo.setLayout(null);
		btnLogar.setBounds(740, 10, 30, 30);
		btnLogar.addActionListener(this);
		panLogo.add(btnLogar);
		panPrincipal.add(panLogo);
		// FIM PANLOGO

		panTableObra.setBounds(50, 235, 684, 260);
		panTableAutor.setBounds(50, 235, 684, 260);
		panTableEvento.setBounds(50, 235, 684, 260);
		tabelaObra = new JTable(obraControl);
		tabelaAutor = new JTable(autorControl);
		tabelaEvento = new JTable(eventoControl);
		tabelaObra.getSelectionModel().addListSelectionListener(this);
		tabelaObra.getColumnModel().getColumn(0).setPreferredWidth(1);
		tabelaObra.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabelaObra.getColumnModel().getColumn(3).setPreferredWidth(250);
		tabelaAutor.getColumnModel().getColumn(0).setPreferredWidth(1);
		tabelaAutor.getColumnModel().getColumn(1).setPreferredWidth(200);
		tabelaAutor.getColumnModel().getColumn(2).setPreferredWidth(200);
		tabelaEvento.getColumnModel().getColumn(0).setPreferredWidth(1);
		tabelaEvento.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabelaEvento.getColumnModel().getColumn(2).setPreferredWidth(200);
		tabelaEvento.getColumnModel().getColumn(3).setPreferredWidth(50);
		panPrincipal.add(panTableObra);
		panPrincipal.add(panTableAutor);
		panPrincipal.add(panTableEvento);
		panTableObra.setViewportView(tabelaObra);
		panTableAutor.setViewportView(tabelaAutor);
		panTableEvento.setViewportView(tabelaEvento);
		panTableAutor.setVisible(false);
		panTableEvento.setVisible(false);
		
		panPrincipal.add(panFormulario);

		btnVerDetalhes.setBounds(100, 427, 120, 23);
		panFormulario.add(btnVerDetalhes);
		btnVerDetalhes.addActionListener(this);
		
		
		btnAdicionar.setBounds(255, 427, 120, 23);
		btnAdicionar.addActionListener(this);

		btnAlterar.setBounds(410, 427, 120, 23);
		btnAlterar.addActionListener(this);
		
		btnExcluir.setBounds(565, 427, 120, 23);
		btnExcluir.addActionListener(this);
		
		ImageIcon loginimg = new ImageIcon("C:\\Users\\Priscila\\git\\Museu\\Museu\\img\\login.png");
		ImageIcon logoffimg = new ImageIcon("C:\\Users\\Priscila\\git\\Museu\\Museu\\img\\logoff.png"); 
		
		btnLogar.setIcon(loginimg);
		
		if(logado == true){
			panFormulario.add(btnAdicionar);
			panFormulario.add(btnAlterar);
			panFormulario.add(btnExcluir);
			btnLogar.setIcon(logoffimg);
		}
		rdbtnObras.setForeground(Color.WHITE);
		rdbtnObras.setSelected(true);
		rdbtnObras.setBounds(100, 31, 109, 23);
		panFormulario.add(rdbtnObras);
		rdbtnObras.addActionListener(this);
		rdbtnObras.setBackground(Color.DARK_GRAY);
		
		rdbtnAutores.setForeground(Color.WHITE);
		rdbtnAutores.setBounds(337, 31, 109, 23);
		panFormulario.add(rdbtnAutores);
		rdbtnAutores.addActionListener(this);
		rdbtnAutores.setBackground(Color.DARK_GRAY);
		
		rdbtnEventos.setForeground(Color.WHITE);
		rdbtnEventos.setBounds(585, 31, 109, 23);
		panFormulario.add(rdbtnEventos);
		rdbtnEventos.addActionListener(this);
		rdbtnEventos.setBackground(Color.DARK_GRAY);

		grupo.add(rdbtnObras);
		grupo.add(rdbtnAutores);
		grupo.add(rdbtnEventos);
		
		ImageIcon bgimg = new ImageIcon("C:\\Users\\Priscila\\git\\Museu\\Museu\\img\\background.png");
		ImageIcon logoimg = new ImageIcon("C:\\Users\\Priscila\\git\\Museu\\Museu\\img\\logo.png"); 
		JLabel background = new JLabel();
		JLabel logo = new JLabel();
		background.setIcon(bgimg);
		background.setBounds(0, 0, 800, 700);
		logo.setIcon(logoimg);
		logo.setBounds(0, 0, 800, 90);
		panFormulario.add(background);
		panLogo.add(logo);
		janela.setResizable(false);
		janela.setTitle("Museu Digital");
		janela.setContentPane(panPrincipal);
		janela.setSize(790, 590);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		obraControl.pesquisar(txtPesquisa.getText());
		tabelaObra.invalidate();
		tabelaObra.revalidate();
	}

	public static void main(String[] args) {
		boolean log = true;
		new MainPesq(log);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// int linha = tabela.getSelectedRow();
		// Obra o = obraControl.getLista().get(linha);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnPesquisar) {
			if (rdbtnObras.isSelected()) {
				obraControl.pesquisar(txtPesquisa.getText());
				tabelaObra.invalidate();
				tabelaObra.revalidate();
			} else if (rdbtnAutores.isSelected()) {
				autorControl.pesquisar(txtPesquisa.getText());
				tabelaAutor.invalidate();
				tabelaAutor.revalidate();
			} else if (rdbtnEventos.isSelected()) {
				eventoControl.pesquisar(txtPesquisa.getText());
				tabelaEvento.invalidate();
				tabelaEvento.revalidate();
			}

		} else if (e.getSource() == btnAdicionar) {
			if (rdbtnObras.isSelected()) {
				new CadObraForm();
			} else if (rdbtnAutores.isSelected()) {
				new CadAutorForm();
			} else if (rdbtnEventos.isSelected()) {
				new CadEventoForm();
			}

		} else if (e.getSource() == btnLogar) {
			if (logado == false){
				janela.dispose();
				new LoginForm();
			} else {
				int i = JOptionPane.showOptionDialog(null, "Efetuar logoff?", "Logoff",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (i == JOptionPane.YES_OPTION) {
					janela.dispose();
					logado = false;
					new MainPesq(logado);
				}
			}

		} else if (e.getSource() == btnVerDetalhes) {
			if (rdbtnObras.isSelected()) {
				try {
					id = (long) tabelaObra.getValueAt(tabelaObra.getSelectedRow(), 0);
					new VerObraForm(id);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Selecione uma obra");
				}
			} else if (rdbtnAutores.isSelected()) {
				try {
					id = (long) tabelaAutor.getValueAt(tabelaAutor.getSelectedRow(), 0);
					new VerAutorForm(id);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Selecione um autor");
				}
			} else if (rdbtnEventos.isSelected()) {
				try {
					id = (long) tabelaEvento.getValueAt(tabelaEvento.getSelectedRow(), 0);
					new VerEventoForm(id);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Selecione um evento");
				}
			}

		} else if (e.getSource() == btnAlterar) {
			if (rdbtnObras.isSelected()) {
				try {
					id = (long) tabelaObra.getValueAt(tabelaObra.getSelectedRow(), 0);
					Obra o = obraControl.pesquisarPorId(id);
					new CadObraForm(o);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Selecione uma obra");
				}
			} else if (rdbtnAutores.isSelected()) {
				try {
					id = (long) tabelaAutor.getValueAt(tabelaAutor.getSelectedRow(), 0);
					Autor a = autorControl.pesquisarPorId(id);
					new CadAutorForm(a);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Selecione um autor");
				}
			} else if (rdbtnEventos.isSelected()) {
				try {
					id = (long) tabelaEvento.getValueAt(tabelaEvento.getSelectedRow(), 0);
					Evento ev = eventoControl.pesquisarPorId(id);
					new CadEventoForm(ev);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Selecione um evento");
				}
			}

		} else if (e.getSource() == btnExcluir) {
			if (rdbtnObras.isSelected()) {
				try {
					id = (long) tabelaObra.getValueAt(tabelaObra.getSelectedRow(), 0);
					int i = JOptionPane.showOptionDialog(null, "Deseja mesmo excluir?", "Excluir obra",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
					if (i == JOptionPane.YES_OPTION) {
						obraControl.excluir(id);
						obraControl.pesquisar(txtPesquisa.getText());
						tabelaObra.invalidate();
						tabelaObra.revalidate();
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Selecione uma obra");
				}
			} else if (rdbtnAutores.isSelected()) {
				try {
					id = (long) tabelaAutor.getValueAt(tabelaAutor.getSelectedRow(), 0);
					int i = JOptionPane.showOptionDialog(null, "Deseja mesmo excluir?", "Excluir autor",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
					if (i == JOptionPane.YES_OPTION) {
						autorControl.excluir(id);
						autorControl.pesquisar(txtPesquisa.getText());
						tabelaAutor.invalidate();
						tabelaAutor.revalidate();
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Selecione um autor");
				}
			} else if (rdbtnEventos.isSelected()) {
				try {
					id = (long) tabelaEvento.getValueAt(tabelaEvento.getSelectedRow(), 0);
					int i = JOptionPane.showOptionDialog(null, "Deseja mesmo excluir?", "Excluir evento",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
					if (i == JOptionPane.YES_OPTION) {
						eventoControl.excluir(id);
						eventoControl.pesquisar(txtPesquisa.getText());
						tabelaEvento.invalidate();
						tabelaEvento.revalidate();
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Selecione um evento");
				}
			}

		} else if (e.getSource() == rdbtnAutores) {
			tabelaAutor.getSelectionModel().addListSelectionListener(this);
			panTableAutor.setViewportView(tabelaAutor);
			autorControl.pesquisar(txtPesquisa.getText());
			tabelaAutor.invalidate();
			tabelaAutor.revalidate();
			panTableObra.setVisible(false);
			panTableAutor.setVisible(true);
			panTableEvento.setVisible(false);
		} else if (e.getSource() == rdbtnObras) {
			tabelaObra.getSelectionModel().addListSelectionListener(this);
			panTableObra.setViewportView(tabelaObra);
			obraControl.pesquisar(txtPesquisa.getText());
			tabelaObra.invalidate();
			tabelaObra.revalidate();
			panTableObra.setVisible(true);
			panTableAutor.setVisible(false);
			panTableEvento.setVisible(false);
		} else if (e.getSource() == rdbtnEventos) {
			tabelaEvento.getSelectionModel().addListSelectionListener(this);
			panTableEvento.setViewportView(tabelaEvento);
			eventoControl.pesquisar(txtPesquisa.getText());
			tabelaEvento.invalidate();
			tabelaEvento.revalidate();
			panTableObra.setVisible(false);
			panTableAutor.setVisible(false);
			panTableEvento.setVisible(true);

		}
	}
}
