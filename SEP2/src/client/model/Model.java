package client.model;

import shared.Employee;
import shared.Policy;
import shared.Customer;
import shared.Damage;

import java.util.List;

public interface Model
{
  void addEmployee(Employee employee);
  void updateEmployee(Employee employee,Employee oldEmployee);
  void deleteEmployee(int employee);
  void addCustomer(Customer customer);
  void updateCustomer(Customer customer);
  void deleteCustomer(int customerNo);
  void addPolicy(Policy policy);
  void deletePolicy(int policyno);
  void addDamage(Damage damage);
  void updateDamage(Damage damage);
  void deleteDamage(int damageno);
  List<Customer> readCustomer();
  List<Policy> readPolicy(int customerNo);
  List<Employee> readEmployee();
  List<Damage> readDamage(int policeno);
}
