package client.networking;

import client.model.Damage.Damage;
import shared.Employee;
import shared.Policy;
import shared.Customer;
import shared.Subject;

import java.rmi.RemoteException;
import java.util.List;

public interface Client extends Subject
{
  void start();
  void createCustomer(Customer customer) throws RemoteException;
  List<Customer> readCustomer();
  List<Policy> readPolicy(int customerNo);
  List<Employee> readEmployee();
  List<Damage> readDamage(int policeno);
}
