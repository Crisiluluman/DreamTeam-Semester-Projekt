package client.view.DamageEmployee.CreateDamage;

import client.model.Damage.Damage;
import client.model.Model;
import client.model.Police.Police;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.regex.Pattern;

public class CreateDamageViewModel {

    private Model model;
    private CreateDamageViewController cdvc;
    private Damage damage;
    private Police police;

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
    Police dummy = new Police(1,"Car",100,50,"kasko");
    damage = new Damage(dummy.getPoliceNo(), policeType,Double.parseDouble(expensesTextfield.getValue()),Integer.parseInt(damageNoTextfield.getValue()), String.valueOf(infoTextArea.getValue()));
    clearLabels();
    saveToDB();
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

  public void saveToDB()
  {

    Connection connection = null;
    Statement statement = null;

    System.out.println("Test 1");

    try
    {

      Class.forName("org.postgresql.Driver");
      System.out.println("Test2");
      connection = DriverManager
          .getConnection("jdbc:postgresql://localhost:5432/Sonny", "postgres",
              "1234");
      System.out.println("Test2");
      statement = connection.createStatement();
      System.out.println("Test2");
      String sql = "INSERT INTO \"Damage\".damage values(" + damage.getPoliceNo() + "," + "'" + damage.getPoliceType() + "'"  + "," + damage.getExpenses() + "," + damage.getDamageNo() + "," + "'" + damage.getInfo() + "'" + ");";
      System.out.println("Test2");


      statement.executeUpdate(sql);
      statement.close();
      connection.close();
    }
    catch (Exception e)
    {
      System.err.println(e.getClass().getName() + ": " + e.getMessage());
      System.exit(0);

    }
    System.out.println("Insert to Database ok!");
  }


}
