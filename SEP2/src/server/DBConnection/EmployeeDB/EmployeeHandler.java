package server.DBConnection.EmployeeDB;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import server.DBConnection.DBConnections;
import server.DBConnection.DBConnectionsInterface;
import shared.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeHandler implements EmployeeData
{
  // Calls methods in the Connections and has SQL strings
  private DBConnectionsInterface connection;

  public EmployeeHandler()
  {
    connection = new DBConnections();
  }

  @Override public void addEmployeeData(Employee employee)
  {
    String sql = "INSERT INTO \"insurance\".employee (name,address,cpr,email,tlfnr,position) values(" + "'" + employee.getName()
        + "'" + "," + "'" + employee.getAddress() + "'" + "," + "'" + employee.getCPR() + "'" + "," + "'" + employee.getEmail()
        + "'" + "," + "'" + employee.getTlfNr() + "'" + ","
        + "'" + employee.getPosition() + "'" +");";
    connection.AddToDB(sql);
  }



  @Override public List<Employee> readEmployeeData()
  {
    String sql = "SELECT * FROM \"insurance\".Employee;";
    return connection.fillEmployeeTableDB(sql);
  }



  @Override public void updateEmployeeData(Employee employee)
  {
    String sql =
        "Update \"insurance\".employee set name =" + "'" + employee.getName()+ "'" + ","
            + "address =" + "'" + employee.getAddress() + "'" + ","
            + "cpr =" + "'" + employee.getCPR() + "'" + ","
            + "email =" + "'" + employee.getEmail() + "'" + ","
            + "tlfnr =" + "'" + employee.getTlfNr() + "'" + ","
            + "position =" + "'" + employee.getPosition() + "'"
            + " where employeeNo =" + employee.getEmployeeNo() +";";
    connection.AddToDB(sql);

  }

  @Override public void deleteEmployeeData(int employeeNo)
  {
    String sql = "Delete from \"insurance\".employee where employeeno =" + "'" + employeeNo + "'" +";";
    connection.AddToDB(sql);
  }

  @Override public List totalEmployees()
  {
    String sql = "SELECT count(employeeno) as "+"total"+" from \"insurance\".employee";
    return connection.totalFromDB(sql);
  }

  @Override public List totalManager()
  {
    String sql = "SELECT count(employeeno) as "+"total"+" from \"insurance\".employee where position ='Manager'";
    return connection.totalFromDB(sql);
  }

  @Override public List totalSalesmen()
  {
    String sql = "SELECT count(employeeno) as "+"total"+" from \"insurance\".employee where position ='Salesman'";
    return connection.totalFromDB(sql);
  }

  @Override public List totalDamageEmployee()
  {
    String sql = "SELECT count(employeeno) as "+"total"+" from \"insurance\".employee where position ='DamageEmployee'";
    return connection.totalFromDB(sql);
  }


}
