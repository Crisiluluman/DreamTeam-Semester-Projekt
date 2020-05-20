package shared.Networking;

import shared.Damage;
import shared.Policy;
import shared.Customer;
import shared.Employee;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface InsuranceServer extends Remote
{
  void start() throws RemoteException, AlreadyBoundException;
  void registerClient(InsuranceClient client) throws RemoteException;
  void addEmployee(Employee employee) throws RemoteException;
  void deleteEmployee(int cpr) throws RemoteException;
  void addCustomer(Customer customer) throws RemoteException;
  List<Customer> readCustomers() throws RemoteException;
  List<Policy> readPolicy() throws RemoteException;
  List<Employee> readEmployee() throws RemoteException;
  List<Damage> readDamage(int policeno) throws RemoteException;
  void deleteCustomer(Customer customer) throws RemoteException;
  void addPolicy(Policy policy) throws RemoteException;
  void deletePolicy(Policy Policy) throws RemoteException;
  void addDamage(Policy policy, Damage damage) throws RemoteException;
  void deleteDamage(Damage damage) throws RemoteException;
}
