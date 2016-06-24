package boundary;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import control.ObraControl;
import entidade.Obra;

public class MainPesq implements ActionListener, ListSelectionListener {
	private ObraControl control = new ObraControl();
	private JFrame janela = new JFrame("Cadastro de Obra");
	private JTable tabela;
	private JTextField txtPesquisa = new JTextField();
	private JButton btnPesquisar = new JButton("Pesquisar");
	private JButton btnLogar = new JButton("L");

	public MainPesq() {
		JPanel panPrincipal = new JPanel();
		JScrollPane panTable = new JScrollPane();
		panTable.setBounds(0, 165, 584, 295);
		JPanel panFormulario = new JPanel();
		panFormulario.setBounds(0, 90, 584, 75);
		panFormulario.setLayout(null);
		JLabel lblDigiteONome = new JLabel("Digite o Nome da Obra:");
		lblDigiteONome.setBounds(32, 11, 146, 23);
		panFormulario.add(lblDigiteONome);
		txtPesquisa.setBounds(32, 34, 399, 23);
		panFormulario.add(txtPesquisa);
		btnPesquisar.setBounds(445, 34, 100, 23);
		panFormulario.add(btnPesquisar);
		btnPesquisar.addActionListener(this);
		panPrincipal.setLayout(null);

		// PANLOGO
		JPanel panLogo = new JPanel();
		panLogo.setBounds(0, 0, 584, 90);
		panLogo.setLayout(null);
		btnLogar.setBounds(528, 56, 46, 23);
		panLogo.add(btnLogar);
		panPrincipal.add(panLogo);
		// FIM PANLOGO

		tabela = new JTable(control);
		tabela.getSelectionModel().addListSelectionListener(this);

		panPrincipal.add(panFormulario);
		panPrincipal.add(panTable);
		panTable.setViewportView(tabela);
		janela.setTitle("Museu Digital");

		janela.setContentPane(panPrincipal);

		janela.setSize(600, 500);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MainPesq();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int linha = tabela.getSelectedRow();
		Obra o = control.getLista().get(linha);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnPesquisar) {
			List<Obra> lista = control.pesquisar(txtPesquisa.getText());
			tabela.invalidate();
			tabela.revalidate();
		} else if (e.getSource() == btnLogar) {
			// fechar janela
			// tabela.invalidate();
			// tabela.revalidate();
		}
	}

}
