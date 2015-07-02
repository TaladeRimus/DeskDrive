package view;

import interfaces.DeskDocInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.DeskDocController;


public class DeskDoc extends JFrame {

	private JPanel contentPane;
	JMenuBar menuBar;
	JMenu mnNewMenu;
	JMenuItem mntmNovo;
	JMenuItem mntmAbrir;
	JMenuItem mntmFechar;
	JMenu mnNewMenu_1;
	JMenuItem mntmEnviar;
	JMenuItem mntmDesconectar;
	TextArea conteudo;
	DeskDocInterface doc;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Launch the application.
	 */
	public void start() {

		DeskDoc frame = new DeskDoc();
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					
					frame.setVisible(true);
					frame.setTitle("DeskDoc");
					
					TimerTask receberDados = new TimerTask() {						
						@Override
						public void run() {
							try {
								frame.receiveFromServer();
								frame.repaint();
								
							} catch (RemoteException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}
					};
					
					Timer timerReceber = new Timer();
					timerReceber.scheduleAtFixedRate(receberDados, 2000, 2000);
					
				
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Cria o frame do cliente
	 */
	public DeskDoc() {
		
		startConnection();
		createItems();
		setItems();
		actions();
		
	}
	
	
	public void createItems(){
		contentPane = new JPanel();		
	}

	public void setItems(){
		
		conteudo = new TextArea();
		setBounds(100, 100, 450, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(conteudo, BorderLayout.CENTER);
		

		
	}
	
	public void actions(){
		conteudo.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
						
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					doc.setConteudo(conteudo.getText());
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}


	
	protected void receiveFromServer() throws RemoteException {
		
		try{
		conteudo.setText(doc.getConteudo());
		conteudo.setCaretPosition(doc.getConteudo().length());
		} catch ( Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void startConnection(){
		try {
			doc = (DeskDocInterface) Naming.lookup("rmi://localhost:1099/Desk");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
