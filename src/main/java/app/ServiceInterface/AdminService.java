package app.ServiceInterface;

import app.dto.PartnerDto;
import app.dto.UserDto;
import org.springframework.stereotype.Service;




public interface AdminService {
    public void CreatePartner(PartnerDto partnerDto) throws Exception;
}
