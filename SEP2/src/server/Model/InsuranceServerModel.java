package server.Model;

import javafx.scene.control.TableView;
import shared.Customer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.List;

public interface InsuranceServerModel
{
  void start() throws RemoteException, AlreadyBoundException;
  List<Customer> readCustomers() throws RemoteException;
}
