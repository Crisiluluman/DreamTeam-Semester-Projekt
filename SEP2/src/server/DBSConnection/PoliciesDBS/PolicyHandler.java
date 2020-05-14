package server.DBSConnection.PoliciesDBS;

import client.model.Police.Policy;
import server.DBSConnection.DBSConnections;

public class PolicyHandler implements PolicyData
{
  private DBSConnections connection;

  @Override public void addPolicyData(Policy policy)
  {
    String sql = "INSERT INTO \"Insurance\".Policy values("+ policy.getPoliceNo() +
        "," + "'"+ policy.getPoliceType()+"'"+","+ policy
        .getPrice()+","+ policy.getDeductible()+"," +"'"+ policy.getCoverage()+"');";
    connection.connectToDB(sql);
  }
}
