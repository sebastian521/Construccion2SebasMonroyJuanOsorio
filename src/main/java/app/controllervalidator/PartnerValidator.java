package app.controllervalidator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
public class PartnerValidator extends CommonsValidator{
    public double validMoney(String money) throws Exception{
        return super.isValidDouble("La Cantidad De La Factura", money);
        }
    
    public void validType(String type) throws Exception{
        super.isValidString("El Tipo De Suscripción", type);
    }
}
