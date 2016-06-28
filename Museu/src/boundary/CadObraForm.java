package boundary;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import control.ObraControl;
import entidade.Obra;
import javax.swing.SwingConstants;

public class CadObraForm implements ActionListener {
	private JFrame janela = new JFrame("Cadastro de Obra");
	private JTextField txtNome = new JTextField();
	private JTextField txtAutor = new JTextField();
	private JTextArea txtDescricao = new JTextArea(1, 1);
	private JTextField txtCategoria = new JTextField();
	private JTextField txtMaterial = new JTextField();
	private JTextField txtDimensoes = new JTextField();
	private JTextField txtAno = new JTextField();
	private JButton btnAdicionar = new JButton("Adicionar");
	private JButton btnAlterar = new JButton("Alterar");
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
	private long id;

	public CadObraForm() {
		JPanel panPrincipal = new JPanel();
		JPanel panFormulario = new JPanel();
		panFormulario.setBounds(0, 90, 584, 371);
		panFormulario.setLayout(null);
		panPrincipal.setLayout(null);
		
		//PANLOGO
		JPanel panLogo = new JPanel();
		panLogo.setBounds(0, 0, 584, 90);
		panLogo.setLayout(null);
		panPrincipal.add(panLogo);
		//FIM PANLOGO
		
		lblnome.setBounds(10, 7, 146, 23);
		lblnome.setForeground(Color.WHITE);
		panFormulario.add(lblnome);
		txtNome.setBounds(91, 7, 230, 23);
		panFormulario.add(txtNome);
		
		lblautor.setBounds(10, 41, 146, 23);
		lblautor.setForeground(Color.WHITE);
		panFormulario.add(lblautor);
		txtAutor.setBounds(91, 41, 230, 23);
		panFormulario.add(txtAutor);
		
		lbldesc.setBounds(10, 75, 146, 23);
		lbldesc.setForeground(Color.WHITE);
		panFormulario.add(lbldesc);
		
		txtDescricao.setTabSize(1);
		txtDescricao.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane(txtDescricao);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(91, 75, 230, 58);
		panFormulario.add(scroll);
		
		lblcat.setBounds(10, 144, 146, 23);
		lblcat.setForeground(Color.WHITE);
		panFormulario.add(lblcat);
		txtCategoria.setBounds(91, 144, 230, 23);
		panFormulario.add(txtCategoria);
		
		lblmaterial.setBounds(10, 178, 146, 23);
		lblmaterial.setForeground(Color.WHITE);
		panFormulario.add(lblmaterial);
		txtMaterial.setBounds(91, 178, 230, 23);
		panFormulario.add(txtMaterial);
		
		lbldimensoes.setBounds(10, 212, 146, 23);
		lbldimensoes.setForeground(Color.WHITE);
		panFormulario.add(lbldimensoes);
		txtDimensoes.setBounds(91, 212, 230, 23);
		panFormulario.add(txtDimensoes);
		
		lblano.setBounds(10, 246, 146, 23);
		lblano.setForeground(Color.WHITE);
		panFormulario.add(lblano);
		txtAno.setBounds(91, 246, 87, 23);
		panFormulario.add(txtAno);
				
		btnAdicionar.setBounds(44, 311, 230, 23);
		panFormulario.add(btnAdicionar);
		btnAdicionar.addActionListener(this);
		btnCancelar.setBounds(305, 311, 230, 23);
		panFormulario.add(btnCancelar);
		btnCancelar.addActionListener(this);
		panFormulario.add(btnUpload);
		btnUpload.setBounds(389, 212, 146, 23);
		panFormulario.add(lblimagem);
		btnUpload.addActionListener(this);
		lblimagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblimagem.setForeground(Color.WHITE);
		lblimagem.setBounds(350, 11, 224, 192);

		panPrincipal.add(panFormulario);
		panPrincipal.add(panLogo);
		
		ImageIcon bgimg = new ImageIcon("C:\\Users\\Danilo\\git\\Museu\\img\\background.png");
		ImageIcon logoimg = new ImageIcon("C:\\Users\\Danilo\\git\\Museu\\img\\logo.png"); 
		JLabel background = new JLabel();
		JLabel logo = new JLabel();
		background.setIcon(bgimg);
		background.setBounds(0, 0, 800, 700);
		logo.setIcon(logoimg);
		logo.setBounds(0, 0, 800, 90);
		panFormulario.add(background);
		panLogo.add(logo);

		janela.setContentPane(panPrincipal);
		janela.setSize(600, 500);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public CadObraForm(Obra obra) {
		janela.setTitle("Alterar Obra");
		btnAdicionar.setText("Alterar");
		
		JPanel panPrincipal = new JPanel();
		JPanel panFormulario = new JPanel();
		panFormulario.setBounds(0, 90, 584, 371);
		panFormulario.setLayout(null);
		panPrincipal.setLayout(null);
		
		//PANLOGO
		JPanel panLogo = new JPanel();
		panLogo.setBounds(0, 0, 584, 90);
		panLogo.setLayout(null);
		panPrincipal.add(panLogo);
		//FIM PANLOGO
		
		lblnome.setBounds(10, 7, 146, 23);
		lblnome.setForeground(Color.WHITE);
		panFormulario.add(lblnome);
		txtNome.setBounds(91, 7, 230, 23);
		panFormulario.add(txtNome);
		
		lblautor.setBounds(10, 41, 146, 23);
		lblautor.setForeground(Color.WHITE);
		panFormulario.add(lblautor);
		txtAutor.setBounds(91, 41, 230, 23);
		panFormulario.add(txtAutor);
		
		lbldesc.setBounds(10, 75, 146, 23);
		lbldesc.setForeground(Color.WHITE);
		panFormulario.add(lbldesc);
		
		txtDescricao.setTabSize(1);
		txtDescricao.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane(txtDescricao);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(91, 75, 230, 58);
		panFormulario.add(scroll);
		
		lblcat.setBounds(10, 144, 146, 23);
		lblcat.setForeground(Color.WHITE);
		panFormulario.add(lblcat);
		txtCategoria.setBounds(91, 144, 230, 23);
		panFormulario.add(txtCategoria);
		
		lblmaterial.setBounds(10, 178, 146, 23);
		lblmaterial.setForeground(Color.WHITE);
		panFormulario.add(lblmaterial);
		txtMaterial.setBounds(91, 178, 230, 23);
		panFormulario.add(txtMaterial);
		
		lbldimensoes.setBounds(10, 212, 146, 23);
		lbldimensoes.setForeground(Color.WHITE);
		panFormulario.add(lbldimensoes);
		txtDimensoes.setBounds(91, 212, 230, 23);
		panFormulario.add(txtDimensoes);
		
		lblano.setBounds(10, 246, 146, 23);
		lblano.setForeground(Color.WHITE);
		panFormulario.add(lblano);
		txtAno.setBounds(91, 246, 87, 23);
		panFormulario.add(txtAno);
				
		btnAdicionar.setBounds(44, 311, 230, 23);
		panFormulario.add(btnAdicionar);
		btnAdicionar.addActionListener(this);
		btnCancelar.setBounds(305, 311, 230, 23);
		panFormulario.add(btnCancelar);
		btnCancelar.addActionListener(this);
		panFormulario.add(btnUpload);
		btnUpload.setBounds(389, 212, 146, 23);
		panFormulario.add(lblimagem);
		btnUpload.addActionListener(this);
		lblimagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblimagem.setForeground(Color.WHITE);
		lblimagem.setBounds(350, 11, 224, 192);

		panPrincipal.add(panFormulario);
		panPrincipal.add(panLogo);
		
		ImageIcon bgimg = new ImageIcon(getClass().getResource("/img/background.png"));
		ImageIcon logoimg = new ImageIcon(getClass().getResource("/img/logo.png")); 
		JLabel background = new JLabel();
		JLabel logo = new JLabel();
		background.setIcon(bgimg);
		background.setBounds(0, 0, 800, 700);
		logo.setIcon(logoimg);
		logo.setBounds(0, 0, 800, 90);
		panFormulario.add(background);
		panLogo.add(logo);

		janela.setContentPane(panPrincipal);
		janela.setSize(600, 500);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		obraToForm(obra);
	}

	public Obra formToObra() {
		Obra o = new Obra();
		o.setId(id);
		o.setNome(txtNome.getText());
		o.setAutor(txtAutor.getText());
		o.setDescricao(txtDescricao.getText());
		o.setCategoria(txtCategoria.getText());
		o.setMaterial(txtMaterial.getText());
		o.setDimensoes(txtDimensoes.getText());
		o.setAno(Integer.parseInt(txtAno.getText()));
		o.setImagem(lblimagem.getText());
		return o;
	}


	private void obraToForm(Obra obra) {
		id = obra.getId();
		txtNome.setText(obra.getNome());
		txtAutor.setText(obra.getAutor());
		txtCategoria.setText(obra.getCategoria());
		txtDescricao.setText(obra.getDescricao());
		txtMaterial.setText(obra.getMaterial());
		txtDimensoes.setText(obra.getDimensoes());
		txtAno.setText(String.valueOf(obra.getAno()));
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdicionar) {
			control.adicionar(formToObra());
			JOptionPane.showMessageDialog(null, "Obra adicionada");
			janela.dispose();
		} else if (e.getSource() == btnAlterar) {
			control.adicionar(formToObra());
			JOptionPane.showMessageDialog(null, "Obra alterada");
			janela.dispose();
		} else if (e.getSource() == btnCancelar) {
		 janela.dispose();
		} else if (e.getSource() == btnUpload) {
			
		}

	}
}
