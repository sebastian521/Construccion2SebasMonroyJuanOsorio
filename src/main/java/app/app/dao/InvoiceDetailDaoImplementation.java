/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.app.dao;

import app.dao.Interfaces.InvoiceDetailDao;
import app.dao.repositories.InvoiceDetailRepository;
import app.model.InvoiceDetail;
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
@NoArgsConstructor
@Getter
@Setter
public class InvoiceDetailDaoImplementation implements InvoiceDetailDao {
    @Autowired
    InvoiceDetailRepository invoiceDetailRepository;

    @Override
    public void createInvoiceDetail(InvoiceDetail invoiceDetail) throws Exception {
        invoiceDetailRepository.save(invoiceDetail);
        }
    
}
