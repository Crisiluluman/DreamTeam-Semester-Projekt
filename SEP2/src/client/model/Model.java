package client.model;

import shared.*;

import java.beans.PropertyChangeEvent;
import java.util.List;

public interface Model extends Subject
{
  void addEmployee(Employee employee);
  void updateEmployee(Employee employee);
  void deleteEmployee(int employee);
  List totalEmployees();
  List totalManager();
  List totalSalesmen();
  List totalDamageEmployee();

  void addCustomer(Customer customer);
  void updateCustomer(Customer customer);
  void deleteCustomer(int customerNo);
  void clearTableCustomer();
  List totalCustomers();

  void addPolicy(Policy policy);
  void updatePolicy(Policy policy);
  void deletePolicy(int policyno);
  List totalPolicies();

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
void updateAll(PropertyChangeEvent evt);

}
