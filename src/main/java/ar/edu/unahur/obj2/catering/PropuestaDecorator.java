package ar.edu.unahur.obj2.catering;

public abstract class PropuestaDecorator implements Propuesta{
    protected final Propuesta propuestaDecorada;

    public PropuestaDecorator(Propuesta propuestaDecorada){
        this.propuestaDecorada = propuestaDecorada;
    }

    @Override 
    public Integer cantidadDeServicios(){
        return propuestaDecorada.cantidadDeServicios();
    }

    @Override 
    public boolean incluye(String nombreDeServicio){
        return propuestaDecorada.incluye(nombreDeServicio);
    }
}
