package server.DBConnection.CustomerDB;

import shared.Customer;
import javafx.scene.control.TableView;
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
  {
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

  @Override public void deleteCustomerData(Customer customer)
  {
    String sql = "Delete from \"insurance\".customer where customerno =" + "'" + customer.getCustomerNo() + "'" +";";
    connection.AddToDB(sql);
  }

  @Override public List<Customer> readCustomerData()
  {
    String sql = "SELECT * FROM \"insurance\".customer;";
    return connection.fillTableDB(sql);
  }
}
