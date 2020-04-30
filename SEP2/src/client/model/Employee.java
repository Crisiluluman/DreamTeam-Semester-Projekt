package client.model;

public interface Employee
{
    String getName();
    long getCPR();
    String getAddress();
    String getEmail();
    int getTlfNr();
    void setName(String name);
    void setCPR(long CPR);
    void setAddress(String address);
    void setEmail(String email);
    void setTlfNr(int tlfNr);
    String getPosition();
}
