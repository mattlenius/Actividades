package co.com.calendarActivities.repository;



import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import co.com.calendarActivities.domain.Actividad;
import co.com.calendarActivities.domain.Cliente;
import co.com.calendarActivities.domain.TipoDocumento;


@ExtendWith(SpringExtension.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
class TestClienteRepository {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private TipoDocumentoRepository documentoRepository;
	
	@Autowired
	private ActividadRepository actividadRepository;
	
	long clie_id=2;
	@Test
	@DisplayName("crearCliente")
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void testA() {

		assertNotNull(clienteRepository,"El clienteRepository es nulo");
		assertNotNull(documentoRepository,"El documentoRepository es nulo");
		
		Cliente cliente = clienteRepository.findById(clie_id);
		assertNull(cliente);
		
		cliente = new Cliente();
		cliente.setActivo("S");
		cliente.setDireccion("cra25#19a-37");
		cliente.setEmail("juan.arcila@gamil.com");
		cliente.setNombre("juan david");
		cliente.setTelefono("3105220300");
		cliente.setClieId(clie_id);
		
		TipoDocumento tipoDocumento = documentoRepository.findById(2L);
		assertNotNull(tipoDocumento);
		cliente.setTipoDocumento(tipoDocumento);
		
		clienteRepository.save(cliente);

	}
	@Test
	@DisplayName("modificarCliente")
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void testB() {

		assertNotNull(clienteRepository,"El entityManager es nulo");
		
		Cliente cliente = clienteRepository.findById(clie_id);
		assertNotNull(cliente,"El cliente no existe");
		
		cliente = new Cliente();
		cliente.setActivo("N");
		cliente.setDireccion("cra25#19a-37");
		cliente.setEmail("juan.arcila@gamil.com");
		cliente.setNombre("juan david");
		cliente.setTelefono("3105220300");
		cliente.setClieId(clie_id);
		
		TipoDocumento tipoDocumento = documentoRepository.findById(2L);
		assertNotNull(tipoDocumento);
		cliente.setTipoDocumento(tipoDocumento);
		

		clienteRepository.update(cliente);


	}
	@Test
	@DisplayName("borrarCliente")
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void testC() {

		assertNotNull(clienteRepository,"El entityManager es nulo");
		
		Cliente cliente = clienteRepository.findById(clie_id);
		assertNotNull(cliente,"El cliente no existe");


		clienteRepository.delete(cliente);

	}
	
	private final static Logger log= LoggerFactory.getLogger(TestClienteRepository.class);
	@Test
	@DisplayName("consultarTodos")
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void testE() {

		assertNotNull(clienteRepository,"El clienteRepository es nulo");
		List<Cliente> losCliente = clienteRepository.findAll();

		losCliente.forEach(cliente->{
			log.info("Id "+cliente.getClieId());
			log.info("nombre "+cliente.getNombre());
		});
	}
	
	

	@Test
	@DisplayName("consultarTodos")
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	void testI() throws ParseException {

		assertNotNull(clienteRepository,"El clienteRepository es nulo");
		Cliente cliente = clienteRepository.findById(clie_id);
		assertNotNull(cliente,"El cliente no existe");
		Actividad actividad = new Actividad();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/mm/dd");
		String fechainicio="2018/02/20";
		String fechaFin = "2019/07/20";
		List<Actividad> actividads=actividadRepository.findFechasById(sdf.parse(fechainicio),  sdf.parse(fechaFin), cliente.getClieId());
		
		for(Actividad actividad2:actividads) {
			log.info("Id "+actividad2.getActiId());
			log.info("nombre "+actividad2.getNombre());
		}
		
	
	}

}
