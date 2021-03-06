package client.view.Salesman.CreateCustomer;

import client.core.ViewHandler;
import shared.Customer;
import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.regex.Pattern;

public class CreateCustomerViewModel implements PropertyChangeListener
{
  private Model model;
  public StringProperty nameTextfield;
  public StringProperty addressTextfield;
  public StringProperty postcodeTextField;
  public StringProperty cprnoTextfield;
  public StringProperty customerNoTextField;
  private shared.Customer customer;
  public StringProperty nameLabel;
  public StringProperty addressLabel;
  public StringProperty postcodeLabel;
  public StringProperty cprnoLabel;
  public StringProperty customernoLabel;
  private boolean update;

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
    update = false;
    this.model.addListener("updateCustomers",this);

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


  public void onClick()
  {

    customer = new Customer(String.valueOf(nameTextfield.getValue()), String.valueOf(addressTextfield.getValue()),
        Integer.parseInt(postcodeTextField.getValue()),
        Long.parseLong(cprnoTextfield.getValue()));
      clearLabels();
      model.addCustomer(customer);

  }

  public void clearLabels()
  {
  nameLabel.setValue("");
  addressLabel.setValue("");
  postcodeLabel.setValue("");
  cprnoLabel.setValue("");
  }



  public void clearTextfields()
  {
    nameTextfield.setValue("");
    addressTextfield.setValue("");
    postcodeTextField.setValue("");
    cprnoTextfield.setValue("");
    customerNoTextField.setValue("");
  }


  public boolean checker()
  {
    clearLabels();

    if(nameTextfield.getValue().equals("") || !(Pattern.matches("[a-åA-Å]+",nameTextfield.getValue())))
    {
      nameLabel.setValue("Invalid input - try again");
      return false;
    }
    if(addressTextfield.getValue().equals(""))
    {
      addressLabel.setValue("Invalid input - try again");
      return false;
    }

    if(postcodeTextField.getValue().equals("") || Integer.parseInt(postcodeTextField.getValue()) > 9991 || Integer.parseInt(postcodeTextField.getValue()) < 999)
    {
      postcodeLabel.setValue("Invalid input - try again");
      return false;
    }

    if(cprnoTextfield.getValue().equals("") || !Pattern.matches("[0-9]+",cprnoTextfield.getValue()) || Long.parseLong(cprnoTextfield.getValue()) < Long.parseLong("0101000000")  || Long.parseLong(cprnoTextfield.getValue()) > Long.parseLong("3112999999"))
    {
      cprnoLabel.setValue("Invalid input - try again");
      return false;
    }
    
    return true;
  }

  public boolean getUpdate()
  {
    return update;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    update = true;
  }
}
