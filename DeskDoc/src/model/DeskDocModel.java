package model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import interfaces.DeskDocInterface;

public class DeskDocModel extends UnicastRemoteObject implements DeskDocInterface {

	String conteudo;
	
	public DeskDocModel() throws RemoteException{
		
	}
	
	@Override
	public void setConteudo(String conteudo) throws RemoteException {
		this.conteudo = conteudo;

	}

	@Override
	public String getConteudo() throws RemoteException {
		return this.conteudo;
	}

}
