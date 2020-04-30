package client.view.Manager.ManageEmployee;

import client.model.Employee;
import client.model.Manager.Manager;
import client.model.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ManageEmployeeViewModel
{
  private Model model;


  public ManageEmployeeViewModel(Model model)
  {
    this.model = model;
  }

  public void getEmployeesFromDB(TableView TV)
  {
    ObservableList<Employee> list = FXCollections.observableArrayList();
      Connection c = null;
      Statement stmt = null;
      try {
        Class.forName("org.postgresql.Driver");
        c = DriverManager
                .getConnection("jdbc:postgresql://localhost:5432/postgres",
                        "postgres", "qawsedrf123");
        c.setAutoCommit(false);
        System.out.println("Opened database successfully");

        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM \"createpolicy\".Employees;" );
        while ( rs.next() ) {
          String name = rs.getString("name");
          String  address = rs.getString("address");
          String  CPR = rs.getString("cpr");
          String position = rs.getString("position");
          String email = rs.getString("email");
          String phone = rs.getString("tlfnr");
          System.out.println( "name = " + name );
          System.out.println( "address = " + address );
          System.out.println( "CPR = " + CPR );
          System.out.println( "position = " + position );
          System.out.println( "email = " + email );
          System.out.println( "phone = " + phone );
          if(position.equalsIgnoreCase("manager"))
          {
            Employee employee = new Manager(name, address, Long.parseLong(CPR), email, Integer.parseInt(phone), position);
            list.add(employee);
          }
          if(position.equalsIgnoreCase("salesman"))
          {
            Employee employee = new Manager(name, address, Long.parseLong(CPR), email, Integer.parseInt(phone), position);
            list.add(employee);
          }
          if(position.equalsIgnoreCase("damageemployee"))
          {
            Employee employee = new Manager(name, address, Long.parseLong(CPR), email, Integer.parseInt(phone), position);
            list.add(employee);
          }

        }
        rs.close();
        stmt.close();
        c.close();
      } catch ( Exception e ) {
        System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        System.exit(0);
      }
      System.out.println("Database query ok ");
    }

  }

