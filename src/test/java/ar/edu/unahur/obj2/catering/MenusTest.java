package ar.edu.unahur.obj2.catering;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

public class MenusTest {

    private Servicio mesaEntradas = new Servicio("Mesa de entradas", 80_000.0);
    private Servicio parrillada = new Servicio("Parrillada completa", 240_000.0);
    private Servicio mesaDulce = new Servicio("Mesa dulce", 60_000.0);    
    private Servicio barraTragos = new Servicio("Barra de tragos", 150_000.0);
    private Servicio dj = new Servicio("DJ y sonido", 120_000.0);
    private Servicio brindis = new Servicio("Brindis de bienvenida", 50_000.0);

    private Menu menuParrillero = new Menu("Menú Parrillero", 10.0, List.of(mesaEntradas, parrillada, mesaDulce));
    private Menu packFiesta = new Menu("Pack Fiesta", 5.0, List.of(barraTragos, dj));
    private Menu eventoCompleto = new Menu("Evento Completo", 20.0, List.of(menuParrillero, packFiesta, brindis));

    @Test 
    public void dadoUnMenuQueContieneOtrosMenus_alCalcularSuPrecioYServicios_funcionaRecursivamente(){
        assertEquals(518_800.0, eventoCompleto.precio(), 0.01);
        assertEquals(6, eventoCompleto.cantidadDeServicios());

        assertTrue(menuParrillero.incluye("Parrillada completa"));
        assertTrue(packFiesta.incluye("DJ y sonido"));

        assertFalse(eventoCompleto.incluye("Fotografo"));
        assertFalse(eventoCompleto.incluye("Sushi Bar"));
    }
}
