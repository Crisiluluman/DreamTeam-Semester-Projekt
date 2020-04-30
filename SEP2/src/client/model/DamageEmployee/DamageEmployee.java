package client.model.DamageEmployee;

import client.model.Employee;

public class DamageEmployee implements Employee
{
  private String name;
  private String address;
  private long CPR;
  private int tlfnr;
  private String email;
  private String position;
  public DamageEmployee(String name,String address,long cprNr,String email,int PhoneNumber, String position)
  {
    this.name=name;
    this.address=address;
    this.CPR =cprNr;
    this.tlfnr = PhoneNumber;
    this.email=email;
    this.position = position;
  }
  @Override
  public String getName()
  {
    return name;
  }
  @Override
  public String getEmail()
  {
    return email;
  }
  @Override
  public void setName(String name)
  {
    this.name = name;
  }
  @Override
  public String getAddress()
  {
    return address;
  }
  @Override
  public void setAddress(String address)
  {
    this.address = address;
  }

  @Override
  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String getPosition() {
    return position;
  }
  @Override
  public long getCPR()
  {
    return CPR;
  }
  @Override
  public void setCPR(long CPR)
  {
    this.CPR = CPR;
  }
  @Override
  public int getTlfNr()
  {
    return tlfnr;
  }
  @Override
  public void setTlfNr(int tlfnr)
  {
    this.tlfnr = tlfnr;
  }

  public String toString()
  {
    return "name: " + name + "cpr: " + CPR + "cell: " + tlfnr + "address: " + address + "email: " + email + "position: " + position;
  }
}
