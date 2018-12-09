package managedbean;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entity.Empleado;
import util.JPAUtil;

public class EmpleadoMB {


	
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
	
	

	public Empleado buscar(Long id) {
		EntityManager manager = null;
		try {
			manager = JPAUtil.getEntityManager();
			return manager.find(Empleado.class,id);
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
			Empleado c = manager.find(Empleado.class,id);
			
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
	
	
	
	
	public Empleado getEmpleadoByUsuario(String usuario){
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Empleado> consulta= em.createNamedQuery("Empleado.getByUsuario", Empleado.class);
		consulta.setParameter("p_usuario", usuario);
		
		return consulta.getSingleResult();	
	}
	
	
	
	public Empleado getEmpleadoByDNI(String dni){
		EntityManager em = JPAUtil.getEntityManager();
		
		Query query = em.createQuery ("Select e FROM Empleado e WHERE e.dni = :parametro"); //JPQL
		query.setParameter ("parametro", dni);
		Empleado obj = (Empleado) query.getSingleResult();
		
		return obj;
		
	}
	
	
	public Empleado getEmpleadoByUsuarioClave(String usuario, String clave){
	
		EntityManager em = JPAUtil.getEntityManager();
		
		Query q = em.createQuery ("Select e from Empleado e WHERE e.usuario = :usuario and e.clave = :clave");
		q.setParameter ("usuario", usuario);
		q.setParameter ("clave", clave);
		List<Empleado> empleados = q.getResultList();
		return (empleados.size()>0)?empleados.get(0):null;
	}
	
	
	public List<Empleado> listaEmpleados(){
		EntityManager em = JPAUtil.getEntityManager();
		TypedQuery<Empleado> consulta= em.createNamedQuery("Empleado.findAll", Empleado.class);
		return consulta.getResultList();
	}
	
	
	
}
