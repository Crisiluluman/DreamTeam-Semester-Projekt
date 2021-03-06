package shared;



import java.io.Serializable;

public class Policy implements Serializable
{
  private int policeNo;
  private String policeType;
  private int price;
  private int deductible;
  private String coverage;
  private int customerNo;


  public Policy(String policeType, int price, int deductible, String coverage,int customerNo)
  {
    this.policeType=policeType;
    this.price = price;
    this.deductible = deductible;
    this.coverage = coverage;
    this.customerNo=customerNo;

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

  public int getCustomerNo()
  {
    return customerNo;
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
        "Customer number: " + getCustomerNo() + "\n";
  }
}
