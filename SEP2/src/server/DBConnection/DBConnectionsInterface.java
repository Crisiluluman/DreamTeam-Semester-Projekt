package server.DBConnection;

import shared.Customer;
import shared.Damage;
import shared.Employee;
import shared.Policy;

import java.util.List;

public interface DBConnectionsInterface
{
  void AddToDB(String sql);
  List<Customer> fillCustomerTableDB(String sql);
  List<Policy> fillPolicyTableDB(String sql);
  List<Employee> fillEmployeeTableDB(String sql);
  List<Damage> fillDamageTableDB(String sql, int policeno);
  List totalFromDB(String sql);
}
