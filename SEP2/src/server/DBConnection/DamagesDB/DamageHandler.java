package server.DBConnection.DamagesDB;

import shared.Damage;
import shared.Policy;
import javafx.scene.control.Tab;
import javafx.scene.control.TableView;
import server.DBConnection.DBConnections;

import java.util.List;

public class DamageHandler implements DamageData
{
  private DBConnections connection;

  public DamageHandler()
  {
    connection = new DBConnections();
  }

  @Override public void addDamageData(Policy policy, Damage damage)
  {
    String sql =
        "INSERT INTO \"insurance\".damage values(" + damage.getPoliceType() + "," + "'" + damage.getPoliceType() + "'"
            + "," + damage.getExpenses() + "," + damage.getDamageNo() + "," + "'" + damage
            .getInfo() + "'" + ");";
    connection.AddToDB(sql);
  }

  @Override public void updateDamageData(Damage damage, Damage damageOld)
  {
    // you need a goddam policyno in here
    String sql = "Update \"insurance\".damage set type =" + "'" + damage.getPoliceType() + "'" + ","
        + "expenses =" + damage.getExpenses() + "," + "info =" + "'" + damage.getInfo() + "'" + ","
        + "dPolicyType =" + "'" + damage.getPoliceType() + "'" + " where damageNo =" + damageOld.getDamageNo() + ";";
    connection.AddToDB(sql);
  }

  @Override public List<Damage> readDamageData(int policeno)
  {
    String sql = "SELECT * FROM \"insurance\".damage where policyno='"+policeno+"';";
    return connection.fillDamageTableDB(sql,policeno);
  }

  @Override public void deleteDamageData(Damage damage)
  {
    String sql = "Delete from \"insurance\".damage where damageno =" + "'" + damage.getDamageNo() + "'" +";";
    connection.AddToDB(sql);
  }
}
