package ar.edu.unahur.obj2.catering;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

public class GestionTest {
    private Servicio parrillada = new Servicio("Parrillada completa", 240_000.0);
    private Servicio barraTragos = new Servicio("Barra de tragos", 150_000.0);
    private Servicio fotografo = new Servicio("Fotógrafo", 100_000.0);;
    private Servicio mesaEntradas = new Servicio("Mesa de entradas", 80_000.0);
    private Servicio mesaDulce = new Servicio("Mesa dulce", 60_000.0);
    private Menu menuParrillero = new Menu("Menú Parrillero", 10.0, List.of(mesaEntradas, parrillada, mesaDulce));
    private GestorCarta gestor = new GestorCarta();

    @Test
    public void dadaUnaSecuenciaInmediataYReversiones_actualizaYDeshaceCorrectamente() {

        assertEquals(342_000.0, menuParrillero.precio(), 0.01);

        gestor.aplicar(new AgregarPropuestaAMenu(menuParrillero, fotografo));
        assertEquals(432_000.0, menuParrillero.precio(), 0.01);

        gestor.aplicar(new ActualizarPrecioServicio(parrillada, 260_000.0));

        gestor.revertir();
        assertEquals(432_000.0, menuParrillero.precio(), 0.01);

        gestor.revertir();
        assertEquals(342_000.0, menuParrillero.precio(), 0.01);
    }
}
