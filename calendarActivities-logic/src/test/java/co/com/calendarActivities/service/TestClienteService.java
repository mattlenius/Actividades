package co.com.calendarActivities.service;



import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
class TestClienteService {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private TipoDocumentoService documentoService;
	
	long clie_id=1143849298L;
	@Test
	@DisplayName("crearCliente")

	void testA() throws Exception {

		assertNotNull(clienteService,"El clienteService es nulo");
		assertNotNull(documentoService,"El documentoRepository es nulo");
		
		Cliente cliente = clienteService.findById(clie_id);
		assertNull(cliente);
		
		cliente = new Cliente();
		cliente.setActivo("S");
		cliente.setDireccion("cra25#19a-37");
		cliente.setEmail("juan.arcila@gamil.com");
		cliente.setNombre("juan david");
		cliente.setTelefono("3105220300");
		cliente.setClieId(clie_id);
		
		TipoDocumento tipoDocumento = documentoService.findById(2L);
		assertNotNull(tipoDocumento);
		cliente.setTipoDocumento(tipoDocumento);
		
		clienteService.save(cliente);

	}
	@Test
	@DisplayName("modificarCliente")

	void testB() throws Exception {

		assertNotNull(clienteService,"El entityManager es nulo");
		
		Cliente cliente = clienteService.findById(clie_id);
		assertNotNull(cliente,"El cliente no existe");
		
		cliente = new Cliente();
		cliente.setActivo("N");
		cliente.setDireccion("cra25#19a-37");
		cliente.setEmail("juan.arcila@gamil.com");
		cliente.setNombre("juan david");
		cliente.setTelefono("3105220300");
		cliente.setClieId(clie_id);
		
		TipoDocumento tipoDocumento = documentoService.findById(2L);
		assertNotNull(tipoDocumento);
		cliente.setTipoDocumento(tipoDocumento);
		

		clienteService.update(cliente);


	}
	@Test
	@DisplayName("borrarCliente")
	void testC() throws Exception {

		assertNotNull(clienteService,"El entityManager es nulo");
		
		Cliente cliente = clienteService.findById(clie_id);
		assertNotNull(cliente,"El cliente no existe");


		clienteService.delete(cliente);

	}
	
	private final static Logger log= LoggerFactory.getLogger(TestClienteService.class);
	@Test
	@DisplayName("consultarTodos")
	void testE() {

		assertNotNull(clienteService,"El clienteRepository es nulo");
		List<Cliente> losCliente = clienteService.findAll();

		losCliente.forEach(cliente->{
			log.info("Id "+cliente.getClieId());
			log.info("nombre "+cliente.getNombre());
		});
	}

}
