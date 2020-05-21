package server.networking;

import shared.*;
import server.Model.ServerModelInterface;
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

  @Override public void deleteEmployee(int cpr) throws RemoteException
  {
    serverModel.deleteEmployee(cpr);
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

  @Override public void updateCustomer(Customer customer) throws RemoteException
  {

    serverModel.updateCustomer(customer);
  }

  @Override public void updateDamage(Damage damage) throws RemoteException
  {
    serverModel.updateDamage(damage);
  }

  @Override public void updateEmployee(Employee employee, Employee oldEmployee)
      throws RemoteException
  {
    serverModel.updateEmployee(employee,oldEmployee);
  }

  @Override public void deleteCustomer(int customerNo) throws RemoteException
  {
    serverModel.deleteCustomer(customerNo);
  }

  // policy

  @Override public void addPolicy(Policy policy) throws RemoteException
  {
    serverModel.addPolicy(policy);
  }

  @Override public void deletePolicy(int policyno) throws RemoteException
  {
    serverModel.deletePolicy(policyno);
  }

  // damage

  @Override public void addDamage(Damage damage)
      throws RemoteException
  {
    serverModel.addDamage(damage);
  }

  @Override public void deleteDamage(int damageno) throws RemoteException
  {
    serverModel.deleteDamage(damageno);
  }
}



