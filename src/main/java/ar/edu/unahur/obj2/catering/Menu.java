package ar.edu.unahur.obj2.catering;

import java.util.ArrayList;
import java.util.List;

public class Menu implements Propuesta{
    private final String nombre;
    private final Double descuentoPorcentaje;
    private final List<Propuesta> propuestas;

    public Menu(String nombre, Double descuentoPorcentaje, List<Propuesta> propuestas) {
        if (descuentoPorcentaje < 0 || descuentoPorcentaje > 100) {
            throw new DescuentoInvalidoException("El descuento debe estar entre 0 y 100: " + descuentoPorcentaje);            
        }
        this.nombre = nombre;
        this.descuentoPorcentaje = descuentoPorcentaje;
        this.propuestas = new ArrayList<>(propuestas);
        
    }

    @Override 
    public Double precio(){
        double sumaPrecios = propuestas.stream().mapToDouble(Propuesta::precio).sum();
        double factorDescuento = 1.0 - (descuentoPorcentaje / 100.0);
        return sumaPrecios * factorDescuento;
    }

    @Override
    public String descripcion(){
        return nombre;
    }

    @Override 
    public Integer cantidadDeServicios() {
        return propuestas.stream().mapToInt(Propuesta::cantidadDeServicios).sum();
    }

    @Override
    public boolean incluye(String nombreServicio) {
        return propuestas.stream().anyMatch(p -> p.incluye(nombreServicio));
    }

    public void agregar(Propuesta propuesta) {
        propuestas.add(propuesta);
    }

    public void quitar(Propuesta propuesta) {
        if (!propuestas.contains(propuesta)) {
            throw new PropuestaNoIncluidaException("La propuesta no se encuntra en este menu.");
        }
        propuestas.remove(propuesta);
    }
}
