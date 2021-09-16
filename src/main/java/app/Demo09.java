package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo09 {
	
public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		
		EntityManager em = fabrica.createEntityManager();
		
	    //Validar un Usuario segun su Usuario y clave ->usar procedimiento almacenados
		
		String sql2 = "{call usp_validaAcceso(:xurs, :xcla)}";
		
		// TypedQuery<Usuario> query = em.createQuery(sql2, Usuario.class);
		Query query = em.createNativeQuery(sql2, Usuario.class);
		query.setParameter("xurs","U002@gmail.com");
		query.setParameter("xcla","10002");
		
		Usuario u = null;
		try {
			u = (Usuario) query.getSingleResult();
		} catch (Exception e) {
			
		}
		
		if(u == null) {
			System.out.println("Codigo No existe");
		}else {
			System.out.println("Bienvenido : "+ u.getNombre());
	     	System.out.println(u);
	     	
	    }
	 
		em.close();
		
	}


}
