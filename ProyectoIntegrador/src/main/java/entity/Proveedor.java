package entity;


import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@NamedQueries({
    @NamedQuery(name="Proveedor.findAll",
                query="SELECT e FROM Proveedor e"),
}) 
@Table(name="tb_proveedor")
public class Proveedor {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String proveedor;
	
	
	@OneToMany(mappedBy="proveedor")
	private List<Producto> productos;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getProveedor() {
		return proveedor;
	}


	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}


	public List<Producto> getProductos() {
		return productos;
	}


	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	
	
	
	

}
