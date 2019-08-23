package co.com.sofka.calculadora.controller;

import co.com.sofka.calculadora.utils.Amortizacion;
import co.com.sofka.calculadora.utils.FuncionesCalculadora;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


import java.util.Arrays;
import java.util.List;

import static co.com.sofka.calculadora.utils.FuncionesCalculadora.*;

@RestController
@RequestMapping(value = "/calculadora")
@RequiredArgsConstructor
public class CaluladoraServices {

    @GetMapping(value = "/suma")
    public Mono<Integer> sumaDosNumeros (Integer a, Integer b) {
        return Mono.just(a).map(FuncionesCalculadora.sumar(b));
    }

    @GetMapping(value = "/resta")
    public Mono<Integer> restaDosNumeros (Integer a, Integer b) {
        return Mono.just(a).map(FuncionesCalculadora.restar(b));
    }

    @GetMapping(value = "/multiplicacion")
    public Mono<String> tablaMultiplicar (Integer multiplicando) {
        return Mono.just(multiplicando).flatMap(multiplicar);
    }

    @GetMapping(value = "/amortizacion")
    public Mono<List<Amortizacion>> tablaAmortizacion (Integer numberOfFees, Integer creditAmount) {
        return Mono.just(Arrays.asList(numberOfFees, creditAmount)).flatMap(amortizar);
    }




}
