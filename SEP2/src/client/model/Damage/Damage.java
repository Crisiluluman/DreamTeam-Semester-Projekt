package client.model.Damage;

import client.model.Police.Police;

public class Damage {
  private Police police;
  private double expenses;
  private int damageNo;
  private String info;

  public Damage(Police police, double expenses, int damageNo, String info)
  {
    this.police = police;
    this.expenses = expenses;
    this.info = info;
    this.damageNo = damageNo;
  }

  public Police getPolice() {
    return police;
  }

  public double getExpenses() {
    return expenses;
  }

  public String getInfo() {
    return info;
  }

  public void setPolice(Police police)
  {
    this.police = police;
  }

  public int getDamageNo()
  {
    return damageNo;
  }

  public void setDamageNo(int damageNo)
  {
    this.damageNo = damageNo;
  }

  public void setExpenses(double expenses)
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
