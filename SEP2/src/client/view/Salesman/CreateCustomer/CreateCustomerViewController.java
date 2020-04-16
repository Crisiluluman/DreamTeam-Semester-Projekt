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
  @FXML public TextField householdTextfield;
  @FXML public TextField CustomerNoTextField;

  private ViewHandler vh;
  private CreateCustomerViewModel ccv;
  private Region root;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf, Region root)
{
  this.vh = vh;
  ccv = vmf.getCreateCustomerViewModel();
  this.root = root;
}

  @Override
  public Region getRoot() {
    return root;
  }


}


