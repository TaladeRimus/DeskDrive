package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;

import servidor.Servidor;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;

public class Server extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnIniciarDeskdriverServer;
	Servidor server = new Servidor();
	/**
	 * Launch the application.
	 */
	public void startServerView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server frame = new Server();
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
	public Server() {
		
		createItems();
		setItems();
		addItems();
		addActions();
		
	}
	
	
	public void createItems(){
		
		contentPane = new JPanel();
		textField = new JTextField();
		btnIniciarDeskdriverServer = new JButton("Iniciar DeskDriver Server");
		
	}
	
	public void setItems(){
	
		
		setContentPane(contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 275, 200);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setBounds(10, 11, 239, 75);
		textField.setColumns(10);
		btnIniciarDeskdriverServer.setBounds(10, 94, 239, 42);
		
	}
	
	public void addItems(){
		
		contentPane.add(textField);
		contentPane.add(btnIniciarDeskdriverServer);

	}
	
	public void addActions(){

		btnIniciarDeskdriverServer.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					if ( server.startServer() ) {
						textField.setText("Servidor iniciado");
						btnIniciarDeskdriverServer.disable();
					}
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
	}
	
	
}
