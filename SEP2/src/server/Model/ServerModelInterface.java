package server.Model;

import shared.Damage;
import shared.Employee;
import shared.Policy;
import shared.Customer;

import java.util.List;

public interface ServerModelInterface
{
   void addEmployee(Employee employee);
   void deleteEmployee(Employee employee);
   void addCustomer(Customer customer);
   void deleteCustomer(Customer customer);
   void addPolicy(Policy policy);
   void deletePolicy(Policy policy);
   void addDamage(Policy policy, Damage damage);
   void deleteDamage(Damage damage);

   List<Customer> readCustomers();
   List<Policy> readPolicy();
   List<Employee> readEmployee();
   List<Damage> readDamage(int policeno);
}
