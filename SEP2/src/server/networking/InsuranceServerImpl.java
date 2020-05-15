package server.networking;

import shared.Networking.InsuranceClient;
import shared.Networking.InsuranceServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class InsuranceServerImpl implements InsuranceServer
{

  public InsuranceServerImpl() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this,0);
  }

  public void start() throws RemoteException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("Server", this);
    System.out.println("Server started");
  }

  @Override public void registerClient(InsuranceClient client) throws RemoteException
  {

  }
}
