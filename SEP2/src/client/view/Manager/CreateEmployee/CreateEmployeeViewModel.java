package client.view.Manager.CreateEmployee;

import client.model.DamageEmployee.DamageEmployee;
import client.model.Manager.Manager;
import client.model.Model;
import client.model.Salesman.Salesman;
import javafx.beans.property.SimpleStringProperty;

public class CreateEmployeeViewModel {
    private Model model;
private SimpleStringProperty name;
private SimpleStringProperty address;
private SimpleStringProperty CPR;
private SimpleStringProperty position;
private SimpleStringProperty email;
private SimpleStringProperty phone;
    public CreateEmployeeViewModel(Model model) {
        this.model = model;
        name = new SimpleStringProperty();
        address = new SimpleStringProperty();
        CPR = new SimpleStringProperty();
        position = new SimpleStringProperty();
        email = new SimpleStringProperty();
        phone = new SimpleStringProperty();
    }
    public void onCreate(String position)
    {
if (position.equals("Manager"))
{
    Manager manager = new Manager(String.valueOf(name.getValue()),String.valueOf(address.getValue()),
        Integer.parseInt(CPR.getValue()),String.valueOf(email.getValue()),Integer.parseInt(phone.getValue()));
}
if (position.equals("SalesMan"))
{
   Salesman salesman = new Salesman(String.valueOf(name.getValue()),String.valueOf(address.getValue()),
        Integer.parseInt(CPR.getValue()),String.valueOf(email.getValue()),Integer.parseInt(phone.getValue()));
}
if (position.equals("DamageEmployee"))
{
    DamageEmployee damageEmployee = new DamageEmployee(String.valueOf(name.getValue()),String.valueOf(address.getValue()),
        Integer.parseInt(CPR.getValue()),String.valueOf(email.getValue()),Integer.parseInt(phone.getValue()));
}
saveToDB();
    }

    public void saveToDB()
    {

    }
    public boolean checker()
    {
        return true;
    }
    public void clearLabel()
    {

    }
    public void clearTextFields()
    {

    }
    public SimpleStringProperty nameProperty()
    {
        return name;
    }


    public SimpleStringProperty addressProperty()
    {
        return address;
    }


    public SimpleStringProperty CPRProperty()
    {
        return CPR;
    }


    public SimpleStringProperty positionProperty()
    {
        return position;
    }


    public SimpleStringProperty emailProperty()
    {
        return email;
    }


    public SimpleStringProperty phoneProperty()
    {
        return phone;
    }
}
