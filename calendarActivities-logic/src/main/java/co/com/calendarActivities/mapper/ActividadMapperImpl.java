package co.com.calendarActivities.mapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.com.calendarActivities.domain.Actividad;
import co.com.calendarActivities.dto.ActividadDTO;
import co.com.calendarActivities.dto.ClienteDTO;
import co.com.calendarActivities.service.ClienteService;


@Component
@Scope("singleton")
public class ActividadMapperImpl implements ActividadMapper {
	
	
	@Autowired
	private  ClienteService clienteService;

	 @Transactional(readOnly = true)
	public ActividadDTO clienteToClienteDTO(Actividad actividad) throws Exception {
		 try {

			 ActividadDTO actividadDTO = new ActividadDTO();

			 actividadDTO.setACTI_ID(actividad.getActiId());
			 actividadDTO.setNOMBRE((actividad.getNombre() != null)
	                ? actividad.getNombre(): null);
			 actividadDTO.setDESCRIPCION((actividad.getDescripcion() != null)
	                ? actividad.getDescripcion() : null);
			 actividadDTO.setFECHA((actividad.getFecha() != null)
	                ? actividad.getFecha() : null);
			 actividadDTO.setHORA_INICIO(actividad.getHoraInicio()!=null? actividad.getHoraInicio():null );
			 actividadDTO.setHORA_INICIO((actividad.getHoraInicio() != null)
		                ? actividad.getHoraInicio(): null);
			 actividadDTO.setCLIE_ID(actividad.getCliente()!=null ?actividad.getCliente().getClieId():null);
			 return actividadDTO;
			 
	        } catch (Exception e) {
	            throw e;
	        }
	}

	 @Transactional(readOnly = true)
	public Actividad clienteDTOToCliente(ActividadDTO actividadDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	 @Transactional(readOnly = true)
	public List<ActividadDTO> listClienteToListClienteDTO(List<Actividad> actividad) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	 @Transactional(readOnly = true)
	public List<Actividad> listClienteDTOToListCliente(List<ActividadDTO> actividadDTOs) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
