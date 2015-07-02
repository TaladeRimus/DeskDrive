package servidor;

import interfaces.DeskDocInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import model.DeskDocModel;

public class Servidor {
	
	public boolean startServer() throws MalformedURLException {
		
		
		
		try {
			
			DeskDocInterface deskDoc = new DeskDocModel();
			LocateRegistry.createRegistry(1099);
			try {

				Naming.rebind("Desk", deskDoc);
				return true;
				
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			
		} catch (RemoteException e) {
			
			e.printStackTrace();
			
		}
		return false;
		
	}

}
