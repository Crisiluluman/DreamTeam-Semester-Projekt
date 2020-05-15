package server.model;

import client.model.Customer.Customer;
import server.DBConnection.CustomerDB.CustomerHandler;
import server.DBConnection.EmployeeDB.EmployeeHandler;
import shared.Employee;

public class ServerModel
{
 private EmployeeHandler employeehandler;
 private CustomerHandler customerhandler;

  public ServerModel()
  {
    employeehandler = new EmployeeHandler();
  }

  // Employees

  public void addEmployee(Employee employee)
  {
    employeehandler.addEmployeeData(employee);
  }

  public void updateEmployee(Employee employee)
  {
    employeehandler.updateEmployeeData(employee);
  }

  public void readEmployee(Employee employee)
  {
    employeehandler.readEmployeeData(employee);
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

  public void updateEmployee(Customer customer, Customer customerOld)
  {
    customerhandler.updateCustomerData(customer, customerOld);
  }

  public void readEmployee(Customer customer)
  {
    customerhandler.readCustomerData(customer);
  }

  public void deleteEmployee(Customer customer)
  {
    customerhandler.removeCustomerData(customer);
  }

}
