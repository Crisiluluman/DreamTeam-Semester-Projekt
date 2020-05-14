package server.DBSConnection.DamagesDBS;

import client.model.Damage.Damage;
import server.DBSConnection.DBSConnections;

public class DamageHandler implements DamageData
{
  private DBSConnections connection;

  public DamageHandler(DBSConnections connection)
  {
    this.connection = connection;
  }

  @Override public void addDamageData(Damage damage)
  {
    String sql = "INSERT INTO \"Insurance\".damage values(" + damage.getPoliceNo() + "," + "'" + damage.getPoliceType() + "'"  + "," + damage.getExpenses() + "," + damage.getDamageNo() + "," + "'" + damage.getInfo() + "'" + ");";
    connection.connectToDB(sql);
  }
}
