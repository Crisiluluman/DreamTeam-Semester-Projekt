package server.Model;

import shared.Damage;
import shared.Employee;
import shared.Policy;
import shared.Customer;

import java.util.List;

public interface ServerModelInterface
{
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
   List getExpenses();

   void addDamage(Damage damage);
   void updateDamage(Damage damage);
   void deleteDamage(int damageno);
   List totalDamages();


   List<Customer> readCustomers();
   List<Policy> readPolicy(int custonerNo);
   List<Employee> readEmployee();
   List<Damage> readDamage(int policeno);
}
