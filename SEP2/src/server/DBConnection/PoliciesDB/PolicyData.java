package server.DBConnection.PoliciesDB;

import shared.Policy;

public interface PolicyData
{
  void addPolicyData(Policy policy);
  void updatePolicyData(Policy policy, Policy policyOld);
  void readPolicyData(Policy policy);
  void deletePolicyData(Policy policy);
}
