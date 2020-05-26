package client.view.Salesman.ManageCustomer;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import shared.Customer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ManageCustomerViewModel implements PropertyChangeListener
{
  private Model model;
  public StringProperty nameTextfield;
  public StringProperty addressTextfield;
  public StringProperty postcodeTextField;
  public StringProperty cprnoTextfield;
  public StringProperty customerNoTextField;
  private ObservableList list;
  private boolean update;

  public ManageCustomerViewModel(Model model)
  {
    nameTextfield = new SimpleStringProperty();
    addressTextfield = new SimpleStringProperty();
    postcodeTextField = new SimpleStringProperty();
    cprnoTextfield = new SimpleStringProperty();
    customerNoTextField = new SimpleStringProperty();
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

  public boolean getUpdate()
  {
    return update;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    update = true;
  }
}
