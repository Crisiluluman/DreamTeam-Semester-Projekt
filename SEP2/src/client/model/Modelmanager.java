package client.model;

import client.networking.Client;

public class Modelmanager implements Model
{
  private Client client;
  public Modelmanager(Client client)
  {
    this.client = client;
  }
}
