package co.com.calendarActivities.mapper;

import java.util.List;

import co.com.calendarActivities.domain.Cliente;
import co.com.calendarActivities.dto.ClienteDTO;



public interface ClienteMapper {
	
	 public ClienteDTO clienteToClienteDTO(Cliente cliente)throws Exception;

	 public Cliente clienteDTOToCliente(ClienteDTO clienteDTO)throws Exception;
	 
	 public List<ClienteDTO> listClienteToListClienteDTO(List<Cliente> clientes)throws Exception;

	 public List<Cliente> listClienteDTOToListCliente(List<ClienteDTO> clienteDTOs) throws Exception;

}
