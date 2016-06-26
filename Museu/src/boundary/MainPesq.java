package boundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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

import control.ObraControl;
import entidade.Obra;

public class MainPesq implements ActionListener, ListSelectionListener {
	private ObraControl control = new ObraControl();
	private JFrame janela = new JFrame("Cadastro de Obra");
	private JTable tabela;
	private JTextField txtPesquisa = new JTextField();
	private JButton btnPesquisar = new JButton("Pesquisar");
	private JButton btnLogar = new JButton("L");
	private JButton btnVerDetalhes = new JButton("Ver detalhes");
	private JButton btnAdicionar = new JButton("Adicionar");
	private JButton btnAlterar = new JButton("Alterar");
	private JButton btnExcluir = new JButton("Excluir");
	private long id = 0;

	public MainPesq() {
		JPanel panPrincipal = new JPanel();
		JPanel panFormulario = new JPanel();
		panFormulario.setBounds(0, 90, 584, 371);
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
		JScrollPane panTable = new JScrollPane();
		panTable.setBounds(0, 165, 584, 242);
		// FIM PANLOGO

		tabela = new JTable(control);
		tabela.getSelectionModel().addListSelectionListener(this);
		panPrincipal.add(panTable);
		panTable.setViewportView(tabela);

		panPrincipal.add(panFormulario);
		
		
		btnVerDetalhes.setBounds(35, 337, 120, 23);
		panFormulario.add(btnVerDetalhes);
		btnVerDetalhes.addActionListener(this);
		
		
		btnAdicionar.setBounds(165, 337, 120, 23);
		panFormulario.add(btnAdicionar);
		btnAdicionar.addActionListener(this);
		
		btnAlterar.setBounds(295, 337, 120, 23);
		panFormulario.add(btnAlterar);
		btnAlterar.addActionListener(this);
		
		btnExcluir.setBounds(425, 337, 120, 23);
		panFormulario.add(btnExcluir);
		btnExcluir.addActionListener(this);
		
		janela.setTitle("Museu Digital");

		janela.setContentPane(panPrincipal);

		janela.setSize(600, 500);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		control.pesquisar(txtPesquisa.getText());
		tabela.invalidate();
		tabela.revalidate();
	}

	public static void main(String[] args) {
		new MainPesq();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
	//	int linha = tabela.getSelectedRow();
	//	Obra o = control.getLista().get(linha);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == btnPesquisar) {
			control.pesquisar(txtPesquisa.getText());
			tabela.invalidate();
			tabela.revalidate();
		} else if (e.getSource() == btnAdicionar) {
			System.out.println("Botão Adicionar");
			new CadObraForm();
	    } else if (e.getSource() == btnLogar) {
			// abrir tela login
	
		} else if (e.getSource() == btnVerDetalhes) {
			id = (long) tabela.getValueAt(tabela.getSelectedRow(), 0);
			if (id != 0){
				new VerObraForm(id);
			} else {
				JOptionPane.showMessageDialog(null, "Selecione uma obra");
			}
			
	
		} else if (e.getSource() == btnAlterar) {
			// abrir tela login
	
		} else if (e.getSource() == btnExcluir) {
			id = (long) tabela.getValueAt(tabela.getSelectedRow(), 0);
			int i = JOptionPane.showOptionDialog(null, "Deseja mesmo excluir?", "Excluir obra", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if(i == JOptionPane.YES_OPTION){
				control.excluir(id);
				control.pesquisar(txtPesquisa.getText());
				tabela.invalidate();
				tabela.revalidate();
			}
			
		}
	}

}
