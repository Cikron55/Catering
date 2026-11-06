package ar.edu.unahur.obj2.catering;

public class ActualizarPrecioServicio implements  Modificacion{
    private final Servicio servicio;
    private final Double nuevoPrecio;
    private Double precioAnterior;

    public ActualizarPrecioServicio(Servicio servicio, Double nuevoPrecio) {
        this.servicio = servicio;
        this.nuevoPrecio = nuevoPrecio;
    }

    @Override
    public void ejecutar() {
        if (nuevoPrecio < 0) {
            throw new PrecioNegativoException("Precio negativo inválido: " + nuevoPrecio);
        }
        this.precioAnterior = servicio.precio();
        servicio.actualizarPrecio(nuevoPrecio);
    }

    @Override
    public void revertir() {
        servicio.actualizarPrecio(precioAnterior);
    }
}
