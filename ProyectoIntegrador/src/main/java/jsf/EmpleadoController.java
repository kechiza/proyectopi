package jsf;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import entity.Empleado;
import managedbean.EmpleadoMB;

@ManagedBean(name = "empleadoJSF")
@SessionScoped
public class EmpleadoController implements Serializable {

	private String id;

	private String usuario;

	private String clave;

	private String nombre;

	private String apellido;

	private String dni;

	private String rol;

	private String sexo;

	private Date fechaNacimiento;

	private Empleado empleadoModel;

	private List<Empleado> lstEmpleado;
	FacesContext contexto = null;

	public EmpleadoController() {
		
	}

	public String initPantalla() {
		EmpleadoMB empleadoMB = new EmpleadoMB();
		lstEmpleado = empleadoMB.listaEmpleados();
		empleadoModel = new Empleado();
		
		return eventoLimpiarFormulario();
	}

	public String eventoRegistrarEmpleado() {

		System.out.println("Nombre: " + nombre);
		System.out.println("Apellido: " + apellido);
		System.out.println("DNI: " + dni);
		System.out.println("rol: " + rol);
		System.out.println("sexo: " + sexo);
		System.out.println("Usuario: " + usuario);
		System.out.println("Clave: " + clave);
		System.out.println("fechaNacimiento: " + fechaNacimiento);

		Empleado objEmpleado = new Empleado();
		objEmpleado.setApellido(apellido);
		objEmpleado.setDni(dni);
		objEmpleado.setFecha_nacimiento(fechaNacimiento);
		objEmpleado.setNombre(nombre);
		objEmpleado.setRol(rol);
		objEmpleado.setSexo(sexo);
		objEmpleado.setUsuario(usuario);
		objEmpleado.setClave(clave);

		EmpleadoMB empleadoMB = new EmpleadoMB();
		empleadoMB.insertar(objEmpleado);
		
		lstEmpleado = empleadoMB.listaEmpleados();
		return "listadoEmpleados";
	}

	public String eventoLimpiarFormulario() {
		apellido = "";
		nombre = "";
		fechaNacimiento = null;
		rol = "";
		sexo = "";
		usuario = "";
		clave = "";
		dni = "";

		return "registrarEmpleado";
	}
	
	public String eventoLimpiarFormularioActualizar() {
		apellido = "";
		nombre = "";
		fechaNacimiento = null;
		rol = "";
		sexo = "";
		usuario = "";
		clave = "";
		dni = "";

		return "actualizarEmpleado";
	}

	public String eventoEliminarEmpleado() {
		System.out.println("id Empleado:" + this.getId());
		
		//vamos a eliminar 
		
		if(this.getId()!= null) {
			EmpleadoMB empleadoMB = new EmpleadoMB();
			empleadoMB.eliminar(Long.valueOf(this.getId()));
			
			lstEmpleado = empleadoMB.listaEmpleados();
		}
		

		return "listadoEmpleados";
	}
	
	public void eventoIrActualizar() throws IOException {
		if(this.getId()!= null) {
			EmpleadoMB empleadoMB = new EmpleadoMB();
			Empleado objEmpleado = empleadoMB.buscar(Long.valueOf(this.getId()));
			id = objEmpleado.getId()+"";
			apellido = objEmpleado.getApellido();
			nombre = objEmpleado.getNombre();
			fechaNacimiento = objEmpleado.getFecha_nacimiento();
			rol = objEmpleado.getRol();
			sexo = objEmpleado.getSexo();
			usuario = objEmpleado.getUsuario();
			clave = objEmpleado.getClave();
			dni = objEmpleado.getDni();
		}

		FacesContext.getCurrentInstance().getExternalContext().redirect("actualizarEmpleado.xhtml");
		
	}
	
	public void eventoListarEmpleados() throws IOException{
		FacesContext.getCurrentInstance().getExternalContext().redirect("listadoEmpleados.xhtml");
	}
	
	public String eventoActualizarEmpleado() {

		System.out.println("Nombre: " + nombre);
		System.out.println("Apellido: " + apellido);
		System.out.println("DNI: " + dni);
		System.out.println("rol: " + rol);
		System.out.println("sexo: " + sexo);
		System.out.println("Usuario: " + usuario);
		System.out.println("Clave: " + clave);
		System.out.println("fechaNacimiento: " + fechaNacimiento);

		Empleado objEmpleado = new Empleado();
		objEmpleado.setId(Long.parseLong(id));
		objEmpleado.setApellido(apellido);
		objEmpleado.setDni(dni);
		objEmpleado.setFecha_nacimiento(fechaNacimiento);
		objEmpleado.setNombre(nombre);
		objEmpleado.setRol(rol);
		objEmpleado.setSexo(sexo);
		objEmpleado.setUsuario(usuario);
		objEmpleado.setClave(clave);

		EmpleadoMB empleadoMB = new EmpleadoMB();
		empleadoMB.actualizar(objEmpleado);
		
		lstEmpleado = empleadoMB.listaEmpleados();
		return "listadoEmpleados";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Empleado getEmpleadoModel() {
		return empleadoModel;
	}

	public void setEmpleadoModel(Empleado empleadoModel) {
		this.empleadoModel = empleadoModel;
	}

	public List<Empleado> getLstEmpleado() {
		return lstEmpleado;
	}

	public void setLstEmpleado(List<Empleado> lstEmpleado) {
		this.lstEmpleado = lstEmpleado;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}




