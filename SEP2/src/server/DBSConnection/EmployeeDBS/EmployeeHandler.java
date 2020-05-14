package server.DBSConnection.EmployeeDBS;

import server.DBSConnection.DBSConnections;
import shared.Employee;

public class EmployeeHandler implements EmployeeData
{
  // Calls methods in the Connections and has SQL strings
  private DBSConnections connection;

  public EmployeeHandler()
  {
    connection = new DBSConnections();
  }

  @Override public void addEmployeeData(Employee employee)
  {
    String sql = "";
    switch (employee.getPosition())
    {
      // employees
      case "Manager":
        sql = "INSERT INTO \"createpolicy\".employees values(" + "'" + employee.getName()
            + "'" + "," + "'" + employee.getAddress() + "'" + "," + "'" + employee.getCPR() + "'" + "," + "'" + employee.getEmail()
            + "'" + "," + "'" + employee.getTlfNr() + "'" + ",'Manager');";
        connection.connectToDB(sql);
        break;

      case "Salesman":
        sql = "INSERT INTO \"createpolicy\".employees values(" + "'" + employee.getName()
            + "'" + "," + "'" + employee.getAddress() + "'" + "," + "'" + employee.getCPR() + "'" + "," + "'" + employee.getEmail()
            + "'" + "," + "'" + employee.getTlfNr() + "'" + ",'Salesman');";
        connection.connectToDB(sql);
        break;

      case "DamageEmployee":
        sql = "INSERT INTO \"createpolicy\".employees values(" + "'" + employee.getName()
            + "'" + "," + "'" + employee.getAddress() + "'" + "," + "'" + employee.getCPR() + "'" + "," + "'" + employee.getEmail()
            + "'" + "," + "'" + employee.getTlfNr() + "'" + ",'Damage-employee');";
        connection.connectToDB(sql);
        break;
    }
  }


  @Override public void readEmployeeData(Employee employee)
  {

  }

  @Override public void updateEmployeeData(Employee employee)
  {
    String sql = "";
    switch (employee.getPosition())
    {
      // employees
      case "Manager":
        sql =
            "Update \"Insurance\".employees set(" + "'" + employee.getName()
                + "'" + "," + "'" + employee.getAddress() + "'" + "," + "'" + employee.getCPR() + "'" + "," + "'" + employee.getEmail()
                + "'" + "," + "'" + employee.getTlfNr() + "'" + ",'Manager');";
        connection.connectToDB(sql);
        break;

      case "Salesman":
        sql = "INSERT INTO \"createpolicy\".employees values(" + "'" + employee.getName()
            + "'" + "," + "'" + employee.getAddress() + "'" + "," + "'" + employee.getCPR() + "'" + "," + "'" + employee.getEmail()
            + "'" + "," + "'" + employee.getTlfNr() + "'" + ",'Salesman');";
        connection.connectToDB(sql);
        break;

      case "DamageEmployee":
        sql = "INSERT INTO \"createpolicy\".employees values(" + "'" + employee.getName()
            + "'" + "," + "'" + employee.getAddress() + "'" + "," + "'" + employee.getCPR() + "'" + "," + "'" + employee.getEmail()
            + "'" + "," + "'" + employee.getTlfNr() + "'" + ",'Damage-employee');";
        connection.connectToDB(sql);
        break;
    }
  }
}
