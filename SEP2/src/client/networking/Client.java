package client.networking;

import javafx.scene.control.TableView;
import shared.Customer;
import shared.Subject;

import java.rmi.RemoteException;
import java.util.List;

public interface Client extends Subject
{
  void start();
  void createCustomer(Customer customer) throws RemoteException;
  List<Customer> readCustomer();
}
