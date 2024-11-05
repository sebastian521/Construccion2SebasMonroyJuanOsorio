
package app.dto;


public class GuestDto {
    
    private long Id;
    private String Status;
    private UserDto user;
    private PartnerDto Partner;

    public GuestDto(){
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public PartnerDto getPartner() {
        return Partner;
    }

    public void setPartner(PartnerDto Partner) {
        this.Partner = Partner;
    }

    public long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    
    
    
}
