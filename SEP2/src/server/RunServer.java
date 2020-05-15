package server;

import server.Model.InsuranceServerModel;
import server.Model.ServerModel;
import server.networking.InsuranceServerImpl;
import shared.Networking.InsuranceServer;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer
{
  public static void main(String[] args) throws RemoteException, AlreadyBoundException
  {
    InsuranceServerModel server = new InsuranceServerImpl(new ServerModel());
    server.start();
  }
}
