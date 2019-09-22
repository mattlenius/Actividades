package co.com.calendarActivities.repository;

import java.util.List;

import co.com.calendarActivities.domain.TipoDocumento;

public interface TipoDocumentoRepository {
	public void save(TipoDocumento tipoDocumento);
	public void update(TipoDocumento tipoDocumento);
	public void delete(TipoDocumento tipoDocumento);
	public TipoDocumento findById(Long id);
	public List<TipoDocumento> findAll();
}
