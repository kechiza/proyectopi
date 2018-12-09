package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_venta_producto")
public class Venta_Producto {
	
	
	@Id
	@GeneratedValue
	private Long id;

	//@ManyToOne(fetch=FetchType.LAZY)
	@ManyToOne
	@JoinColumn(name="venta_id")
	private Venta venta;
	
	@ManyToOne
	@JoinColumn(name="producto_id")
	private Producto producto;
	
	
	
	private int cantidad;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
	


}
