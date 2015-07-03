package view;

import interfaces.loginInterface;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import controller.loginController;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField tf_usuario;
	private JLabel lbl_senha;
	private JLabel lbl_user;
	private JPasswordField pf_password;
	JButton btn_cadastrar;
	JButton btn_entrar;
	loginInterface l;
	DeskDoc drive = new DeskDoc();
	Server server = new Server();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setType(Type.UTILITY);
		setTitle("DeskDrive");
		setResizable(false);
		
		createItems();
		setItems();
		addItems();
		addActions();
		
	}
	
	public void setItems(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 220, 240);
		setContentPane(contentPane);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		lbl_user.setBounds(30, 33, 61, 14);
		tf_usuario.setBounds(87, 30, 86, 20);
		tf_usuario.setColumns(10);
		lbl_senha.setBounds(30, 76, 46, 14);
		pf_password.setBounds(87, 76, 86, 20);
		btn_cadastrar.setBounds(30, 155, 143, 23);
		btn_entrar.setBounds(30, 119, 143, 23);

	}

	
	public void createItems(){
		
		contentPane = new JPanel();
		tf_usuario = new JTextField();
		lbl_user = new JLabel("Usu\u00E1rio: ");
		lbl_senha = new JLabel("Senha: ");
		pf_password = new JPasswordField();
		btn_entrar = new JButton("Entrar");
		btn_cadastrar = new JButton("Cadastrar");
	}
	
	public void addItems(){
		
		contentPane.add(lbl_user);
		contentPane.add(tf_usuario);
		contentPane.add(lbl_senha);
		contentPane.add(btn_cadastrar);
		contentPane.add(btn_entrar);
		contentPane.add(pf_password);
		
		
	}
	
	public void addActions(){
		btn_entrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					loginAction();
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		});
		
		btn_cadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				cadastraAction();
				
			}
		});
	}
	
	private void cadastraAction() {
		String username = tf_usuario.getText();
		String password = pf_password.getText();
		
		l = new loginController();
		l.registro(username, password);
		
	}
	
	private void loginAction() throws MalformedURLException{
		
		String username = tf_usuario.getText();
		String password = pf_password.getText();
		l = new loginController();
		if ( l.login(username, password) == 2 ) {
			drive.start();
		} else if ( l.login(username, password) == 1) {
			
			server.startServerView();
		}

	}
}
