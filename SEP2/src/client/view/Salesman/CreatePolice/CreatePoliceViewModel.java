package client.view.Salesman.CreatePolice;

import client.model.Model;
import client.model.Police.Police;
import javafx.beans.property.*;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CreatePoliceViewModel implements PropertyChangeListener
{
  private Model model;
  private StringProperty policeType;
  private StringProperty policyNr;
  private StringProperty price;
  private StringProperty deductible;
  private StringProperty coverage;
  private StringProperty customer;



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
  Police police = new Police(Integer.parseInt(policyNr.getValue()),String.valueOf(policeType),
      Integer.parseInt(price.getValue()),Integer.parseInt(deductible.getValue()), String.valueOf(coverage.getValue()));
model.createPolice(police);
System.out.println(model.getPolice().getPoliceInfo());

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
