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
import javax.swing.ScrollPaneConstants;
import control.EventoControl;
import entity.Evento;

public class VerEventoForm implements ActionListener {
	private JFrame janela = new JFrame("Cadastro de Evento");
	private JLabel lblNome = new JLabel();
	private JTextArea txtDescricao = new JTextArea(1, 1);
	private JLabel lblDatainicio = new JLabel();
	private JLabel lblDataenc = new JLabel();
	private JLabel lblValortot = new JLabel();
	private JLabel lblValormeia = new JLabel();
	private JLabel lblQnting = new JLabel();
	private JButton btnAlterar = new JButton("Alterar");
	private JButton btnExcluir = new JButton("Excluir");
	private EventoControl control = new EventoControl();
	private JLabel lblnome = new JLabel("Nome");
	private JLabel lbldescricao = new JLabel("Descrição");
	private JLabel lbldatainicio = new JLabel("Data de Início");
	private JLabel lbldataenc = new JLabel("Data de encerramento");
	private JLabel lblvalortot = new JLabel("Valor Total do ingresso  R$");
	private JLabel lblvalormeia = new JLabel("Valor da meia entrada    R$");
	private JLabel lblqnting = new JLabel("Quantidade de ingressos");
	private String path = System.getProperty("user.dir");
	private long id;

	public VerEventoForm(long id_evento, boolean logado) {
		id = id_evento;

		JPanel panPrincipal = new JPanel();
		JPanel panFormulario = new JPanel();
		panFormulario.setBounds(0, 90, 584, 371);

		panFormulario.setLayout(null);
		panPrincipal.setLayout(null);

		lblnome.setBounds(10, 7, 160, 23);
		lblnome.setForeground(Color.WHITE);
		panFormulario.add(lblnome);
		lblNome.setBounds(170, 7, 230, 23);
		lblNome.setForeground(Color.WHITE);
		panFormulario.add(lblNome);

		lbldescricao.setBounds(10, 41, 160, 23);
		lbldescricao.setForeground(Color.WHITE);
		panFormulario.add(lbldescricao);
		txtDescricao.setTabSize(1);
		txtDescricao.setLineWrap(true);
		txtDescricao.setEditable(false);

		JScrollPane scroll = new JScrollPane(txtDescricao);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(170, 41, 230, 58);
		panFormulario.add(scroll);

		lbldatainicio.setBounds(10, 110, 160, 23);
		lbldatainicio.setForeground(Color.WHITE);
		panFormulario.add(lbldatainicio);
		lblDatainicio.setBounds(170, 110, 230, 23);
		lblDatainicio.setForeground(Color.WHITE);
		panFormulario.add(lblDatainicio);

		lbldataenc.setBounds(10, 144, 160, 23);
		lbldataenc.setForeground(Color.WHITE);
		panFormulario.add(lbldataenc);
		lblDataenc.setBounds(170, 144, 230, 23);
		lblDataenc.setForeground(Color.WHITE);
		panFormulario.add(lblDataenc);

		lblvalortot.setBounds(10, 178, 160, 23);
		lblvalortot.setForeground(Color.WHITE);
		panFormulario.add(lblvalortot);
		lblValortot.setBounds(170, 178, 230, 23);
		lblValortot.setForeground(Color.WHITE);
		panFormulario.add(lblValortot);

		lblvalormeia.setBounds(10, 212, 160, 23);
		lblvalormeia.setForeground(Color.WHITE);
		panFormulario.add(lblvalormeia);
		lblValormeia.setBounds(170, 212, 230, 23);
		lblValormeia.setForeground(Color.WHITE);
		panFormulario.add(lblValormeia);

		lblqnting.setBounds(10, 246, 160, 23);
		lblqnting.setForeground(Color.WHITE);
		panFormulario.add(lblqnting);
		lblQnting.setBounds(170, 246, 230, 23);
		lblQnting.setForeground(Color.WHITE);
		panFormulario.add(lblQnting);

		if (logado == true) {
			btnAlterar.setBounds(44, 311, 230, 23);
			panFormulario.add(btnAlterar);
			btnAlterar.addActionListener(this);
			btnExcluir.setBounds(320, 311, 230, 23);
			panFormulario.add(btnExcluir);
			btnExcluir.addActionListener(this);
		}

		// PANLOGO
		JPanel panLogo = new JPanel();
		panLogo.setBounds(0, 0, 584, 90);
		panLogo.setLayout(null);
		panPrincipal.add(panLogo);
		// FIM PANLOGO

		panPrincipal.add(panFormulario);

		ImageIcon bgimg = new ImageIcon(path + "/img/background.png");
		ImageIcon logoimg = new ImageIcon(path + "/img/logo.png");
		JLabel background = new JLabel();
		JLabel logo = new JLabel();
		background.setIcon(bgimg);
		background.setBounds(0, 0, 800, 700);
		logo.setIcon(logoimg);
		logo.setBounds(0, 0, 800, 90);
		panFormulario.add(background);
		panLogo.add(logo);

		Evento ev = control.pesquisarPorId(id);
		eventoToForm(ev);

		janela.setResizable(false);
		janela.setContentPane(panPrincipal);
		janela.setSize(600, 500);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	private void eventoToForm(Evento ev) {
		id = ev.getId();
		lblNome.setText(ev.getNome());
		txtDescricao.setText(ev.getDescricao());
		lblDatainicio.setText(ev.getDatainicio());
		lblDataenc.setText(ev.getDataenc());
		lblValortot.setText(String.valueOf(ev.getValortot()));
		lblValormeia.setText(String.valueOf(ev.getValormeia()));
		lblQnting.setText(String.valueOf(ev.getQnting()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAlterar) {
			Evento ev = control.pesquisarPorId(id);
			new CadEventoForm(ev);
			janela.dispose();
		} else if (e.getSource() == btnExcluir) {
			int i = JOptionPane.showOptionDialog(null, "Deseja mesmo excluir?", "Excluir evento",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (i == JOptionPane.YES_OPTION) {
				control.excluir(id);
				janela.dispose();
			}

		}
	}

}
