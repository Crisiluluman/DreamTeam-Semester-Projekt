package shared.Networking;
import javafx.scene.control.TableView;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InsuranceClient extends Remote
{
  void updateDamages() throws RemoteException;
}
