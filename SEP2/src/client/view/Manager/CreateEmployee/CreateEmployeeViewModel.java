package client.view.Manager.CreateEmployee;

import client.model.DamageEmployee.DamageEmployee;
import client.model.Manager.Manager;
import client.model.Model;
import client.model.Salesman.Salesman;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.regex.Pattern;

public class CreateEmployeeViewModel {
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

    public CreateEmployeeViewModel(Model model) {
        this.model = model;
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
    }
    public void onCreate(String position)
    {
if (position.equals("Manager"))
{
   manager = new Manager(String.valueOf(name.getValue()),String.valueOf(address.getValue()),
        Long.parseLong(CPR.getValue()),String.valueOf(email.getValue()),Integer.parseInt(phone.getValue()), "Manager");
   saveToDB(Manager());
}
if (position.equals("Salesman"))
{
   salesman = new Salesman(String.valueOf(name.getValue()),String.valueOf(address.getValue()),
        Long.parseLong(CPR.getValue()),String.valueOf(email.getValue()),Integer.parseInt(phone.getValue()), "Salesman");
   saveToDB(SalesMan());
}
if (position.equals("DamageEmployee"))
{
    damageEmployee = new DamageEmployee(String.valueOf(name.getValue()),String.valueOf(address.getValue()),
        Long.parseLong(CPR.getValue()),String.valueOf(email.getValue()),Integer.parseInt(phone.getValue()), "DamageEmployee");
    saveToDB(DamageEmployee());
}
    }

    public void saveToDB(String sql)
    {

        Connection c = null;
        Statement stmt = null;
        try
        {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","1234");

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

        if(CPR.getValue().equals("") || Pattern.matches("[a-åA-Å]+",CPR.getValue()) || Long.parseLong(CPR.getValue()) < Long.parseLong("0101000001")  || Long.parseLong(CPR.getValue()) > Long.parseLong("3112999999"))
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
}
