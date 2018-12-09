package jsf;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import entity.Empleado;
import managedbean.EmpleadoMB;

@ManagedBean(name="seguridadJSF")
@SessionScoped
public class SeguridadController implements Serializable{
	
	private String usuario;
	
	private String clave;
	
	private Empleado empleadoModel;
	
	
	


	
	//evento invocado desde logueo.xhtml para loguear
	public String eventoLogueo(){	

		System.out.println("Usuario: "+usuario);
		System.out.println("Clave: "+clave);
		
		FacesContext contexto = FacesContext.getCurrentInstance();
		
		EmpleadoMB empleadoMb = new EmpleadoMB();
		empleadoModel = empleadoMb.getEmpleadoByUsuarioClave(usuario, clave);
		
		if(empleadoModel== null){//Usuario no existe
						
			  FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Usuario no existe!","");
			  contexto.addMessage( null, message);
	          return "logueo";
	          
		}else{//Usuario existe
			
			HttpSession session = (HttpSession) contexto.getExternalContext().getSession(false);
			
			session.setAttribute("objetoUsuarioSesion", empleadoModel);	
			contexto.addMessage(null, new FacesMessage("Mensaje Sistema",  "Bienvenido a Primefaces" ) );
			contexto.addMessage(null, new FacesMessage("Bandeja de Pedidos", "Tiene Pepedidos Urgentes."));
			
			return "inicio";
		}
			
	}
	
	
	public String eventoCerrarSesion(){
		
		FacesContext contexto = FacesContext.getCurrentInstance();
		HttpSession session = (HttpSession) contexto.getExternalContext().getSession(false);
		session.invalidate();
		
		return "logueo";
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
	



	public Empleado getEmpleadoModel() {
		return empleadoModel;
	}

	public void setEmpleadoModel(Empleado empleadoModel) {
		this.empleadoModel = empleadoModel;
	}

	

	

	
	
}
