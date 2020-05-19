package server.DBConnection.CustomerDB;

import shared.Customer;
import javafx.scene.control.TableView;

import java.util.List;

public interface CustomerData
{
  void addCustomerData(Customer customer);
  void updateCustomerData(Customer customer, Customer customerOld);
  void deleteCustomerData(Customer customer);
  List<Customer> readCustomerData();

}
