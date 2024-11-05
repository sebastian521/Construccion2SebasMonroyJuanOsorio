/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package app.dao.repositories;

import app.model.Partner;
import app.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author tsuna
 */
@Repository
public interface PartnerRepository extends JpaRepository<Partner, Long> {

    public boolean existsByID(Long ID);
    public Partner findByID(Long ID);
    public Partner findByUserID(User user);
    public Partner findByMoney(double monto);
    
    @Modifying
    @Transactional
    @Query("UPDATE Partner p SET p.money = :money WHERE p.userID.id = :userId")
    void updateMoneyByUserId(@Param("money") Double monto, @Param("userId") Long userID);
}


