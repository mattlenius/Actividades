package co.com.calendarActivities.mapper;

import java.util.List;

import co.com.calendarActivities.domain.Actividad;
import co.com.calendarActivities.dto.ActividadDTO;



public interface ActividadMapper {
	 public ActividadDTO clienteToClienteDTO(Actividad actividad)throws Exception;

	 public Actividad clienteDTOToCliente(ActividadDTO actividadDTO)throws Exception;
	 
	 public List<ActividadDTO> listClienteToListClienteDTO(List<Actividad> actividad)throws Exception;

	 public List<Actividad> listClienteDTOToListCliente(List<ActividadDTO> actividadDTOs) throws Exception;

}
