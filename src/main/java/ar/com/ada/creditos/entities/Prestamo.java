package ar.com.ada.creditos.entities;

import java.util.*;
import java.math.*;
import javax.persistence.*;

@Entity
@Table(name = "prestamo")

public class Prestamo {
    @Id
    @Column(name = "prestamo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int prestamoId;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    private BigDecimal importe;

    private int cuotas;

    @Column(name = "fecha_alta")
    private Date fechaAlta;

    @ManyToOne // los JoinColumn van donde esta presente la fk
    @JoinColumn(name = "cliente_id", referencedColumnName = "cliente_id")
    private Cliente cliente;

    public int getPrestamoId() {
        return prestamoId;
    }

    public void setPrestamoId(int prestamoId) {
        this.prestamoId = prestamoId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public int getCuotas() {
        return cuotas;
    }

    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        this.cliente.getPrestamos().add(this); // relacion bidireccional
    }

}
// otra manera de plantearlo es haciendo un metodo agregarPrestamo
// para que sea mas legible
// public void agregarPrestamo(Prestamo prestamo){
// this.prestamos.add(prestamo);
// }
// y cambiar el set a:
// public void setCliente(Cliente cliente){
// this.cliente = cliente;
// this.cliente.agregarPrestamo(this);
// }