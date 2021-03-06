package server.DBConnection;

import shared.*;
import client.model.Salesman.Salesman;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnections implements DBConnectionsInterface
{

  // Has a lot of logic, dealing with the database

  @Override public void AddToDB(String sql)
  {
    Connection connection = null;
    Statement statement = null;

    try
    {
      Class.forName("org.postgresql.Driver");
      System.out.println("før");
      connection = DriverManager

          .getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
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

  @Override public List<Customer> fillCustomerTableDB(String sql)
  {
    ArrayList<Customer> list = new ArrayList<>();
    ObservableList<String> row;

    Connection c = null;
    Statement stmt = null;
    try
    {
      Class.forName("org.postgresql.Driver");
      c = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");

      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery(sql);


      while(rs.next())
      {
        //We are using non property style for making dynamic table
        String name = rs.getString("name");
        String address = rs.getString("address");
        int postcode = rs.getInt("postcode");
        int customerNo = rs.getInt("customerNo");
        long cprNr = rs.getLong("cpr");

        Customer customer = new Customer(name, address, postcode,
            cprNr);
        customer.setCustomerNo(customerNo);
        list.add(customer);

      }
      stmt.close();
      c.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("Error on Building Data");
    }
    System.out.println(list);
    return list;
  }
  @Override public List<Policy> fillPolicyTableDB(String sql)
  {
    ArrayList<Policy> list = new ArrayList<>();
    ObservableList<String> row;

    Connection c = null;
    Statement stmt = null;
    try
    {
      Class.forName("org.postgresql.Driver");
      c = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");

      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery(sql);


      while(rs.next())
      {
        //We are using non property style for making dynamic table
        int policyNo = rs.getInt("policyNo");
        String type = rs.getString("type");
        int price = rs.getInt("price");
        int deductible = rs.getInt("deductible");
        String coverage = rs.getString("coverage");
        int customerNo = rs.getInt("customerno");

       Policy policy = new Policy(type,price,deductible,coverage,customerNo);
       policy.setPoliceNo(policyNo);
        list.add(policy);

      }
      stmt.close();
      c.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("Error on Building Data");
    }
    System.out.println(list);
    return list;
  }
  @Override public List<Employee> fillEmployeeTableDB(String sql)
{
  ArrayList<Employee> list = new ArrayList<>();
  ObservableList<String> row;

  Connection c = null;
  Statement stmt = null;
  try
  {
    Class.forName("org.postgresql.Driver");
    c = DriverManager
        .getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");

    c.setAutoCommit(false);
    System.out.println("Opened database successfully");

    stmt = c.createStatement();
    ResultSet rs = stmt.executeQuery(sql);


    while(rs.next())
    {
      Employee employee = null;
      //We are using non property style for making dynamic table
      int employeeNo = rs.getInt("employeeno");
      String name = rs.getString("name");
      String address = rs.getString("address");
      long cpr = rs.getLong("cpr");
      int tlfnr = rs.getInt("tlfnr");
      String email = rs.getString("email");
      String position = rs.getString("position");

      employee = new Salesman(name,address,cpr,email,tlfnr,position);
      employee.setEmployeeNo(employeeNo);
      list.add(employee);

    }
    stmt.close();
    c.close();
  }
  catch (Exception e)
  {
    e.printStackTrace();
    System.out.println("Error on Building Data");
  }
  System.out.println(list);
  return list;
}

  @Override public List<Damage> fillDamageTableDB(String sql, int policeno)
  {
    ArrayList<Damage> list = new ArrayList<>();
    ObservableList<String> row;

    Connection c = null;
    Statement stmt = null;
    try
    {
      Class.forName("org.postgresql.Driver");
      c = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");

      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery(sql);



      while(rs.next())
      {
        Employee employee = null;
        //We are using non property style for making dynamic table
        int damageNo = rs.getInt("damageNo");
        double expenses = rs.getDouble("expenses");
        String info = rs.getString("info");
        String dpolicytype = rs.getString("dpolicytype");

        Damage damage = new Damage(policeno,dpolicytype,expenses,info);
damage.setDamageNo(damageNo);
        list.add(damage);

      }
      stmt.close();
      c.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("Error on Building Data");
    }
    System.out.println(list);
    return list;

  }

  @Override public List totalFromDB(String sql)
  {
    ArrayList<Integer> list = new ArrayList<>();

    Connection c = null;
    Statement stmt = null;
    try
    {
      Class.forName("org.postgresql.Driver");
      c = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");

      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery(sql);


      while(rs.next())
      {
        //We are using non property style for making dynamic table

        int total = rs.getInt("total");


        list.add(total);

      }
      stmt.close();
      c.close();
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("Error on Building Data");
    }
    System.out.println(list);
    return list;
  }

}
