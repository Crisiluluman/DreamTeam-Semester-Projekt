package client.view.DamageEmployee.CreateDamage;

import shared.Damage;
import client.model.Model;
import shared.Policy;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;

import java.rmi.RemoteException;
import java.util.regex.Pattern;

public class CreateDamageViewModel {

    private Model model;
    private Damage damage;
    private Policy policy;

    private StringProperty policyTypeDropdown;
    private StringProperty expensesTextfield;
    private StringProperty damageNoTextfield;
    private StringProperty infoTextArea;

    private StringProperty PolicyTypeDropdownLabel;
    private StringProperty expensesLabel;
    private StringProperty damageNoLabel;


    public CreateDamageViewModel(Model model)
    {
      this.model = model;
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

  public void onClick(String policeType)
  {
    Policy policy = new Policy(1,"Car",100,50,"kasko");
    damage = new Damage(policy.getPoliceNo(), policeType,Double.parseDouble(expensesTextfield.getValue()),Integer.parseInt(damageNoTextfield.getValue()), String.valueOf(infoTextArea.getValue()));
    clearLabels();
    model.addDamage(policy,damage);
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

    if(expensesTextfield.getValue().equals("") || Pattern.matches("[a-åA-Å]+",expensesTextfield.getValue()))
    {
      expensesLabel.setValue("Invalid input - try again");
      return false;
    }
    if(damageNoTextfield.getValue().equals("") || Pattern.matches("[a-åA-Å]+",damageNoTextfield.getValue()))
    {
      damageNoLabel.setValue("Invalid input - try again");
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

}
