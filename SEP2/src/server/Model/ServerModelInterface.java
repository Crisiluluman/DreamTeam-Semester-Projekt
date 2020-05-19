package server.Model;

import client.model.Damage.Damage;
import shared.Employee;
import shared.Policy;
import shared.Customer;

import java.util.List;

public interface ServerModelInterface
{
   List<Customer> readCustomers();
   List<Policy> readPolicy();
   List<Employee> readEmployee();
   List<Damage> readDamage(int policeno);
}
