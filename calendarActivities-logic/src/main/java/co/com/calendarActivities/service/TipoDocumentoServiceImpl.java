package co.com.calendarActivities.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.calendarActivities.domain.TipoDocumento;
import co.com.calendarActivities.repository.TipoDocumentoRepository;

@Service
@Scope("singleton")
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;

	@Override
	@Transactional(readOnly=true)
	public TipoDocumento findById(Long id) {
		return tipoDocumentoRepository.findById(id);
	}

	@Override
	public List<TipoDocumento> findAll() {
		return tipoDocumentoRepository.findAll();
	}


}
