package server.DBConnection.DamagesDB;

import server.DBConnection.DBConnectionsInterface;
import shared.Damage;
import server.DBConnection.DBConnections;

import java.util.List;

public class DamageHandler implements DamageData
{
  private DBConnectionsInterface connection;

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
    String sql = "Update \"insurance\".damage set dPolicyType =" + "'" + damage.getPoliceType() + "'" + ","
        + "expenses =" + damage.getExpenses() + "," + "info =" + "'" + damage.getInfo() + "'"
     + " where damageNo =" + damage.getDamageNo() + ";";
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

  @Override public List totalDamages()
  {
    String sql = "SELECT count(damageno) as "+"total"+" from \"insurance\".damage";
    return connection.totalFromDB(sql);
  }
}
