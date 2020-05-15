package client.model.Manager;

import shared.Employee;

public class Manager extends Employee
{

  public Manager(String name, String address, long cpr,String email,int tlfnr, String position)
  {
    super(name, address, cpr, tlfnr,email,position);

  }


  @Override
  public String getName() {
    return super.getName();
  }
  @Override
  public long getCPR() {
    return super.getCPR();
  }
  @Override
  public String getEmail()
  {
    return super.getEmail();
  }
  @Override
  public int getTlfNr() {
    return super.getTlfNr();
  }
  @Override
  public String getAddress() {
    return super.getAddress();
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
  public void setTlfNr(int tlfnr)
  {
    super.setTlfNr(tlfnr);
  }

  @Override
  public String getPosition() {
    return super.getPosition();
  }

  @Override
  public void setAddress(String address)
  {
    super.setAddress(address);
  }

  @Override
  public void setEmail(String email) {
    super.setEmail(email);
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
