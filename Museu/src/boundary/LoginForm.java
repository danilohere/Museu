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
import javax.swing.JTextField;

import control.LoginControl;
import entidade.Login;

import javax.swing.JPasswordField;

public class LoginForm implements ActionListener{
	private JFrame janela = new JFrame("Login");
	private JTextField txtUsuario = new JTextField();
	private JPasswordField txtSenha = new JPasswordField();
	private JLabel lblusuario = new JLabel("Usuário:");
	private	JLabel lblsenha = new JLabel("Senha:");
	private JButton btnAcessar = new JButton("Acessar");
	private JButton btnVoltar = new JButton("Voltar");
	private LoginControl control = new LoginControl();
	private boolean logado;

	public LoginForm(){
		JPanel panPrincipal = new JPanel();
		JPanel panFormulario = new JPanel();
		panFormulario.setBounds(0, 0, 230, 250);
		panFormulario.setLayout(null);
		panPrincipal.setLayout(null);
		
		lblusuario.setBounds(10, 86, 100, 23);
		lblusuario.setForeground(Color.WHITE);
		panFormulario.add(lblusuario);
		txtUsuario.setBounds(70, 86, 150, 23);
		panFormulario.add(txtUsuario);
		
		lblsenha.setBounds(10, 120, 100, 23);
		lblsenha.setForeground(Color.WHITE);
		panFormulario.add(lblsenha);
		
		btnAcessar.setBounds(10, 200, 100, 23);
		panFormulario.add(btnAcessar);
		btnAcessar.addActionListener(this);
		btnVoltar.setBounds(120, 200, 100, 23);
		panFormulario.add(btnVoltar);
		
		txtSenha.setBounds(70, 120, 150, 23);
		panFormulario.add(txtSenha);
		btnVoltar.addActionListener(this);
		
		panPrincipal.add(panFormulario);
		
		ImageIcon bgimg = new ImageIcon("C:\\Users\\Danilo\\git\\Museu\\img\\background.png");
		JLabel background = new JLabel();
		background.setIcon(bgimg);
		background.setBounds(0, 0, 230, 250);
		panFormulario.add(background);
		janela.setResizable(false);
		
		janela.setContentPane(panPrincipal);
		janela.setSize(230, 250);
		janela.setUndecorated(true);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		//janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnAcessar) {
			String usu = txtUsuario.getText();
			String sen = String.valueOf(txtSenha.getPassword());
			Login l = new Login();		
			l = control.pesquisarPorId(usu);
			if (l.getUsuario() != null){
				if (l.getSenha() == sen){
					logado = true;
					JOptionPane.showMessageDialog(null, "Bem vindo "+l.getUsuario());
					janela.dispose();
					new MainPesq(logado);
				} else {
					JOptionPane.showMessageDialog(null, "Senha incorreta");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Usuário não encontrado");
			}
		} else if (e.getSource() == btnVoltar) {
			logado = false;
			janela.dispose();
			new MainPesq(logado);
		}
	}
	
	
}
