package client.view.Salesman.CreateCustomer;

import client.core.ViewHandler;
import client.model.Customer.Customer;
import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.regex.Pattern;

public class CreateCustomerViewModel
{
  private Model model;
  private boolean flag = true;
  public StringProperty nameTextfield;
  public StringProperty addressTextfield;
  public StringProperty postcodeTextField;
  public StringProperty cprnoTextfield;
  public StringProperty customerNoTextField;
  private Customer customer;
  public StringProperty nameLabel;
  public StringProperty addressLabel;
  public StringProperty postcodeLabel;
  public StringProperty cprnoLabel;
  public StringProperty customernoLabel;

  public CreateCustomerViewModel(Model model)
  {
    this.model = model;
    nameTextfield = new SimpleStringProperty();
    addressTextfield = new SimpleStringProperty();
    postcodeTextField = new SimpleStringProperty();
    cprnoTextfield = new SimpleStringProperty();
    customerNoTextField = new SimpleStringProperty();
    nameLabel = new SimpleStringProperty();
    addressLabel = new SimpleStringProperty();
    postcodeLabel = new SimpleStringProperty();
    cprnoLabel = new SimpleStringProperty();
    customernoLabel = new SimpleStringProperty();


  }

  public StringProperty getnameLabelProperty()
  {
    return nameLabel;
  }

  public StringProperty getaddressLabelProperty()
  {
    return addressLabel;
  }

  public StringProperty getpostcodeLabelProperty()
  {
    return postcodeLabel;
  }

  public StringProperty getcprnoLabelProperty()
  {
    return cprnoLabel;
  }

  public StringProperty getcustomernoLabelProperty()
  {
    return customernoLabel;
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

  public StringProperty getCprnoTextfield()
  {
    return cprnoTextfield;
  }

  public StringProperty getCustomerNoTextField()
  {
    return customerNoTextField;
  }

  public void onClick()
  {

    if(nameTextfield.getValue() !=null && addressTextfield.getValue() != null && postcodeTextField.getValue() != null && cprnoTextfield.getValue() != null && customerNoTextField != null)
    {
      customer = new Customer(String.valueOf(nameTextfield.getValue()), String.valueOf(addressTextfield.getValue()),
          Integer.parseInt(postcodeTextField.getValue()), Integer.parseInt(customerNoTextField.getValue()),
          Integer.parseInt(cprnoTextfield.getValue()));
    }

    System.out.println(nameTextfield.getValue());
    if(nameTextfield.getValue() == null || (Pattern.matches("[a-åA-Å] +",nameTextfield.getValue())))
    {
      nameLabel.setValue("Invalid input - try again");
      flag = false;
    }
    else if(addressTextfield.getValue() == null)
    {
      addressLabel.setValue("Invalid input - try again");
      flag = false;
    }

    else if(postcodeTextField.getValue() == null || Integer.parseInt(postcodeTextField.getValue()) > 9990 || Integer.parseInt(postcodeTextField.getValue()) < 1000)
    {
      postcodeLabel.setValue("Invalid input - try again");
      flag = false;
    }

    else if(cprnoTextfield.getValue() == null || Integer.parseInt(cprnoTextfield.getValue()) < 0101000001 || Integer.parseInt(cprnoTextfield.getValue()) > Long.parseLong("3112999999"))
    {
      cprnoLabel.setValue("Invalid input - try again");
      flag = false;
    }

    else if(customerNoTextField.getValue() == null || Pattern.matches("[a-åA-Å] +",customerNoTextField.getValue()))
    {
      customernoLabel.setValue("Invalid input - try again");
      flag = false;
    }

    else
    {
      nameLabel.setValue("");
      addressLabel.setValue("");
      postcodeLabel.setValue("");
      cprnoLabel.setValue("");
      saveToDB();
    }
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
      statement = connection.createStatement();
      String sql = "INSERT INTO \"Customer\".customer values(" + customer.getCostumerNo() + "," + "'" + customer.getName() + "'" + ","
          + "'" + customer.getAddress() + "'" + "," + customer.getPostcode() + "," + customer.getCprNr() + ");";


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

  public boolean getFlag()
  {
    return flag;
  }

}
