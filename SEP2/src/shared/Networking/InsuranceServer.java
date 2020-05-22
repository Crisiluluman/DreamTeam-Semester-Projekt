package shared.Networking;

import javafx.scene.control.TableView;
import shared.Damage;
import shared.Policy;
import shared.Customer;
import shared.Employee;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface InsuranceServer extends Remote
{// TODO: Clean
  void start() throws RemoteException, AlreadyBoundException;
  void registerClient(InsuranceClient client) throws RemoteException;
  void addEmployee(Employee employee) throws RemoteException;
  void deleteEmployee(int cpr) throws RemoteException;
  void addCustomer(Customer customer) throws RemoteException;
  List<Customer> readCustomers() throws RemoteException;
  List<Policy> readPolicy(int customerNo) throws RemoteException;
  List<Employee> readEmployee() throws RemoteException;
  List<Damage> readDamage(int policeno) throws RemoteException;
  void updateCustomer(Customer customer) throws RemoteException;
  void updateDamage(Damage damage) throws RemoteException;
  void updateEmployee(Employee employee) throws RemoteException;
  void deleteCustomer(int customerNo) throws RemoteException;
  void addPolicy(Policy policy) throws RemoteException;
  void updatePolicy(Policy policy) throws RemoteException;
  void deletePolicy(int policyno) throws RemoteException;
  void addDamage(Damage damage) throws RemoteException;
  void deleteDamage(int damageno) throws RemoteException;

  List totalCustomers() throws RemoteException;
  List totalEmployees() throws RemoteException;
  List totalDamages() throws RemoteException;

  //Callback
  void updateDamage(int row, InsuranceClient insuranceClient) throws RemoteException;

  //Customer

  //Employee

  //Damages

  //Policies
}
