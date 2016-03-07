package br.univel.server;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import br.univel.common.ChatClient;
import br.univel.common.ChatServer;

public class AppServer implements ChatServer {
	
	private Map<String, ChatClient> mapClientes = new HashMap<>();
	

	@Override
	public void registrar(String name, ChatClient client)
			throws RemoteException {
		if(mapClientes.containsKey(name)){
			throw new RemoteException("Esse nome já está sendo usado");
			
		}
		
		mapClientes.put(name, client);
		
		
	}

	@Override
	public void enviarMsgPrivada(String from, String to, String msg)
			throws RemoteException {
		
		mapClientes.get(to).receberMsgPrivada(from, msg);
		
	}

	@Override
	public void enviarMsgPublic(String from, String msg) throws RemoteException {
		for (Entry<String,ChatClient> e : mapClientes.entrySet()){
			if(e.getKey().equals(from)){
				continue;
			}else{
				e.getValue().receberMsgPublica(from,msg);
			}
		}
		
	}

	@Override
	public void logoff(String name) throws RemoteException {
		mapClientes.remove(name);
		
	}
	

}
