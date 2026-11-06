package ar.edu.unahur.obj2.catering;

public class AdicionalPorcentual extends PropuestaDecorator{
    private final String nombreAdicional;
    private final Double porcentaje;

    public AdicionalPorcentual(Propuesta propuestaDecorada, String nombreAdicional, Double porcentaje){
        super(propuestaDecorada);
        this.nombreAdicional = nombreAdicional;
        this.porcentaje = porcentaje;
    }

    @Override
    public Double precio() {
        return propuestaDecorada.precio() * (1.0 + (porcentaje / 100.0));
    }

    @Override
    public String descripcion() {
        return propuestaDecorada.descripcion() + " + " + nombreAdicional;
    }
}
