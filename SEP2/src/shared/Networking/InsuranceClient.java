package shared.Networking;
import javafx.scene.control.TableView;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InsuranceClient extends Remote
{
  void updateDamages() throws RemoteException;
  void updateCustomers() throws RemoteException;
  void updatePolicies() throws RemoteException;
  void updateEmployees() throws RemoteException;
}
