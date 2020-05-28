package shared;

import java.io.Serializable;

public class Customer implements Serializable
{
  private String name;
  private String address;
  private int postcode;
  private int costumerNo;
  private long cprNr; // primary key
  private double combinedRatio;

  public Customer(String name,String address, int postcode,long cprNr)
  {
    this.name=name;
    this.address=address;
    this.cprNr =cprNr;
    this.postcode = postcode;
  }

  public int getPostcode()
  {
    return postcode;
  }

  public int getCustomerNo()
  {
    return costumerNo;
  }

  public void setCustomerNo(int customerNo)
  {
    this.costumerNo = customerNo;
  }

  public String getName()
  {
    return name;
  }

  public String getAddress()
  {
    return address;
  }

  public long getCprNr()
  {
    return cprNr;
  }

  public double getCombinedRatio()
  {
    return combinedRatio;
  }

  public void setCombinedRatio(double combinedRatio)
  {
    this.combinedRatio = combinedRatio;
  }

  @Override public String toString()
  {
    return "Customer{" + "name='" + name + '\'' + ", address='" + address + '\''
        + ", postcode=" + postcode + ", costumerNo=" + costumerNo + ", cprNr="
        + cprNr + '}';
  }


}
