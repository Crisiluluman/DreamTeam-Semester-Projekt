package client.core;

import client.model.Model;
import client.model.Modelmanager;

public class ModelFactory
{

  private Model model;

  private final ClientFactory clientFactory;

  public ModelFactory(ClientFactory cf)
  {
    clientFactory = cf;
  }

  public Model getModel()
  {
    if(model == null)
    {
      model = new Modelmanager(clientFactory.getClient());
    }
    return model;
  }



}
