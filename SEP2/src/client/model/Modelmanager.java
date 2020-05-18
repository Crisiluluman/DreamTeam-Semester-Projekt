package client.model;

import client.model.Policy.Policy;
import client.model.Policy.PoliceList;
import client.networking.Client;
import javafx.scene.control.TableView;
import shared.Customer;

import java.rmi.NotBoundException;
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

  @Override
  public List<Customer> readCustomer(){
    return client.readCustomer();
  }

}
