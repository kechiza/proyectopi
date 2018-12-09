package managedbean;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.Producto;
import util.JPAUtil;


public class ProductoMB {
	
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
	
	

	public Producto buscar(Long id) {
		EntityManager manager = null;
		try {
			manager = JPAUtil.getEntityManager();
			return manager.find(Producto.class,id);
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
			Producto c = manager.find(Producto.class,id);
			
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
	
	
	public List<Producto> listaProducto(){
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Producto> consulta= em.createNamedQuery("Producto.findAll", Producto.class);
		return consulta.getResultList();
	}
	

}
