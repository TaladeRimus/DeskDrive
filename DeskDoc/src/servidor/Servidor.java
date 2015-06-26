package servidor;

import interfaces.DeskDocInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import view.DeskDocServer;
import model.DeskDocModel;

public class Servidor {
	
	public static void main(String[] args) throws MalformedURLException {
		
		DeskDocServer server = new DeskDocServer();
		
		try {
			
			DeskDocInterface deskDoc = new DeskDocModel();
			LocateRegistry.createRegistry(1099);
			server.setVisible(true);
			try {

				Naming.rebind("Desk", deskDoc);
				System.out.println("Servidor iniciado");
				System.out.println("Conteudo: " + deskDoc.getConteudo());
			
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			
		} catch (RemoteException e) {
			
			e.printStackTrace();
			
		}
		
	}

}
