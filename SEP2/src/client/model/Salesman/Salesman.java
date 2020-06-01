package client.model.Salesman;

import shared.Employee;

public class Salesman extends Employee
{


  // private String rank;

  public Salesman(String name, String address,long cpr, String email, int tlf, String position)
  {
    super(name,address,cpr,tlf,email,position);
  }


  public String toString()
  {
    return "name: " + super.getName() + "cpr: " + super.getCPR() + "tlf: " + super.getTlfNr() + "address: " + super.getAddress() + "email: " + super.getEmail() + "position: " + super.getPosition();
  }
}
