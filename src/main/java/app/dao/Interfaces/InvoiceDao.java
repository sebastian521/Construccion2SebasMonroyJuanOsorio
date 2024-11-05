package app.dao.Interfaces;

import app.model.Invoice;


public interface InvoiceDao {
    public void createInvoice(Invoice invoice) throws Exception;
}
