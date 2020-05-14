package client.model;

import client.model.Policy.Policy;
import client.core.ViewModelFactory;
import client.model.Policy.PolicyList;
import client.networking.Client;

public class Modelmanager implements Model
{
  private Client client;
  private PolicyList policyList;
  public Modelmanager(Client client)
  {
    this.client = client;
    policyList = new PolicyList();
  }
/**/
  @Override public void createPolice(Policy policy)
  {
    policyList.addPolicy(policy);
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
