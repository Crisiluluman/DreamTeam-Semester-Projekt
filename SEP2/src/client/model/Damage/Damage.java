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

  public String toString()
  {
    return "" + "Police:" + police + " expenses: " + expenses + " info: " + info;
  }

  public void editDamage(Police police, int expenses, String info) {
    this.police = police;
    this.expenses = expenses;
    this.info = info;
  }
}
