package co.com.calendarActivities.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.com.calendarActivities.domain.Actividad;
import co.com.calendarActivities.domain.Cliente;
import co.com.calendarActivities.repository.ActividadRepository;

@Service
@Scope("singleton")
@ComponentScan(basePackages = "co.com.calendarActivities.repository") 
public class ActividadServiceImpl implements ActividadService {
	

	@Autowired
	private ActividadRepository  actividadRepository;
	
	
	@Autowired
	private Validator validator;
	
	
	public void validar(Actividad actividad) throws Exception {
	    try {
	        Set<ConstraintViolation<Actividad>> constraintViolations = validator.validate(actividad);

	        if (constraintViolations.size() > 0) {
	            StringBuilder strMessage = new StringBuilder();

	            for (ConstraintViolation<Actividad> constraintViolation : constraintViolations) {
	                strMessage.append(constraintViolation.getPropertyPath()
	                                                     .toString());
	                strMessage.append(" - ");
	                strMessage.append(constraintViolation.getMessage());
	                strMessage.append(". \n");
	            }

	            throw new Exception(strMessage.toString());
	        }
	    } catch (Exception e) {
	        throw e;
	    }
	}
	
	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void save(Actividad actividad) throws Exception {
		if(actividad==null) {
			throw new Exception("El actividad es nulo");
		}
		validar(actividad);
		
		actividadRepository.save(actividad);
		  

	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void update(Actividad actividad) throws Exception {
		if(actividad==null) {
			throw new Exception("El actividad es nulo");
		}
		validar(actividad);
		
		actividadRepository.save(actividad);

	}

	@Override
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void delete(Actividad actividad) throws Exception {
		if(actividad==null) {
			throw new Exception("El actividad es nulo");
		}
		Actividad entity=actividadRepository.findById(actividad.getActiId());
		actividadRepository.delete(entity);

	}

	@Override
	@Transactional(readOnly=true)
	public Actividad findById(Long id) {
		return actividadRepository.findById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Actividad> findAll() {
		return actividadRepository.findAll();
	}

	@Override
	public List<Actividad> findFechasById(Date fechainicio, Date fechaFin, Long id) {
		// TODO Auto-generated method stub
		return actividadRepository.findFechasById(fechainicio, fechaFin, id);
	}

}
