package co.com.calendarActivities.jpa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.com.calendarActivities.domain.Cliente;
import co.com.calendarActivities.domain.TipoDocumento;

class TestClientJPA {
	long clie_id=1143849298L;
	@Test
	@DisplayName("crearCliente")

	void testA() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("calendarActivities-logic");
		assertNotNull(entityManagerFactory,"El entityManagerFactory es nulo");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		assertNotNull(entityManager,"El entityManager es nulo");
		
		Cliente cliente = entityManager.find(Cliente.class, clie_id);
		assertNull(cliente);
		
		cliente = new Cliente();
		cliente.setActivo("S");
		cliente.setDireccion("cra25#19a-37");
		cliente.setEmail("juan.arcila@gamil.com");
		cliente.setNombre("juan david");
		cliente.setTelefono("3105220300");
		cliente.setClieId(clie_id);
		
		TipoDocumento tipoDocumento = entityManager.find(TipoDocumento.class, 2L);
		assertNotNull(tipoDocumento);
		cliente.setTipoDocumento(tipoDocumento);
		
		entityManager.getTransaction().begin();
		entityManager.persist(cliente);
		entityManager.getTransaction().commit();

	}
	@Test
	@DisplayName("modificarCliente")

	void testB() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("calendarActivities-logic");
		assertNotNull(entityManagerFactory,"El entityManagerFactory es nulo");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		assertNotNull(entityManager,"El entityManager es nulo");
		
		Cliente cliente = entityManager.find(Cliente.class, clie_id);
		assertNotNull(cliente,"El cliente no existe");
		
		cliente = new Cliente();
		cliente.setActivo("N");
		cliente.setDireccion("cra25#19a-37");
		cliente.setEmail("juan.arcila@gamil.com");
		cliente.setNombre("juan david");
		cliente.setTelefono("3105220300");
		cliente.setClieId(clie_id);
		
		TipoDocumento tipoDocumento = entityManager.find(TipoDocumento.class, 2L);
		assertNotNull(tipoDocumento);
		cliente.setTipoDocumento(tipoDocumento);
		
		entityManager.getTransaction().begin();
		entityManager.merge(cliente);
		entityManager.getTransaction().commit();

	}
	@Test
	@DisplayName("borrarCliente")

	void testC() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("calendarActivities-logic");
		assertNotNull(entityManagerFactory,"El entityManagerFactory es nulo");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		assertNotNull(entityManager,"El entityManager es nulo");
		
		Cliente cliente = entityManager.find(Cliente.class, clie_id);
		assertNotNull(cliente,"El cliente no existe");

		entityManager.getTransaction().begin();
		entityManager.remove(cliente);
		entityManager.getTransaction().commit();

	}
	
	private final static Logger log= LoggerFactory.getLogger(TestClientJPA.class);
	@Test
	@DisplayName("consultarTodos")

	void testE() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("calendarActivities-logic");
		assertNotNull(entityManagerFactory,"El entityManagerFactory es nulo");
		
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		assertNotNull(entityManager,"El entityManager es nulo");
		
		String JPQL="SELECT cli from Cliente cli";
		List<Cliente> losCliente = entityManager.createQuery(JPQL).getResultList();

		losCliente.forEach(cliente->{
			log.info("Id "+cliente.getClieId());
			log.info("nombre "+cliente.getNombre());
		});
	}



}
