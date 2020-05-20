package client.model;

import shared.Employee;
import shared.Policy;
import client.model.Policy.PoliceList;
import javafx.scene.control.TableView;
import shared.Customer;
import shared.Damage;

import java.rmi.RemoteException;
import java.util.List;

public interface Model
{
  void addEmployee(Employee employee);
  void deleteEmployee(int employee);
  void addCustomer(Customer customer);
  void deleteCustomer(int customerNo);
  void addPolicy(Policy policy);
  void deletePolicy(int policyno);
  void addDamage(Policy policy, Damage damage);
  void deleteDamage(int damageno);
  List<Customer> readCustomer();
  List<Policy> readPolicy();
  List<Employee> readEmployee();
  List<Damage> readDamage(int policeno);
}
