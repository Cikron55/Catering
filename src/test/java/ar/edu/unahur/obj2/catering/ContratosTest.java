package ar.edu.unahur.obj2.catering;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ContratosTest {

    private Servicio mesaEntradas = new Servicio("Mesa de entradas", 80_000.0);
    private Servicio parrillada = new Servicio("Parrillada completa", 240_000.0);
    private Servicio mesaDulce = new Servicio("Mesa dulce", 60_000.0);
    private Servicio brindis = new Servicio("Brindis de bienvenida", 50_000.0);
    private Menu menuParrillero = new Menu("Menú Parrillero", 10.0, List.of(mesaEntradas, parrillada, mesaDulce));

    @Test 
    public void dadoUnMenuConMozosYNocturno_elOrdenAlteraElPrecioYDescripcion(){
        Propuesta propuesta1 = new AdicionalPorcentual(new AdicionalMontoFijo(menuParrillero, "Mozos adicionales", 18_000.0), "Servicio nocturno", 20.0);

        assertEquals(432_000.0, propuesta1.precio(), 0.01);
        assertEquals("Menú Parrillero + Mozos adicionales + Servicio nocturno", propuesta1.descripcion());

        Propuesta propuesta2 = new AdicionalMontoFijo(new AdicionalPorcentual(menuParrillero, "Servicio nocturno", 20.0),"Mozos adicionales", 18_000.0);
        assertEquals(428_400.0, propuesta2.precio(), 0.01);
        assertEquals("Menú Parrillero + Servicio nocturno + Mozos adicionales", propuesta2.descripcion());
    }

    @Test
    public void dadoUnAdicionalRepetido_calculaElPrecioAcumuladoCorrectamente() {
        Propuesta brindisDobleVajilla = new AdicionalMontoFijo(new AdicionalMontoFijo(brindis, "Vajilla premium", 12_000.0),"Vajilla premium", 12_000.0);

        assertEquals(74_000.0, brindisDobleVajilla.precio(), 0.01);
        assertEquals("Brindis de bienvenida + Vajilla premium + Vajilla premium", brindisDobleVajilla.descripcion());
    }

    @Test
    public void dadaUnaPropuestaDecorada_laOriginalNoCambia() {
        Propuesta menuConMozos = new AdicionalMontoFijo(menuParrillero, "Mozos adicionales", 18_000.0);
        
        assertEquals(342_000.0, menuParrillero.precio(), 0.01);
        assertEquals("Menú Parrillero", menuParrillero.descripcion());
        
        assertEquals(360_000.0, menuConMozos.precio(), 0.01);
    }

    @Test
    public void dadoUnContratoCreado_fijaElImporteYDescripcionDelMomento() {
        Propuesta menuConMozos = new AdicionalMontoFijo(menuParrillero, "Mozos adicionales", 18_000.0);
        Contrato contrato = new Contrato("Briana", menuConMozos);

        assertEquals("Briana", contrato.getNombreCliente());
        assertEquals(360_000.0, contrato.getImporteFijado(), 0.01);
        assertEquals("Menú Parrillero + Mozos adicionales", contrato.getdescripcionFijada());
    }
}
