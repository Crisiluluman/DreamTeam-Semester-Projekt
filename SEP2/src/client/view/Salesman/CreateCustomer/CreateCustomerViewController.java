package client.view.Salesman.CreateCustomer;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.viewController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class CreateCustomerViewController implements viewController
{
  @FXML public TextField nameTextfield;
  @FXML public TextField addressTextfield;
  @FXML public TextField postcodeTextField;
  @FXML public TextField cprnoTextfield;
  @FXML public TextField CustomerNoTextField;
  @FXML public Label nameLabel;
  @FXML public Label addressLabel;
  @FXML public Label postcodeLabel;
  @FXML public Label cprnoLabel;
  @FXML public Label customernoLabel;

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
  cprnoTextfield.textProperty().bindBidirectional(ccv.getCprnoTextfield());
  nameLabel.textProperty().bind(ccv.getnameLabelProperty());
  addressLabel.textProperty().bind(ccv.getaddressLabelProperty());
  postcodeLabel.textProperty().bind(ccv.getpostcodeLabelProperty());
  cprnoLabel.textProperty().bind(ccv.getcprnoLabelProperty());
  ccv.clearTextfields();
}

  @Override
  public Region getRoot() {
    return root;
  }

  public void onCreateCustomer()
  {
    if(ccv.checker())
    {
      ccv.onClick();
      ccv.clearTextfields();
      ccv.clearLabels();
    }

    if(ccv.getUpdate())
    {
      vh.updateCustomerViews();
      vh.openView("Salesman");

    }
  }
  public void onCancel()
  {
    ccv.clearTextfields();
    vh.openView("Salesman");
  }

}


