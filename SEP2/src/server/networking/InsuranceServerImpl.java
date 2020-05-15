package server.networking;

import javafx.scene.control.TableView;
import server.Model.InsuranceServerModel;
import server.Model.ServerModel;
import server.Model.ServerModelInterface;
import shared.Networking.InsuranceClient;
import shared.Networking.InsuranceServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class InsuranceServerImpl implements InsuranceServerModel, InsuranceServer
{
  private ServerModelInterface serverModel;

  public InsuranceServerImpl(ServerModelInterface serverModel) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this,0);
    this.serverModel = serverModel;
  }

  public void start() throws RemoteException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("Server", this);
    System.out.println("Server started");
  }

  @Override public void registerClient(InsuranceClient client)
  {

  }

  @Override
  public void readCustomer(TableView TV) {
    serverModel.readCustomer(TV);
  }
}
