package server;

import server.networking.InsuranceServerImpl;
import shared.InsuranceServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer
{
  public static void main(String[] args)
      throws RemoteException, AlreadyBoundException
  {
    InsuranceServer server = new InsuranceServerImpl();
    server.start();
  }
}
