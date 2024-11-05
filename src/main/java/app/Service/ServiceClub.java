package app.Service;

import app.Controller.Utils;
import java.sql.SQLException;
import app.dao.Interfaces.UserDao;
import app.dao.Interfaces.GuestDao;
import app.dao.Interfaces.PartnerDao;
import app.dao.Interfaces.PersonDao;
import app.dao.Interfaces.InvoiceDao;
import app.dao.Interfaces.InvoiceDetailDao;
import app.dto.GuestDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import app.dto.PartnerDto;
import app.ServiceInterface.AdminService;
import app.ServiceInterface.GuestService;
import app.ServiceInterface.LoginService;
import app.ServiceInterface.PartnerService;
import app.dto.InvoiceDetailDto;
import app.dto.InvoiceDto;
import app.helpers.Helpers;
import app.model.Invoice;
import app.model.InvoiceDetail;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
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

public class ServiceClub implements LoginService, AdminService, PartnerService, GuestService {
    @Autowired
        private PersonDao persondao;
    @Autowired
        private UserDao userdao;
    @Autowired
        private PartnerDao partnerdao;
    @Autowired
    private GuestDao guest;
     @Autowired
    private InvoiceDao invoicedao;
     @Autowired
     private InvoiceDetailDao invoicedetail;  
     @Autowired 
     public static UserDto user;
     
     
    
    
    @Override
    public void Login(UserDto userDto) throws Exception {
        UserDto validateDto = userdao.findByID(userDto);
        if (validateDto == null) {
            throw new Exception("no existe ese usuario registrado");
        }
        if (!userDto.getPassword().equals(validateDto.getPassword())) {
            System.out.println(validateDto.getPassword());
            System.out.println(userDto.getPassword());
            throw new Exception("usuario o contraseña incorrecto");
        }
        userDto.setRole(validateDto.getRole());
        user = validateDto;
    }

    @Override
    public void Logout() {
        user = null;
        System.out.println("se ha cerrado sesion");
    }

    private void createPerson(PersonDto personDto) throws Exception {
        if (this.persondao.existsByDocument(personDto)) {
            throw new Exception("ya existe una persona con ese documento");
        }
        this.persondao.createPerson(personDto);
    }

    private void createUser(UserDto userDto) throws Exception {
        this.createPerson(userDto.getPersonId());
        if (this.userdao.existsByUserName(userDto)) {
            this.persondao.deletePerson(userDto.getPersonId());
            throw new Exception("ya existe un usuario con ese user name");
        }
        try {
            this.userdao.createUser(userDto);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            this.persondao.deletePerson(userDto.getPersonId());
        }
    }
    @Override
     public void CreatePartner(PartnerDto partnerDto) throws Exception{
        
        this.createUser(partnerDto.getUserId());
        UserDto userDto = userdao.findByID(partnerDto.getUserId());
        partnerDto.setUserId(userDto);
        this.partnerdao.createPartner(partnerDto);
     }

    @Override
    public void createGuest(GuestDto GuestDto) throws Exception{
        this.createUser(GuestDto.getUser());
        PartnerDto partnerDto = partnerdao.findByUserID(user);
        GuestDto.setPartner(partnerDto);
    }
    public GuestDto getGuestById(long guestId) throws Exception {
        return guest.getGuestById(guestId);
    }
    
    public void addfunds() throws Exception {
        double addfunds;
        UserDto user = ServiceClub.user;
        PartnerDto partner = partnerdao.findByUserID(user);
        System.out.println("Bienvenido su monto actual es: " + partner.getMoney() + " y su tipo de socio es: " + partner.getType());
        System.out.println("Ingresa el monto que desea agregar");
        double monto = Double.parseDouble(Utils.getReader().nextLine());
        monto = partner.getMoney() + monto;
        addfunds = monto;
        if (partner.getType().equals("regular") && addfunds >= 1000000) {
            System.out.println("No puedes tener mas de 1000000");
            addfunds = addfunds - monto;
        } else if (partner.getType().equals("vip") && addfunds >= 5000000) {
            System.out.println("No puedes tener mas de 5000000");
        }
        partner.setMoney(addfunds);
        this.partnerdao.getMoneyByPartner(addfunds);
        this.partnerdao.addfunds(partner);
    }
    
    public void createinvoice() throws Exception {
        double monto = 0;
        String descripcion;
        UserDto userDto = userdao.findByID(user);
        if (userDto == null) {
    // Manejar el caso en el que userDto es null
    throw new IllegalArgumentException("El usuario no puede ser null");
}
        System.out.println(userDto.getID());
        System.out.println(userDto.getRole());
        System.out.println(userDto.getUserName());
        System.out.println(userDto.getPersonId().getName());
        PartnerDto partner = partnerdao.findByUserID(userDto);
        System.out.println(partner.getUserId().getID());
        System.out.println(userDto.getPersonId().getDocument());
        PersonDto person = persondao.findByDocument(userDto);
        System.out.println("Bienvenido " + partner.getUserId().getName() + " ingresa la cantidad de items a consumir");
        int items = Utils.getReader().nextInt();
        List<InvoiceDetailDto> invoices = new ArrayList<InvoiceDetailDto>();
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setPartner(partner);
        invoiceDto.setPerson(person);
        invoiceDto.setStatus("Pago pendiente");
        invoiceDto.setDateCreate(new Timestamp(System.currentTimeMillis()));
        for (int i = 0; i < items; i++) {
            InvoiceDetailDto invoicedetail = new InvoiceDetailDto();
            invoicedetail.setInvoice(invoiceDto);
            invoicedetail.setItem(i + 1);
            System.out.println("Ingrese el monto del item " + invoicedetail.getItem());
            invoicedetail.setAmount(Utils.getReader().nextDouble());
            System.out.println("Ingrese la descripcion del item " + invoicedetail.getItem());
            invoicedetail.setDescription("item: " + (i + 1) + " " + Utils.getReader().next());
            monto = monto + invoicedetail.getAmount();
            invoices.add(invoicedetail);
        }
        invoiceDto.setAmount(monto);
        Invoice invoice = Helpers.Parse(invoiceDto);
        invoicedao.createInvoice(invoice);

        for (InvoiceDetailDto detail : invoices) {
            detail.setInvoice(invoiceDto);
            InvoiceDetail invoiceDetail = Helpers.parse(detail);
            invoiceDetail.setInvoiceid(invoice);
            invoicedetail.createInvoiceDetail(invoiceDetail);
        }
        System.out.println("Factura creada");

    }
}
