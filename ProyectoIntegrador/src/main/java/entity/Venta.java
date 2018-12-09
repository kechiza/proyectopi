package entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="tb_venta")
public class Venta {

	@Id
	@GeneratedValue
	private Long id;
	
	
	@ManyToOne
	@JoinColumn(name="empleado_id")
	private Empleado empleado;
	
	@Column(name="fecha")
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Column(name="monto_total")
	private double monto_total;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public double getMonto_total() {
		return monto_total;
	}

	public void setMonto_total(double monto_total) {
		this.monto_total = monto_total;
	}
	

	
	
	
	
}
