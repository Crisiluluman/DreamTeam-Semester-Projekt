package client.core;

import client.networking.Client;
import client.networking.InsuranceClientImpl;

public class ClientFactory
{
  private Client client;
  public Client getClient()
  {
    if(client == null)
    {
      client = new InsuranceClientImpl();
    }
    return client;
  }

}
