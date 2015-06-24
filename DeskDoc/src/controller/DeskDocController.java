package controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import interfaces.DeskDocInterface;

public class DeskDocController extends UnicastRemoteObject implements DeskDocInterface {
	
	private static final long serialVersionUID = 1L;
	String conteudo;

	public DeskDocController() throws RemoteException {
		this.conteudo = "Conteudo";
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
