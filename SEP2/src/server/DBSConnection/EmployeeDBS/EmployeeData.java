package server.DBSConnection.EmployeeDBS;

import shared.Employee;

public interface EmployeeData
{

  void storeEmployeeData(Employee employee);
  void readEmployeeData(Employee employee);
}
