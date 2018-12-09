package entity;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
    @NamedQuery(name="Presentacion.findAll",
                query="SELECT e FROM Presentacion e"),
}) 
@Table(name="tb_presentacion")
public class Presentacion {
	
	
		@Id
		@GeneratedValue
		private Long id;
		
		private String presentacion;
		
		@OneToMany(mappedBy="presentacion")
		private List<Producto> productos;
		

		public List<Producto> getProductos() {
			return productos;
		}
		public void setProductos(List<Producto> productos) {
			this.productos = productos;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getPresentacion() {
			return presentacion;
		}
		public void setPresentacion(String presentacion) {
			this.presentacion = presentacion;
		}

		
		
		
		

		
	


}
