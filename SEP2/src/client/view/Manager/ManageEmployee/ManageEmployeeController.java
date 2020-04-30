package client.view.Manager.ManageEmployee;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.Manager.ManagerView.ManagerViewModel;
import client.view.viewController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;

public class ManageEmployeeController implements viewController
{
  @FXML private TableColumn ColumnPosition;
  @FXML private  TableColumn ColumnCPR;
  @FXML private  TableColumn ColumnAddress;
  @FXML private  TableColumn ColumnName;
  @FXML private Label loggedInLabel;
  @FXML private TextField searchTextField;
  @FXML private Button searchButton;
  @FXML private Button selectButton;
  @FXML private TableView employeeTableView;
  @FXML private Button deleteButton;
  @FXML private Button backButton;
  @FXML private Button createEmployeeButton;
  private ViewHandler vh;
  private ManageEmployeeViewModel mevm;
  private Region root;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf, Region root)
  {
    this.vh = vh;
    this.root = root;
    mevm = vmf.getManageEmployeeViewModel();
    mevm.getEmployeesFromDB(employeeTableView);
    ColumnName.textProperty().bind(mevm.getEmployeesFromDB());
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
