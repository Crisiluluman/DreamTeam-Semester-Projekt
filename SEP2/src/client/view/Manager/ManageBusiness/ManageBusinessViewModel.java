package client.view.Manager.ManageBusiness;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.List;

public class ManageBusinessViewModel
{
  private Model model;
  private StringProperty totalCustomersTextField;
  private StringProperty totalEmployeesTextField;
  private StringProperty totalSalesmenTextField;
  private StringProperty totalDamageEmployeeTextField;
  private StringProperty totalManagerTextField;

  private StringProperty totalDamagesTextField;
  private StringProperty totalPoliciesTextField;
  private StringProperty income;
  private StringProperty expenses;
  public ManageBusinessViewModel(Model model)
  {
    this.model = model;
    totalCustomersTextField = new SimpleStringProperty();
    totalEmployeesTextField = new SimpleStringProperty();
    totalDamagesTextField = new SimpleStringProperty();
    totalPoliciesTextField = new SimpleStringProperty();
    totalSalesmenTextField = new SimpleStringProperty();
    totalDamageEmployeeTextField = new SimpleStringProperty();
    totalManagerTextField = new SimpleStringProperty();
    income = new SimpleStringProperty();
    expenses = new SimpleStringProperty();
  }


  public StringProperty totalSalesmenTextFieldProperty()
  {
    return totalSalesmenTextField;
  }

  public StringProperty totalDamageEmployeeTextFieldProperty()
  {
    return totalDamageEmployeeTextField;
  }

  public StringProperty totalManagerTextFieldProperty()
  {
    return totalManagerTextField;
  }

  public StringProperty TotalPoliciesTextFieldProperty()
  {
    return totalPoliciesTextField;
  }

  public StringProperty totalCustomersTextFieldProperty()
  {
    return totalCustomersTextField;
  }

  public void setTotalTextField()
  {
    this.totalCustomersTextField.set(String.valueOf(model.totalCustomers().get(0)));
    totalEmployeesTextField.set(String.valueOf(model.totalEmployees().get(0)));
    totalDamagesTextField.set(String.valueOf(model.totalDamages().get(0)));
    totalPoliciesTextField.set(String.valueOf(model.totalPolicies().get(0)));
    totalSalesmenTextField.set(String.valueOf(model.totalSalesmen().get(0)));
    totalDamageEmployeeTextField.set(String.valueOf(model.totalDamageEmployee().get(0)));
    totalManagerTextField.set(String.valueOf(model.totalManager().get(0)));


    income.set(String.valueOf(model.getIncome().get(0)));
    expenses.set(String.valueOf(model.getExpenses().get(0)));
  }

  public StringProperty totalEmployeesTextFieldProperty()
  {
    return totalEmployeesTextField;
  }

  public StringProperty totalDamagesTextFieldProperty()
  {
    return totalDamagesTextField;
  }

  public StringProperty incomeProperty()
  {
    return income;
  }

  public StringProperty expensesProperty()
  {
    return expenses;
  }
}
