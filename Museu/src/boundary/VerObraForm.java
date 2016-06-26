package boundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

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
		panFormulario.setBounds(0, 90, 484, 371);
		panFormulario.setLayout(null);
		panPrincipal.setLayout(null);

		lblnome.setBounds(10, 7, 146, 23);
		panFormulario.add(lblnome);
		lblNome.setBounds(69, 7, 171, 23);
		panFormulario.add(lblNome);

		lblautor.setBounds(10, 41, 146, 23);
		panFormulario.add(lblautor);
		lblAutor.setBounds(69, 41, 171, 23);
		panFormulario.add(lblAutor);

		lbldesc.setBounds(10, 75, 146, 23);
		panFormulario.add(lbldesc);
		txtDescricao.setEditable(false);
		txtDescricao.setBounds(69, 75, 171, 58);
		panFormulario.add(txtDescricao);

		lblcat.setBounds(10, 144, 146, 23);
		panFormulario.add(lblcat);
		lblCategoria.setBounds(69, 144, 171, 23);
		panFormulario.add(lblCategoria);

		lblmaterial.setBounds(10, 178, 146, 23);
		panFormulario.add(lblmaterial);
		lblMaterial.setBounds(69, 178, 171, 23);
		panFormulario.add(lblMaterial);

		lbldimensoes.setBounds(10, 212, 146, 23);
		panFormulario.add(lbldimensoes);
		lblDimensoes.setBounds(69, 212, 171, 23);
		panFormulario.add(lblDimensoes);
		lblAno.setBounds(69, 246, 84, 23);
		panFormulario.add(lblAno);

		btnAlterar.setBounds(10, 311, 230, 23);
		panFormulario.add(btnAlterar);
		btnAlterar.addActionListener(this);
		btnExcluir.setBounds(244, 311, 230, 23);
		panFormulario.add(btnExcluir);
		btnExcluir.addActionListener(this);
		panFormulario.add(lblimagem);
		lblimagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblimagem.setBounds(250, 11, 224, 192);

		// PANLOGO
		JPanel panLogo = new JPanel();
		panLogo.setBounds(0, 0, 484, 90);
		panLogo.setLayout(null);
		panPrincipal.add(panLogo);
		// FIM PANLOGO

		panPrincipal.add(panFormulario);

		lblano.setBounds(10, 246, 146, 23);
		panFormulario.add(lblano);
		panPrincipal.add(panLogo);

		Obra o = control.pesquisarPorId(id);
		obraToForm(o);
		janela.setTitle("Detalhes da Obra");
		janela.setContentPane(panPrincipal);
		janela.setSize(500, 500);
		janela.setVisible(true);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
			// control.adicionar(formToObra());
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
