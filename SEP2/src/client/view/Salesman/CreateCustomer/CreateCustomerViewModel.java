package client.view.Salesman.CreateCustomer;

import client.model.Customer.Customer;
import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class CreateCustomerViewModel
{
  private Model model;
  public StringProperty nameTextfield;
  public StringProperty addressTextfield;
  public StringProperty postcodeTextField;
  public StringProperty cprnrTextfield;
  public StringProperty customerNoTextField;
  private Customer customer;

  public CreateCustomerViewModel(Model model)
  {
    this.model = model;
    nameTextfield = new SimpleStringProperty();
    addressTextfield = new SimpleStringProperty();
    postcodeTextField = new SimpleStringProperty();
    cprnrTextfield = new SimpleStringProperty();
    customerNoTextField = new SimpleStringProperty();
  }

  public StringProperty getNameTextfield()
  {
    return nameTextfield;
  }

  public StringProperty getAddressTextfield()
  {
    return addressTextfield;
  }

  public StringProperty getPostcodeTextField()
  {
    return postcodeTextField;
  }

  public StringProperty getCprnrTextfield()
  {
    return cprnrTextfield;
  }

  public StringProperty getCustomerNoTextField()
  {
    return customerNoTextField;
  }

  public void onClick()
  {
    customer = new Customer(String.valueOf(nameTextfield.getValue()), String.valueOf(addressTextfield.getValue()),
        Integer.parseInt(postcodeTextField.getValue()), Integer.parseInt(customerNoTextField.getValue()),
        Integer.parseInt(cprnrTextfield.getValue()));

    saveToDB();
  }

  private void saveToDB()
  {
    Connection connection = null;
    Statement statement = null;

    try
    {
      Class.forName("org.postgresql.Driver");
      connection = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/Sonny", "postgres",
              "1234");
      System.out.println("Database ok");
      System.out.println(customer.getName());
      statement = connection.createStatement();
      String sql = "INSERT INTO \"Customer\".customer values(" + customer.getCostumerNo() + "," + "'" + customer.getName() + "'" + "," + "'" + customer.getAddress() + "'" + "," + customer.getPostcode() + "," + customer.getCprNr() + ");";
//      String sql = "INSERT INTO \"Customer\".customer VALUES (" + customer.getCostumerNo() + ", " + "'" + customer.getName() + "'" + "," + "'" + customer.getAddress() + "'" + "," + customer.getPostcode() + "," + customer.getCprNr() + ")";

      statement.executeUpdate(sql);
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
}
