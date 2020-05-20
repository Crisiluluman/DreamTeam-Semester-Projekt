package client.model;

import client.model.Damage.Damage;
import shared.Employee;
import shared.Policy;
import client.networking.Client;
import shared.Customer;

import java.rmi.RemoteException;
import java.util.List;

public class Modelmanager implements Model
{
  private Client client;

  public Modelmanager(Client client)
  {
    this.client = client;
    client.start();
    client.addListener("update", null);
  }

  @Override public void createCustomer(Customer customer)
  {
    try
    {
      client.createCustomer(customer);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override
  public List<Customer> readCustomer(){
    return client.readCustomer();
  }

  @Override public List<Policy> readPolicy(int customerNo)
  {
    return client.readPolicy(customerNo);
  }

  @Override public List<Employee> readEmployee()
  {
    return client.readEmployee();
  }

  @Override public List<Damage> readDamage(int policeno)
  {
    return client.readDamage(policeno);
  }

}
