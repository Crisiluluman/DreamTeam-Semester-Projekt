package server.DBSConnection;

import shared.Employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

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

      /*May work */
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

  public void addData(Employee employee,String position)
  {
    String sql = "";

    switch (position)
    {
      case "Manager":
        sql = "INSERT INTO \"createpolicy\".employees values("+ "'"+ employee.getName()+"'"+
            "," +"'"+ employee.getAddress()+"'"+","+"'"+employee.getCPR()+"'"+","+"'"+employee.getEmail()+"'"+"," +"'"+employee.getTlfNr()+"'"+",'Manager');";
        connectToDB(sql);
        break;

      case "Salesman":
        sql = "INSERT INTO \"createpolicy\".employees values("+ "'"+ employee.getName()+"'"+
            "," +"'"+ employee.getAddress()+"'"+","+"'"+employee.getCPR()+"'"+","+"'"+employee.getEmail()+"'"+"," +"'"+employee.getTlfNr()+"'"+",'Salesman');";
        connectToDB(sql);
        break;

      case "DamageEmployee":
        sql = "INSERT INTO \"createpolicy\".employees values("+ "'"+ employee.getName()+"'"+
            "," +"'"+ employee.getAddress()+"'"+","+"'"+employee.getCPR()+"'"+","+"'"+employee.getEmail()+"'"+"," +"'"+employee.getTlfNr()+"'"+",'Damage-employee');";
        connectToDB(sql);
        break;
    }



  }

  public void updateEmployee(){}

  public void getEmployee(){}

}
