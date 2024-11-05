
package app.app.dao;

import app.dao.Interfaces.PartnerDao;
import app.dto.PartnerDto;
import app.dao.repositories.PartnerRepository;
import app.dto.UserDto;
import app.helpers.Helpers;
import app.model.Partner;
import app.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Getter
@Setter
public class PartnerDaoImplementation implements PartnerDao {
@Autowired
PartnerRepository partnerRepository;   

    public boolean existsByDocument(PartnerDto partnerDto) throws Exception {
        return partnerRepository.existsByID(partnerDto.getID());
    }

    public void createPartner(PartnerDto partnerDto) throws Exception {    
        Partner partner = Helpers.parse(partnerDto);
        partnerRepository.save(partner);
        partnerDto.setID(partner.getID());
    }


    

    @Override
    public PartnerDto findById(PartnerDto PartnerDto) throws Exception {
        Partner partner = partnerRepository.findByID(PartnerDto.getID());
            return Helpers.parse(partner);
        }

    @Override
    public boolean existsById(UserDto UserDto) throws Exception {
            return partnerRepository.existsById(UserDto.getID());

        }


    public PartnerDto findByUserID(UserDto userDto) throws Exception {
        User user = Helpers.parse(userDto);
        Partner partner = partnerRepository.findByUserID(user);
        if (partner == null) {
            return null;
        }
        return Helpers.parse(partner);
    }

    @Override
    public PartnerDto getMoneyByPartner(double monto) throws Exception {
        Partner partner = partnerRepository.findByMoney(monto);
        return Helpers.parse(partner);
        }


    @Override
    
    public void addfunds(PartnerDto partnerDto) throws Exception {
            partnerRepository.updateMoneyByUserId(partnerDto.getMoney(),partnerDto.getUserId().getID());
        }

    

    
}

