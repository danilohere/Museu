package boundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import control.ObraControl;
import entidade.Obra;
import javax.swing.SwingConstants;

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
	private JButton btnUpload = new JButton("Upload Imagem");
	private ObraControl control = new ObraControl();
	private JLabel lblimagem = new JLabel("Imagem");
	private	JLabel lblnome = new JLabel("Nome");
	private JLabel lblautor = new JLabel("Autor");
	private JLabel lbldesc = new JLabel("Descrição");
	private JLabel lblcat = new JLabel("Categoria");
	private JLabel lblmaterial = new JLabel("Material");
	private JLabel lbldimensoes = new JLabel("Dimensões");
	private JLabel lblano = new JLabel("Ano");	

	public CadObraForm() {
		JPanel panPrincipal = new JPanel();
		JPanel panFormulario = new JPanel();
		panFormulario.setBounds(0, 90, 484, 371);
		
		panFormulario.setLayout(null);
		panPrincipal.setLayout(null);
				

		lblnome.setBounds(10, 7, 146, 23);
		panFormulario.add(lblnome);
		txtNome.setBounds(69, 7, 171, 23);
		panFormulario.add(txtNome);
		
		lblautor.setBounds(10, 41, 146, 23);
		panFormulario.add(lblautor);
		txtAutor.setBounds(69, 41, 171, 23);
		panFormulario.add(txtAutor);
		
		lbldesc.setBounds(10, 75, 146, 23);
		panFormulario.add(lbldesc);
		txtDescricao.setBounds(69, 75, 171, 58);
		panFormulario.add(txtDescricao);
		
		lblcat.setBounds(10, 144, 146, 23);
		panFormulario.add(lblcat);
		txtCategoria.setBounds(69, 144, 171, 23);
		panFormulario.add(txtCategoria);
		
		lblmaterial.setBounds(10, 178, 146, 23);
		panFormulario.add(lblmaterial);
		txtMaterial.setBounds(69, 178, 171, 23);
		panFormulario.add(txtMaterial);
		
		lbldimensoes.setBounds(10, 212, 146, 23);
		panFormulario.add(lbldimensoes);
		txtDimensoes.setBounds(69, 212, 171, 23);
		panFormulario.add(txtDimensoes);
		txtAno.setBounds(69, 246, 84, 23);
		panFormulario.add(txtAno);
		
		btnAdicionar.setBounds(10, 311, 230, 23);
		panFormulario.add(btnAdicionar);
		btnAdicionar.addActionListener(this);
		btnCancelar.setBounds(244, 311, 230, 23);
		panFormulario.add(btnCancelar);
		btnCancelar.addActionListener(this);
		panFormulario.add(btnUpload);
		btnUpload.setBounds(309, 212, 107, 23);
		panFormulario.add(lblimagem);
		btnUpload.addActionListener(this);
		lblimagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblimagem.setBounds(250, 11, 224, 192);
		
		//PANLOGO
		JPanel panLogo = new JPanel();
		panLogo.setBounds(0, 0, 484, 90);
		panLogo.setLayout(null);
		panPrincipal.add(panLogo);
		//FIM PANLOGO
		
		panPrincipal.add(panFormulario);
		
		lblano.setBounds(10, 246, 146, 23);
		panFormulario.add(lblano);
		panPrincipal.add(panLogo);
				

		janela.setContentPane(panPrincipal);
		
		janela.setSize(500, 500);
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

		} else if (e.getSource() == btnCancelar) {
//		fechar janela
		} else if (e.getSource() == btnUpload) {
			
		}

	}
}
