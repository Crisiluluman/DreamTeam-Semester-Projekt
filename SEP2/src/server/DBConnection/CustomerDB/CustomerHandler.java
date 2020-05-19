package server.DBConnection.CustomerDB;

import shared.Customer;
import server.DBConnection.DBConnections;

import java.util.List;

public class CustomerHandler implements CustomerData
{
  private DBConnections connection;

  public CustomerHandler()
  {
    connection = new DBConnections();
  }

  @Override public void addCustomerData(Customer customer)
  { //todo lave database ens
    String sql = "INSERT INTO \"insurance\".customer(name, address, postcode, cpr) values("+"'" + customer.getName() + "'" + ","
        + "'" + customer.getAddress() + "'" + "," +"'"+ customer.getPostcode()+"'" + "," +"'"+ customer.getCprNr() +"'"+ ");";
    connection.AddToDB(sql);

  }

  @Override public void updateCustomerData(Customer customer, Customer customerOld)
  {
    String sql = "Update \"insurance\".customer set name =" + "'" + customer.getName()+ "'" + ","
        + "address =" + "'" + customer.getAddress() + "'" + ","
        + "postcode =" + "'" + customer.getPostcode() + "'" + ","
        + "cpr =" + "'" + customer.getCprNr() + "' "
        + "where cpr =" + "'" + customerOld.getCprNr() +"'" + ";";
    connection.AddToDB(sql);
  }

  @Override public void removeCustomerData(Customer customer)
  {

  }

  @Override public List<Customer> readCustomerData()
  {
    String sql = "SELECT * FROM \"insurance\".customer;";
    return connection.fillCustomerTableDB(sql);
  }
}
