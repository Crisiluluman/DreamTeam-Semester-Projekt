package client.networking;

import client.model.Damage.Damage;
import shared.Employee;
import shared.Policy;
import shared.Customer;
import shared.Subject;

import java.util.List;

public interface Client extends Subject
{
  void start();
  List<Customer> readCustomer();
  List<Policy> readPolicy();
  List<Employee> readEmployee();
  List<Damage> readDamage(int policeno);
}
