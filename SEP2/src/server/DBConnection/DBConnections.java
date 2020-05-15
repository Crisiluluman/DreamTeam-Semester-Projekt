package server.DBConnection;

import java.sql.*;

public class DBConnections
{

  // Has a lot of logic, dealing with the database

/*
  public void AddToDB(String sql)
  {
    Connection connection = null;
    Statement statement = null;

    try
    {
      Class.forName("org.postgresql.Driver");
      System.out.println("før");
      connection = DriverManager

          .getConnection("jdbc:postgresql://localhost:5432/Sonny", "postgres",
              "1234");
      System.out.println("efter");
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
*/

  public void AddToDB(String sql)
  {
    Connection connection = null;
    Statement statement = null;

    try
    {
      Class.forName("org.postgresql.Driver");
      System.out.println("før");
      connection = DriverManager

          .getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
              "1234");
      System.out.println("efter");
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

  public void fillTableDB()
  {

  }



  public void updateEmployee(){}

  public void getEmployee(){}

}
