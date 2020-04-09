package client.view.Salesman.ManageCustomer;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.Salesman.SalesmanView.SalesmanViewModel;
import client.view.viewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class ManageCustomerViewController implements viewController
{
  @FXML TextField manageCustomerTextfield;
  @FXML TextField manageCustomerAddress;
  @FXML TextField manageCustomerPostcode;
  @FXML TextField manageCustomerCPR;
  @FXML TextField manageCustomerHousehold;


  private ViewHandler vh;
  private ManageCustomerViewModel mcv;
  private Region root;

  public void init( ViewHandler vh, ViewModelFactory vmf, Region root)
  {
    this.vh = vh;
    mcv = vmf.getManageCustomerViewModel();
    this.root = root;

  }

  @Override
  public Region getRoot() {
    return root;
  }

}
