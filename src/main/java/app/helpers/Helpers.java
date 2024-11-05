
package app.helpers;

import app.dto.GuestDto;
import app.dto.InvoiceDetailDto;
import app.dto.InvoiceDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.model.Person;
import app.model.User;
import app.model.Partner;
import app.dto.PartnerDto;
import app.model.Guest;
import app.model.Invoice;
import app.model.InvoiceDetail;

public abstract class Helpers {
    public static PersonDto parse(Person Person){
        if (Person == null) {
            return null;
        }
        PersonDto personDto = new PersonDto();
	personDto.setiD(Person.getID());
	personDto.setDocument(Person.getDocument());
	personDto.setName(Person.getName());
	personDto.setCellPhoneNumber(Person.getCellPhone());
	return personDto;     
        
    }
    public static Person parse(PersonDto personDto) {
        if (personDto == null) {
            return null;
        }
		Person person = new Person();
		person.setID(personDto.getiD());
		person.setDocument(personDto.getDocument());
		person.setName(personDto.getName());
		person.setCellPhone(personDto.getCellPhoneNumber());
		return person;
	}
    public static UserDto parse(User user) {
                
		UserDto userDto = new UserDto();
                if (user.getPersonID()!=null){
                    userDto.setPersonId(parse(user.getPersonID()));
                }
		userDto.setID(user.getId());
		userDto.setPersonId(parse(user.getPersonID()));
		userDto.setRole(user.getRole());
		userDto.setUserName(user.getUsername());
                userDto.setPassword(user.getPassword());
		return userDto;
	}
    public static User parse(UserDto userDto) {
      
		User user = new User();
                 if (userDto.getPersonId()!=null){
                   user.setPersonID(parse(userDto.getPersonId()));
                }
		user.setId(userDto.getID());
		user.setPersonID(parse(userDto.getPersonId()));
		user.setRole(userDto.getRole());
		user.setUsername(userDto.getUserName());
                user.setPassword(userDto.getPassword());
		return user;
	}
    public static PartnerDto parse(Partner Partner){
                PartnerDto PartnerDto = new PartnerDto();
                PartnerDto.setID(Partner.getID());
                PartnerDto.setMoney(Partner.getMoney());
                Partner.setType(PartnerDto.getType());
                Partner.setDateCreated(Partner.getDateCreated());
                Partner.setUserID(parse(PartnerDto.getUserId()));
                return PartnerDto;
        
    }
    public static Partner parse(PartnerDto PartnerDto){
                Partner Partner = new Partner();
                Partner.setID(PartnerDto.getID());
                Partner.setMoney(PartnerDto.getMoney());
                Partner.setType(PartnerDto.getType());
                Partner.setDateCreated(PartnerDto.getDatecreated());
		Partner.setUserID(parse(PartnerDto.getUserId()));
                return Partner;
    }
    public static GuestDto parse(Guest guest) {
        GuestDto guestDto = new GuestDto();
        guestDto.setId(guest.getId());
        guestDto.setPartner(parse(guest.getPartner()));
        guestDto.setStatus(guest.getStatus());
        guestDto.setUser(parse(guest.getUser()));

        return guestDto;
    }

    public static Guest parse(GuestDto guestDto) {
        Guest guest = new Guest();
        guest.setId(guestDto.getId());
        guest.setPartner(parse(guestDto.getPartner()));
        guest.setStatus(guestDto.getStatus());
        guest.setUser(parse(guestDto.getUser()));

        return guest;
    }
    public static InvoiceDto Parse(Invoice invoice){
        if (invoice == null) {
            return null;
        }
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setAmount(invoice.getAmount());
        invoiceDto.setDateCreate(invoice.getDate());
        invoiceDto.setId(invoice.getId());
        invoiceDto.setPartner(parse(invoice.getPartner()));
        invoiceDto.setPerson(parse(invoice.getPerson()));
        invoiceDto.setStatus(invoice.getStatus());
        return invoiceDto;
        
    }
    public static Invoice Parse(InvoiceDto invoiceDto){
         if (invoiceDto == null) {
            return null;
        }
        Invoice invoice = new Invoice();
        invoice.setAmount(invoiceDto.getAmount());
        invoice.setDate(invoiceDto.getDateCreate());
        invoice.setId(invoiceDto.getId());
        invoice.setPartner(parse(invoiceDto.getPartner()));
        invoice.setPerson(parse(invoiceDto.getPerson()));
        invoice.setStatus(invoiceDto.getStatus());
        
        return invoice;
    }
    public static InvoiceDetailDto Parse(InvoiceDetail invoiceDetail){
        if (invoiceDetail == null) {
            return null;
        }
        InvoiceDetailDto invoicedetaildto= new InvoiceDetailDto ();
        invoicedetaildto.setAmount(invoiceDetail.getAmount());
        invoicedetaildto.setDescription(invoiceDetail.getDescription());
        invoicedetaildto.setId(invoiceDetail.getId());
        invoicedetaildto.setInvoice(Parse(invoiceDetail.getInvoiceid()));
        invoicedetaildto.setItem(invoiceDetail.getItem());
        return invoicedetaildto;
        
    }
    public static InvoiceDetail parse(InvoiceDetailDto invoiceDetailDto){
        if (invoiceDetailDto == null) {
            return null;
        }
        InvoiceDetail invoiceDetail = new InvoiceDetail ();
        invoiceDetail.setAmount(invoiceDetailDto.getAmount());
        invoiceDetail.setDescription(invoiceDetailDto.getDescription());
        invoiceDetail.setId(invoiceDetailDto.getId());
        invoiceDetail.setInvoiceid(Parse(invoiceDetailDto.getInvoice()));
        invoiceDetail.setItem(invoiceDetailDto.getItem());
        return invoiceDetail;
    }
    
}
