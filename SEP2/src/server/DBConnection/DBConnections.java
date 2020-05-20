package server.DBConnection;

import client.model.Damage.Damage;
import client.model.DamageEmployee.DamageEmployee;
import client.model.Manager.Manager;
import client.model.Salesman.Salesman;
import shared.Employee;
import shared.Policy;
import javafx.collections.ObservableList;
import shared.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnections
{

  // Has a lot of logic, dealing with the database

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
              "ybf56qka");
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

  public List<Customer> fillCustomerTableDB(String sql)
  {
    ArrayList<Customer> list = new ArrayList<>();
    ObservableList<String> row;

    Connection c = null;
    Statement stmt = null;
    try
    {
      Class.forName("org.postgresql.Driver");
      c = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1122");
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

        Customer customer = new Customer(name, address, postcode, customerNo,
            cprNr);
        list.add(customer);
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("Error on Building Data");
    }
    System.out.println(list);
    return list;
  }
  public List<Policy> fillPolicyTableDB(String sql)
  {
    ArrayList<Policy> list = new ArrayList<>();
    ObservableList<String> row;

    Connection c = null;
    Statement stmt = null;
    try
    {
      Class.forName("org.postgresql.Driver");
      c = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1122");
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

       Policy policy = new Policy(policyNo,type,price,deductible,coverage,customerNo);
        list.add(policy);
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("Error on Building Data");
    }
    System.out.println(list);
    return list;
  }
  public List<Employee> fillEmployeeTableDB(String sql)
{
  ArrayList<Employee> list = new ArrayList<>();
  ObservableList<String> row;

  Connection c = null;
  Statement stmt = null;
  try
  {
    Class.forName("org.postgresql.Driver");
    c = DriverManager
        .getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1122");
    c.setAutoCommit(false);
    System.out.println("Opened database successfully");

    stmt = c.createStatement();
    ResultSet rs = stmt.executeQuery(sql);

    while(rs.next())
    {
      Employee employee = null;
      //We are using non property style for making dynamic table
      String name = rs.getString("name");
      String address = rs.getString("address");
      int cpr = rs.getInt("cpr");
      int tlfnr = rs.getInt("tlfnr");
      String email = rs.getString("email");
      String position = rs.getString("position");

      employee = new Salesman(name,address,cpr,email,tlfnr,position);

      list.add(employee);
    }
  }
  catch (Exception e)
  {
    e.printStackTrace();
    System.out.println("Error on Building Data");
  }
  System.out.println(list);
  return list;
}

  public List<Damage> fillDamageTableDB(String sql,int policeno)
  {
    ArrayList<Damage> list = new ArrayList<>();
    ObservableList<String> row;

    Connection c = null;
    Statement stmt = null;
    try
    {
      Class.forName("org.postgresql.Driver");
      c = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1122");
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

        Damage damage = new Damage(policeno,dpolicytype,expenses,damageNo,info);

        list.add(damage);
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
      System.out.println("Error on Building Data");
    }
    System.out.println(list);
    return list;
  }

  public void updateEmployee(){}

  public void getEmployee(){}

}
