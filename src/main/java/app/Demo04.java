package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04 {
	
	public static void main(String[] args) {
		//Obtener la conexion -> segun la unidad de persistencia ->DAOFactoory fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//Crea los DAO usando la fabrica
		EntityManager em = fabrica.createEntityManager();
		
		// -- proceso : obtener informacion de un usuario
		Usuario u = em.find(Usuario.class, 30);
		
		if(u == null) {
			System.out.println("Codigo No existe");
		}else {
			System.out.println("Bienvenido : "+ u.getNombre());
	     	System.out.println(u);
	     	
	    }
	 
		em.close();
		
	}

}
