package client.networking;

import shared.*;

import java.rmi.RemoteException;
import java.util.List;

public interface Client extends Subject
{
  void start();

  void addEmployee(Employee employee);
  void deleteEmployee(Employee employee);
  void addCustomer(Customer customer);
  void deleteCustomer(Customer customer);
  void addPolicy(Policy policy);
  void deletePolicy(Policy policy);
  void addDamage(Policy policy, Damage damage);
  void deleteDamage(Damage damage);

  List<Customer> readCustomer();
}
