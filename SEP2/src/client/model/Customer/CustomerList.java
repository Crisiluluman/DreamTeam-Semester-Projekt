package client.model.Customer;

import client.model.Customer.Customer;

import java.util.ArrayList;

public class CustomerList
{

  private ArrayList<Customer> customers;

  public CustomerList()
  {
    customers = new ArrayList<>();
  }

  public void addCustomer(Customer customer)
  {
    customers.add(customer);
  }
  public void removeCustomer(Customer customer)
  {
    customers.add(customer);
  }
  public ArrayList<Customer> getCustomers()
  {
    return customers;
  }
  public Customer getCustomer(int id)
  {
    return customers.get(id);
  }
}
