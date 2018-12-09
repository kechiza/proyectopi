package jsf;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import entity.Empleado;
import entity.Marca;
import entity.Producto;
import managedbean.MarcaMB;
import managedbean.EmpleadoMB;



@ManagedBean(name = "marcaJSF")
@SessionScoped
public class MarcaController {
	
	private String id;
	private String marca;
	
	private Marca marcaModel;

	private List<Marca> lstMarca;
	FacesContext contexto = null;

	public MarcaController() {
		
	}
	
	
	public String initPantalla() {
		MarcaMB marcaMB = new MarcaMB();
		lstMarca = marcaMB.listaMarca();
		marcaModel = new Marca();
		
		return eventoLimpiarFormulario();
	}

	public String eventoRegistrarMarca() {

		System.out.println("Nombre: " + marca);


		Marca objMarca = new Marca();
		objMarca.setMarca(marca);


		MarcaMB marcaMB = new MarcaMB();
		marcaMB.insertar(objMarca);
		
		lstMarca = marcaMB.listaMarca();
		return "listadoMarca";
	}

	public String eventoLimpiarFormulario() {
		marca = "";


		return "registrarMarca";
	}
	
	public String eventoLimpiarFormularioActualizar() {
		marca = "";


		return "actualizarMarca";
	}

	public String eventoEliminarMarca() {
		
		System.out.println("id Marca:" + this.getId());
		
		//vamos a eliminar 
		
		if(this.getId()!= null) {
			MarcaMB marcaMB = new MarcaMB();
			marcaMB.eliminar(Long.valueOf(this.getId()));
			
			lstMarca = marcaMB.listaMarca();
		}
		

		return "listadoMarca";
	}
	
	public void eventoIrActualizar() throws IOException {
		if(this.getId()!= null) {
			MarcaMB marcaMB = new MarcaMB();
			Marca objMarca = marcaMB.buscar(Long.valueOf(this.getId()));
			
			id = objMarca.getId()+"";			
			marca = objMarca.getMarca();

		}

		FacesContext.getCurrentInstance().getExternalContext().redirect("actualizarMarca.xhtml");
		
	}
	
	public void eventoListarMarca() throws IOException{
		FacesContext.getCurrentInstance().getExternalContext().redirect("listadoMarca.xhtml");
	}
	
	public String eventoActualizarMarca() {

		System.out.println("Nombre: " + marca);


		Marca objMarca = new Marca();
		objMarca.setId(Long.parseLong(id));
		objMarca.setMarca(marca);


		MarcaMB marcaMB = new MarcaMB();
		marcaMB.actualizar(objMarca);
		
		lstMarca = marcaMB.listaMarca();
		return "listadoMarca";
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public Marca getMarcaModel() {
		return marcaModel;
	}


	public void setMarcaModel(Marca marcaModel) {
		this.marcaModel = marcaModel;
	}


	public List<Marca> getLstMarca() {
		return lstMarca;
	}


	public void setLstMarca(List<Marca> lstMarca) {
		this.lstMarca = lstMarca;
	}

	
}



