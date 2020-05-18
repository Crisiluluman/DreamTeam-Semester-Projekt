package server.Model;

import javafx.scene.control.TableView;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public interface InsuranceServerModel
{
  void start() throws RemoteException, AlreadyBoundException;
  void readCustomer(TableView TV) throws RemoteException;
}
