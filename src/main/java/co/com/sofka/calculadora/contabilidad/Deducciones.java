package co.com.sofka.calculadora.contabilidad;


import java.util.function.Function;
import java.util.stream.Stream;
public class Deducciones {

    final static double CAJA_COMPENSACION = 0.04;

    public static Function<Double, Double> deduceCajaDeCompensacion() {
        return value -> value * CAJA_COMPENSACION;
    }

    public static Function<RespuestaSalario, RespuestaSalario> deduceAll() {
        return r -> r.toBuilder()
                .aporteCajaDeCompensacion(deduce(r.getSalarioBase(), CAJA_COMPENSACION))
                .build();
    }

    public static double deduce(double value, double deduction) {
        return value * deduction;
    }

    public static RespuestaSalario calcularSalario(Double salarioBase) {

        return Stream.of(RespuestaSalario.builder()
                .salarioBase(salarioBase)
                .build()).map(Deducciones.deduceAll()).reduce(RespuestaSalario.builder().build(), (r1, r2) -> r2);

    }
    public static double saludEmpleado(double salarioBase, double aporteSaludEmpleado) {
        return salarioBase * aporteSaludEmpleado;
    }

    public static double saludEmpleador(double salarioBase, double aporteSaludEmpleador) {
        return salarioBase * aporteSaludEmpleador;
    }

    public static double pensionEmpleado(double salarioBase, double aportePensionEmpleado) {
        return salarioBase * aportePensionEmpleado;
    }

    public static double pensionEmpleador(double salarioBase, double aportePensionEmpleador) {
        return salarioBase * aportePensionEmpleador;
    }


}
