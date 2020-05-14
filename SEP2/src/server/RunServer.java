package server;

import server.networking.InsuranceServerImpl;
import shared.Networking.InsuranceServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer
{
  public static void main(String[] args) throws RemoteException, AlreadyBoundException
  {
    InsuranceServerImpl server = new InsuranceServerImpl();
    server.start();
  }
}
