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

import entity.Presentacion;
import entity.Empleado;
import entity.Marca;
import entity.Producto;
import entity.Proveedor;
import entity.Zona;
import managedbean.CategoriaMB;
import managedbean.EmpleadoMB;
import managedbean.ProductoMB;


@ManagedBean(name = "productoJSF")
@SessionScoped
public class ProductoController implements Serializable{
	
	private String id;
	private String nombre;
	private String idpresentacion;
	private String idmarca;
	private String idproveedor;
	private String idzona;
	private String codigo;
	private String precio;
	private String stock;
	private String iva;
	private String peso;
	
	private Presentacion presentacion;	
	private Marca marca;
	private Proveedor proveedor;
	private Zona zona;
	
	

	public Presentacion getPresentacion() {
		return presentacion;
	}


	public void setPresentacion(Presentacion presentacion) {
		this.presentacion = presentacion;
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


	public Marca getMarca() {
		return marca;
	}


	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	
	

	private Producto productoModel;

	private List<Producto> lstProducto;
	FacesContext contexto = null;

	public ProductoController() {
		
	}
	
	
	public String initPantalla() {
		ProductoMB productoMB = new ProductoMB();
		lstProducto = productoMB.listaProducto();
		productoModel = new Producto();
		
		return eventoLimpiarFormulario();
	}

	public String eventoRegistrarProducto() {

		System.out.println("Nombre: " + nombre);
		System.out.println("Presentacion: " + idpresentacion);
		System.out.println("Marca: " + idmarca);
		System.out.println("Proveedor: " + idproveedor);
		System.out.println("Zona: " + idzona);
		System.out.println("Codigo: " + codigo);
		System.out.println("Precio: " + precio);
		System.out.println("Stock: " + stock);
		System.out.println("Iva: " + iva);
		System.out.println("Peso: " + peso);
	

		Producto objProducto = new Producto();
		objProducto.setNombre(nombre);
		
		Presentacion objCate=new Presentacion();
		objCate.setId(Long.parseLong(idpresentacion));
		objProducto.setPresentacion(objCate);
		
		Marca objMarca =new Marca();
		objMarca.setId(Long.parseLong(idmarca));		
		objProducto.setMarca(objMarca);
		
		Proveedor objProveedor=new Proveedor();
		objProveedor.setId(Long.parseLong(idproveedor));
		objProducto.setProveedor(objProveedor);
		
		Zona objZona=new Zona();
		objZona.setId(Long.parseLong(idzona));
		objProducto.setZona(objZona);
		
		objProducto.setCodigo(Integer.parseInt(codigo));
		objProducto.setPrecio(Double.parseDouble(precio));
		objProducto.setStock(Integer.parseInt(stock));
		objProducto.setIva(Integer.parseInt(iva));
		objProducto.setPeso(Double.parseDouble(peso));
	
		ProductoMB productoMB = new ProductoMB();
		productoMB.insertar(objProducto);
		
		lstProducto = productoMB.listaProducto();
		return "listadoProducto";
	}

	public String eventoLimpiarFormulario() {
		
		nombre = "";
		idpresentacion = "";
		idmarca = "";
		precio = "";
		stock = "";
	

		return "registrarProducto";
	}
	
	public String eventoLimpiarFormularioActualizar() {
		
		nombre = "";
		idpresentacion = "";
		idmarca = "";
		precio = "";
		stock = "";

		return "actualizarProducto";
	}

	public String eventoEliminarProducto() {
		System.out.println("id Producto:" + this.getId());
		
		//vamos a eliminar 
		
		if(this.getId()!= null) {
			ProductoMB productoMB = new ProductoMB();
			productoMB.eliminar(Long.valueOf(this.getId()));
			
			lstProducto = productoMB.listaProducto();
		}
		

		return "listadoProducto";
	}
	
	public void eventoIrActualizar() throws IOException {
		if(this.getId()!= null) {
			ProductoMB productoMB = new ProductoMB();
			Producto objProducto = productoMB.buscar(Long.valueOf(this.getId()));
			id = objProducto.getId()+"";
			
			nombre = objProducto.getNombre();
			
			Presentacion objCategoria=new Presentacion();		
			idpresentacion=String.valueOf(objCategoria.getId());
			
			Marca objMarca=new Marca();
			idmarca=String.valueOf(objMarca.getId());
			
		    Proveedor objProveedor=new Proveedor();
		    idproveedor=String.valueOf(objProveedor.getId());
		    
		    Zona objZona=new Zona();
		    idzona=String.valueOf(objZona.getId());
		    
		    codigo=String.valueOf(objProducto.getCodigo());
			precio=String.valueOf(objProducto.getPrecio());
			stock=String.valueOf(objProducto.getStock());
			iva=String.valueOf(objProducto.getIva());
			peso=String.valueOf(objProducto.getPeso());
			
		}

		FacesContext.getCurrentInstance().getExternalContext().redirect("actualizarProducto.xhtml");
		
	}
	
	public void eventoListarProducto() throws IOException{
		FacesContext.getCurrentInstance().getExternalContext().redirect("listadoProducto.xhtml");
	}
	
	public String eventoActualizarProducto() {

		System.out.println("Nombre: " + nombre);
		System.out.println("Presentacion: " + idpresentacion);
		System.out.println("Marca: " + idmarca);
		System.out.println("Proveedor: " + idproveedor);
		System.out.println("Zona: " + idzona);
		System.out.println("Codigo: " + codigo);
		System.out.println("Precio: " + precio);
		System.out.println("Stock: " + stock);
		System.out.println("Iva: " + iva);
		System.out.println("Peso: " + peso);

		Producto objProducto = new Producto();
		objProducto.setId(Long.parseLong(id));
		objProducto.setNombre(nombre);
		
		Presentacion objCate=new Presentacion();
		objCate.setId(Long.parseLong(idpresentacion));
		objProducto.setPresentacion(objCate);
		
		Marca objMarca =new Marca();
		objMarca.setId(Long.parseLong(idmarca));		
		objProducto.setMarca(objMarca);
		
		Proveedor objProveedor=new Proveedor();
		objProveedor.setId(Long.parseLong(idproveedor));
		objProducto.setProveedor(objProveedor);
		
		Zona objZona=new Zona();
		objZona.setId(Long.parseLong(idzona));
		objProducto.setZona(objZona);
		
		objProducto.setCodigo(Integer.parseInt(codigo));
		objProducto.setPrecio(Double.parseDouble(precio));
		objProducto.setStock(Integer.parseInt(stock));
		objProducto.setIva(Integer.parseInt(iva));
		objProducto.setPeso(Double.parseDouble(peso));
		

		ProductoMB productoMB = new ProductoMB();
		productoMB.actualizar(objProducto);
		
		lstProducto = productoMB.listaProducto();
		return "listadoProducto";
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	


	

	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getIva() {
		return iva;
	}


	public void setIva(String iva) {
		this.iva = iva;
	}


	public String getPeso() {
		return peso;
	}


	public void setPeso(String peso) {
		this.peso = peso;
	}


	public String getIdpresentacion() {
		return idpresentacion;
	}


	public void setIdpresentacion(String idpresentacion) {
		this.idpresentacion = idpresentacion;
	}


	public String getIdproveedor() {
		return idproveedor;
	}


	public void setIdproveedor(String idproveedor) {
		this.idproveedor = idproveedor;
	}


	public String getIdzona() {
		return idzona;
	}


	public void setIdzona(String idzona) {
		this.idzona = idzona;
	}


	public String getIdmarca() {
		return idmarca;
	}


	public void setIdmarca(String idmarca) {
		this.idmarca = idmarca;
	}


	public String getPrecio() {
		return precio;
	}


	public void setPrecio(String precio) {
		this.precio = precio;
	}


	public String getStock() {
		return stock;
	}


	public void setStock(String stock) {
		this.stock = stock;
	}


	public Producto getProductoModel() {
		return productoModel;
	}


	public void setProductoModel(Producto productoModel) {
		this.productoModel = productoModel;
	}


	public List<Producto> getLstProducto() {
		return lstProducto;
	}


	public void setLstProducto(List<Producto> lstProducto) {
		this.lstProducto = lstProducto;
	}
	
	

	
	

}
