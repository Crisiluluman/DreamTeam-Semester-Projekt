package client.model;

import client.model.Policy.Policy;
import client.model.Policy.PoliceList;
import client.networking.Client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Modelmanager implements Model
{
  private Client client;
  private PolicyList policyList;

  public Modelmanager(Client client)
  {
    this.client = client;
    policyList = new PolicyList();
    client.start();
    client.addListener("update", null);
  }


  @Override public ViewModelFactory getViewModelFactory()
  {
    return null;
  }
}
