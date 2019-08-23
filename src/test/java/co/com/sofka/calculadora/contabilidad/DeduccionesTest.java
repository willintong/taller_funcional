package co.com.sofka.calculadora.contabilidad;

import org.junit.Assert;
import org.junit.Test;
import reactor.core.publisher.Mono;

import static org.junit.Assert.*;

public class DeduccionesTest {


    @Test
    public void deduceTest() {
        double value = 100;
        double deduction = 0.04;
        double result = 4;

        Assert.assertEquals(result, Deducciones.deduce(value, deduction), 0);
    }

    @Test
    public void aporteSaludEmpledoTest(){
        double salarioBase = 1000000;
        double aporteSaludEmpleado = 0.04;

        final RespuestaSalario  resultEmpleado = RespuestaSalario.builder()
                .salarioBase(salarioBase)
                .aporteSaludEmpleado(new Double(40000))
                .build();

        Assert.assertEquals(resultEmpleado.getAporteSaludEmpleado(), Deducciones.saludEmpleado(salarioBase,aporteSaludEmpleado),0);
    }

    @Test
    public void aporteSaludEmpledorTest(){
        double salarioBase = 1000000;
        double aporteSaludEmpleador = 0.12;
        final RespuestaSalario  resultEmpleado = RespuestaSalario.builder()
                .salarioBase(salarioBase)
                .aporteSaludEmpleador(new Double(120000))
                .build();

        Assert.assertEquals(resultEmpleado.getAporteSaludEmpleador(), Deducciones.saludEmpleador(salarioBase, aporteSaludEmpleador),0);
    }

    @Test
    public void aportePensionEmpleadoTest() {
        double salarioBase = 1000000;
        double aportePensionEmpleado = 0.04;

        final RespuestaSalario  resultEmpleado = RespuestaSalario.builder()
                .salarioBase(salarioBase)
                .aportePensionEmpleado(new Double(40000))
                .build();

        Assert.assertEquals(resultEmpleado.getAportePensionEmpleado(), Deducciones.pensionEmpleado(salarioBase, aportePensionEmpleado),0);

    }

    @Test
    public void aportePensionEmpleadorTest() {
        double salarioBase = 1000000;
        double aportePensionEmpleado = 0.085;
        final RespuestaSalario  resultEmpleador = RespuestaSalario.builder()
                .salarioBase(salarioBase)
                .aportePensionEmpleador(new Double(85000))
                .build();

        Assert.assertEquals(resultEmpleador.getAportePensionEmpleador(), Deducciones.pensionEmpleador(salarioBase, aportePensionEmpleado),0);

    }

    @Test
    public void resultContabilityTest() {
        double salarioBase = 1000000;
        final RespuestaSalario response = RespuestaSalario.builder()
                        .salarioBase(salarioBase)
                        .aporteCajaDeCompensacion(new Double(40000))
                        .build();

        Assert.assertEquals(response.getAporteCajaDeCompensacion(), Deducciones.calcularSalario(salarioBase).getAporteCajaDeCompensacion(), 0);
    }

}