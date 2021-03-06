package client.view.Manager.CreateEmployee;

import client.model.DamageEmployee.DamageEmployee;
import client.model.Manager.Manager;
import client.model.Model;
import client.model.Salesman.Salesman;
import javafx.beans.property.SimpleStringProperty;
import server.DBConnection.EmployeeDB.EmployeeHandler;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.regex.Pattern;

public class CreateEmployeeViewModel implements PropertyChangeListener
{
    private Model model;
private SimpleStringProperty name;
private SimpleStringProperty address;
private SimpleStringProperty CPR;
private SimpleStringProperty position;
private SimpleStringProperty email;
private SimpleStringProperty phone;
private SimpleStringProperty Labelname;
private SimpleStringProperty Labeladdress;
private SimpleStringProperty LabelCPR;
private SimpleStringProperty Labelemail;
private SimpleStringProperty Labelphone;
private Manager manager;
private Salesman salesman;
private DamageEmployee damageEmployee;
private boolean update;

private EmployeeHandler handler;

    public CreateEmployeeViewModel(Model model) {
        this.model = model;
        this.model.addListener(this);
        name = new SimpleStringProperty();
        address = new SimpleStringProperty();
        CPR = new SimpleStringProperty();
        position = new SimpleStringProperty();
        email = new SimpleStringProperty();
        phone = new SimpleStringProperty();
        Labelname = new SimpleStringProperty();
        Labeladdress = new SimpleStringProperty();
        LabelCPR = new SimpleStringProperty();
        Labelemail = new SimpleStringProperty();
        Labelphone = new SimpleStringProperty();
        handler = new EmployeeHandler();
        update = false;
    }

    public boolean getUpdate()
    {
        return update;
    }

    public void onCreate(String position)
    {
        if (position.equals("Manager"))
        {
        manager = new Manager(String.valueOf(name.getValue()),String.valueOf(address.getValue()),
        Long.parseLong(CPR.getValue()),String.valueOf(email.getValue()),Integer.parseInt(phone.getValue()), "Manager");
        model.addEmployee(manager);
        }
        if (position.equals("Salesman"))
        {
        salesman = new Salesman(String.valueOf(name.getValue()),String.valueOf(address.getValue()),
        Long.parseLong(CPR.getValue()),String.valueOf(email.getValue()),Integer.parseInt(phone.getValue()), "Salesman");
        model.addEmployee(salesman);
        }
        if (position.equals("DamageEmployee"))
        {
        damageEmployee = new DamageEmployee(String.valueOf(name.getValue()),String.valueOf(address.getValue()),
        Long.parseLong(CPR.getValue()),String.valueOf(email.getValue()),Integer.parseInt(phone.getValue()), "DamageEmployee");
        model.addEmployee(damageEmployee);
        }
    }



    public boolean checker()
    {
        clearLabel();
        if(name.getValue().equals("") || !(Pattern
            .matches("[a-åA-Å]+",name.getValue())))
        {
            Labelname.setValue("Invalid input - try again");
            return false;
        }
        if(address.getValue().equals(""))
        {
            Labeladdress.setValue("Invalid input - try again");
            return false;
        }

        if(CPR.getValue().equals("") || !Pattern.matches("[0-9]+",CPR.getValue()) || Long.parseLong(CPR.getValue()) < Long.parseLong("0101000001")  || Long.parseLong(CPR.getValue()) > Long.parseLong("3112999999"))
        {
            LabelCPR.setValue("Invalid input - try again");
            return false;
        }

        if(email.getValue().equals(""))
        {
            Labelemail.setValue("Invalid input - try again");
            return false;
        }

        if(phone.getValue().equals("") || Pattern.matches("[a-åA-Å]+",phone.getValue()) || !(
            phone.getValue().length() ==8))
        {
            Labelphone.setValue("Invalid input - try again");
            return false;
        }
        return true;
    }
    public void clearLabel()
    {
        Labelphone.setValue("");
        Labelemail.setValue("");
        Labeladdress.setValue("");
        Labelname.setValue("");
        LabelCPR.setValue("");
    }
    public void clearTextFields()
    {
        name.setValue("");
        address.setValue("");
        CPR.setValue("");
        email.setValue("");
        phone.setValue("");
    }
    public SimpleStringProperty nameProperty()
    {
        return name;
    }


    public SimpleStringProperty labelnameProperty()
    {
        return Labelname;
    }


    public SimpleStringProperty labeladdressProperty()
    {
        return Labeladdress;
    }


    public SimpleStringProperty labelCPRProperty()
    {
        return LabelCPR;
    }



    public SimpleStringProperty labelemailProperty()
    {
        return Labelemail;
    }



    public SimpleStringProperty labelphoneProperty()
    {
        return Labelphone;
    }

    public SimpleStringProperty addressProperty()
    {
        return address;
    }


    public SimpleStringProperty CPRProperty()
    {
        return CPR;
    }


    public SimpleStringProperty emailProperty()
    {
        return email;
    }


    public SimpleStringProperty phoneProperty()
    {
        return phone;
    }

    @Override public void propertyChange(PropertyChangeEvent evt)
    {
        update = true;
    }
}
