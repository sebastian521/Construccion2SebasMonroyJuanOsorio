package app.controllervalidator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
public class PersonValidator extends CommonsValidator{
    
    public void ValidName(String name) throws Exception{
        super.isValidString("nombre de la persona", name);
    }
    public long ValidDocument(String Document) throws Exception{
        return super.isValidLong("Documento de la persona",Document);
    }
    public int ValidNumber(String Cellphone) throws Exception{
        return super.isValidInteger("El numero de celular de la persona es",Cellphone);
    }
}
