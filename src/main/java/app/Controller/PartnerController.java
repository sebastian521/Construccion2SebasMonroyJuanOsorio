
package app.Controller;

import app.ServiceInterface.PartnerService;
import app.controllervalidator.PersonValidator;
import app.controllervalidator.UserValidator;
import app.dao.Interfaces.PartnerDao;
import app.dto.GuestDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Getter
@Setter
@NoArgsConstructor
@Controller

public class PartnerController implements ControllerInterface{
    @Autowired
    private PersonValidator personvalidator;
    @Autowired
    private UserValidator uservalidator;
    @Autowired
    private PartnerDao partnerdao;
    @Autowired
    private PartnerService service;
    private static final String MENU = "Ingrese la opcion la accion que desea hacer \n 1..Crear invitado \n 2.. crear factura \n 3. para cerrar sesion";
    
    public void session() throws Exception {
		boolean session = true;
		while (session) {
			session = PartnerSession();
		}

	}
    private boolean PartnerSession() {
		try {
			System.out.println(MENU);
			String option = Utils.getReader().nextLine();
			return menu(option);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return true;
		}
	}
     private boolean menu(String option) throws Exception {
		switch (option) {
		case "1": {
			this.CreateGuest();
			return true;
		}
                case "2":{
                    this.CreateInvoice();
                }
		case "3": {
			System.out.println("se ha cerrado sesion");
			return false;
		}
		default: {
			System.out.println("opcion invalida");
			return true;
		}
		}

	}
     public void CreateGuest() throws Exception{
        System.out.println("ingrese el nombre del Invitado");
		
        String name = Utils.getReader().nextLine();
	personvalidator.ValidName(name);
                
		System.out.println("ingrese la cedula del Invitado");
		long document = personvalidator.ValidDocument(Utils.getReader().nextLine());
                
                System.out.println("ingrese el telefono del Invitado");
                long Cellphone = personvalidator.ValidNumber(Utils.getReader().nextLine());
                
		System.out.println("ingrese el nombre de usuario del Invitado");
		String userName = Utils.getReader().nextLine();
		uservalidator.validUsarName(userName);
                
                System.out.println("ingrese la contraseña del Invitado");
		String password =Utils.getReader().nextLine();
                
		PersonDto personDto = new PersonDto();
		personDto.setName(name);
		personDto.setDocument(document);
		personDto.setCellPhoneNumber(Cellphone);
     
		UserDto userDto = new UserDto();
		userDto.setPersonId(personDto);
		userDto.setUserName(userName);
		userDto.setPassword(password);
		userDto.setRole("Guest");
                
                GuestDto guestDto = new GuestDto();
                guestDto.setUser(userDto);

		this.service.createGuest(guestDto);
     }
     
public void CreateInvoice() throws Exception{
    this.service.createinvoice();
}
    
}
