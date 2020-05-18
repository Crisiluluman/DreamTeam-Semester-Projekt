package server.DBConnection.CustomerDB;

import client.model.Customer.Customer;
import javafx.scene.control.TableView;
import server.DBConnection.DBConnections;

public class CustomerHandler implements CustomerData
{
  private DBConnections connection;

  public CustomerHandler(DBConnections connection)
  {
    this.connection = connection;
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

  @Override public void readCustomerData(TableView TV)
  {
    String sql = "SELECT * FROM \"createpolicy\".customer;";
    connection.fillTableDB(TV, sql);
  }
}
