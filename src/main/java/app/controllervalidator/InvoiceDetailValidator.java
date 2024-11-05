package app.controllervalidator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
public class InvoiceDetailValidator extends CommonsValidator {
    
    public int validItem(String item) throws Exception{
        return super.isValidInteger("el Item ",item);
    }
    public void validDescription(String description) throws Exception{
        super.isValidString("Descripción De La Factura", description);
    }
    public double validAmount(String amount) throws Exception{
        return super.isValidDouble("Cantidad De La Factura", amount);
    }
}


