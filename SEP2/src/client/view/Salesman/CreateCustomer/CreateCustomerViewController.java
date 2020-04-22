package client.view.Salesman.CreateCustomer;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.viewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class CreateCustomerViewController implements viewController
{
  @FXML public TextField nameTextfield;
  @FXML public TextField addressTextfield;
  @FXML public TextField postcodeTextField;
  @FXML public TextField cprnrTextfield;
  @FXML public TextField CustomerNoTextField;

  private ViewHandler vh;
  private CreateCustomerViewModel ccv;
  private Region root;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf, Region root)
{
  this.vh = vh;
  ccv = vmf.getCreateCustomerViewModel();
  this.root = root;
  nameTextfield.textProperty().bindBidirectional(ccv.getNameTextfield());
  addressTextfield.textProperty().bindBidirectional(ccv.getAddressTextfield());
  postcodeTextField.textProperty().bindBidirectional(ccv.getPostcodeTextField());
  cprnrTextfield.textProperty().bindBidirectional(ccv.getCprnrTextfield());
  CustomerNoTextField.textProperty().bindBidirectional(ccv.getCustomerNoTextField());
}

  @Override
  public Region getRoot() {
    return root;
  }

  public void onCreateCustomer()
  {
    ccv.onClick();
    vh.openView("Salesman");
  }
  public void onCancel()
  {
    vh.openView("Salesman");
  }

}


