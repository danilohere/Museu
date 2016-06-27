package boundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.sun.glass.events.KeyEvent;

import control.AutorControl;
import control.EventoControl;
import control.ObraControl;
import entidade.Obra;
import javax.swing.JRadioButton;

public class MainPesq implements ActionListener, ListSelectionListener {
	private ObraControl obraControl = new ObraControl();
	private AutorControl autorControl = new AutorControl();
	private EventoControl eventoControl = new EventoControl();
	// private EventoControl eventoControl = new EventoControl();
	private JFrame janela = new JFrame("Museu Digital");
	private JTable tabelaObra;
	private JTable tabelaAutor;
	private JTable tabelaEvento;
	private JTextField txtPesquisa = new JTextField();
	private JButton btnPesquisar = new JButton("Pesquisar");
	private JButton btnLogar = new JButton("L");
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
	private long id;

	public MainPesq() {
		JPanel panPrincipal = new JPanel();
		JPanel panFormulario = new JPanel();
		panFormulario.setBounds(0, 90, 784, 471);
		panFormulario.setLayout(null);
		JLabel lblDigiteONome = new JLabel("Digite o Nome da Obra:");
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
		btnLogar.setBounds(728, 56, 46, 23);
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
		panFormulario.add(btnAdicionar);
		btnAdicionar.addActionListener(this);

		btnAlterar.setBounds(410, 427, 120, 23);
		panFormulario.add(btnAlterar);
		btnAlterar.addActionListener(this);

		btnExcluir.setBounds(565, 427, 120, 23);
		panFormulario.add(btnExcluir);

		rdbtnObras.setSelected(true);
		// rdbtnObras.setMnemonic(KeyEvent.VK_C);
		rdbtnObras.setBounds(100, 31, 109, 23);
		panFormulario.add(rdbtnObras);
		rdbtnObras.addActionListener(this);

		rdbtnAutores.setBounds(337, 31, 109, 23);
		panFormulario.add(rdbtnAutores);
		rdbtnAutores.addActionListener(this);

		rdbtnEventos.setBounds(585, 31, 109, 23);
		panFormulario.add(rdbtnEventos);
		rdbtnEventos.addActionListener(this);

		grupo.add(rdbtnObras);
		grupo.add(rdbtnAutores);
		grupo.add(rdbtnEventos);

		btnExcluir.addActionListener(this);

		janela.setTitle("Museu Digital");

		janela.setContentPane(panPrincipal);

		janela.setSize(800, 600);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		obraControl.pesquisar(txtPesquisa.getText());
		tabelaObra.invalidate();
		tabelaObra.revalidate();
	}

	public static void main(String[] args) {
		new MainPesq();
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

			} else if (rdbtnEventos.isSelected()) {

			}

		} else if (e.getSource() == btnAdicionar) {
			if (rdbtnObras.isSelected()) {
				new CadObraForm();
			} else if (rdbtnAutores.isSelected()) {

			} else if (rdbtnEventos.isSelected()) {

			}

		} else if (e.getSource() == btnLogar) {
			// abrir tela login

		} else if (e.getSource() == btnVerDetalhes) {
			if (rdbtnObras.isSelected()) {
				try {
					id = (long) tabelaObra.getValueAt(tabelaObra.getSelectedRow(), 0);
					new VerObraForm(id);
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Selecione uma obra");
				}
			} else if (rdbtnAutores.isSelected()) {

			} else if (rdbtnEventos.isSelected()) {

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

			} else if (rdbtnEventos.isSelected()) {

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

			} else if (rdbtnEventos.isSelected()) {

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
