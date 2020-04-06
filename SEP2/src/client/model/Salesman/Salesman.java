package client.model.Salesman;

public class Salesman
{
  private String name;
  private int CPRNo;
  private String address;
  private String email;
  private int tlfNo;


  // private String rank;

  public Salesman(String name, int CPRNo, String address, String email, int tlfNo)
  {
    this.name = name;
    this.CPRNo = CPRNo;
    this.address = address;
    this.email = email;
    this.tlfNo = tlfNo;
  }

  public String getName()
  {
    return name;
  }

  public int getCPRNo()
  {
    return CPRNo;
  }

  public String getAddress()
  {
    return address;
  }

  public String getEmail()
  {
    return email;
  }

  public int getTlfNo()
  {
    return tlfNo;
  }

  @Override public String toString()
  {
    return "Salesman name: " + getName() + " \n" +
        "CPR no: " + getCPRNo() + "\n" +
        "Address: " + getAddress() + "\n" +
        "Email: " + getEmail() + " \n" +
        "Telephone no: " + getTlfNo() + " \n" +
        "\n";
  }
}
