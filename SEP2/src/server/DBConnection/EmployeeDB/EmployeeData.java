package server.DBConnection.EmployeeDB;

import shared.Employee;

import java.util.List;

public interface EmployeeData
{

  void addEmployeeData(Employee employee);
  List<Employee> readEmployeeData();
  void updateEmployeeData(Employee employee, Employee employeeOld);
  void deleteEmployeeData(int cpr);
}
