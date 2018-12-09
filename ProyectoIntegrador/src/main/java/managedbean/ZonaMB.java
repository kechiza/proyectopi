package managedbean;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entity.Zona;
import util.JPAUtil;

public class ZonaMB {
	
	
	
	public List<Zona> listaZona(){
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Zona> consulta= em.createNamedQuery("Zona.findAll", Zona.class);
		return consulta.getResultList();
	}
	
	
	

}
