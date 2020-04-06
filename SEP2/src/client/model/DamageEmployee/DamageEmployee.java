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


  public void editDamageEmployee(String name,String address,int cprNr,int PhoneNumber)
  {
    this.name=name;
    this.address=address;
    this.CprNr=cprNr;
    this.PhoneNumber = PhoneNumber;
  }
  @Override public String toString()
  {
    return "Name: " +name + "\n" + "Address: " + address + "\n" + "CPR: " + CprNr + "\n" + "PhoneNumber: " + PhoneNumber;
  }
}
