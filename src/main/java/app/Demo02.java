package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {
	
	public static void main(String[] args) {
		//Obtener la conexion -> segun la unidad de persistencia ->DAOFactoory fabrica
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		//Crea los DAO usando la fabrica
		EntityManager em = fabrica.createEntityManager();
		
		// -- proceso : actualizar usuario
		Usuario u = new Usuario();
		u.setCodigo(20);
		u.setNombre("Eren");
		u.setApellido("Jeager");
		u.setUsuario("eren24@gmail.com");
		u.setClave("paloma");
		u.setFnacim("2021/08/24");
		u.setTipo(1);
		u.setEstado(1);
		
		//para reg, act, eli -> transacciones
		em.getTransaction().begin();
		em.merge(u); //para actualizar
		em.getTransaction().commit();
		System.out.println("Actualizacion Ok");
		em.close();
		
	}

}
