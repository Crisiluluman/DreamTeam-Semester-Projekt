package server.DBConnection.PoliciesDB;

import shared.Policy;

import java.util.List;

public interface PolicyData
{
  void addPolicyData(Policy policy);
  void updatePolicyData(Policy policy, Policy policyOld);
  List<Policy> readPolicyData();
  void deletePolicyData(Policy policy);
}
