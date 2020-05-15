package client.model.Salesman;

import shared.Employee;

public class Salesman extends Employee
{


  // private String rank;

  public Salesman(String name, String address,long cpr, String email, int tlf, String position)
  {
    super(name,address,cpr,tlf,email,position);
  }
  @Override
  public String getName()
  {
    return super.getName();
  }
  @Override
  public long getCPR()
  {
    return super.getCPR();
  }
  @Override
  public String getAddress()
  {
    return super.getAddress();
  }
  @Override
  public String getEmail()
  {
    return super.getEmail();
  }
  @Override
  public int getTlfNr()
  {
    return super.getTlfNr();
  }
  @Override
  public void setName(String name)
  {
    super.setName(name);
  }
  @Override
  public void setCPR(long cpr)
  {
    super.setCPR(cpr);
  }
  @Override
  public void setAddress(String address)
  {
    super.setAddress(address);
  }
  @Override
  public void setEmail(String email)
  {
    super.setEmail(email);
  }
  @Override
  public void setTlfNr(int tlf)
  {
    super.setTlfNr(tlf);
  }

  @Override
  public String getPosition() {
    return super.getPosition();
  }

  public String toString()
  {
    return "name: " + super.getName() + "cpr: " + super.getCPR() + "tlf: " + super.getTlfNr() + "address: " + super.getAddress() + "email: " + super.getEmail() + "position: " + super.getPosition();
  }
}
