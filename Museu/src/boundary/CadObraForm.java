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

public class CadObraForm implements ActionListener {
	private JFrame janela = new JFrame("Cadastro de Obra");
	private JTextField txtNome = new JTextField();
	private JTextField txtAutor = new JTextField();
	private JTextArea txtDescricao = new JTextArea(1, 50);
	private JTextField txtCategoria = new JTextField();
	private JTextField txtMaterial = new JTextField();
	private JTextField txtDimensoes = new JTextField();
	private JTextField txtAno = new JTextField();
	private JButton btnAdicionar = new JButton("Adicionar");
	private JButton btnCancelar = new JButton("Cancelar");
	private ObraControl control = new ObraControl();
	private JTable tabela;

	public CadObraForm() {
		JPanel panPrincipal = new JPanel(new BorderLayout());
		JScrollPane panTable = new JScrollPane();
		JPanel panFormulario = new JPanel(new GridLayout(5, 2));
		panFormulario.add(new JLabel("Nome"));
		panFormulario.add(txtNome);
		panFormulario.add(new JLabel("Autor"));
		panFormulario.add(txtAutor);
		panFormulario.add(new JLabel("Descrição"));
		panFormulario.add(txtDescricao);
		panFormulario.add(new JLabel("Categoria"));
		panFormulario.add(txtCategoria);
		panFormulario.add(new JLabel("Material"));
		panFormulario.add(txtMaterial);
		panFormulario.add(new JLabel("Dimensões"));
		panFormulario.add(txtDimensoes);
		panFormulario.add(new JLabel("Ano"));
		panFormulario.add(txtAno);
		panFormulario.add(btnAdicionar);
		panFormulario.add(btnCancelar);
		btnAdicionar.addActionListener(this);
		btnCancelar.addActionListener(this);

		panPrincipal.add(panFormulario, BorderLayout.NORTH);
		panPrincipal.add(panTable, BorderLayout.CENTER);


//		Pesquisar
//		tabela = new JTable(control);
//		tabela.getSelectionModel().addListSelectionListener(this);

		panTable.getViewport().add(tabela);

		janela.setContentPane(panPrincipal);

		janela.setSize(600, 400);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public Obra formToObra() {
		Obra o = new Obra();
		o.setNome(txtNome.getText());
		o.setAutor(txtAutor.getText());
		o.setDescricao(txtDescricao.getText());
		o.setCategoria(txtCategoria.getText());
		o.setMaterial(txtMaterial.getText());
		o.setDimensoes(txtDimensoes.getText());
		o.setAno(Integer.parseInt(txtNome.getText()));
		return o;
	}

	private void obraToForm(Obra o) {
		txtNome.setText(o.getNome());
		txtAutor.setText(o.getAutor());
		txtCategoria.setText(o.getCategoria());
		txtDescricao.setText(o.getDescricao());
		txtMaterial.setText(o.getMaterial());
		txtDimensoes.setText(o.getDimensoes());
		txtAno.setText(String.valueOf(o.getAno()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdicionar) {
			control.adicionar(formToObra());
			tabela.invalidate();
			tabela.revalidate();
		} else if (e.getSource() == btnCancelar) {
//fechar janela
		}

	}

//	Pesquisar
//	@Override
//	public void valueChanged(ListSelectionEvent e) {
//		int linha = tabela.getSelectedRow();
//		Obra o = control.getLista().get(linha);
//		obraToForm(o);
//		System.out.println(" Linha selecionada " + linha);
//	}
}
