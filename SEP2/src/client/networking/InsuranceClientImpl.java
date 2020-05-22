package client.networking;

import javafx.scene.control.TableView;
import shared.Employee;
import shared.Policy;
import shared.Customer;
import shared.Damage;
import shared.Networking.InsuranceClient;
import shared.Networking.InsuranceServer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class InsuranceClientImpl implements InsuranceClient, Client
{

  private InsuranceServer server;
  private PropertyChangeSupport property;


  public InsuranceClientImpl()
  {
    this.property = new PropertyChangeSupport(this);
  }

  @Override public void start()
  {
    try
    {
      UnicastRemoteObject.exportObject(this, 0);
      Registry registry = LocateRegistry.getRegistry("localhost", 1099);
      this.server = (InsuranceServer) registry.lookup("Server");
      server.registerClient(this);
      System.out.println("Client connected to server ");
    }
    catch (RemoteException | NotBoundException e)
    {
      e.printStackTrace();
    }
  }


  // employee
  @Override public void addEmployee(Employee employee)
  {
    try
    {
      server.addEmployee(employee);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void updateEmployee(Employee employee)
  {
    try
    {
      server.updateEmployee(employee);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public List<Employee> readEmployee()
  {
    try
    {
      return server.readEmployee();
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void deleteEmployee(int cpr)
  {
    try
    {
      server.deleteEmployee(cpr);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  // Customer

  @Override public void addCustomer(Customer customer)
  {
    try
    {
      server.addCustomer(customer);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void updateCustomer(Customer customer)
  {
    try
    {
      server.updateCustomer(customer);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public List<Customer> readCustomer()
  {
    try
    {
      return server.readCustomers();

    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return null;
  }
  @Override public void deleteCustomer(int customerNo)
  {
    try
    {
      server.deleteCustomer(customerNo);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  // Policy


  @Override public void addPolicy(Policy policy)
  {
    try
    {
      server.addPolicy(policy);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void updatePolicy(Policy policy)
  {
    try
    {
      server.updatePolicy(policy);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public List<Policy> readPolicy(int customerNo)
  {
    try
    {
      return server.readPolicy(customerNo);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void deletePolicy(int policyno)
  {
    try
    {
      server.deletePolicy(policyno);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void addDamage(Damage damage)
  {
    try
    {
      server.addDamage(damage);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void updateDamage(Damage damage)
  {
    try
    {
      server.updateDamage(damage);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public List<Damage> readDamage(int policeno)
  {
    try
    {
      return server.readDamage(policeno);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public void deleteDamage(int damageno)
  {
    try
    {
      server.deleteDamage(damageno);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }


  @Override public void updateDamages() throws RemoteException
  {
    property.firePropertyChange("updateDamages", null, null);
  }

  @Override public void updateCustomers() throws RemoteException
  {
    property.firePropertyChange("updateCustomers", null, null);
  }

  @Override public void updatePolicies() throws RemoteException
  {
    property.firePropertyChange("updatePolicies", null, null);
  }

  @Override public void updateEmployees() throws RemoteException
  {
    property.firePropertyChange("updateEmployees", null, null);
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


}



