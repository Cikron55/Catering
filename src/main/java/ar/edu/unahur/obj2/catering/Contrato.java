package ar.edu.unahur.obj2.catering;

public class Contrato {
    private final String nombreCliente;
    private final Double importeFijado;
    private final String descripcionFijada;

    public Contrato(String nombreCliente, Propuesta propuestaContratada) {
        this.nombreCliente = nombreCliente;
        this.importeFijado = propuestaContratada.precio();
        this.descripcionFijada = propuestaContratada.descripcion();
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public Double getImporteFijado() {
        return importeFijado;
        
    }

    public String getdescripcionFijada() {
        return descripcionFijada;
    }
}
