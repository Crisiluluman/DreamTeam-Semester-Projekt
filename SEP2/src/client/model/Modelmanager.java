package client.model;

import shared.Damage;
import shared.Employee;
import shared.Policy;
import client.networking.Client;
import shared.Customer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class Modelmanager implements Model
{
  private Client client;
  private PropertyChangeSupport property;

  public Modelmanager(Client client)
  {
    this.client = client;
    client.start();
    client.addListener(this::updateAll);
    this.property = new PropertyChangeSupport(this);
  }

  @Override public void addEmployee(Employee employee)
  {
    client.addEmployee(employee);
  }

  @Override public void updateEmployee(Employee employee)
  {
    client.updateEmployee(employee);
  }

  @Override public void deleteEmployee(int cpr)
  {
    client.deleteEmployee(cpr);
  }

  // customer

  @Override public void addCustomer(Customer customer)
  {
    client.addCustomer(customer);
  }

  @Override public void updateCustomer(Customer customer)
  {
    client.updateCustomer(customer);
  }

  @Override public void deleteCustomer(int customerNo)
  {
    client.deleteCustomer(customerNo);
  }

  @Override public void addPolicy(Policy policy)
  {
    client.addPolicy(policy);
  }

  @Override public void updatePolicy(Policy policy)
  {
    client.updatePolicy(policy);
  }

  @Override public void deletePolicy(int policyno)
  {
    client.deletePolicy(policyno);
  }

  @Override public void addDamage(Damage damage)
  {
    client.addDamage(damage);
  }

  @Override public void updateDamage(Damage damage)
  {
    client.updateDamage(damage);
  }

  @Override public void deleteDamage(int damageno)
  {
    client.deleteDamage(damageno);
  }

  @Override public List<Customer> readCustomer()
  {
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

  @Override public void addListener(String eventname,
      PropertyChangeListener listener)
  {
    this.property.addPropertyChangeListener(eventname, listener);
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    property.addPropertyChangeListener(listener);
  }

  @Override public void removeListener(String eventname,
      PropertyChangeListener listener)
  {
    this.property.removePropertyChangeListener(eventname, listener);
  }

  @Override public void updateAll(PropertyChangeEvent evt)
  {

    switch (evt.getPropertyName())
    {
      case "updateDamages":
        property.firePropertyChange("updateDamages", null, null);
        break;

      case "updateEmployees":
        property.firePropertyChange("updateEmployees", null, null);
        break;

      case "updateCustomers":
        property.firePropertyChange("updateCustomers", null, null);
        break;

      case "updatePolicies":
        property.firePropertyChange("updatePolicies", null, null);
        break;

      default:
        break;

    }
  }
}
