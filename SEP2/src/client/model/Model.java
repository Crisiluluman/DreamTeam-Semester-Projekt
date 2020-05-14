package client.model;

import client.model.Policy.Policy;
import client.core.ViewModelFactory;

import client.model.Policy.PolicyList;

public interface Model
{
void createPolicy(Policy policy);
PolicyList getPolicy();
ViewModelFactory getViewModelFactory();
}
