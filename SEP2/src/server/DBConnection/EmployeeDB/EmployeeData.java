package server.DBConnection.EmployeeDB;

import shared.Employee;

public interface EmployeeData
{

  void addEmployeeData(Employee employee);
  void readEmployeeData(Employee employee);
  void updateEmployeeData(Employee employee, Employee employeeOld);
  void deleteEmployeeData(Employee employee);
}
