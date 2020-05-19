package client.model;

import client.model.Damage.Damage;
import shared.Employee;
import shared.Policy;
import shared.Customer;

import java.util.List;

public interface Model
{
  List<Customer> readCustomer();
  List<Policy> readPolicy();
  List<Employee> readEmployee();
  List<Damage> readDamage(int policeno);
}
