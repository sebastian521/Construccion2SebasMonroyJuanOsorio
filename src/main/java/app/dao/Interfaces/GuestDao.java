/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.dao.Interfaces;

import app.dto.GuestDto;
import app.dto.UserDto;

/**
 *
 * @author tsuna
 */
public interface GuestDao {
   public GuestDto getGuestById(long guestId) throws Exception;
   public boolean existsById(GuestDto GuestDto) throws Exception;
   public void createGuest(GuestDto GuestDto) throws Exception;
   public void ActivateStatus(GuestDto guestDto) throws Exception;
   public GuestDto findByUserId(UserDto userDto) throws Exception;
}
