package client.model;

import client.model.Policy.Policy;
import client.model.Policy.PoliceList;
import client.networking.Client;

public class Modelmanager implements Model
{
  private Client client;
  private PoliceList policeList;
  public Modelmanager(Client client)
  {
    this.client = client;
    policeList = new PoliceList();
  }
/**/
  @Override public void createPolice(Policy policy)
  {
    policeList.addPolicy(policy);
  }

  @Override public PoliceList getPolice()
  {
    return policeList;
  }
}
