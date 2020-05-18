package client.networking;

import javafx.scene.control.TableView;
import server.Model.InsuranceServerModel;
import server.Model.ServerModel;
import shared.Customer;
import shared.Networking.InsuranceClient;
import shared.Networking.InsuranceServer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
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
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    catch (NotBoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void update()
  {
    property.firePropertyChange("update", null, null);
  }

  @Override public void addListener(String eventname,
      PropertyChangeListener listener)
  {
    this.property.addPropertyChangeListener(eventname, listener);
  }

  @Override public void removeListener(String eventname,
      PropertyChangeListener listener)
  {
    this.property.removePropertyChangeListener(eventname, listener);

  }

  @Override public List<Customer> readCustomer()
  {
    try
    {
      System.out.println(server.readCustomers());
      return server.readCustomers();

    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return null;
  }
}



