package client.model.Policy;

import client.model.Customer.Customer;

public class Policy
{
  private int policeNo;
  private String policeType;
  private int price;
  private int deductible;
  private String coverage;
  private Customer customer; //todo insert customerno?


  public Policy(int policeNo,String policeType, int price, int deductible, String coverage/* Customer customer*/)
  {
    this.policeNo = policeNo;
    this.policeType=policeType;
    this.price = price;
    this.deductible = deductible;
    this.coverage = coverage;

  }

  public int getPoliceNo()
  {
    return policeNo;
  }

  public int getPrice()
  {
    return price;
  }

  public int getDeductible()
  {
    return deductible;
  }

  public String getCoverage()
  {
    return coverage;
  }

  public String getPoliceType()
  {
    return policeType;
  }

  public void setPoliceNo(int policeNo)
  {
    this.policeNo = policeNo;
  }

  public void setPrice(int price)
  {
    this.price = price;
  }

  public void setDeductible(int deductible)
  {
    this.deductible = deductible;
  }

  @Override public String toString()
  {
    return "Police number: " + getPoliceNo() + " \n" +
        "Police Type: " + getPoliceType() + " \n" +
        "Price: " + getPrice() + "\n" +
        "Deductible's: " + getDeductible() + "\n" +
        "Coverage: " + getCoverage() + "\n" +
        "\n";
  }
}