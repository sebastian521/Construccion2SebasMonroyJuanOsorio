package app.controllervalidator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
public class GuestValidator extends CommonsValidator{
    
    
    public boolean validStatus(String status) throws Exception{
        return super.isValueBoolean("El Estado De La Factura", status);
    }
}
