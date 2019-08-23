package co.com.sofka.calculadora.utils;

import reactor.core.publisher.Mono;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.IntStream;


public class FuncionesCalculadora {


    public static Function<Integer, Mono<String>> multiplicar = multiplicando -> {
        List<Integer> list = new ArrayList<>();
        int[] calculadora = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : calculadora) {
            int multiplica = multiplicando * i;
            list.add(multiplica);
        }
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

}
