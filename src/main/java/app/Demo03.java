package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo03 {
	
	public static void main(String[] args) {
		//Obtener la conexion -> segun la unidad de persistencia ->DAOFactoory fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//Crea los DAO usando la fabrica
		EntityManager em = fabrica.createEntityManager();
		
		// -- proceso : actualizar usuario
		Usuario u = new Usuario();
		u.setCodigo(20);
		
		
		//para reg, act, eli -> transacciones
		em.getTransaction().begin();
		em.remove(u); //para eliminar (borrar de la tabla) / cambiar un estado
		em.getTransaction().commit();
		System.out.println("Eliminaci�n Ok");
		em.close();
		
	}

}
