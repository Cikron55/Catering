package ar.edu.unahur.obj2.catering;

import java.util.ArrayDeque;
import java.util.Deque;

public class GestorCarta {

    private final Deque<Modificacion> historial = new ArrayDeque<>();

    public void aplicar(Modificacion mod) {
        mod.ejecutar();
        historial.push(mod);
    }

    public void revertir() {
        if (historial.isEmpty()) {
            throw new NadaParaRevertirException("No hay modificaciones para revertir en el historial.");
        }
        Modificacion ultima = historial.pop();
        ultima.revertir();
    }
}
