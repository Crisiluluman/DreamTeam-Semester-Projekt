package client.model;

import client.core.ViewModelFactory;
import client.model.Police.Police;
import client.model.Police.PoliceList;
import client.networking.Client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Modelmanager implements Model
{
  private Client client;
  private PoliceList policeList;

  public Modelmanager(Client client) throws RemoteException, NotBoundException
  {
    this.client = client;
    policeList = new PoliceList();
    client.start();
    client.addListener("update", null);
  }

  @Override public void createPolice(Police police)
  {
    policeList.addPolicy(police);
  }

  @Override public PoliceList getPolice()
  {
    return policeList;
  }

  @Override public ViewModelFactory getViewModelFactory()
  {
    return null;
  }
}
