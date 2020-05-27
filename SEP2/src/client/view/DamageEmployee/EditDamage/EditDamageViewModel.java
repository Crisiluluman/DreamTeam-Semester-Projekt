package client.view.DamageEmployee.EditDamage;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import shared.Damage;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.regex.Pattern;

public class EditDamageViewModel implements PropertyChangeListener
{
  Model model;
  private StringProperty expensesTextfield;
  private StringProperty info;
  private StringProperty policyDropDown;
  private int policyNo;
  private int damageNo;
  private boolean update;

  private StringProperty PolicyTypeDropdownLabel;
  private StringProperty expensesLabel;
  private StringProperty damageNoLabel;


  public EditDamageViewModel(Model model)
  {
    this.model=model;
    this.model.addListener(this);
    update = false;
    expensesTextfield = new SimpleStringProperty();
    info = new SimpleStringProperty();
    policyDropDown = new SimpleStringProperty();
    PolicyTypeDropdownLabel = new SimpleStringProperty();
    expensesLabel = new SimpleStringProperty();
    damageNoLabel = new SimpleStringProperty();
  }

  public StringProperty getExpensesLabel()
  {
    return expensesLabel;
  }

  public StringProperty getDamageNoLabel()
  {
    return damageNoLabel;
  }



public void onSave()
{
  Damage damage = new Damage(policyNo,String.valueOf(policyDropDown.getValue()),Double.parseDouble(expensesTextfield.getValue()),String.valueOf(info.getValue()));
  damage.setDamageNo(damageNo);
  model.updateDamage(damage);
}
  public void setFields(ObservableList list)
  {
    policyNo =Integer.valueOf((String) list.get(0));
    damageNo = Integer.valueOf((String) list.get(1));
expensesTextfield.setValue(String.valueOf(list.get(2)));
info.setValue(String.valueOf(list.get(3)));
policyDropDown.setValue(String.valueOf(list.get(4)));
  }

  public void clearLabels()
  {
    expensesLabel.setValue("");
  }

  public StringProperty expensesProperty()
  {
    return expensesTextfield;
  }

  public boolean checker()
  {
    clearLabels();

    if(expensesTextfield.getValue().equals("") || !(Pattern
        .matches("[0-9]+",expensesTextfield.getValue())))
    {
      expensesLabel.setValue("Invalid input - try again");
      return false;
    }

    return true;
  }

  public StringProperty infoProperty()
  {
    return info;
  }



  public StringProperty policyDropDownProperty()
  {
    return policyDropDown;
  }
  public void setChoiceBox(ChoiceBox choiceBox)
  {
    choiceBox.setValue(policyDropDownProperty().getValue());
  }

  public boolean getUpdate()
  {
    return update;
  }

  @Override public void propertyChange(PropertyChangeEvent evt)
  {
    update = true;
  }
}
