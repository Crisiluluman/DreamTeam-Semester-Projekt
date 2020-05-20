package client.model;

import shared.Damage;
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

  @Override public void addEmployee(Employee employee)
  {
    client.addEmployee(employee);
  }

  @Override public void deleteEmployee(int cpr)
  {
    client.deleteEmployee(cpr);
  }

  @Override public void addCustomer(Customer customer)
  {
    client.addCustomer(customer);
  }

  @Override public void deleteCustomer(Customer customer)
  {
    client.deleteCustomer(customer);
  }

  @Override public void addPolicy(Policy policy)
  {
    client.addPolicy(policy);
  }

  @Override public void deletePolicy(Policy policy)
  {
    client.deletePolicy(policy);
  }

  @Override public void addDamage(Policy policy, Damage damage)
  {
    client.addDamage(policy, damage);
  }

  @Override public void deleteDamage(Damage damage)
  {
    client.deleteDamage(damage);
  }

  @Override
  public List<Customer> readCustomer(){
    return client.readCustomer();
  }

  @Override public List<Policy> readPolicy()
  {
    return client.readPolicy();
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
