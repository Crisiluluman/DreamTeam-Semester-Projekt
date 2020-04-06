package client.model.Police;

public class Police
{
  private int policeNo;
  private int price;
  private int deductible;
  private int coverage;

  public Police(int policeNo, int price, int deductible, int coverage)
  {
    this.policeNo = policeNo;
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

  public int getCoverage()
  {
    return coverage;
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
