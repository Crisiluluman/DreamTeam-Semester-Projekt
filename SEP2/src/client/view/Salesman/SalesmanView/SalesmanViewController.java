package client.view.Salesman.SalesmanView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.model.Customer.Customer;
import client.view.viewController;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class SalesmanViewController implements viewController
{
  @FXML private Label loggedInLabel;
  @FXML private TableView customerTableView;
  @FXML private TextField searchTextField;
  @FXML


  private ViewHandler vh;
  private SalesmanViewModel svm;
  private Region root;

public void init( ViewHandler vh, ViewModelFactory vmf, Region root)
{
  this.vh = vh;
  svm = vmf.getSalesmanViewModel();
  this.root = root;


}

  @Override
  public Region getRoot() {
    return root;
  }

public void onCreateCustomer()
{
  vh.openView("CreateCustomer");
}
public void onLogOut()
{
  vh.openView("Login");
}
public void onSelect()
{
  ObservableList Data = svm.editSelect(customerTableView);
  if (Data != null)
{
  vh.openEditManageCustomer(Data);
}
}

public void onDelete()
{
  svm.Delete(customerTableView);
}
}
