/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.dao.repositories;

import app.model.Guest;
import app.model.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author tsuna
 */
public interface GuestRepository extends JpaRepository <Guest, Long>{
    
    public Guest findByUser(User user);
    public boolean existsById(Long id);
        @Modifying
        @Query("UPDATE Guest p SET p.status = ?1 WHERE p.id = ?2")
    public void updateGuestStatus(String status, Long id);
     
        Optional<Guest> findById(Long guestId);
}
