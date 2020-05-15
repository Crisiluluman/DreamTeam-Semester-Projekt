package server.Model;

import client.model.Customer.Customer;
import javafx.scene.control.TableView;
import server.DBConnection.CustomerDB.CustomerHandler;
import server.DBConnection.DamagesDB.DamageHandler;
import server.DBConnection.EmployeeDB.EmployeeHandler;
import shared.Employee;

public class ServerModel implements ServerModelInterface
{
 private EmployeeHandler employeehandler;
 private CustomerHandler customerhandler;
 private DamageHandler damageHandler;

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
   // employeehandler.updateEmployeeData(employee); TODO: Fix this
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

  public void updateCustomer(Customer customer, Customer customerOld)
  {
    customerhandler.updateCustomerData(customer, customerOld);
  }

  public void readCustomer(TableView TV)
  {
    customerhandler.readCustomerData(TV);
  }

  public void deleteCustomer(Customer customer)
  {
    customerhandler.removeCustomerData(customer);
  }

}
