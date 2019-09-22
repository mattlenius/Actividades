package co.com.calendarActivities.spring;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.calendarActivities.domain.Cliente;
import co.com.calendarActivities.domain.TipoDocumento;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
class TestClienteSpring {
	@PersistenceContext
	EntityManager entityManager;

	long clie_id=1143849298L;
	@Test
	@DisplayName("crearCliente")
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void testA() {

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
		
		entityManager.persist(cliente);

	}
	@Test
	@DisplayName("modificarCliente")
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void testB() {

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
		

		entityManager.merge(cliente);


	}
	@Test
	@DisplayName("borrarCliente")
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void testC() {

		assertNotNull(entityManager,"El entityManager es nulo");
		
		Cliente cliente = entityManager.find(Cliente.class, clie_id);
		assertNotNull(cliente,"El cliente no existe");


		entityManager.remove(cliente);

	}
	
	private final static Logger log= LoggerFactory.getLogger(TestClienteSpring.class);
	@Test
	@DisplayName("consultarTodos")
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void testE() {

		assertNotNull(entityManager,"El entityManager es nulo");
		
		String JPQL="SELECT cli from Cliente cli";
		List<Cliente> losCliente = entityManager.createQuery(JPQL).getResultList();

		losCliente.forEach(cliente->{
			log.info("Id "+cliente.getClieId());
			log.info("nombre "+cliente.getNombre());
		});
	}



}
