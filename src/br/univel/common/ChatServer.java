package br.univel.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatServer extends Remote {
	
	public void registrar(String name, ChatClient client)
			throws RemoteException;
	
	public void enviarMsgPrivada(String from, String to, String msg)
		throws RemoteException;
	
	public void enviarMsgPublic(String from, String msg)
			throws RemoteException;
	
	public void logoff(String name)
		throws RemoteException;


}
