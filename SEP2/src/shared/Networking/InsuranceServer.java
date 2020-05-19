package shared.Networking;

import client.model.Damage.Damage;
import shared.Employee;
import shared.Policy;
import shared.Customer;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface InsuranceServer extends Remote
{
  void start() throws RemoteException, AlreadyBoundException;
  void registerClient(InsuranceClient client) throws RemoteException;
  void addCustomer(Customer customer) throws RemoteException;
//  void addEmployee(Employee employee) throws RemoteException;
  List<Customer> readCustomers() throws RemoteException;
  List<Policy> readPolicy() throws RemoteException;
  List<Employee> readEmployee() throws RemoteException;
  List<Damage> readDamage(int policeno) throws RemoteException;
}
