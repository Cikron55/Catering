package ar.edu.unahur.obj2.catering;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ServicioTest {

    private Servicio mesaEntradas = new Servicio("Mesa de entradas", 80_000.0);
    private Servicio parrillada = new Servicio("Parrillada completa", 240_000.0);
    private Servicio mesaDulce = new Servicio("Mesa dulce", 60_000.0);
    private Menu menuParrillero = new Menu("Menú Parrillero", 10.0, List.of(mesaEntradas, parrillada, mesaDulce));


    @Test 
    public void dadoUnServicioConPrecioNegativo_alCrearlo_lanzaPrecioNegativoException() {
        assertThrows(PrecioNegativoException.class, () -> {new Servicio("Servicio invalido", -500_000.0);});
    }

    @Test 
    public void dadoUnMenuConDescuentoInvalido_alCrearlo_lanzaDescuentoInvalidoException(){
        assertThrows(DescuentoInvalidoException.class, () -> {new Menu("Menu invalido", 150.0, List.of(mesaEntradas));});
    }

    @Test 
    public void dadoUnMenuParrillero_alConsultarCantidadDeServiciosEInclusion_devuelveLosValoresQueSeEsperan(){
        assertEquals(3, menuParrillero.cantidadDeServicios());
        assertTrue(menuParrillero.incluye("Parrillada completa"));
        assertFalse(menuParrillero.incluye("DJ y sonido"));
    }
}
