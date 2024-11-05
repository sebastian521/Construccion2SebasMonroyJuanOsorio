package app.Controller;

import app.controllervalidator.PersonValidator;
import app.controllervalidator.UserValidator;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Getter
@Setter
@NoArgsConstructor
@Controller
public class GuestController implements ControllerInterface {
    @Autowired
    private PersonValidator personavalidator;
    @Autowired
    private UserValidator UserValidator;
    private static final String MENU = "Ingrese la opcion la accion que desea hacer \n 1. para crear factura \n 2. para cerrar sesion";
    
    
    
    
    @Override

    public void session() throws Exception {
		boolean session = true;
		while (session) {
			session = GuestSession();
		}

	}
    private boolean GuestSession() {
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
                    this.CreateInvoice();
			
			return true;
		}
		case "2": {
			System.out.println("se ha cerrado sesion");
			return false;
		}
		default: {
			System.out.println("opcion invalida");
			return true;
		}
		}

	}

        
    private void CreateInvoice() throws Exception {
        
    }
    
    
    


    
}
