package view;

import interfaces.DeskDocInterface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.DeskDocController;

import java.awt.TextArea;
import java.rmi.RemoteException;

public class DeskDocServer extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DeskDocInterface doc;
	TextArea conteudo;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public void server() {
		
		DeskDocServer frame = new DeskDocServer();
		try {
			DeskDocController ddc = new DeskDocController();
			for(;;){
				System.out.println(ddc.getConteudo());
			}
		} catch (RemoteException e1) {
			
			e1.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
										
					frame.setVisible(true);
					frame.getFromServer();
				
					
					
				} catch (Exception e) {
					
					e.printStackTrace();
					
				}
			
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DeskDocServer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		conteudo = new TextArea();
		conteudo.setEditable(false);
		contentPane.add(conteudo, BorderLayout.CENTER);
	}
	
	public void getFromServer() throws RemoteException{
		String conteudo = doc.getConteudo();
		System.out.println("CONTEUDO " + conteudo);
		
	}

}
