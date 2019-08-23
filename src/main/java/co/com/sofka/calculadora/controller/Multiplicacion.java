package co.com.sofka.calculadora.controller;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class Multiplicacion {
    private Integer multiplicador;
    private Integer multiplicando;
    private Integer result;
}
