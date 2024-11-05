package app.ServiceInterface;

import app.dto.GuestDto;

public interface PartnerService {
    public void createGuest(GuestDto GuestDto) throws Exception;
    public void createinvoice() throws Exception;
    
}
