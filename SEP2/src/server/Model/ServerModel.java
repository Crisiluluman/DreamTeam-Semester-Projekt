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
    damageHandler = new DamageHandler();
    policyHandler = new PolicyHandler();
  }


  // Employees
  @Override public void addEmployee(Employee employee)
  {
    employeehandler.addEmployeeData(employee);
  }

  @Override public List<Employee> readEmployee()
  {
    return employeehandler.readEmployeeData();
  }

  @Override public void deleteEmployee(int cpr)
  {
    employeehandler.deleteEmployeeData(cpr);
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

  @Override public void deleteCustomer(int customerNo)
  {
   customerhandler.deleteCustomerData(customerNo);
  }


  // Policy
  @Override public void addPolicy(Policy policy)
  {

    policyHandler.addPolicyData(policy);
  }
  @Override public List<Policy> readPolicy()
  {
    return policyHandler.readPolicyData();
  }

  @Override public void deletePolicy(int policyno)
  {
    policyHandler.deletePolicyData(policyno);
  }

  // Damage

  @Override public void addDamage(Policy policy, Damage damage)
  {
    damageHandler.addDamageData(policy, damage);
  }

  @Override public List<Damage> readDamage(int policeno)
  {
    return damageHandler.readDamageData(policeno);
  }

  @Override public void deleteDamage(int damageno)
  {
    damageHandler.deleteDamageData(damageno);
  }
}
