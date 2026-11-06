package ar.edu.unahur.obj2.catering;

public class AdicionalMontoFijo extends PropuestaDecorator{
    private final String nombreAdicional;
    private final Double montoAdicional;

    public AdicionalMontoFijo(Propuesta propuestaDecorada, String nombreAdicional, Double montoAdicional) {
        super(propuestaDecorada);
        this.nombreAdicional = nombreAdicional;
        this.montoAdicional = montoAdicional;
    }

    @Override
    public Double precio() {
        return propuestaDecorada.precio() + montoAdicional;
    }

    @Override
    public String descripcion() {
        return propuestaDecorada.descripcion() + " + " + nombreAdicional;
    }
}
