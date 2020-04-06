package client.model.Customer;

public class Customer
{
  private String name;
  private String address;
  private int age;
  private int CprNr;
  private String Roommate = null;

  public Customer(String name,String address,int age,int cprNr,String roommate)
  {
    this.name=name;
    this.address=address;
    this.age=age;
    this.CprNr=cprNr;
    this.Roommate=roommate;
  }
  public Customer(String name,String address,int age,int cprNr)
  {
this.name=name;
this.address=address;
this.age=age;
this.CprNr=cprNr;
  }

  public void editCustomer(String name,String address,int age,int cprNr)
  {
    this.name=name;
    this.address=address;
    this.age=age;
    this.CprNr=cprNr;
    Roommate = null;
  }
  public void editCustomer(String name,String address,int age,int cprNr,String roommate)
  {
    this.name=name;
    this.address=address;
    this.age=age;
    this.CprNr=cprNr;
    this.Roommate=roommate;
  }


}
