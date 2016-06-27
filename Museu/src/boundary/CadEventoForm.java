package boundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import control.EventoControl;
import entidade.Evento;

public class CadEventoForm implements ActionListener {

	private JFrame janela = new JFrame("Cadastro de Evento");
	private JTextField txtNome = new JTextField();
	private JTextArea txtDescricao = new JTextArea(1, 1);
	private JTextField txtDatainicio = new JTextField();
	private JTextField txtDataenc = new JTextField();
	private JTextField txtValortot = new JTextField();
	private JTextField txtValormeia = new JTextField();
	private JTextField txtQnting = new JTextField();
	private JButton btnAdicionar = new JButton("Adicionar");
	private JButton btnAlterar = new JButton("Alterar");
	private JButton btnCancelar = new JButton("Cancelar");
	private EventoControl control = new EventoControl();
	private JLabel lblnome = new JLabel("Nome");
	private JLabel lbldescricao = new JLabel("Data de Início");
	private JLabel lbldatainicio = new JLabel("Data de Início");
	private JLabel lbldataenc = new JLabel("Data de encerramento");
	private JLabel lblvalortot = new JLabel("Valor Total do ingresso  R$");
	private JLabel lblvalormeia = new JLabel("Valor da meia entrada    R$");
	private JLabel lblqnting = new JLabel("Quantidade de ingressos");
	private long id;

