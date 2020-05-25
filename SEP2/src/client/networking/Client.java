package client.networking;

import shared.*;

import java.rmi.RemoteException;
import java.util.List;

public interface Client extends Subject
{
  void start();

  void addEmployee(Employee employee);
  void updateEmployee(Employee employee);
  void deleteEmployee(int cpr);
  List totalEmployees();
  void addCustomer(Customer customer);
  void updateCustomer(Customer customer);
  void deleteCustomer(int customerNo);
  List totalCustomers();
  void addPolicy(Policy policy);
  void updatePolicy(Policy policy);
  void deletePolicy(int policyno);
  List getIncome();
  void addDamage(Damage damage);
  void updateDamage(Damage damage);
  void deleteDamage(int damageno);
  List totalDamages();
  List getExpenses();

  List<Customer> readCustomer();
  List<Policy> readPolicy(int customerNo);
  List<Employee> readEmployee();
  List<Damage> readDamage(int policeno);
}
