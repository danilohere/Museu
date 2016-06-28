package boundary;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

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
import entidade.Evento;

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
	private JLabel lblnome = new JLabel();
	private JLabel lbldescricao = new JLabel();
	private JLabel lbldatainicio = new JLabel();
	private JLabel lbldataenc = new JLabel();
	private JLabel lblvalortot = new JLabel();
	private JLabel lblvalormeia = new JLabel();
	private JLabel lblqnting = new JLabel();
	private long id;

	public VerEventoForm(long id_evento) {
		id = id_evento;

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

		lbldescricao.setBounds(10, 41, 146, 23);
		lbldescricao.setForeground(Color.WHITE);
		panFormulario.add(lbldescricao);
		txtDescricao.setTabSize(1);
		txtDescricao.setLineWrap(true);
		txtDescricao.setEditable(false);

		JScrollPane scroll = new JScrollPane(txtDescricao);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(91, 41, 230, 58);
		panFormulario.add(scroll);

		
		lbldatainicio.setBounds(10, 110, 146, 23);
		lbldatainicio.setForeground(Color.WHITE);
		panFormulario.add(lbldatainicio);
		lblDatainicio.setBounds(91, 110, 230, 23);
		lblDatainicio.setForeground(Color.WHITE);
		panFormulario.add(lblDatainicio);

		lbldataenc.setBounds(10, 144, 146, 23);
		lbldataenc.setForeground(Color.WHITE);
		panFormulario.add(lbldataenc);
		lblDataenc.setBounds(91, 144, 230, 23);
		lblDataenc.setForeground(Color.WHITE);
		panFormulario.add(lblDataenc);

		lblvalortot.setBounds(10, 178, 146, 23);
		lblvalortot.setForeground(Color.WHITE);
		panFormulario.add(lblvalortot);
		lblValortot.setBounds(91, 178, 230, 23);
		lblValortot.setForeground(Color.WHITE);
		panFormulario.add(lblValortot);

		lblvalormeia.setBounds(10, 212, 146, 23);
		lblvalormeia.setForeground(Color.WHITE);
		panFormulario.add(lblvalormeia);
		lblValormeia.setBounds(91, 212, 230, 23);
		lblValormeia.setForeground(Color.WHITE);
		panFormulario.add(lblValormeia);
		
		lblqnting.setBounds(10, 212, 146, 23);
		lblqnting.setForeground(Color.WHITE);
		panFormulario.add(lblqnting);
		lblQnting.setBounds(91, 212, 230, 23);
		lblQnting.setForeground(Color.WHITE);
		panFormulario.add(lblQnting);
		
		btnAlterar.setBounds(44, 311, 230, 23);
		panFormulario.add(btnAlterar);
		btnAlterar.addActionListener(this);
		
		btnExcluir.setBounds(320, 311, 230, 23);
		panFormulario.add(btnExcluir);
		btnExcluir.addActionListener(this);
		
		// PANLOGO
		JPanel panLogo = new JPanel();
		panLogo.setBounds(0, 0, 584, 90);
		panLogo.setLayout(null);
		panPrincipal.add(panLogo);
		// FIM PANLOGO

		panPrincipal.add(panFormulario);
		
		ImageIcon bgimg = new ImageIcon("C:\\Users\\Danilo\\git\\Museu\\img\\background.png");
		ImageIcon logoimg = new ImageIcon("C:\\Users\\Danilo\\git\\Museu\\img\\logo.png"); 
		JLabel background = new JLabel();
		JLabel logo = new JLabel();
		background.setIcon(bgimg);
		background.setBounds(0, 0, 800, 700);
		logo.setIcon(logoimg);
		logo.setBounds(0, 0, 800, 90);

		Evento ev = control.pesquisarPorId(id);
		eventoToForm(ev);
		
		janela.setContentPane(panPrincipal);
		janela.setSize(600, 500);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	private void eventoToForm(Evento ev) {
		id = ev.getId();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		lblNome.setText(ev.getNome());
		txtDescricao.setText(ev.getDescricao());
		lblDatainicio.setText(sdf.format(ev.getDatainicio()));
		lblDataenc.setText(sdf.format(ev.getDataenc()));
		lblValortot.setText(String.valueOf(ev.getValortot()));
		lblValormeia.setText(String.valueOf(ev.getNome()));
		lblQnting.setText(String.valueOf(ev.getNome()));
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
