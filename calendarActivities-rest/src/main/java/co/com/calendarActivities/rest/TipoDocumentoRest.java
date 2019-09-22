package co.com.calendarActivities.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.calendarActivities.domain.TipoDocumento;
import co.com.calendarActivities.dto.TipoDocumentoDTO;
import co.com.calendarActivities.mapper.TipoDocumentoMapper;
import co.com.calendarActivities.service.TipoDocumentoService;

@RestController
@CrossOrigin
@RequestMapping("/tipoDocumento")
public class TipoDocumentoRest {
	
	@Autowired
	private TipoDocumentoService tipoDocumentoService;
	
	@Autowired
	private TipoDocumentoMapper tipoDocumentoMapper;
	
	@GetMapping("/{id}")
	public TipoDocumentoDTO findById(@PathVariable("id") Long id)throws Exception {
		TipoDocumento documento=tipoDocumentoService.findById(id);
		if(documento==null) {
			return null;
		}
		TipoDocumentoDTO documentoDTO=tipoDocumentoMapper.tipoDocumentoToTipoDocumentoDTO(documento);
		return documentoDTO;
	}
	
	@GetMapping("/")
	public List<TipoDocumentoDTO> findAll()throws Exception{
		return tipoDocumentoMapper.listTipoDocumentoToListTipoDocumentoDTO(tipoDocumentoService.findAll());
	}
	


}
