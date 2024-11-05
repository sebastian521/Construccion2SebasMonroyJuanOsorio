package app.dto;

import java.sql.Timestamp;

public class PartnerDto  {
    private long ID; 
    private double money;
    private String Type;
    private UserDto UserId;
    private Timestamp datecreated;
    

    public PartnerDto() {
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public UserDto getUserId() {
        return UserId;
    }

    public void setUserId(UserDto UserId) {
        this.UserId = UserId;
    }

    public Timestamp getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(Timestamp datecreated) {
        this.datecreated = datecreated;
    }
    
    

   
    
}
