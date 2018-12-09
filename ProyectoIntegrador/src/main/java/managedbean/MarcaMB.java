package managedbean;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.Marca;
import util.JPAUtil;

public class MarcaMB {
	
	
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
	
	

	public Marca buscar(Long id) {
		EntityManager manager = null;
		try {
			manager = JPAUtil.getEntityManager();
			return manager.find(Marca.class,id);
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
			Marca c = manager.find(Marca.class,id);
			
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
	
	
	public List<Marca> listaMarca(){
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Marca> consulta= em.createNamedQuery("Marca.findAll", Marca.class);
		return consulta.getResultList();
	}
	
	

}
