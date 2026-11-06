package ar.edu.unahur.obj2.catering;

public class AgregarPropuestaAMenu implements Modificacion{
    private final Menu menu;
    private final Propuesta propuestaAAgregar;

    public AgregarPropuestaAMenu(Menu menu, Propuesta propuestaAAgregar) {
        this.menu = menu;
        this.propuestaAAgregar = propuestaAAgregar;
    }

    @Override
    public void ejecutar() {
        menu.agregar(propuestaAAgregar);
    }

    @Override
    public void revertir() {
        menu.quitar(propuestaAAgregar);
    }
}
