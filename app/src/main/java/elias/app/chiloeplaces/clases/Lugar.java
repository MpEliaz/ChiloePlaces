package elias.app.chiloeplaces.clases;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * Created by Elias on 15-01-15.
 */
public class Lugar extends JSONBean {

    @JsonProperty
    private int id;
    @JsonProperty
    private String nombre;
    @JsonProperty
    private String direccion;
    @JsonProperty
    private String telefono;
    @JsonProperty
    private String comuna;
    @JsonProperty
    private String descripcion;
    @JsonProperty
    private String creado_por;
    @JsonProperty
    private String fecha;
    @JsonProperty
    private Boolean estado;
    @JsonProperty
    private String portada;
    @JsonProperty
    private ArrayList<Imagen> imagenes;

    public Lugar() {
    }

    public Lugar(int id, String nombre, String direccion, String telefono, String comuna, String descripcion, String creado_por, String fecha, Boolean estado, String portada) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.comuna = comuna;
        this.descripcion = descripcion;
        this.creado_por = creado_por;
        this.fecha = fecha;
        this.estado = estado;
        this.portada = portada;
        procesa
    }

    //<editor-fold desc="GETTERS">
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getComuna() {
        return comuna;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCreado_por() {
        return creado_por;
    }

    public String getFecha() {
        return fecha;
    }

    public Boolean getEstado() {
        return estado;
    }

    public String getPortada() {
        return portada;
    }

    public ArrayList<Imagen> getImagenes() {
        return imagenes;
    }
    //</editor-fold>

    public void setId(int id) {

        int oldval = this.id;
        this.id = id;
        support.firePropertyChange("id", oldval, id);
    }

    public void setNombre(String nombre) {

        String oldVal = this.nombre;
        this.nombre = nombre;
        support.firePropertyChange("nombre", oldVal, nombre);
    }

    public void setDireccion(String direccion) {

        String oldVal = this.direccion;
        this.direccion = direccion;
        support.firePropertyChange("direccion", oldVal, direccion);
    }

    public void setTelefono(String telefono) {

        String oldVal = this.telefono;
        this.telefono = telefono;
        support.firePropertyChange("telefono", oldVal, telefono);
    }

    public void setComuna(String comuna) {

        String oldVal = this.comuna;
        this.comuna = comuna;
        support.firePropertyChange("comuna", oldVal, comuna);
    }

    public void setDescripcion(String descripcion) {

        String oldVal = this.descripcion;
        this.descripcion = descripcion;
        support.firePropertyChange("descripcion", oldVal, descripcion);
    }

    public void setCreado_por(String creado_por) {

        String oldVal = this.creado_por;
        this.creado_por = creado_por;
        support.firePropertyChange("creado_por", oldVal, creado_por);
    }

    public void setFecha(String fecha) {

        String oldVal = this.fecha;
        this.fecha = fecha;
        support.firePropertyChange("fecha", oldVal, fecha);
    }

    public void setEstado(Boolean estado) {

        Boolean oldVal = this.estado;
        this.estado = estado;
        support.firePropertyChange("estado", oldVal, estado);
    }

    public void setPortada(String portada) {

        String oldVal = this.portada;
        this.portada = portada;
        support.firePropertyChange("portada", oldVal, portada);
    }

    public void setImagenes(ArrayList<Imagen> imagenes) {

        ArrayList<Imagen> oldVal = this.imagenes;
        this.imagenes = imagenes;
        support.firePropertyChange("imagenes", oldVal, imagenes);
    }

    //<editor-fold desc="EQUALS AND HASH">
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lugar)) return false;

        Lugar lugar = (Lugar) o;

        if (comuna != null ? !comuna.equals(lugar.comuna) : lugar.comuna != null) return false;
        if (creado_por != null ? !creado_por.equals(lugar.creado_por) : lugar.creado_por != null)
            return false;
        if (descripcion != null ? !descripcion.equals(lugar.descripcion) : lugar.descripcion != null)
            return false;
        if (direccion != null ? !direccion.equals(lugar.direccion) : lugar.direccion != null)
            return false;
        if (estado != null ? !estado.equals(lugar.estado) : lugar.estado != null) return false;
        if (fecha != null ? !fecha.equals(lugar.fecha) : lugar.fecha != null) return false;
        if (imagenes != null ? !imagenes.equals(lugar.imagenes) : lugar.imagenes != null)
            return false;
        if (nombre != null ? !nombre.equals(lugar.nombre) : lugar.nombre != null) return false;
        if (portada != null ? !portada.equals(lugar.portada) : lugar.portada != null) return false;
        if (telefono != null ? !telefono.equals(lugar.telefono) : lugar.telefono != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + (direccion != null ? direccion.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (comuna != null ? comuna.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (creado_por != null ? creado_por.hashCode() : 0);
        result = 31 * result + (fecha != null ? fecha.hashCode() : 0);
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (portada != null ? portada.hashCode() : 0);
        result = 31 * result + (imagenes != null ? imagenes.hashCode() : 0);
        return result;
    }
    //</editor-fold>
}
