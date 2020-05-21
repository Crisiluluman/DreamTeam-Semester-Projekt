package client.view.Salesman.ManageCustomer;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import shared.Customer;

public class ManageCustomerViewModel
{
  private Model model;
  public StringProperty nameTextfield;
  public StringProperty addressTextfield;
  public StringProperty postcodeTextField;
  public StringProperty cprnoTextfield;
  public StringProperty customerNoTextField;

  public ManageCustomerViewModel(Model model)
  {
    nameTextfield = new SimpleStringProperty();
    addressTextfield = new SimpleStringProperty();
    postcodeTextField = new SimpleStringProperty();
    cprnoTextfield = new SimpleStringProperty();
    customerNoTextField = new SimpleStringProperty();
    this.model = model;
  }

  public void setFields(ObservableList<String> list)
  {
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
}
