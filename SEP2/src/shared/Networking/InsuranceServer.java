package shared.Networking;

import shared.InsuranceClient;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InsuranceServer extends Remote
{

  void registerClient(InsuranceClient client) throws RemoteException;

}
