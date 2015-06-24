package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.TextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;

public class DeskDoc extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeskDoc frame = new DeskDoc();
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
	public DeskDoc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Arquivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNovo = new JMenuItem("Novo");
		mnNewMenu.add(mntmNovo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mnNewMenu.add(mntmAbrir);
		
		JMenuItem mntmFechar = new JMenuItem("Fechar");
		mnNewMenu.add(mntmFechar);
		
		JMenu mnNewMenu_1 = new JMenu("Op\u00E7\u00F5es");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmEnviar = new JMenuItem("Enviar");
		mnNewMenu_1.add(mntmEnviar);
		
		JMenuItem mntmDesconectar = new JMenuItem("Desconectar");
		mnNewMenu_1.add(mntmDesconectar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		TextArea ta_conteudo = new TextArea();
		contentPane.add(ta_conteudo, BorderLayout.CENTER);
	}

}
