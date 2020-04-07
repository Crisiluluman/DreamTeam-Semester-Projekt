package client.model.Police;

import client.model.Customer.Customer;

public class Police
{
  private int policeNo;
  private int price;
  private int deductible;
  private String coverage;
  private Customer customer;

  public Police(int policeNo, int price, int deductible, String coverage, Customer customer)
  {
    this.policeNo = policeNo;
    this.price = price;
    this.deductible = deductible;
    this.coverage = coverage;
    this.customer = customer;
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

  public Customer getCustomer()
  {
    return customer;
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
        "Price: " + getPrice() + "\n" +
        "Deductible's: " + getDeductible() + "\n" +
        "Coverage: " + getCoverage() + "\n" +
        "\n";
  }
}
