package server.DBConnection.CustomerDB;

import client.model.Customer.Customer;

public interface CustomerData
{
  void addCustomerData(Customer customer);
  void updateCustomerData(Customer customer, Customer customerOld);
  void removeCustomerData(Customer customer);
  void readCustomerData(Customer customer);

}