	public CadEventoForm() {
		JPanel panPrincipal = new JPanel();
		JPanel panFormulario = new JPanel();
		
		panFormulario.setBounds(0, 90, 434, 351);
		panFormulario.setLayout(null);
		panPrincipal.setLayout(null);

		lblnome.setBounds(10, 7, 160, 23);
		panFormulario.add(lblnome);
		txtNome.setBounds(170, 7, 230, 23);
		panFormulario.add(txtNome);

		lbldescricao.setBounds(10, 41, 160, 23);
		panFormulario.add(lbldescricao);
		
		txtDescricao.setTabSize(1);
		txtDescricao.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane(txtDescricao);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(170, 41, 230, 58);
		panFormulario.add(scroll);

		lbldatainicio.setBounds(10, 110, 160, 23);
		panFormulario.add(lbldatainicio);
		txtDatainicio.setBounds(170, 110, 87, 23);
		panFormulario.add(txtDatainicio);

		lbldataenc.setBounds(10, 144, 160, 23);
		panFormulario.add(lbldataenc);
		txtDataenc.setBounds(170, 144, 87, 23);
		panFormulario.add(txtDataenc);

		lblvalortot.setBounds(10, 178, 160, 23);
		panFormulario.add(lblvalortot);
		txtValortot.setBounds(170, 178, 87, 23);
		panFormulario.add(txtValortot);

		lblvalormeia.setBounds(10, 212, 160, 23);
		panFormulario.add(lblvalormeia);
		txtValormeia.setBounds(170, 212, 87, 23);
		panFormulario.add(txtValormeia);

		lblqnting.setBounds(10, 246, 160, 23);
		panFormulario.add(lblqnting);
		txtQnting.setBounds(170, 246, 87, 23);
		panFormulario.add(txtQnting);

		btnAdicionar.setBounds(10, 290, 200, 23);
		panFormulario.add(btnAdicionar);
		btnAdicionar.addActionListener(this);
		
		btnCancelar.setBounds(220, 290, 200, 23);
		panFormulario.add(btnCancelar);
		btnCancelar.addActionListener(this);

		// PANLOGO
		JPanel panLogo = new JPanel();
		panLogo.setBounds(0, 0, 434, 90);
		panLogo.setLayout(null);
		panPrincipal.add(panLogo);
		// FIM PANLOGO

		panPrincipal.add(panFormulario);
		panPrincipal.add(panLogo);

		janela.setContentPane(panPrincipal);
		janela.setSize(450, 480);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public CadEventoForm(Evento ev) {
		janela.setTitle("Alterar Evento");
		btnAdicionar.setText("Alterar");

		JPanel panPrincipal = new JPanel();
		JPanel panFormulario = new JPanel();
		
		panFormulario.setBounds(0, 90, 434, 351);
		panFormulario.setLayout(null);
		panPrincipal.setLayout(null);

		lblnome.setBounds(10, 7, 160, 23);
		panFormulario.add(lblnome);
		txtNome.setBounds(170, 7, 230, 23);
		panFormulario.add(txtNome);

		lbldescricao.setBounds(10, 41, 160, 23);
		panFormulario.add(lbldescricao);
		
		txtDescricao.setTabSize(1);
		txtDescricao.setLineWrap(true);
		
		JScrollPane scroll = new JScrollPane(txtDescricao);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(170, 41, 230, 58);
		panFormulario.add(scroll);

		lbldatainicio.setBounds(10, 110, 160, 23);
		panFormulario.add(lbldatainicio);
		txtDatainicio.setBounds(170, 110, 87, 23);
		panFormulario.add(txtDatainicio);

		lbldataenc.setBounds(10, 144, 160, 23);
		panFormulario.add(lbldataenc);
		txtDataenc.setBounds(170, 144, 87, 23);
		panFormulario.add(txtDataenc);

		lblvalortot.setBounds(10, 178, 160, 23);
		panFormulario.add(lblvalortot);
		txtValortot.setBounds(170, 178, 87, 23);
		panFormulario.add(txtValortot);

		lblvalormeia.setBounds(10, 212, 160, 23);
		panFormulario.add(lblvalormeia);
		txtValormeia.setBounds(170, 212, 87, 23);
		panFormulario.add(txtValormeia);

		lblqnting.setBounds(10, 246, 160, 23);
		panFormulario.add(lblqnting);
		txtQnting.setBounds(170, 246, 87, 23);
		panFormulario.add(txtQnting);

		btnAdicionar.setBounds(10, 290, 200, 23);
		panFormulario.add(btnAdicionar);
		btnAdicionar.addActionListener(this);
		
		btnCancelar.setBounds(220, 290, 200, 23);
		panFormulario.add(btnCancelar);
		btnCancelar.addActionListener(this);

		// PANLOGO
		JPanel panLogo = new JPanel();
		panLogo.setBounds(0, 0, 434, 90);
		panLogo.setLayout(null);
		panPrincipal.add(panLogo);
		// FIM PANLOGO

		panPrincipal.add(panFormulario);
		panPrincipal.add(panLogo);

		janela.setContentPane(panPrincipal);
		janela.setSize(450, 480);
		janela.setVisible(true);
		janela.setLocationRelativeTo(null);
		janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		eventoToForm(ev);
	}

	public Evento formToEvento() {
		Evento ev = new Evento();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		ev.setId(id);
		ev.setNome(txtNome.getText());
		ev.setDescricao(txtDescricao.getText());
		try {
			ev.setDatainicio(sdf.parse(txtDatainicio.getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		try {
			ev.setDataenc(sdf.parse(txtDataenc.getText()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ev.setValortot(Float.parseFloat(txtValortot.getText()));
		ev.setValormeia(Float.parseFloat(txtValormeia.getText()));
		ev.setQnting(Integer.parseInt(txtQnting.getText()));
		return ev;
	}

	private void eventoToForm(Evento ev) {
		id = ev.getId();
		txtNome.setText(ev.getNome());
		txtDescricao.setText(ev.getDescricao());
		txtDatainicio.setText(String.valueOf(ev.getDatainicio()));
		txtDataenc.setText(String.valueOf(ev.getDataenc()));
		txtValortot.setText(String.valueOf(ev.getValortot()));
		txtValormeia.setText(String.valueOf(ev.getValormeia()));
		txtQnting.setText(String.valueOf(ev.getQnting()));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAdicionar) {
			control.adicionar(formToEvento());
			JOptionPane.showMessageDialog(null, "Evento adicionado");
			janela.dispose();
		} else if (e.getSource() == btnAlterar) {
			control.adicionar(formToEvento());
			JOptionPane.showMessageDialog(null, "Evento alterado");
			janela.dispose();
		} else if (e.getSource() == btnCancelar) {
			janela.dispose();
		}

	}

}
