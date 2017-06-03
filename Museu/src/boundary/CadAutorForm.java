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
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;


import control.AutorControl;
import entity.Autor;
public class CadAutorForm implements ActionListener {
		private JFrame janela = new JFrame("Cadastro de Autor");
		private JTextField txtNome = new JTextField();
		private JTextField txtNasc = new JTextField();
		private JTextField txtPeriodo = new JTextField();
		private JTextArea txtBiografia = new JTextArea(1, 1);
		private JButton btnAdicionar = new JButton("Adicionar");
		private JButton btnAlterar = new JButton("Alterar");
		private JButton btnCancelar = new JButton("Cancelar");
		private AutorControl control = new AutorControl();
		private	JLabel lblnome = new JLabel("Nome");
		private JLabel lblnasc = new JLabel("Nascimento");
		private JLabel lblperiodo = new JLabel("Período");
		private JLabel lblbio = new JLabel("Biografia");
		private String path = System.getProperty("user.dir");
		private long id;

		public CadAutorForm() {
			JPanel panPrincipal = new JPanel();
			JPanel panFormulario = new JPanel();
			panFormulario.setBounds(0, 90, 584, 371);
			
			panFormulario.setLayout(null);
			panPrincipal.setLayout(null);
					

			lblnome.setBounds(10, 7, 146, 23);
			lblnome.setForeground(Color.WHITE);
			panFormulario.add(lblnome);
			txtNome.setBounds(91, 7, 230, 23);
			panFormulario.add(txtNome);
			
			lblnasc.setBounds(10, 41, 146, 23);
			lblnasc.setForeground(Color.WHITE);
			panFormulario.add(lblnasc);
			txtNasc.setBounds(91, 41, 230, 23);
			panFormulario.add(txtNasc);
			
			lblperiodo.setBounds(10, 75, 146, 23);
			lblperiodo.setForeground(Color.WHITE);
			panFormulario.add(lblperiodo);
			txtPeriodo.setBounds(91, 75, 230, 23);
			panFormulario.add(txtPeriodo);
			
			
			lblbio.setBounds(10, 109, 146, 23);
			lblbio.setForeground(Color.WHITE);
			panFormulario.add(lblbio);
			
			txtBiografia.setTabSize(1);
			txtBiografia.setLineWrap(true);
			
			JScrollPane scroll = new JScrollPane(txtBiografia);
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			scroll.setBounds(91, 109, 230, 58);
			panFormulario.add(scroll);
			
			
			btnAdicionar.setBounds(44, 311, 230, 23);
			panFormulario.add(btnAdicionar);
			btnAdicionar.addActionListener(this);
			btnCancelar.setBounds(305, 311, 230, 23);
			panFormulario.add(btnCancelar);
			btnCancelar.addActionListener(this);
			
			//PANLOGO
			JPanel panLogo = new JPanel();
			panLogo.setBounds(0, 0, 584, 90);
			panLogo.setLayout(null);
			panPrincipal.add(panLogo);
			//FIM PANLOGO
			
			panPrincipal.add(panFormulario);
			
			ImageIcon bgimg = new ImageIcon(path+"/img/background.png");
			ImageIcon logoimg = new ImageIcon(path+"/img/logo.png"); 
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
		
		public CadAutorForm(Autor autor) {
			janela.setTitle("Alterar Autor");
			
			JPanel panPrincipal = new JPanel();
			JPanel panFormulario = new JPanel();
			panFormulario.setBounds(0, 90, 584, 371);
			
			panFormulario.setLayout(null);
			panPrincipal.setLayout(null);
					

			lblnome.setBounds(10, 7, 146, 23);
			lblnome.setForeground(Color.WHITE);
			panFormulario.add(lblnome);
			txtNome.setBounds(91, 7, 230, 23);
			panFormulario.add(txtNome);
			
			lblnasc.setBounds(10, 41, 146, 23);
			lblnasc.setForeground(Color.WHITE);
			panFormulario.add(lblnasc);
			txtNasc.setBounds(91, 41, 230, 23);
			panFormulario.add(txtNasc);
			
			lblperiodo.setBounds(10, 75, 146, 23);
			lblperiodo.setForeground(Color.WHITE);
			panFormulario.add(lblperiodo);
			txtPeriodo.setBounds(91, 75, 230, 23);
			panFormulario.add(txtPeriodo);
			
			
			lblbio.setBounds(10, 109, 146, 23);
			lblbio.setForeground(Color.WHITE);
			panFormulario.add(lblbio);
			
			txtBiografia.setTabSize(1);
			txtBiografia.setLineWrap(true);
			
			JScrollPane scroll = new JScrollPane(txtBiografia);
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
			scroll.setBounds(91, 109, 230, 58);
			panFormulario.add(scroll);
			
			
			btnAlterar.setBounds(44, 311, 230, 23);
			panFormulario.add(btnAlterar);
			btnAlterar.addActionListener(this);
			btnCancelar.setBounds(305, 311, 230, 23);
			panFormulario.add(btnCancelar);
			btnCancelar.addActionListener(this);
			
			//PANLOGO
			JPanel panLogo = new JPanel();
			panLogo.setBounds(0, 0, 584, 90);
			panLogo.setLayout(null);
			panPrincipal.add(panLogo);
			//FIM PANLOGO
			
			panPrincipal.add(panFormulario);
			
			ImageIcon bgimg = new ImageIcon(path+"/img/background.png");
			ImageIcon logoimg = new ImageIcon(path+"/img/logo.png"); 
			JLabel background = new JLabel();
			JLabel logo = new JLabel();
			background.setIcon(bgimg);
			background.setBounds(0, 0, 800, 700);
			logo.setIcon(logoimg);
			logo.setBounds(0, 0, 800, 90);
			panFormulario.add(background);
			panLogo.add(logo);
			
			janela.setContentPane(panPrincipal);
			janela.setResizable(false);
			janela.setSize(600, 500);
			janela.setVisible(true);
			janela.setLocationRelativeTo(null);
			janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			
			autorToForm(autor);
		}

		public Autor formToAutor() {
			Autor a = new Autor();
			a.setId(id);
			a.setNome(txtNome.getText());
			a.setNasc(txtNasc.getText());
			a.setPeriodo(txtPeriodo.getText());
			a.setBiografia(txtBiografia.getText());
			
			return a;
		}


		private void autorToForm(Autor autor) {
			id = autor.getId();
			txtNome.setText(autor.getNome());
			txtNasc.setText(autor.getNasc());
			txtPeriodo.setText(autor.getPeriodo());
			txtBiografia.setText(autor.getBiografia());
		}


		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == btnAdicionar) {
				control.adicionar(formToAutor());
				JOptionPane.showMessageDialog(null, "Autor adicionado");
				janela.dispose();
			} else if (e.getSource() == btnAlterar) {
				control.adicionar(formToAutor());
				JOptionPane.showMessageDialog(null, "Autor alterado");
				janela.dispose();
			} else if (e.getSource() == btnCancelar) {
			 janela.dispose();
			}

		}
	}


