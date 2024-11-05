/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.app.dao;

import app.dao.Interfaces.GuestDao;
import app.dao.repositories.GuestRepository;
import app.dto.GuestDto;
import app.dto.UserDto;
import app.helpers.Helpers;
import app.model.Guest;
import app.model.User;
import java.util.Optional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tsuna
 */
@Service
@Getter
@Setter
@NoArgsConstructor
public class GuestDaoImplementation implements GuestDao {
    @Autowired
    GuestRepository guestrepository;
    
    public boolean existsById(GuestDto GuestDto) throws Exception {
         return guestrepository.existsById(GuestDto.getId());
                
	}


    @Override
    public GuestDto getGuestById(long guestId) throws Exception {
        Optional<Guest> optionalGuest = guestrepository.findById(guestId);
        return Helpers.parse(optionalGuest.get());     
    }
    
    public void createGuest(GuestDto GuestDto) throws Exception {	
	Guest guest;
        guest = Helpers.parse(GuestDto);
        guestrepository.save(guest);
        GuestDto.setId(guest.getId());
    }

    @Override
    public void ActivateStatus(GuestDto guestDto) throws Exception {
        Guest  guest= Helpers.parse(guestDto);
        guestrepository.save(guest);
        }

    @Override
    public GuestDto findByUserId(UserDto userDto) throws Exception {
        User user = Helpers.parse(userDto);
        Guest guest = guestrepository.findByUser(user);
        if (guest == null) {
            return null;
        }
        return Helpers.parse(guest);
        }
}