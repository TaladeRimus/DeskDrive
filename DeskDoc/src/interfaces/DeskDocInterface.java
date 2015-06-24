package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DeskDocInterface extends Remote{
	
	public void setConteudo(String conteudo) throws RemoteException;
	public String getConteudo() throws RemoteException;
	
}
