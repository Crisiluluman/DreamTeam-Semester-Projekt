package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InsuranceClient extends Remote
{
  void update() throws RemoteException;
}
