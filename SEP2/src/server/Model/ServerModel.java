package server.Model;

import shared.Damage;
import shared.Policy;
import server.DBConnection.CustomerDB.CustomerHandler;
import server.DBConnection.DamagesDB.DamageHandler;
import server.DBConnection.EmployeeDB.EmployeeHandler;
import server.DBConnection.PoliciesDB.PolicyHandler;
import shared.Customer;
import shared.Employee;

import java.util.List;

public class ServerModel implements ServerModelInterface
{
 private EmployeeHandler employeehandler;
 private CustomerHandler customerhandler;
  private PolicyHandler policyHandler;
  private DamageHandler damageHandler;

  public ServerModel()
  {
    employeehandler = new EmployeeHandler();
    customerhandler = new CustomerHandler();
  }


  // Employees
  @Override public void addEmployee(Employee employee)
  {
    employeehandler.addEmployeeData(employee);
  }


  @Override public void deleteEmployee(Employee employee)
  {
    employeehandler.deleteEmployeeData(employee);
  }


  // Customers
  @Override public void addCustomer(Customer customer)
  {
    customerhandler.addCustomerData(customer);
  }

  @Override public List<Customer> readCustomers()
  {
    return customerhandler.readCustomerData();
  }

  @Override public void deleteCustomer(Customer customer)
  {
   customerhandler.deleteCustomerData(customer);
  }


  // Policy
  @Override public void addPolicy(Policy policy)
  {

    policyHandler.addPolicyData(policy);
  }

  @Override public void deletePolicy(Policy policy)
  {
    policyHandler.deletePolicyData(policy);
  }

  // Damage

  @Override public void addDamage(Policy policy, Damage damage)
  {
    damageHandler.addDamageData(policy, damage);
  }

  @Override public void deleteDamage(Damage damage)
  {
    damageHandler.deleteDamageData(damage);
  }
}
