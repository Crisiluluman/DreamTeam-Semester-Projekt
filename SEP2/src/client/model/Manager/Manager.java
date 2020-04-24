package client.model.Manager;

public class Manager {
  private String name;
  private int cpr;
  private int tlfnr;
  private String address;
  private String email;

  public Manager(String name, String address, int cpr,String email,int tlfnr)
  {
    this.name = name;
    this.cpr = cpr;
    this.tlfnr = tlfnr;
    this.address = address;
    this.email=email;
  }

  public String getName() {
    return name;
  }

  public int getCpr() {
    return cpr;
  }

  public int getTlfnr() {
    return tlfnr;
  }

  public String getAddress() {
    return address;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public void setCpr(int cpr)
  {
    this.cpr = cpr;
  }

  public void setTlfnr(int tlfnr)
  {
    this.tlfnr = tlfnr;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public String toString()
  {
    return "name: " + name + "cpr: " + cpr + "cell: " + tlfnr + "address: " + address;
  }

  public void editManager(String name, int cpr, int cellNr, String address)
  {
    this.name = name;
    this.cpr = cpr;
    this.tlfnr = cellNr;
    this.address = address;
  }
}
