package co.com.sofka.calculadora.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class Amortizacion {
    private Integer periodo;
    private Double interes;
    private Double amortizacionCapital;
    private Double cuota;
    private Double capitalPendiente;

}
