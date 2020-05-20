package server.Model;

import client.model.Damage.Damage;
import shared.Employee;
import shared.Policy;
import shared.Customer;

import java.util.List;

public interface ServerModelInterface
{
   void addCustomer(Customer customer);
   List<Customer> readCustomers();
   List<Policy> readPolicy(int custonerNo);
   List<Employee> readEmployee();
   List<Damage> readDamage(int policeno);
}
