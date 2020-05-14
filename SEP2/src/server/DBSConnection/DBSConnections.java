package server.DBSConnection;

import shared.Employee;

import java.sql.*;

public class DBSConnections
{
  // Has a lot of logic, dealing with the database

  public void connectToDB(String sql)
  {
    Connection connection = null;
    Statement statement = null;

    try
    {
      Class.forName("org.postgresql.Driver");
      connection = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
              "1122");
      statement = connection.createStatement();

      String toSql = sql;

      statement.executeUpdate(toSql);
      statement.close();
      connection.close();
    }
    catch (Exception e)
    {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);

    }
    System.out.println("Insert to Database ok!");
  }




  public void updateEmployee(){}

  public void getEmployee(){}

}
