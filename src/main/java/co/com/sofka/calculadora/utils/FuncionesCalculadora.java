package co.com.sofka.calculadora.utils;

import reactor.core.publisher.Mono;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;


public class FuncionesCalculadora {


    public static Function<Integer, Mono<String>> multiplicar = multiplicando -> {
        List<String> list = new ArrayList<>();
        IntStream.rangeClosed(0, 10).forEach(
                multiplicador -> list.add(multiplicando  + "X" +  multiplicador  + "=" +  multiplicando * multiplicador +"<p>" ));
        return Mono.just(list.toString());
    };

    public static Function<Integer, Integer> sumar(Integer twoNumber) {
        return number -> number + twoNumber;
    }


    public static Function<Integer, Integer> restar(int twoNumber) {
        return number -> number - twoNumber;
    }

    public static Function<List<Integer>, Mono<List<Amortizacion>>> amortizar = lista -> {
        final Integer numberOfFees = lista.get(0);
        final Integer creditAmount = lista.get(1);
        final Double INTERES = 0.01;
        final Double amortizacionDelCapital = (double) creditAmount / numberOfFees;
        List<Amortizacion> tablaPrestamo = new ArrayList<>(lista.get(0));
        IntStream.rangeClosed(1, numberOfFees).forEach(
                periodos -> tablaPrestamo.add(Amortizacion.builder()
                        .periodo(periodos)
                        .interes(creditAmount * INTERES)
                        .amortizacionCapital(amortizacionDelCapital)
                        .cuota(INTERES * creditAmount + amortizacionDelCapital)
                        .capitalPendiente(creditAmount - amortizacionDelCapital * periodos).build()));
        return Mono.just(tablaPrestamo);
    };

    public static Function<Integer, Mono<PagoNeto>> saldoNeto = sueldo -> {
        final double salarioBase = sueldo;
        final double interesSaludEmpleado = 0.04;
        final double interesSaludEmpleador = 0.12;
        final double interesPensionEmpleador = 0.085;
        final double interesPensionEmpleado = 0.04;
        final double riesgoLaborales = 0.005;
        final double cajaCompensacion = 0.04;
        final double pagoNetoEmpleado = salarioBase - (salarioBase * (interesSaludEmpleado + interesPensionEmpleado));
        final double pagoDelEmpleado = ((salarioBase * interesPensionEmpleado) + (salarioBase * interesSaludEmpleado));
        final double pagoDelEmpleador  = (salarioBase * (interesSaludEmpleador + interesPensionEmpleador + riesgoLaborales + cajaCompensacion));
        final Integer salarioMinimo = (4 * 828116);
        final double aporteFSP = salarioBase >= salarioMinimo ? 0.01 : 0.00;

        return Mono.just(PagoNeto.builder()
                 .salarioBase(salarioBase)
                 .interesSaludEmpleado(interesSaludEmpleado)
                 .interesSaludEmpleador(interesSaludEmpleador)
                 .interesPensionEmpleado(interesPensionEmpleado)
                 .riesgoLaborales(riesgoLaborales)
                 .aporteFSP(aporteFSP)
                 .cajaCompensacion(cajaCompensacion)
                 .interesPensionEmpleador(interesPensionEmpleador)
                 .pagoFinalEmpleado(pagoNetoEmpleado)
                 .costoEmpleado(pagoDelEmpleado)
                 .costoEmpleador(pagoDelEmpleador).build());

    };
}
