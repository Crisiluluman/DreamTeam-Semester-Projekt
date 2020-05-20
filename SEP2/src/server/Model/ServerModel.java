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

  public void updateEmployee(Employee employee)
  {
   // employeehandler.updateEmployeeData(employee); TODO: Fix this
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

  @Override public List<Policy> readPolicy(int customerNo)
  {
    return policyHandler.readPolicyData(customerNo);
  }

  @Override public List<Employee> readEmployee()
  {
    return employeehandler.readEmployeeData();
  }
  @Override public void deleteCustomer(int customerNo)
  {
    customerhandler.deleteCustomerData(customerNo);
  }

  @Override public void deletePolicy(int policyno)
  {
    policyHandler.deletePolicyData(policyno);
  }

  // Damage

  @Override public void addDamage(Damage damage)
  {
    damageHandler.addDamageData(damage);
  }
  // Policy
  @Override public void addPolicy(Policy policy)
  {

    policyHandler.addPolicyData(policy);
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
