package server.DBSConnection.CustomerDBS;

import client.model.Customer.Customer;
import server.DBSConnection.DBSConnections;

public class CustomerHandler implements CustomerData
{
  private DBSConnections connection;

  public CustomerHandler(DBSConnections connection)
  {
    this.connection = connection;
  }

  @Override public void addCustomerData(Customer customer)
  {
    String sql = "INSERT INTO \"Insurance\".Customer values(" +"'"+ customer.getCostumerNo()+"'" + "," + "'" + customer.getName() + "'" + ","
        + "'" + customer.getAddress() + "'" + "," +"'"+ customer.getPostcode()+"'" + "," +"'"+ customer.getCprNr() +"'"+ ");";
    connection.connectToDB(sql);

  }
}
