package server.DBConnection.PoliciesDB;

import client.model.Policy.Policy;

public interface PolicyData
{
  void addPolicyData(Policy policy);
  void updatePolicyData(Policy policy, Policy policyOld);
  void readPolicyData(Policy policy);
  void deletePolicyData(Policy policy);
}
