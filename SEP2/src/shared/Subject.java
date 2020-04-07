package shared;

import java.beans.PropertyChangeListener;

public interface Subject extends PropertyChangeListener
{
  void addListener(String eventname, PropertyChangeListener listener);
  void addListener(PropertyChangeListener listener);
  void removeListener(String eventname,PropertyChangeListener listener);
  void removeListener(PropertyChangeListener listener);
}
