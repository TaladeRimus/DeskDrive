package servidor;

import interfaces.DeskDocInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import controller.DeskDocController;

public class Servidor {
	
	public static void main(String[] args) throws MalformedURLException {
		
		try {
			
			DeskDocInterface deskDoc = new DeskDocController();
			LocateRegistry.createRegistry(1099);
			Naming.rebind("Desk", deskDoc);
			System.out.println("Servidor iniciado");
			
		} catch (RemoteException e) {
			
			e.printStackTrace();
			
		}
		
	}

}
