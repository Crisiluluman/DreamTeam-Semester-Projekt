package client.view.Manager.EditEmployee;

import client.model.DamageEmployee.DamageEmployee;
import client.model.Manager.Manager;
import client.model.Model;
import client.model.Salesman.Salesman;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import shared.Employee;

import java.rmi.RemoteException;
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
    ObservableList list;


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


    public void onSaveClicked(String position)
    {
        System.out.println(position);
        if (position.equals("Manager")) {
            manager = new Manager(String.valueOf(nameTextField.getValue()), String.valueOf(addressTextField.getValue()),
                    Long.parseLong(CPRTextField.getValue()), String.valueOf(emailTextField.getValue()), Integer.parseInt(phoneTextField.getValue()), position);
            manager.setEmployeeNo(Integer.parseInt((String) list.get(0)));
            model.updateEmployee(manager);
        }
        if (position.equals("Salesman")) {
            salesman = new Salesman(String.valueOf(nameTextField.getValue()), String.valueOf(addressTextField.getValue()),
                    Long.parseLong(CPRTextField.getValue()), String.valueOf(emailTextField.getValue()), Integer.parseInt(phoneTextField.getValue()), position);
            salesman.setEmployeeNo(Integer.parseInt((String) list.get(0)));
            model.updateEmployee(salesman);
        }
        if (position.equals("DamageEmployee")) {
            damageEmployee = new DamageEmployee(String.valueOf(nameTextField.getValue()), String.valueOf(addressTextField.getValue()),
                    Long.parseLong(CPRTextField.getValue()), String.valueOf(emailTextField.getValue()), Integer.parseInt(phoneTextField.getValue()), position);
            damageEmployee.setEmployeeNo(Integer.parseInt((String) list.get(0)));
            model.updateEmployee(damageEmployee);
        }
    }
    public void setChoiceBox(ChoiceBox choiceBox)
    {
        choiceBox.setValue(positionTextField.getValue());
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
        this.list=list;
        nameTextField.setValue(list.get(1));
        addressTextField.setValue(list.get(2));
        CPRTextField.setValue(String.valueOf(list.get(3)));
        positionTextField.setValue(list.get(6));
        emailTextField.setValue(list.get(4));
        phoneTextField.setValue(String.valueOf(list.get(5)));
    }
}

