package co.com.calendarActivities.service;

import java.util.List;

import co.com.calendarActivities.domain.TipoDocumento;

public interface TipoDocumentoService {
	public TipoDocumento findById(Long id);
	public List<TipoDocumento> findAll();
}
