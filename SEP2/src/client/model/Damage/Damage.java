package client.model.Damage;

import client.model.Police.Police;

public class Damage {
  private Police police;
  private int expenses;
  private String info;

  private Damage(Police police, int expenses, String info)
  {
    this.police = police;
    this.expenses = expenses;
    this.info = info;
  }

  public Police getPolice() {
    return police;
  }

  public int getExpenses() {
    return expenses;
  }

  public String getInfo() {
    return info;
  }

  public void setPolice(Police police)
  {
    this.police = police;
  }

  public void setExpenses(int expenses)
  {
    this.expenses = expenses;
  }

  public void setInfo(String info)
  {
    this.info = info;
  }

  public String toString()
  {
    return "" + "Police:" + police + " expenses: " + expenses + " info: " + info;
  }

}
