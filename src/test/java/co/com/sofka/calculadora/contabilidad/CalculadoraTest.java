package co.com.sofka.calculadora.contabilidad;

import co.com.sofka.calculadora.utils.FuncionesCalculadora;
import org.junit.Assert;
import org.junit.Test;
import reactor.core.publisher.Mono;

public class CalculadoraTest {

    @Test
    public void sumarTest(){
        Integer oneNumber  = 2;
        Integer twoNumber = 3;
        Integer result = 5;

        Assert.assertEquals( result, Mono.just(oneNumber).map( FuncionesCalculadora.sumar(twoNumber)).block() );
    }

    @Test
    public void restarTest(){
        Integer oneNumber  = 5;
        Integer twoNumber = 3;
        Integer result = 2;

        Assert.assertEquals(result, Mono.just(oneNumber).map( FuncionesCalculadora.restar(twoNumber)).block());
    }
}
