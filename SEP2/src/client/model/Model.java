package client.model;

import client.model.Damage.Damage;
import shared.Employee;
import shared.Policy;
import shared.Customer;

import java.util.List;

public interface Model
{
  void createCustomer(Customer customer);
  List<Customer> readCustomer();
  List<Policy> readPolicy(int customerNo);
  List<Employee> readEmployee();
  List<Damage> readDamage(int policeno);
}
