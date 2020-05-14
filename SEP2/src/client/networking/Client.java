package client.networking;

import shared.Subject;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public interface Client extends Subject
{
  void start() throws RemoteException, NotBoundException;
}
