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
import javax.swing.JTextArea;

import control.ObraControl;
import entidade.Obra;
import javax.swing.SwingConstants;

public class VerObraForm implements ActionListener {
	private JFrame janela = new JFrame("Cadastro de Obra");
	private JLabel lblNome = new JLabel();
	private JLabel lblAutor = new JLabel();
	private JTextArea txtDescricao = new JTextArea(1, 50);
	private JLabel lblCategoria = new JLabel();
	private JLabel lblMaterial = new JLabel();
	private JLabel lblDimensoes = new JLabel();
	private JLabel lblAno = new JLabel();
	private JButton btnAlterar = new JButton("Alterar");
	private JButton btnExcluir = new JButton("Excluir");
	private ObraControl control = new ObraControl();
	private JLabel lblimagem = new JLabel("Imagem");
	private JLabel lblnome = new JLabel("Nome");
	private JLabel lblautor = new JLabel("Autor");
	private JLabel lbldesc = new JLabel("Descrição");
	private JLabel lblcat = new JLabel("Categoria");
	private JLabel lblmaterial = new JLabel("Material");
	private JLabel lbldimensoes = new JLabel("Dimensões");
	private JLabel lblano = new JLabel("Ano");
	private long id;

	public VerObraForm(long id_obra) {
		id = id_obra;
		JPanel panPrincipal = new JPanel();
		JPanel panFormulario = new JPanel();
		panFormulario.setBounds(0, 90, 594, 371);
		panFormulario.setLayout(null);
		panPrincipal.setLayout(null);

		lblnome.setBounds(10, 7, 146, 23);
		lblnome.setForeground(Color.WHITE);
		panFormulario.add(lblnome);
		lblNome.setBounds(91, 7, 230, 23);
		lblNome.setForeground(Color.WHITE);
		panFormulario.add(lblNome);

		lblautor.setBounds(10, 41, 146, 23);
		lblautor.setForeground(Color.WHITE);
		panFormulario.add(lblautor);
		lblAutor.setBounds(91, 41, 230, 23);
		lblAutor.setForeground(Color.WHITE);
		panFormulario.add(lblAutor);

		lbldesc.setBounds(10, 75, 146, 23);
		lbldesc.setForeground(Color.WHITE);
		panFormulario.add(lbldesc);
		txtDescricao.setEditable(false);
		txtDescricao.setBounds(91, 75, 230, 58);
		panFormulario.add(txtDescricao);

		lblcat.setBounds(10, 144, 146, 23);
		lblcat.setForeground(Color.WHITE);
		panFormulario.add(lblcat);
		lblCategoria.setBounds(91, 144, 230, 23);
		lblCategoria.setForeground(Color.WHITE);
		panFormulario.add(lblCategoria);

		lblmaterial.setBounds(10, 178, 146, 23);
		lblmaterial.setForeground(Color.WHITE);
		panFormulario.add(lblmaterial);
		lblMaterial.setBounds(91, 178, 230, 23);
		lblMaterial.setForeground(Color.WHITE);
		panFormulario.add(lblMaterial);

		lbldimensoes.setBounds(10, 212, 146, 23);
		lbldimensoes.setForeground(Color.WHITE);
		panFormulario.add(lbldimensoes);
		lblDimensoes.setBounds(91, 212, 230, 23);
		lblDimensoes.setForeground(Color.WHITE);
		panFormulario.add(lblDimensoes);
		lblano.setForeground(Color.WHITE);
		lblano.setBounds(10, 246, 146, 23);
		panFormulario.add(lblano);
		lblAno.setBounds(91, 246, 146, 23);
		lblAno.setForeground(Color.WHITE);
		panFormulario.add(lblAno);

		btnAlterar.setBounds(44, 311, 230, 23);
		panFormulario.add(btnAlterar);
		btnAlterar.addActionListener(this);
		btnExcluir.setBounds(320, 311, 230, 23);
		panFormulario.add(btnExcluir);
		btnExcluir.addActionListener(this);
		panFormulario.add(lblimagem);
		lblimagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblimagem.setBounds(350, 11, 224, 192);

		// PANLOGO
		JPanel panLogo = new JPanel();
		panLogo.setBounds(0, 0, 594, 90);
		panLogo.setLayout(null);
		panPrincipal.add(panLogo);
		// FIM PANLOGO

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
		
		panPrincipal.add(panFormulario);
		panPrincipal.add(panLogo);

		Obra o = control.pesquisarPorId(id);
		obraToForm(o);
		janela.setResizable(false);
		janela.setTitle("Detalhes da Obra");
		janela.setContentPane(panPrincipal);
		janela.setSize(600, 500);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void obraToForm(Obra o) {
		lblNome.setText(o.getNome());
		lblAutor.setText(o.getAutor());
		lblCategoria.setText(o.getCategoria());
		txtDescricao.setText(o.getDescricao());
		lblMaterial.setText(o.getMaterial());
		lblDimensoes.setText(o.getDimensoes());
		lblAno.setText(String.valueOf(o.getAno()));
		lblimagem.setText(o.getImagem());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAlterar) {
			Obra o = control.pesquisarPorId(id);
			new CadObraForm(o);
		} else if (e.getSource() == btnExcluir) {
			int i = JOptionPane.showOptionDialog(null, "Deseja mesmo excluir?", "Excluir obra",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (i == JOptionPane.YES_OPTION) {
				control.excluir(id);
				janela.dispose();
			}

		}
	}
}
