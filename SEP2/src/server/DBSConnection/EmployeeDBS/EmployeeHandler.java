package server.DBSConnection.EmployeeDBS;

import server.DBSConnection.DBSConnections;
import shared.Employee;

public class EmployeeHandler implements EmployeeData
{
  // Calls methods in the Connections and has SQL strings
  private DBSConnections connection;

  public EmployeeHandler(DBSConnections connection)
  {
    this.connection = connection;
  }

  @Override public void storeEmployeeData(Employee employee)
  {

  }

  @Override public void readEmployeeData(Employee employee)
  {

  }


}
