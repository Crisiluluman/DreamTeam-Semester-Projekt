package client.model.Manager;

import shared.Employee;

public class Manager implements Employee {
  private String name;
  private long cpr;
  private int tlfnr;
  private String address;
  private String email;
  private String position;

  public Manager(String name, String address, long cpr,String email,int tlfnr, String position)
  {
    this.name = name;
    this.cpr = cpr;
    this.tlfnr = tlfnr;
    this.address = address;
    this.email=email;
    this.position = position;
  }
  @Override
  public String getName() {
    return name;
  }
  @Override
  public long getCPR() {
    return cpr;
  }
  @Override
  public String getEmail()
  {
    return email;
  }
  @Override
  public int getTlfNr() {
    return tlfnr;
  }
  @Override
  public String getAddress() {
    return address;
  }
  @Override
  public void setName(String name)
  {
    this.name = name;
  }
  @Override
  public void setCPR(long cpr)
  {
    this.cpr = cpr;
  }
  @Override
  public void setTlfNr(int tlfnr)
  {
    this.tlfnr = tlfnr;
  }

  @Override
  public String getPosition() {
    return position;
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

  public String toString()
  {
    return "name: " + name + "cpr: " + cpr + "cell: " + tlfnr + "address: " + address + "email: " + email + "position: " + position;
  }

  public void editManager(String name,String address,long cpr,String email,int cellNr)
  {
    this.name = name;
    this.cpr = cpr;
    this.email=email;
    this.tlfnr = cellNr;
    this.address = address;
  }
}
