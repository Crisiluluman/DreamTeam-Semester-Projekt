package client.model.Manager;

import shared.Employee;

public class Manager extends Employee
{

  public Manager(String name, String address, long cpr,String email,int tlfnr, String position)
  {
    super(name, address, cpr, tlfnr,email,position);

  }


  public String toString()
  {
    return  "name: " + super.getName() + "cpr: " + super.getCPR() + "tlfnr: " + super.getTlfNr() + "address: " + super.getAddress() + "email: " + super.getEmail() + "position: " + super.getPosition();
  }

  public void editManager(String name,String address,long cpr,String email,int tlfnr)
  {
    super.setName(name);
    super.setAddress(address);
    super.setCPR(cpr);
    super.setEmail(email);
    super.setTlfNr(tlfnr);
  }
}
