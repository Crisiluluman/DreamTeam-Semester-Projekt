package client.view.Manager.ManageBusiness;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.viewController;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class ManageBusinessController implements viewController
{
  @FXML private TextField totalCustomersTextField;
  @FXML private TextField totalEmployeesTextField;
  @FXML private TextField totalDamageTextField;
  @FXML private TextField totalPoliciesTextField;
  @FXML private TextField totalSalesmenTextField;
  @FXML private TextField totalDamageEmployeeTextField;
  @FXML private TextField totalManagerTextField;


  @FXML private BarChart<?, ?> bar_chart;
  @FXML private CategoryAxis x;
  @FXML private NumberAxis y;


  private ViewHandler vh;
  private ManageBusinessViewModel mbvm;
  private Region root;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf, Region root)
  {
    this.vh = vh;
    this.root = root;
    mbvm = vmf.getManageBusinessViewModel();
    totalCustomersTextField.textProperty().bind(mbvm.totalCustomersTextFieldProperty());
    totalEmployeesTextField.textProperty().bind(mbvm.totalEmployeesTextFieldProperty());
    totalDamageTextField.textProperty().bind(mbvm.totalDamagesTextFieldProperty());
    totalPoliciesTextField.textProperty().bind(mbvm.TotalPoliciesTextFieldProperty());
    totalSalesmenTextField.textProperty().bind(mbvm.totalSalesmenTextFieldProperty());
    totalDamageEmployeeTextField.textProperty().bind(mbvm.totalDamageEmployeeTextFieldProperty());
    totalManagerTextField.textProperty().bind(mbvm.totalManagerTextFieldProperty());
    mbvm.setTotalTextField();

    XYChart.Series set1 = new XYChart.Series<>();

   if(mbvm.incomeProperty() != null && mbvm.expensesProperty() != null)
   {
     set1.getData().add(new XYChart.Data("Income", Integer.parseInt(mbvm.incomeProperty().getValue())));
     set1.getData().add(new XYChart.Data("Expenses", Integer.parseInt(mbvm.expensesProperty().getValue())));
     bar_chart.getData().addAll(set1);
   }
  }
  @Override
  public Region getRoot() {
    return root;
  }

  public void onBack()
  {
    vh.openView("Manager");
  }
}
