package client.model.Customer;

public class Customer
{
  private String name;
  private String address;
  private int costumerNo;
  private int cprNr; // primary key
  private String household = null;

  public Customer(String name,String address,int costumerNo,int cprNr,String household)
  {
    this.name=name;
    this.address=address;
    this.costumerNo = costumerNo;
    this.cprNr =cprNr;
    this.household = household;
  }
  public Customer(String name,String address,int age,int cprNr)
  {
this.name=name;
this.address=address;
this.costumerNo = costumerNo;
this.cprNr =cprNr;
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

  public int getAge()
  {
    return costumerNo;
  }

  public void setAge(int costumerNo)
  {
    this.costumerNo = costumerNo;
  }

  public int getCprNr()
  {
    return cprNr;
  }

  public void setCprNr(int cprNr)
  {
    this.cprNr = cprNr;
  }

  public String getHousehold()
  {
    return household;
  }

  public void setHousehold(String household)
  {
    this.household = household;
  }

  @Override public String toString()
  {
    return "Customer{" + "name='" + name + '\'' + ", address='" + address + '\''
        + ", CustomerNo=" + costumerNo + ", cprNr=" + cprNr + ", household='" + household
        + '\'' + '}';
  }
}
