package br.univel.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatClient extends Remote {
	
	public void receberMsgPrivada(String from,String msg) 
			throws RemoteException;
	
	public void receberMsgPublica(String from,String msg) 
			throws RemoteException;
	
	public void NotificarEntrada(String name) 
			throws RemoteException;
	
	public void NotificarSaida(String name) 
			throws RemoteException;
	

}
