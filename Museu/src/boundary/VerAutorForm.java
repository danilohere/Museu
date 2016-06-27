package boundary;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import control.AutorControl;
import entidade.Autor;

public class VerAutorForm implements ActionListener {
	private JFrame janela = new JFrame("Cadastro de Autor");
	private JLabel lblNome = new JLabel();
	private JLabel lblNasc = new JLabel();
	private JLabel lblPeriodo = new JLabel();
	private JTextArea txtBiografia = new JTextArea(1, 1);
	private JButton btnAlterar = new JButton("Alterar");
	private JButton btnExcluir = new JButton("Excluir");
	private AutorControl control = new AutorControl();
	private JLabel lblimagem = new JLabel("Imagem");
	private JLabel lblnome = new JLabel("Nome");
	private JLabel lblnasc = new JLabel("Nascimento");
	private JLabel lblperiodo = new JLabel("Período");
	private JLabel lblbio = new JLabel("Biografia");
	private long id;

	public VerAutorForm(long id_autor) {
		id = id_autor;

		JPanel panPrincipal = new JPanel();
		JPanel panFormulario = new JPanel();
		panFormulario.setBounds(0, 90, 584, 371);

		panFormulario.setLayout(null);
		panPrincipal.setLayout(null);

		lblnome.setBounds(10, 7, 146, 23);
		lblnome.setForeground(Color.WHITE);
		panFormulario.add(lblnome);
		lblNome.setBounds(91, 7, 230, 23);
		lblNome.setForeground(Color.WHITE);
		panFormulario.add(lblNome);

		lblnasc.setBounds(10, 41, 146, 23);
		lblnasc.setForeground(Color.WHITE);
		panFormulario.add(lblnasc);
		lblNasc.setBounds(91, 41, 230, 23);
		lblNasc.setForeground(Color.WHITE);
		panFormulario.add(lblNasc);

		lblperiodo.setBounds(10, 144, 146, 23);
		lblperiodo.setForeground(Color.WHITE);
		panFormulario.add(lblperiodo);
		lblPeriodo.setBounds(91, 144, 230, 23);
		lblPeriodo.setForeground(Color.WHITE);
		panFormulario.add(lblPeriodo);

		lblbio.setBounds(10, 75, 146, 23);
		lblbio.setForeground(Color.WHITE);
		panFormulario.add(lblbio);

		txtBiografia.setTabSize(1);
		txtBiografia.setLineWrap(true);

		JScrollPane scroll = new JScrollPane(txtBiografia);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(91, 75, 230, 58);
		panFormulario.add(scroll);

		btnAlterar.addActionListener(this);
		btnExcluir.setBounds(320, 311, 230, 23);
		panFormulario.add(btnExcluir);
		btnExcluir.addActionListener(this);
		lblimagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblimagem.setBounds(350, 11, 224, 192);

		// PANLOGO
		JPanel panLogo = new JPanel();
		panLogo.setBounds(0, 0, 584, 90);
		panLogo.setLayout(null);
		panPrincipal.add(panLogo);
		// FIM PANLOGO

		panPrincipal.add(panFormulario);

		Autor a = control.pesquisarPorId(id);
		autorToForm(a);
		
		janela.setContentPane(panPrincipal);
		janela.setSize(600, 500);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private void autorToForm(Autor autor) {
		id = autor.getId();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		lblNome.setText(autor.getNome());
		lblNasc.setText(sdf.format(autor.getNasc()));
		lblPeriodo.setText(autor.getPeriodo());
		txtBiografia.setText(autor.getBiografia());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAlterar) {
			Autor a = control.pesquisarPorId(id);
			new CadAutorForm(a);
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
