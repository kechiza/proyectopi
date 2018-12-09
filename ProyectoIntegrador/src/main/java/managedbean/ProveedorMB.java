package managedbean;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.Proveedor;
import util.JPAUtil;

public class ProveedorMB {
	
	
	public List<Proveedor> listaProveedor(){
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Proveedor> consulta= em.createNamedQuery("Proveedor.findAll", Proveedor.class);
		return consulta.getResultList();
	}
	

}
