package server.Model;

import client.model.Damage.Damage;
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
 private DamageHandler damageHandler;
 private PolicyHandler policyHandler;

  public ServerModel()
  {
    employeehandler = new EmployeeHandler();
    customerhandler = new CustomerHandler();
    damageHandler = new DamageHandler();
    policyHandler = new PolicyHandler();
  }

  // Employees

  public void addEmployee(Employee employee)
  {
    employeehandler.addEmployeeData(employee);
  }

  public void updateEmployee(Employee employee)
  {
   // employeehandler.updateEmployeeData(employee); TODO: Fix this
  }

  public void deleteEmployee(Employee employee)
  {
    employeehandler.deleteEmployeeData(employee);
  }

  // Customers

  public void addCustomer(Customer customer)
  {
    customerhandler.addCustomerData(customer);
  }

  public void updateCustomer(Customer customer, Customer customerOld)
  {
    customerhandler.updateCustomerData(customer, customerOld);
  }

  public List<Customer> readCustomers()
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

  @Override public List<Damage> readDamage(int policeno)
  {
    return damageHandler.readDamageData(policeno);
  }

  public void deleteCustomer(Customer customer)
  {
   customerhandler.removeCustomerData(customer);
  }

}
