package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo08 {
	
	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		
		EntityManager em = fabrica.createEntityManager();
		
	    //Validar un Usuario segun su Usuario y clave
		
		String sql2 = "Select u from Usuario u where u.usuario = :xusr and u.clave = :xcla";
		
		TypedQuery<Usuario> query = em.createQuery(sql2, Usuario.class);
		query.setParameter("xurs","U002@gmail.com");
		query.setParameter("xcla","10002");
		
		Usuario u = null;
		try {
			u = query.getSingleResult();
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
