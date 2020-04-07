package client.model.DamageEmployee;

public class DamageEmployee
{
  private String name;
  private String address;
  private int CprNr;
  private int PhoneNumber;
  public DamageEmployee(String name,String address,int cprNr,int PhoneNumber)
  {
    this.name=name;
    this.address=address;
    this.CprNr=cprNr;
    this.PhoneNumber = PhoneNumber;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getAddress()
  {
    return address;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public int getCprNr()
  {
    return CprNr;
  }

  public void setCprNr(int cprNr)
  {
    CprNr = cprNr;
  }

  public int getPhoneNumber()
  {
    return PhoneNumber;
  }

  public void setPhoneNumber(int phoneNumber)
  {
    PhoneNumber = phoneNumber;
  }

  @Override public String toString()
  {
    return "Name: " +name + "\n" + "Address: " + address + "\n" + "CPR: " + CprNr + "\n" + "PhoneNumber: " + PhoneNumber;
  }
}
