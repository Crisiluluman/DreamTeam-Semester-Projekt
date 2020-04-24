package client.view.Salesman.CreatePolice;

import client.model.Model;
import client.model.Police.Police;
import javafx.beans.property.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
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

  private Police police;



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
  }
public void createPolicy(String policeType)
{

  police = new Police(Integer.parseInt(policyNr.getValue()),String.valueOf(policeType),
      Integer.parseInt(price.getValue()),Integer.parseInt(deductible.getValue()), String.valueOf(coverage.getValue()));


saveToDB();
}
public void saveToDB()
{
  Connection c = null;
  Statement stmt = null;
  try
  {
    Class.forName("org.postgresql.Driver");
    c = DriverManager
        .getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1122");

    System.out.println("The database is open");

    stmt = c.createStatement();
    String sql = "INSERT INTO \"createpolicy\".PoliceList values("+ police.getPoliceNo() +
        "," + "'"+police.getPoliceType()+"'"+","+police.getPrice()+","+police.getDeductible()+"," +"'"+police.getCoverage()+"');";
    stmt.executeUpdate(sql);



    stmt.close();
    c.close();
  } catch (Exception e)
  {
    e.printStackTrace();
  }
}

public boolean checker()
{
 clear();
  if (policyNr.getValue().equals("") || Pattern.matches("[a-åA-å]+", policyNr.getValue()))
  {
    LabelPolicyNr.setValue("Missing Policy Nr or invalid input");
    return false;
  }

  if (price.getValue().equals("") || Pattern.matches("[a-åA-å]+", price.getValue()))
  {
   LabelPrice.setValue("Missing Price or invalid input");
   return false;
  }
  if (deductible.getValue().equals("") || Pattern.matches("[a-åA-å]+", deductible.getValue()))
  {
    LabelDeductible.setValue("Missing Deductible or invalid input");
    return false;
  }if (coverage.getValue().equals("") || !Pattern.matches("[a-åA-å]+", coverage.getValue()))
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

  }
}
