package shared;

import java.io.Serializable;

public abstract class Employee implements Serializable
{
    private String name;
    private String address;
    private long CPR;
    private int tlfnr;
    private String email;
    private String position;

    public Employee(String name, String address, long CPR, int tlfnr,
        String email, String position)
    {
        this.name = name;
        this.address = address;
        this.CPR = CPR;
        this.tlfnr = tlfnr;
        this.email = email;
        this.position = position;
    }

    public String getName()
{
  return name;
}


    public String getEmail()
    {
        return email;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPosition() {
        return position;
    }

    public long getCPR()
    {
        return CPR;
    }

    public void setCPR(long CPR)
    {
        this.CPR = CPR;
    }

    public int getTlfNr()
    {
        return tlfnr;
    }

    public void setTlfNr(int tlfnr)
    {
        this.tlfnr = tlfnr;
    }

    public String toString()
    {
        return "name: " + name + "cpr: " + CPR + "cell: " + tlfnr + "address: " + address + "email: " + email + "position: " + position;
    }

    //    String getName();
//    long getCPR();
//    String getAddress();
//    String getEmail();
//    int getTlfNr();
//    void setName(String name);
//    void setCPR(long CPR);
//    void setAddress(String address);
//    void setEmail(String email);
//    void setTlfNr(int tlfNr);
//    String getPosition();
}
