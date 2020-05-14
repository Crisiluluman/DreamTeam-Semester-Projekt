package client.model;

import client.model.Police.Policy;
import client.core.ViewModelFactory;
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
/**/
  @Override public void createPolice(Policy policy)
  {
    policeList.addPolicy(policy);
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
