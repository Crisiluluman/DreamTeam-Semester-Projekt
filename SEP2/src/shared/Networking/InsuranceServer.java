package shared.Networking;

import javafx.scene.control.TableView;
import shared.Customer;
import shared.Employee;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface InsuranceServer extends Remote
{
  void registerClient(InsuranceClient client) throws RemoteException;
//  void addEmployee(Employee employee) throws RemoteException;
  List<Customer> readCustomers() throws RemoteException;
}
