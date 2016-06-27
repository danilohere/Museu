package boundary;

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
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import control.AutorControl;
import entidade.Autor;
public class CadAutorForm implements ActionListener {
		private JFrame janela = new JFrame("Cadastro de Autor");
		private JTextField txtNome = new JTextField();
		private JTextField txtNasc = new JTextField();
		private JTextField txtPeriodo = new JTextField();
		private JTextArea txtBiografia = new JTextArea(1, 1);
		private JButton btnAdicionar = new JButton("Adicionar");
		private JButton btnAlterar = new JButton("Alterar");
		private JButton btnCancelar = new JButton("Cancelar");
		private JButton btnUpload = new JButton("Upload Imagem");
		private AutorControl control = new AutorControl();
		private JLabel lblimagem = new JLabel("Imagem");
		private	JLabel lblnome = new JLabel("Nome");
		private JLabel lblnasc = new JLabel("Nascimento");
		private JLabel lblperiodo = new JLabel("Per�odo");
		private JLabel lblbio = new JLabel("Biografia");
		private long id;

		public CadAutorForm() {
			JPanel panPrincipal = new JPanel();
			JPanel panFormulario = new JPanel();
			panFormulario.setBounds(0, 90, 584, 371);
			
			panFormulario.setLayout(null);
			panPrincipal.setLayout(null);
					

			lblnome.setBounds(10, 7, 146, 23);
			panFormulario.add(lblnome);
			txtNome.setBounds(91, 7, 230, 23);
			panFormulario.add(txtNome);
			
			lblnasc.setBounds(10, 41, 146, 23);
			panFormulario.add(lblnasc);
			txtNasc.setBounds(91, 41, 230, 23);
			panFormulario.add(txtNasc);
			
			lblperiodo.setBounds(10, 144, 146, 23);
			panFormulario.add(lblperiodo);
			txtPeriodo.setBounds(91, 144, 230, 23);
			panFormulario.add(txtPeriodo);
			
			
			lblbio.setBounds(10, 75, 146, 23);
			panFormulario.add(lblbio);
			
			txtBiografia.setTabSize(1);
			txtBiografia.setLineWrap(true);
			
			JScrollPane scroll = new JScrollPane(txtBiografia);
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			scroll.setBounds(91, 75, 230, 58);
			panFormulario.add(scroll);
			
			
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
			lblimagem.setBounds(350, 11, 224, 192);
			
			//PANLOGO
			JPanel panLogo = new JPanel();
			panLogo.setBounds(0, 0, 584, 90);
			panLogo.setLayout(null);
			panPrincipal.add(panLogo);
			//FIM PANLOGO
			
			panPrincipal.add(panFormulario);
			
			janela.setContentPane(panPrincipal);
			
			janela.setSize(600, 500);
			janela.setVisible(true);
			janela.setLocationRelativeTo(null);
			janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
		
		public CadAutorForm(Autor autor) {
			janela.setTitle("Alterar Autor");
			btnAdicionar.setText("Alterar");
			
			JPanel panPrincipal = new JPanel();
			JPanel panFormulario = new JPanel();
			panFormulario.setBounds(0, 90, 584, 371);
			
			panFormulario.setLayout(null);
			panPrincipal.setLayout(null);
					

			lblnome.setBounds(10, 7, 146, 23);
			panFormulario.add(lblnome);
			txtNome.setBounds(91, 7, 230, 23);
			panFormulario.add(txtNome);
			
			lblnasc.setBounds(10, 41, 146, 23);
			panFormulario.add(lblnasc);
			txtNasc.setBounds(91, 41, 230, 23);
			panFormulario.add(txtNasc);
			
			lblperiodo.setBounds(10, 144, 146, 23);
			panFormulario.add(lblperiodo);
			txtPeriodo.setBounds(91, 144, 230, 23);
			panFormulario.add(txtPeriodo);
			
			lblbio.setBounds(10, 75, 146, 23);
			panFormulario.add(lblbio);
			
			txtBiografia.setTabSize(1);
			txtBiografia.setLineWrap(true);
			
			JScrollPane scroll = new JScrollPane(txtBiografia);
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			scroll.setBounds(91, 75, 230, 58);
			panFormulario.add(scroll);
			
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
			lblimagem.setBounds(350, 11, 224, 192);
			
			//PANLOGO
			JPanel panLogo = new JPanel();
			panLogo.setBounds(0, 0, 584, 90);
			panLogo.setLayout(null);
			panPrincipal.add(panLogo);
			//FIM PANLOGO
			
			panPrincipal.add(panFormulario);
			
			janela.setContentPane(panPrincipal);
			
			janela.setSize(600, 500);
			janela.setVisible(true);
			janela.setLocationRelativeTo(null);
			janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			autorToForm(autor);
		}

		public Autor formToAutor() {
			Autor a = new Autor();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			a.setId(id);
			a.setNome(txtNome.getText());
			try {
				a.setNasc(sdf.parse(txtNasc.getText()));
			} catch (Exception e) {
				e.printStackTrace();
			}
			a.setPeriodo(txtPeriodo.getText());
			a.setBiografia(txtBiografia.getText());
			
			return a;
		}


		private void autorToForm(Autor autor) {
			id = autor.getId();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			txtNome.setText(autor.getNome());
			txtNasc.setText(sdf.format(autor.getNasc()));
			txtPeriodo.setText(autor.getPeriodo());
			txtBiografia.setText(autor.getBiografia());
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnAdicionar) {
				control.adicionar(formToAutor());
				JOptionPane.showMessageDialog(null, "Autor adicionada");
				janela.dispose();
			} else if (e.getSource() == btnAlterar) {
				control.adicionar(formToAutor());
				JOptionPane.showMessageDialog(null, "Autor alterada");
				janela.dispose();
			} else if (e.getSource() == btnCancelar) {
			 janela.dispose();
			} else if (e.getSource() == btnUpload) {
				
			}

		}
	}

