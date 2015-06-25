package servidor;

import interfaces.DeskDocInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import controller.DeskDocController;

public class Cliente {
	
	
	
	public void chamaCliente(String conteudo){
		
		try {
			DeskDocInterface docInterface = (DeskDocInterface) Naming.lookup("rmi://localhost:1099/Desk");
			
			docInterface.setConteudo(conteudo);
			System.out.println("Conteudo: " + conteudo);
			
		} catch (RemoteException ex) {
            ex.printStackTrace();
        } catch (NotBoundException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
		
	}
	
}
