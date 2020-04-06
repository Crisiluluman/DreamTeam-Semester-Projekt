package client.model.Manager;

public class Manager {
  private String name;
  private int cpr;
  private int cellNr;
  private String address;

  public Manager(String name, int cpr, int cellNr, String address)
  {
    this.name = name;
    this.cpr = cpr;
    this.cellNr = cellNr;
    this.address = address;
  }

  public String getName() {
    return name;
  }

  public int getCpr() {
    return cpr;
  }

  public int getCellNr() {
    return cellNr;
  }

  public String getAddress() {
    return address;
  }

  public String toString()
  {
    return "name: " + name + "cpr: " + cpr + "cell: " + cellNr + "address: " + address;
  }

  public void editManager(String name, int cpr, int cellNr, String address)
  {
    this.name = name;
    this.cpr = cpr;
    this.cellNr = cellNr;
    this.address = address;
  }
}
