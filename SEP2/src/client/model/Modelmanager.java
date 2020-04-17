package client.model;

import client.model.Police.Police;
import client.model.Police.PoliceList;
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

  @Override public void createPolice(Police police)
  {
    policeList.addPolicy(police);
  }

  @Override public PoliceList getPolice()
  {
    return policeList;
  }
}
