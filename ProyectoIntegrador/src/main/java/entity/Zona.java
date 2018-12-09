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
    @NamedQuery(name="Zona.findAll",
                query="SELECT e FROM Zona e"),
}) 
@Table(name="tb_zona")
public class Zona {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String zona;
	
	@OneToMany(mappedBy="zona")
	private List<Producto> productos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	

	
	
	

}
