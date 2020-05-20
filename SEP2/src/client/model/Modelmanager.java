package client.model;

import shared.Damage;
import shared.Employee;
import shared.Policy;
import client.networking.Client;
import shared.Customer;

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

  @Override public void deleteCustomer(int customerNo)
  {
    client.deleteCustomer(customerNo);
  }

  @Override public void addPolicy(Policy policy)
  {
    client.addPolicy(policy);
  }

  @Override public void deletePolicy(int policyno)
  {
    client.deletePolicy(policyno);
  }

  @Override public void addDamage(Damage damage)
  {
    client.addDamage(damage);
  }

  @Override public void deleteDamage(int damageno)
  {
    client.deleteDamage(damageno);
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
