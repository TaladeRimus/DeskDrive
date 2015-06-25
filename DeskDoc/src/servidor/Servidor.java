package servidor;

import interfaces.DeskDocInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import model.DeskDocModel;

public class Servidor {
	
	public static void main(String[] args) throws MalformedURLException {
		
		try {
			
			DeskDocInterface deskDoc = new DeskDocModel();
			LocateRegistry.createRegistry(1099);
			try {

				Naming.rebind("Desk", deskDoc);
				System.out.println("Servidor iniciado");
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			
		} catch (RemoteException e) {
			
			e.printStackTrace();
			
		}
		
	}

}
