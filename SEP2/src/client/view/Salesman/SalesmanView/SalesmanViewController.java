package client.view.Salesman.SalesmanView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.viewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class SalesmanViewController implements viewController
{
  @FXML public Label loggedInLabel;
  @FXML public TableView customerTableView;
  @FXML public TextField searchTextField;

  private ViewHandler vh;
  private SalesmanViewModel svm;
  private Region root;

public void init( ViewHandler vh, ViewModelFactory vmf, Region root)
{
  this.vh = vh;
  svm = vmf.getSalesmanViewModel();
  this.root = root;


}



}
