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

  @Override public void updateEmployee(Employee employee)
  {
    employeehandler.updateEmployeeData(employee);
  }


  @Override public void deleteEmployee(int cpr)
  {
    employeehandler.deleteEmployeeData(cpr);
  }

  @Override public List totalEmployees()
  {
    return employeehandler.totalEmployees();
  }

  @Override public List totalManager()
  {
    return employeehandler.totalManager();
  }

  @Override public List totalSalesmen()
  {
    return employeehandler.totalSalesmen();
  }

  @Override public List totalDamageEmployee()
  {
    return employeehandler.totalDamageEmployee();
  }

  // Customers
  @Override public void addCustomer(Customer customer)
  {
    customerhandler.addCustomerData(customer);
  }

  @Override public void updateCustomer(Customer customer)
  {
    customerhandler.updateCustomerData(customer);
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

  @Override public List totalCustomers()
  {
    return customerhandler.TotalCustomers();
  }

  @Override public void deletePolicy(int policyno)
  {
    policyHandler.deletePolicyData(policyno);
  }

  @Override public List totalPolicies()
  {
   return policyHandler.totalPolicies();
  }

  @Override public List getIncome()
  {
    return policyHandler.getIncome();
  }

  @Override public List getExpenses()
  {
    return policyHandler.getExpenses();
  }

  // Damage

  @Override public void addDamage(Damage damage)
  {
    damageHandler.addDamageData(damage);
  }

  @Override public void updateDamage(Damage damage)
  {
    damageHandler.updateDamageData(damage);
  }

  // Policy
  @Override public void addPolicy(Policy policy)
  {

    policyHandler.addPolicyData(policy);
  }

  @Override public void updatePolicy(Policy policy)
  {
    policyHandler.updatePolicyData(policy);
  }



  @Override public List<Damage> readDamage(int policeno)
  {
    return damageHandler.readDamageData(policeno);
  }

  @Override public void deleteDamage(int damageno)
  {
    damageHandler.deleteDamageData(damageno);
  }

  @Override public List totalDamages()
  {
    return damageHandler.totalDamages();
  }
}
