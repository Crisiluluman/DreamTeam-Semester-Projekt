package client.model.Salesman;

import shared.Employee;

public class Salesman implements Employee
{
  private String name;
  private long CPR;
  private String address;
  private String email;
  private int tlfNr;
  private String position;


  // private String rank;

  public Salesman(String name, String address,long CPRNo, String email, int tlfNo, String position)
  {
    this.name = name;
    this.CPR = CPRNo;
    this.address = address;
    this.email = email;
    this.tlfNr = tlfNo;
    this.position = position;
  }
  @Override
  public String getName()
  {
    return name;
  }
  @Override
  public long getCPR()
  {
    return CPR;
  }
  @Override
  public String getAddress()
  {
    return address;
  }
  @Override
  public String getEmail()
  {
    return email;
  }
  @Override
  public int getTlfNr()
  {
    return tlfNr;
  }
  @Override
  public void setName(String name)
  {
    this.name = name;
  }
  @Override
  public void setCPR(long CPR)
  {
    this.CPR = CPR;
  }
  @Override
  public void setAddress(String address)
  {
    this.address = address;
  }
  @Override
  public void setEmail(String email)
  {
    this.email = email;
  }
  @Override
  public void setTlfNr(int tlfNr)
  {
    this.tlfNr = tlfNr;
  }

  @Override
  public String getPosition() {
    return position;
  }

  public String toString()
  {
    return "name: " + name + "cpr: " + CPR + "cell: " + tlfNr + "address: " + address + "email: " + email + "position: " + position;
  }
}
