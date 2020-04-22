package client.model.Customer;

public class Customer
{
  private String name;
  private String address;
  private int postcode;
  private int costumerNo;
  private int cprNr; // primary key

  public Customer(String name,String address, int postcode, int costumerNo,int cprNr)
  {
    this.name=name;
    this.address=address;
    this.costumerNo = costumerNo;
    this.cprNr =cprNr;
    this.postcode = postcode;
  }

  public int getPostcode()
  {
    return postcode;
  }

  public void setPostcode(int postcode)
  {
    this.postcode = postcode;
  }

  public int getCostumerNo()
  {
    return costumerNo;
  }

  public void setCostumerNo(int costumerNo)
  {
    this.costumerNo = costumerNo;
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
    return cprNr;
  }

  public void setCprNr(int cprNr)
  {
    this.cprNr = cprNr;
  }


  @Override public String toString()
  {
    return "Customer{" + "name='" + name + '\'' + ", address='" + address + '\''
        + ", postcode=" + postcode + ", costumerNo=" + costumerNo + ", cprNr="
        + cprNr + '}';
  }
}
