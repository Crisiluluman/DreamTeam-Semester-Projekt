package server.DBSConnection.EmployeeDBS;

import shared.Employee;

public interface EmployeeData
{

  void addEmployeeData(Employee employee);
  void readEmployeeData(Employee employee);
  void updateEmployeeData(Employee employee);
}
