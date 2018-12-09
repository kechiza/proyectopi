package managedbean;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entity.Empleado;
import entity.Venta;
import util.JPAUtil;

public class VentaMB {


	
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
	
	
	public List<Venta> ventasByIdEmpleado(Long id){
		EntityManager em = JPAUtil.getEntityManager();
		
		Query query = em.createQuery ("Select v FROM Venta v WHERE v.empleado.id = :idEmpleado order by v.fecha asc"); //JPQL
		query.setParameter ("idEmpleado", id);
		
		List<Venta> ventas;
		
		ventas  = query.getResultList();
		
		return ventas;	
	}
	
	
	
	
	
}
