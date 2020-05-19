package server;

import server.Model.ServerModel;
import server.networking.InsuranceServerImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer
{
  public static void main(String[] args) throws RemoteException, AlreadyBoundException
  {
    InsuranceServerImpl server = new InsuranceServerImpl(new ServerModel());
    server.start();
  }
}
