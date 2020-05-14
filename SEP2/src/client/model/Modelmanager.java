package client.model;

import client.core.ViewModelFactory;
import client.model.Policy.Policy;
import client.model.Policy.PolicyList;
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

  @Override public void createPolicy(Policy policy)
  {
    policeList.addPolicy(policy);
  }

  @Override public PolicyList getPolice()
  {
    return policyList;
  }

  @Override public ViewModelFactory getViewModelFactory()
  {
    return null;
  }
}
