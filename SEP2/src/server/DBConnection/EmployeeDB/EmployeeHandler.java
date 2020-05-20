package server.DBConnection.EmployeeDB;

import server.DBConnection.DBConnections;
import shared.Employee;

import java.util.List;

public class EmployeeHandler implements EmployeeData
{
  // Calls methods in the Connections and has SQL strings
  private DBConnections connection;

  public EmployeeHandler()
  {
    connection = new DBConnections();
  }

  @Override public void addEmployeeData(Employee employee)
  {
    String sql = "INSERT INTO \"insurance\".employee values(" + "'" + employee.getName()
        + "'" + "," + "'" + employee.getAddress() + "'" + "," + "'" + employee.getCPR() + "'" + "," + "'" + employee.getEmail()
        + "'" + "," + "'" + employee.getTlfNr() + "'" + ","
        + "'" + employee.getPosition() + "'" +");";
    connection.AddToDB(sql);

//    switch (employee.getPosition())
//    {
//      case "Manager":
//        sql = "INSERT INTO \"insurance\".employee values(" + "'" + employee.getName()
//            + "'" + "," + "'" + employee.getAddress() + "'" + "," + "'" + employee.getCPR() + "'" + "," + "'" + employee.getEmail()
//            + "'" + "," + "'" + employee.getTlfNr() + "'" + ","
//            + "'" + employee.getPosition() + "'" +");";
//        connection.AddToDB(sql);
//        break;

//      case "Salesman":
//        sql = "INSERT INTO \"insurance\".employee values(" + "'" + employee.getName()
//            + "'" + "," + "'" + employee.getAddress() + "'" + "," + "'" + employee.getCPR() + "'" + "," + "'" + employee.getEmail()
//            + "'" + "," + "'" + employee.getTlfNr() + "'" + ",'Salesman');";
//        connection.AddToDB(sql);
//        break;
//
//      case "DamageEmployee":
//        sql = "INSERT INTO \"insurance\".employee values(" + "'" + employee.getName()
//            + "'" + "," + "'" + employee.getAddress() + "'" + "," + "'" + employee.getCPR() + "'" + "," + "'" + employee.getEmail()
//            + "'" + "," + "'" + employee.getTlfNr() + "'" + ",'Damage-employee');";
//        connection.AddToDB(sql);
//        break;
   // }
  }



  @Override public List<Employee> readEmployeeData()
  {
    String sql = "SELECT * FROM \"insurance\".Employee;";
    return connection.fillEmployeeTableDB(sql);
  }



  @Override public void updateEmployeeData(Employee employee, Employee employeeOld)
  {

    String sql =
        "Update \"insurance\".employee set name =" + "'" + employee.getName()+ "'" + ","
            + "address =" + "'" + employee.getAddress() + "'" + ","
            + "cpr =" + "'" + employee.getCPR() + "'" + ","
            + "email =" + "'" + employee.getEmail() + "'" + ","
            + "tlfnr =" + "'" + employee.getTlfNr() + "'" + ","
            + "position =" + "'" + employee.getPosition() + "'"
            + " where cpr =" + "'" + employeeOld.getCPR() + "'" +";";
    connection.AddToDB(sql);

//
//    String sql = "";
//    switch (employeeOld.getPosition())
//    {
//      // employees
//      case "Manager":
//        sql =
//            "Update \"insurance\".employee set name =" + "'" + employee.getName()+ "'" + ","
//                + "address =" + "'" + employee.getAddress() + "'" + ","
//                + "cpr =" + "'" + employee.getCPR() + "'" + ","
//                + "email =" + "'" + employee.getEmail() + "'" + ","
//                + "tlfnr =" + "'" + employee.getTlfNr() + "'" + ","
//                + "position =" + "'" + employee.getPosition() + "'"
//                + " where cpr =" + "'" + employeeOld.getCPR() + "'" +";";
//        connection.AddToDB(sql);
//        break;
//
//      case "Salesman":
//        sql =
//            "Update \"insurance\".employee set name =" + "'" + employee.getName()+ "'" + ","
//                + "address =" + "'" + employee.getAddress() + "'" + ","
//                + "cpr =" + "'" + employee.getCPR() + "'" + ","
//                + "email =" + "'" + employee.getEmail() + "'" + ","
//                + "tlfnr =" + "'" + employee.getTlfNr() + "'" + ","
//                + "position =" + "'" + employee.getPosition() + "'"
//                + " where cpr =" + "'" + employeeOld.getCPR() + "'" +";";
//        connection.AddToDB(sql);
//        break;
//
//      case "DamageEmployee":
//        sql =
//            "Update \"insurance\".employee set name =" + "'" + employee.getName()+ "'" + ","
//                + "address =" + "'" + employee.getAddress() + "'" + ","
//                + "cpr =" + "'" + employee.getCPR() + "'" + ","
//                + "email =" + "'" + employee.getEmail() + "'" + ","
//                + "tlfnr =" + "'" + employee.getTlfNr() + "'" + ","
//                + "position =" + "'" + employee.getPosition() + "'"
//                + " where cpr =" + "'" + employeeOld.getCPR() + "'" +";";
//        connection.AddToDB(sql);
//        break;
   // }
  }

  @Override public void deleteEmployeeData(int cpr)
  {
    String sql = "Delete from \"insurance\".employee where cpr =" + "'" + cpr + "'" +";";
    connection.AddToDB(sql);
  }
}
