package server.Model;

import shared.Damage;
import shared.Employee;
import shared.Policy;
import shared.Customer;

import java.util.List;

public interface ServerModelInterface
{
   void addEmployee(Employee employee);
   void deleteEmployee(int cpr);
   void addCustomer(Customer customer);
   void deleteCustomer(int customerNo);
   void addPolicy(Policy policy);
   void deletePolicy(int policyno);
   void addDamage(Policy policy, Damage damage);
   void deleteDamage(int damageno);

   List<Customer> readCustomers();
   List<Policy> readPolicy();
   List<Employee> readEmployee();
   List<Damage> readDamage(int policeno);
}
