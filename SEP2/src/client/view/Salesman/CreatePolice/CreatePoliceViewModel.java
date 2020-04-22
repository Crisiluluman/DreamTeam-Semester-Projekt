package client.view.Salesman.CreatePolice;

import client.model.Model;
import client.model.Police.Police;
import javafx.beans.property.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreatePoliceViewModel implements PropertyChangeListener
{
  private Model model;
  private StringProperty policeType;
  private StringProperty policyNr;
  private StringProperty price;
  private StringProperty deductible;
  private StringProperty coverage;
  private StringProperty customer;
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

  @Override public void propertyChange(PropertyChangeEvent evt)
  {

  }
}
