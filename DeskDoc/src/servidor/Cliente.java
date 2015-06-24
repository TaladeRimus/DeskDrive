package servidor;

import interfaces.DeskDocInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Cliente {
	
	
	public static void main(String[] args) {
		String nome = JOptionPane.showInputDialog("Digite seu nome");

		try {
			
			DeskDocInterface deskDoc = (DeskDocInterface) Naming.lookup("rmi://localhost:1099/Desk");
			deskDoc.setConteudo(nome);
			//System.out.println(deskDoc.hello());
		
			
			
		} catch (RemoteException ex) {			
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);			
		} catch(NotBoundException ex){			
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);		
		} catch(MalformedURLException ex){			
			Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);		
		}
	}
	
	
}
