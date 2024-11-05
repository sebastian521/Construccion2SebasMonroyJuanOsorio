package app.controllervalidator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
@Getter
@Setter
@NoArgsConstructor


    public class InvoiceValidator extends CommonsValidator {
        

    public double validAmount(String amount) throws Exception{
        return super.isValidDouble("Cantidad De La Factura", amount);
    }    
    public boolean validArticle(String status) throws Exception{
        return super.isValueBoolean("Estado De La factura ", status);
    }
}
