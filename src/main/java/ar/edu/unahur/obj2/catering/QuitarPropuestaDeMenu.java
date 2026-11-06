package ar.edu.unahur.obj2.catering;

public class QuitarPropuestaDeMenu implements Modificacion{
    private final Menu menu;
    private final Propuesta propuestaAQuitar;

    public QuitarPropuestaDeMenu(Menu menu, Propuesta propuestaAQuitar) {
        this.menu = menu;
        this.propuestaAQuitar = propuestaAQuitar;
    }

    @Override
    public void ejecutar() {
        menu.quitar(propuestaAQuitar);
    }

    @Override
    public void revertir() {
        menu.agregar(propuestaAQuitar);
    }
}
