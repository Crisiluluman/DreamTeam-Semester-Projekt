package client.view.Salesman.ManageCustomer;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import shared.Customer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.regex.Pattern;

public class ManageCustomerViewModel implements PropertyChangeListener
{
  private Model model;
  public StringProperty nameTextfield;
  public StringProperty addressTextfield;
  public StringProperty postcodeTextField;
  public StringProperty cprnoTextfield;
  public StringProperty customerNoTextField;
  public StringProperty nameLabel;
  public StringProperty addressLabel;
  public StringProperty postcodeLabel;
  public StringProperty cprnoLabel;
  public StringProperty customernoLabel;
  private ObservableList list;
  private boolean update;

  public ManageCustomerViewModel(Model model)
  {
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
    this.model = model;
    this.model.addListener(this);
    update = false;
  }

  public void setFields(ObservableList<String> list)
  {
    this.list=list;
    customerNoTextField.setValue(String.valueOf(list.get(4)));
    nameTextfield.setValue(list.get(0));
    addressTextfield.setValue(list.get(1));
    postcodeTextField.setValue(String.valueOf(list.get(2)));
    cprnoTextfield.setValue(String.valueOf(list.get(3)));
  }
public void onSave()
{
  Customer customer = new Customer(String.valueOf(nameTextfield.getValue()), String.valueOf(addressTextfield.getValue()),
      Integer.parseInt(postcodeTextField.getValue()),
      Long.parseLong(cprnoTextfield.getValue()));
  customer.setCustomerNo(Integer.parseInt((String)list.get(4)));
  model.updateCustomer(customer);
}

  public boolean checker()
  {
    clearLabels();

    if(nameTextfield.getValue().equals("") || !(Pattern
        .matches("[a-åA-Å]+",nameTextfield.getValue())))
    {
      nameLabel.setValue("Invalid input - try again");
      return false;
    }
    if(addressTextfield.getValue().equals(""))
    {
      addressLabel.setValue("Invalid input - try again");
      return false;
    }

    if(postcodeTextField.getValue().equals("") || Integer.parseInt(postcodeTextField.getValue()) > 9990 || Integer.parseInt(postcodeTextField.getValue()) < 1000)
    {
      postcodeLabel.setValue("Invalid input - try again");
      return false;
    }

    if(cprnoTextfield.getValue().equals("") || Pattern.matches("[a-åA-Å]+",cprnoTextfield.getValue()) || Long.parseLong(cprnoTextfield.getValue()) < Long.parseLong("0101000001")  || Long.parseLong(cprnoTextfield.getValue()) > Long.parseLong("3112999999"))
    {
      cprnoLabel.setValue("Invalid input - try again");
      return false;
    }

    return true;
  }

  public void clearLabels()
  {
    nameLabel.setValue("");
    addressLabel.setValue("");
    postcodeLabel.setValue("");
    cprnoLabel.setValue("");
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


  public boolean getUpdate()
  {
    return update;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    update = true;
  }
}
