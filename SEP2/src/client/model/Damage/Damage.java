package client.model.Damage;

import java.io.Serializable;

public class Damage implements Serializable
{
  private int policeNo;
  private String policeType;
  private double expenses;
  private int damageNo;
  private String info;

  public Damage(int policeNo, String policeType, double expenses, int damageNo, String info)
  {
    this.policeNo = policeNo;
    this.policeType = policeType;
    this.expenses = expenses;
    this.info = info;
    this.damageNo = damageNo;
  }


  public int getPoliceNo() {
    return policeNo;
  }

  public String getPoliceType(){return policeType;}

  public double getExpenses() {
    return expenses;
  }

  public String getInfo() {
    return info;
  }

  public void setPoliceNo(int policeNo)
  {
    this.policeNo = policeNo;
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
    return "" + "Police:" + policeNo + " expenses: " + expenses + " info: " + info;
  }

}
