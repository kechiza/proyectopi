package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQueries({
    @NamedQuery(name="Producto.findAll",
                query="SELECT e FROM Producto e"),
}) 
@Table(name="tb_producto")
public class Producto {
	
	
	@Id
	@GeneratedValue
	private Long id;

	private String nombre;
	
	private int codigo;
			

	private double precio;

	private int stock;
	
	private int iva;
	
	private double peso;
	
	
	
	@ManyToOne
	@JoinColumn(name="id_presentacion")
	private Presentacion presentacion;
	
	@ManyToOne
	@JoinColumn(name="id_marca")
	private Marca marca;
	
	@ManyToOne
	@JoinColumn(name="id_proveedor")
	private Proveedor proveedor;
	
	@ManyToOne
	@JoinColumn(name="id_zona")
	private Zona zona;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Presentacion getPresentacion() {
		return presentacion;
	}

	public void setPresentacion(Presentacion presentacion) {
		this.presentacion = presentacion;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Zona getZona() {
		return zona;
	}

	public void setZona(Zona zona) {
		this.zona = zona;
	}

	
	

	
	
	

}
