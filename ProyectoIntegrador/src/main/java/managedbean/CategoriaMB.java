package managedbean;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.Presentacion;
import util.JPAUtil;



public class CategoriaMB {
	
	
public void insertar(Object obj){
		
		EntityManager manager = null;

		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();
			manager.persist(obj);//Genera el JPQL internamente 
			manager.flush();// Enviar en cola(pueden haber varios SQL)
			manager.getTransaction().commit(); //Envia a la BD
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			manager.close();
		}
	}
	
	

	public Presentacion buscar(Long id) {
		EntityManager manager = null;
		try {
			manager = JPAUtil.getEntityManager();
			return manager.find(Presentacion.class,id);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			manager.close();
		}
		return null;
	}
	
	
	public void actualizar(Object obj) {
		EntityManager manager = null;

		try {
			manager = JPAUtil.getEntityManager();
			manager.getTransaction().begin();
			manager.merge(obj);
			manager.flush();
			manager.getTransaction().commit(); 
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			manager.close();
		}
	}
	
	public void eliminar(Long id) {
		EntityManager manager = null;

		try {
			manager = JPAUtil.getEntityManager();
			Presentacion c = manager.find(Presentacion.class,id);
			
			manager.getTransaction().begin();
			manager.remove(c);
			manager.flush();
			manager.getTransaction().commit(); 
		} catch (Exception e) {
			manager.getTransaction().rollback();
			e.printStackTrace();
		}finally{
			manager.close();
		}
	}
	
	
	public List<Presentacion> listaCategoria(){
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Presentacion> consulta= em.createNamedQuery("Presentacion.findAll", Presentacion.class);
		return consulta.getResultList();
	}
	
	
	

}
