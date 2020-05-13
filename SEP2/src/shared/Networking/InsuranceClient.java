package shared.Networking;

import java.rmi.Remote;

public interface InsuranceClient extends Remote
{
  void update();
  String getUsername();
  void notifyEmployee(String msg);
}
