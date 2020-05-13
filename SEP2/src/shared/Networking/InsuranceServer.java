package shared.Networking;

import client.networking.Client;

import java.rmi.Remote;

public interface InsuranceServer extends Remote
{
  void registerClient(Client client);

}
