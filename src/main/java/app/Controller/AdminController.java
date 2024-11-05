
package app.Controller;
import app.controllervalidator.PersonValidator;
import app.controllervalidator.UserValidator;
import app.Service.ServiceClub;
import app.ServiceInterface.AdminService;
import app.dto.PartnerDto;
import app.dto.PersonDto;
import app.dto.UserDto;
import java.sql.Timestamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Getter
@Setter
@NoArgsConstructor
@Controller
public class AdminController  implements ControllerInterface{
    @Autowired
    private PersonValidator personaValidator;
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private AdminService service;
    private static final String MENU = "ingrese la opcion /n 1. Crear socio /2. para cerrar sesion /n";
    
  

    @Override
    public void session() throws Exception{
        boolean session = true;
        while (session){
            session = menu();
        }
    }
    private boolean menu(){
        try{
            System.out.println("Bienvenido " + ServiceClub.user.getUserName());
            System.out.println(MENU);
            String option = Utils.getReader().nextLine();
            return options(option);
            
        }catch (Exception e){
            System.out.println(e.getMessage());
            return true;
        }
    }
    private boolean options (String option) throws Exception{
        switch (option){
            case "1" -> {
                this.createPartner();
                return true;
            }
            case "2" -> {
                System.out.println("se ha cerrado sesion");
                return false;
            }
                
  
            default -> {
                System.out.println("ingrese una opcion que sea valida");
            }
            
                
            }
        return true;
        
        
    }
    
        
    
   private void createPartner() throws Exception {
       System.out.println("ingrese el nombre del socio");
        
       String name = Utils.getReader().nextLine();
        personaValidator.ValidName(name);
        
        System.out.println("ingrese el documento del socio");
        long cedula = personaValidator.ValidDocument(Utils.getReader().nextLine());
        
        System.out.println("Ingrese el nombre usuario del socio");
        String userName = Utils.getReader().nextLine();
        userValidator.validUsarName(userName);
        
        System.out.println("ingrese la contraseña del socio");
        String password = Utils.getReader().nextLine();
        
        PersonDto personDto = new PersonDto();
        personDto.setName(name);
        personDto.setDocument(cedula);
        personDto.setCellPhoneNumber(cedula);
        
        UserDto userDto = new UserDto();
        userDto.setPersonId(personDto);
        userDto.setUserName(userName);
        userDto.setPassword(password);
        userDto.setRole("partner");
        
        PartnerDto partnerDto = new PartnerDto();
        partnerDto.setUserId(userDto);
        partnerDto.setDatecreated(new Timestamp(System.currentTimeMillis()));
        partnerDto.setMoney(50000);
        partnerDto.setType("regular");
        partnerDto.setUserId(userDto);
        
        this.service.CreatePartner(partnerDto);
        System.out.println("se ha creado el usuario exitosamente");
        
        
    
    }
    


}
