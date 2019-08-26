package co.com.sofka.calculadora.utils;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder (toBuilder = true)
public class PagoNeto {
    public Double salarioBase;
    public double interesSaludEmpleado;
    public double interesSaludEmpleador;
    public double interesPensionEmpleado;
    public double interesPensionEmpleador;
    public double riesgoLaborales;
    public double cajaCompensacion;
    public double aporteFSP;

    public  double pagoFinalEmpleado;
    public double costoEmpleado;
    public double costoEmpleador;
}
