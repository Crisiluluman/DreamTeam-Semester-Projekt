package server.DBConnection.CustomerDB;

import server.DBConnection.DBConnectionsInterface;
import shared.Customer;
import server.DBConnection.DBConnections;

import java.util.List;

public class CustomerHandler implements CustomerData
{
  private DBConnectionsInterface connection;

  public CustomerHandler()
  {
    connection = new DBConnections();
  }

  @Override public void addCustomerData(Customer customer)
  {
    String sql = "INSERT INTO \"insurance\".customer(name, address, postcode, cpr) values("+"'" + customer.getName() + "'" + ","
        + "'" + customer.getAddress() + "'" + "," +"'"+ customer.getPostcode()+"'" + "," +"'"+ customer.getCprNr() +"'"+ ");";
    connection.AddToDB(sql);

  }

  @Override public void updateCustomerData(Customer customer)
  {
    String sql = "Update \"insurance\".customer set name =" + "'" + customer.getName()+ "'" + ","
        + "address =" + "'" + customer.getAddress() + "'" + ","
        + "postcode =" + "'" + customer.getPostcode() + "'" + ","
        + "cpr =" + "'" + customer.getCprNr() + "' "
        + "where customerno =" + "'" + customer.getCustomerNo() +"'" + ";";
    connection.AddToDB(sql);
  }

  @Override public void deleteCustomerData(int customerNo)
  {
    String sql = "Delete from \"insurance\".customer where customerno =" + "'" + customerNo + "'" +";";
    connection.AddToDB(sql);
  }

  @Override public List TotalCustomers()
  {
    String sql = "SELECT count(customerno) as "+"total"+" from \"insurance\".customer";
    return connection.totalFromDB(sql);
  }

  @Override public List<Customer> readCustomerData()
  {
    String sql = "SELECT * FROM \"insurance\".customer;";
    return connection.fillCustomerTableDB(sql);
  }

  @Override public void clearTableCustomer()
  {
    String sql = "drop table \"insurance\".Customer;";
    connection.AddToDB(sql);
  }

  @Override public void createTableCustomer()
  {
    String sql ="create table \"insurance\".Customer" + "("
        + "customerNo SERIAL," + "name varchar(50) NOT NULL,"
        + "address varchar(50) NOT NULL,"
        + "postcode varchar(4) NOT NULL," + "cpr varchar(10) NOT NULL,"
        + "cr numeric," + "primary key(customerNo)" + ");";
    System.out.println(sql);
    connection.AddToDB(sql);
  }

}
