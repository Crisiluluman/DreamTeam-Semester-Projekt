package server.networking;

import client.model.Damage.Damage;
import shared.Employee;
import shared.Policy;
import server.Model.ServerModelInterface;
import shared.Customer;
import shared.Networking.InsuranceClient;
import shared.Networking.InsuranceServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class InsuranceServerImpl implements InsuranceServer
{
  private ServerModelInterface serverModel;

  public InsuranceServerImpl(ServerModelInterface serverModel) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this,0);
    this.serverModel = serverModel;
  }

  public void start() throws RemoteException, AlreadyBoundException
  {
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("Server", this);
    System.out.println("Server started");
  }


  @Override public void registerClient(InsuranceClient client)
  {

  }

  @Override public void addCustomer(Customer customer) throws RemoteException
  {
    serverModel.addCustomer(customer);
  }


  @Override
  public List<Customer> readCustomers() {
    return serverModel.readCustomers();
  }

  @Override public List<Policy> readPolicy(int customerNo) throws RemoteException
  {
    return serverModel.readPolicy(customerNo);
  }

  @Override public List<Employee> readEmployee() throws RemoteException
  {
    return serverModel.readEmployee();
  }

  @Override public List<Damage> readDamage(int policeno) throws RemoteException
  {
    return serverModel.readDamage(policeno);
  }
}
