package server.networking;



import shared.Damage;
import shared.Policy;
import server.Model.InsuranceServerModel;
import server.Model.ServerModelInterface;
import shared.Customer;
import shared.Employee;
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

  // employee

  @Override public void addEmployee(Employee employee) throws RemoteException
  {
    serverModel.addEmployee(employee);
  }

  @Override public void deleteEmployee(Employee employee) throws RemoteException
  {
    serverModel.deleteEmployee(employee);
  }


  // Customer
  @Override public void addCustomer(Customer customer) throws RemoteException
  {
    serverModel.addCustomer(customer);
  }

  @Override
  public List<Customer> readCustomers()
  {
    return serverModel.readCustomers();
  }

  @Override public void deleteCustomer(Customer customer) throws RemoteException
  {
    serverModel.deleteCustomer(customer);
  }

  // policy

  @Override public void addPolicy(Policy policy) throws RemoteException
  {
    serverModel.addPolicy(policy);
  }

  @Override public void deletePolicy(Policy policy) throws RemoteException
  {
    serverModel.deletePolicy(policy);
  }

  // damage

  @Override public void addDamage(Policy policy, Damage damage)
      throws RemoteException
  {
    serverModel.addDamage(policy, damage);
  }

  @Override public void deleteDamage(Damage damage) throws RemoteException
  {
    serverModel.deleteDamage(damage);
  }
}



