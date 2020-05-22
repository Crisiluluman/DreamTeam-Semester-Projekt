package client.view.Salesman.CreatePolicy;

import client.model.Model;
import javafx.collections.ObservableList;
import shared.Policy;
import javafx.beans.property.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.regex.Pattern;

public class CreatePoliceViewModel implements PropertyChangeListener
{
  private Model model;
  CreatePoliceViewController controller;
  private StringProperty policeType;
  private StringProperty policyNr;
  private StringProperty price;
  private StringProperty deductible;
  private StringProperty coverage;
  private StringProperty customer;
  private StringProperty LabelPolicyNr;
  private StringProperty LabelPrice;
  private StringProperty LabelDeductible;
  private StringProperty LabelCoverage;
  private boolean update;
  private Policy policy;
  private int customerNo;


  public CreatePoliceViewModel(Model model)
  {
    this.model = model;
    policeType = new SimpleStringProperty();
    policyNr = new SimpleStringProperty();
    price = new SimpleStringProperty();
    deductible = new SimpleStringProperty();
    coverage = new SimpleStringProperty();
    customer = new SimpleStringProperty();
    controller = new CreatePoliceViewController();
    LabelPolicyNr = new SimpleStringProperty();
    LabelPrice = new SimpleStringProperty();
    LabelDeductible = new SimpleStringProperty();
    LabelCoverage = new SimpleStringProperty();
    update = false;
    this.model.addListener(this);

  }


public void createPolicy(String policeType)
{

  policy = new Policy(String.valueOf(policeType),
      Integer.parseInt(price.getValue()),Integer.parseInt(deductible.getValue()), String.valueOf(coverage.getValue()),customerNo);
  model.addPolicy(policy);
  System.out.println(policy + "Det er den!");
}
public void setCustomerNo(ObservableList list)
{
  customerNo = Integer.parseInt((String)list.get(4));
}
public boolean checker()
{
 clear();

  if (price.getValue().equals("") || Pattern.matches("[a-åA-å]+", price.getValue()))
  {
   LabelPrice.setValue("Missing Price or invalid input");
   return false;
  }
  if (deductible.getValue().equals("") || Pattern.matches("[a-åA-å]+", deductible.getValue()))
  {
    LabelDeductible.setValue("Missing Deductible or invalid input");
    return false;
  }if (coverage.getValue().equals("") || !Pattern.matches("[a-åA-Å]+", coverage.getValue()))
  {
  LabelCoverage.setValue("Missing Coverage or invalid input");
  return false;
  }
  return true;
}
public void clear()
{
  LabelCoverage.setValue("");
  LabelDeductible.setValue("");
  LabelPolicyNr.setValue("");
  LabelPrice.setValue("");
}
  public StringProperty coverageProperty()
  {
    return coverage;
  }


  public StringProperty customerProperty()
  {
    return customer;
  }


  public StringProperty policeTypeProperty()
  {
    return policeType;
  }


  public StringProperty policyNrProperty()
  {
    return policyNr;
  }


  public StringProperty priceProperty()
  {
    return price;
  }


  public StringProperty deductibleProperty()
  {
    return deductible;
  }

  public StringProperty labelPolicyNrProperty()
  {
    return LabelPolicyNr;
  }

  public StringProperty labelPriceProperty()
  {
    return LabelPrice;
  }


  public StringProperty labelDeductibleProperty()
  {
    return LabelDeductible;
  }


  public StringProperty labelCoverageProperty()
  {
    return LabelCoverage;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    update = true;
  }

  public boolean getUpdate()
  {
    return update;
  }
}
