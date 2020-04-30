package client.view.Manager.ManageEmployee;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.Manager.ManagerView.ManagerViewModel;
import client.view.viewController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class ManageEmployeeController implements viewController
{
  public Label loggedInLabel;
  public TextField searchTextField;
  public Button searchButton;
  public Button selectButton;
  public TableView employeeTableView;
  public Button deleteButton;
  public Button backButton;
  public Button createEmployeeButton;
  private ViewHandler vh;
  private ManageEmployeeViewModel mevm;
  private Region root;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf, Region root)
  {
    this.vh = vh;
    this.root = root;
    mevm = vmf.getManageEmployeeViewModel();

  }

  @Override
  public Region getRoot() {
    return root;
  }
  public void onCreateEmployee()
  {
    vh.openView("CreateEmployee");
  }

  public void onSelectEmployee(){
    vh.openView("EditEmployee");
  }
}
