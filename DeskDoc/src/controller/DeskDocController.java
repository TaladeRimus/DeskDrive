package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import servidor.Cliente;
import interfaces.DeskDocInterface;

public class DeskDocController extends UnicastRemoteObject implements DeskDocInterface {
	
	private static final long serialVersionUID = 1L;
	String conteudo;
	
	public DeskDocController(String conteudo) throws RemoteException {
		this.conteudo = conteudo;
	
		Cliente c = new Cliente();
		c.chamaCliente(this.conteudo);
		
	}

	@Override
	public void setConteudo(String conteudo) throws RemoteException {
		
		this.conteudo = conteudo;
		
	}

	@Override
	public String getConteudo() throws RemoteException {
		
		return conteudo;
		
	}

}
