package client.view.DamageEmployee.CreateDamage;

import shared.Damage;
import client.model.Model;
import shared.Policy;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.regex.Pattern;

public class CreateDamageViewModel implements PropertyChangeListener
{

    private Model model;
    private Damage damage;
    private String type;
    private int polno;

    private StringProperty policyTypeDropdown;
    private StringProperty expensesTextfield;
    private StringProperty damageNoTextfield;
    private StringProperty infoTextArea;

    private StringProperty PolicyTypeDropdownLabel;
    private StringProperty expensesLabel;
    private StringProperty damageNoLabel;
  private boolean updates;



  public CreateDamageViewModel(Model model)
    {
      this.model = model;
      this.model.addListener(this);
      this.updates=false;
      policyTypeDropdown = new SimpleStringProperty();
      expensesTextfield = new SimpleStringProperty();
      damageNoTextfield = new SimpleStringProperty();
      infoTextArea = new SimpleStringProperty();
      PolicyTypeDropdownLabel = new SimpleStringProperty();
      expensesLabel = new SimpleStringProperty();
      damageNoLabel = new SimpleStringProperty();

    }

    public StringProperty getPolicyTypeDropdown()
    {
      return policyTypeDropdown;
    }

  public StringProperty getExpensesTextfield()
  {
    return expensesTextfield;
  }

  public StringProperty getDamageNoTextfield()
  {
    return damageNoTextfield;
  }

  public StringProperty getInfoTextArea()
  {
    return infoTextArea;
  }


  public StringProperty getExpensesLabel()
  {
    return expensesLabel;
  }

  public StringProperty getDamageNoLabel()
  {
    return damageNoLabel;
  }

  public void setOnClick(ObservableList list)
  {
    type = (String) list.get(1);
    polno = Integer.parseInt((String) list.get(0));

  }

  public void onClick()
  {
    damage = new Damage( polno, type,Double.parseDouble(expensesTextfield.getValue()), String.valueOf(infoTextArea.getValue()));
    clearLabels();
    model.addDamage(damage);
  }

  public void clearLabels()
  {
    PolicyTypeDropdownLabel.setValue("");
    expensesLabel.setValue("");
    damageNoLabel.setValue("");
  }
  public void clearTextfields()
  {
    expensesTextfield.setValue("");
    damageNoTextfield.setValue("");
    infoTextArea.setValue("");
  }

  public boolean checker()
  {
    clearLabels();

    if(expensesTextfield.getValue().equals("") || !(Pattern.matches("[0-9]+",expensesTextfield.getValue())))
    {
      expensesLabel.setValue("Invalid input - try again");
      return false;
    }

    return true;
  }

  public void setFields(ObservableList list)
  {
    policyTypeDropdown.setValue(String.valueOf(list.get(1)));
  }

  public void choicebox(ChoiceBox box)
  {
    box.setValue(policyTypeDropdown.getValue());
  }

  public boolean getUpdate(){
    return updates;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    updates = true;
  }
}
