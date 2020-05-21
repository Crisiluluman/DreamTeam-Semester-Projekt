package server.DBConnection.DamagesDB;

import shared.Damage;
import server.DBConnection.DBConnections;

import java.util.List;

public class DamageHandler implements DamageData
{
  private DBConnections connection;

  public DamageHandler()
  {
    connection = new DBConnections();
  }

  @Override public void addDamageData(Damage damage)
  {
    System.out.println(damage);
    String sql = "INSERT INTO \"insurance\".damage (policyNo, expenses, info, dPolicyType) values(" + damage.getPoliceNo() + ","
        + damage.getExpenses()+","
        + "'" + damage.getInfo()+ "'" + ","
        +"'"+ damage.getPoliceType()+"'" +");";
    connection.AddToDB(sql);
  }

  @Override public void updateDamageData(Damage damage)
  {
    // you need a goddam policyno in here
    String sql = "Update \"insurance\".damage set type =" + "'" + damage.getPoliceType() + "'" + ","
        + "expenses =" + damage.getExpenses() + "," + "info =" + "'" + damage.getInfo() + "'" + ","
        + "dPolicyType =" + "'" + damage.getPoliceType() + "'" + " where damageNo =" + damage.getDamageNo() + ";";
    connection.AddToDB(sql);
  }

  @Override public List<Damage> readDamageData(int policeno)
  {
    String sql = "SELECT * FROM \"insurance\".damage where policyno='"+policeno+"';";
    return connection.fillDamageTableDB(sql,policeno);
  }

  @Override public void deleteDamageData(int damageno)
  {
    String sql = "Delete from \"insurance\".damage where damageno =" + "'" + damageno + "'" +";";
    connection.AddToDB(sql);
  }
}
