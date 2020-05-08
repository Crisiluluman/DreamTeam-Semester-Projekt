package client.view.Manager.EditEmployee;

import client.model.DamageEmployee.DamageEmployee;
import client.model.Employee;
import client.model.Manager.Manager;
import client.model.Model;
import client.model.Salesman.Salesman;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.regex.Pattern;

public class EditEmployeeViewModel {
    private Model model;
    private StringProperty nameTextField;
    private StringProperty addressTextField;
    private StringProperty CPRTextField;
    private StringProperty positionTextField;
    private StringProperty emailTextField;
    private StringProperty phoneTextField;
    private StringProperty nameLabel;
    private StringProperty addressLabel;
    private StringProperty CPRLabel;
    private StringProperty positionLabel;
    private StringProperty emailLabel;
    private StringProperty phoneLabel;
    private Manager manager;
    private Salesman salesman;
    private DamageEmployee damageEmployee;


    public EditEmployeeViewModel(Model model) {
        this.model = model;
        nameTextField = new SimpleStringProperty();
        addressTextField = new SimpleStringProperty();
        CPRTextField = new SimpleStringProperty();
        positionTextField = new SimpleStringProperty();
        emailTextField = new SimpleStringProperty();
        phoneTextField = new SimpleStringProperty();
        nameLabel = new SimpleStringProperty();
        addressLabel = new SimpleStringProperty();
        CPRLabel = new SimpleStringProperty();
        positionLabel = new SimpleStringProperty();
        emailLabel = new SimpleStringProperty();
        phoneLabel = new SimpleStringProperty();

    }

    public StringProperty getNameTextFieldProperty() {
        return nameTextField;
    }

    public StringProperty getAddressTextFieldProperty() {
        return addressTextField;
    }


    public StringProperty getCPRTextFieldProperty() {
        return CPRTextField;
    }

    public Model getModel()
    {
        return model;
    }

    public StringProperty getEmailTextFieldProperty() {
        return emailTextField;
    }


    public StringProperty getPhoneTextFieldProperty() {
        return phoneTextField;
    }


    public StringProperty getNameLabelProperty() {
        return nameLabel;
    }

    public StringProperty getAddressLabelProperty() {
        return addressLabel;
    }

    public StringProperty getCPRLabelProperty() {
        return CPRLabel;
    }

    public StringProperty getPositionLabelProperty() {
        return positionLabel;
    }

    public StringProperty getEmailLabelProperty() {
        return emailLabel;
    }


    public StringProperty getPhoneLabelProperty() {
        return phoneLabel;
    }

    public void saveToDB(String sql)
    {

        Connection c = null;
        Statement stmt = null;
        try
        {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","qawsedrf123");

            System.out.println("The database is open");

            stmt = c.createStatement();
            stmt.executeUpdate(sql);



            stmt.close();
            c.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void onSaveClicked(String position) {
        if (position.equals("Manager")) {
            manager = new Manager(String.valueOf(nameTextField.getValue()), String.valueOf(addressTextField.getValue()),
                    Long.parseLong(CPRTextField.getValue()), String.valueOf(emailTextField.getValue()), Integer.parseInt(phoneTextField.getValue()), "Manager");
            saveToDB(Manager());
        }
        if (position.equals("Salesman")) {
            salesman = new Salesman(String.valueOf(nameTextField.getValue()), String.valueOf(addressTextField.getValue()),
                    Long.parseLong(CPRTextField.getValue()), String.valueOf(emailTextField.getValue()), Integer.parseInt(phoneTextField.getValue()), "Salesman");
            saveToDB(SalesMan());
        }
        if (position.equals("DamageEmployee")) {
            damageEmployee = new DamageEmployee(String.valueOf(nameTextField.getValue()), String.valueOf(addressTextField.getValue()),
                    Long.parseLong(CPRTextField.getValue()), String.valueOf(emailTextField.getValue()), Integer.parseInt(phoneTextField.getValue()), "DamageEmployee");
            saveToDB(DamageEmployee());
        }
    }

    public String Manager()
    {
        String sql = "INSERT INTO \"createpolicy\".employees values("+ "'"+ manager.getName()+"'"+
                "," +"'"+ manager.getAddress()+"'"+","+"'"+manager.getCPR()+"'"+","+"'"+manager.getEmail()+"'"+"," +"'"+manager.getTlfNr()+"'"+",'Manager');";
        return sql;
    }
    public String SalesMan()
    {
        String sql = "INSERT INTO \"createpolicy\".employees values("+ "'"+ salesman.getName()+"'"+
                "," +"'"+ salesman.getAddress()+"'"+","+"'"+salesman.getCPR()+"'"+","+"'"+salesman.getEmail()+"'"+"," +"'"+salesman.getTlfNr()+"'"+",'Salesman');";
        return sql;
    }

    public String DamageEmployee()
    {
        String sql = "INSERT INTO \"createpolicy\".employees values("+ "'"+ damageEmployee.getName()+"'"+
                "," +"'"+ damageEmployee.getAddress()+"'"+","+"'"+damageEmployee.getCPR()+"'"+","+"'"+damageEmployee.getEmail()+"'"+"," +"'"+damageEmployee.getTlfNr()+"'"+",'Damage-employee');";
        return sql;
    }
    public boolean checker()
    {
        clearLabels();
        if(nameTextField.getValue().equals("") || !(Pattern
                .matches("[a-åA-Å]+",nameTextField.getValue())))
        {
            nameLabel.setValue("Invalid input - try again");
            return false;
        }
        if(addressTextField.getValue().equals(""))
        {
            addressLabel.setValue("Invalid input - try again");
            return false;
        }

        if(CPRTextField.getValue().equals("") || Pattern.matches("[a-åA-Å]+",CPRTextField.getValue()) || Long.parseLong(CPRTextField.getValue()) < Long.parseLong("0101000001")  || Long.parseLong(CPRTextField.getValue()) > Long.parseLong("3112999999"))
        {
            CPRLabel.setValue("Invalid input - try again");
            return false;
        }

        if(emailTextField.getValue().equals(""))
        {
            emailLabel.setValue("Invalid input - try again");
            return false;
        }

        if(phoneTextField.getValue().equals("") || Pattern.matches("[a-åA-Å]+",phoneTextField.getValue()) || !(
                phoneTextField.getValue().length() ==8))
        {
            phoneLabel.setValue("Invalid input - try again");
            return false;
        }
        return true;
    }


    public void clearTextFields() {
        nameTextField.setValue("");
        addressTextField.setValue("");
        CPRTextField.setValue("");
        positionTextField.setValue("");
        emailTextField.setValue("");
        phoneTextField.setValue("");
    }

    public void clearLabels() {
        nameLabel.setValue("");
        addressLabel.setValue("");
        CPRLabel.setValue("");
        positionLabel.setValue("");
        emailLabel.setValue("");
        phoneLabel.setValue("");
    }
    public void setFields(ObservableList<String> list)
    {
        String name = list.get(0);

        nameTextField.setValue(name);
        System.out.println(nameTextField.getValue());
        addressTextField.setValue(list.get(1));
        CPRTextField.setValue(String.valueOf(list.get(2)));
        positionTextField.setValue(list.get(5));
        emailTextField.setValue(list.get(3));
        phoneTextField.setValue(String.valueOf(list.get(4)));
    }
}

