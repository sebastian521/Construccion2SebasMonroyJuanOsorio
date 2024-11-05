/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.app.dao;

import app.dao.Interfaces.InvoiceDao;
import app.dao.repositories.InvoiceRepository;
import app.model.Invoice;
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
public class InvoiceDaoImplementation implements InvoiceDao {

    @Autowired
    InvoiceRepository invoiceRepository;
    public void createInvoice(Invoice invoice) throws Exception {
        invoiceRepository.save(invoice);
    }
        
    
}
