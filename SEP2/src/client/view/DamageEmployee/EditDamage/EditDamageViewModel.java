package client.view.DamageEmployee.EditDamage;

import client.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import shared.Damage;

public class EditDamageViewModel
{
  Model model;
  private StringProperty expenses;
  private StringProperty info;
  private StringProperty policyDropDown;
  private int policyNo;
  private int damageNo;
  public EditDamageViewModel(Model model)
  {
    this.model=model;
    expenses = new SimpleStringProperty();
    info = new SimpleStringProperty();
    policyDropDown = new SimpleStringProperty();
  }
public void onSave()
{
  Damage damage = new Damage(policyNo,String.valueOf(policyDropDown.getValue()),Integer.valueOf(expenses.getValue()),String.valueOf(info.getValue()));
  model.updateDamage(damage);
}
  public void setFields(ObservableList list)
  {
    policyNo =Integer.valueOf((String) list.get(0));
    damageNo = Integer.valueOf((String) list.get(1));
expenses.setValue(String.valueOf(list.get(2)));
info.setValue(String.valueOf(list.get(3)));
policyDropDown.setValue(String.valueOf(list.get(4)));
  }



  public StringProperty expensesProperty()
  {
    return expenses;
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
}
