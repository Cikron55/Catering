package ar.edu.unahur.obj2.catering;
public class Servicio implements Propuesta{

    private final String nombre;
    private Double precio;

    public Servicio(String nombre, Double precio) {
        if (precio < 0) {
            throw new PrecioNegativoException("El precio no puede ser negativo: " + precio);            
        }
        this.nombre = nombre;
        this.precio = precio;
        
    }

    @Override
    public Double precio() {
        return precio;
    }

    @Override
    public String descripcion() {
        return nombre;
    }

    @Override
    public Integer cantidadDeServicios() {
        return 1;
    }

    @Override
    public boolean incluye(String nombreServicio) {
        return this.nombre.equals(nombreServicio);
    }
}
