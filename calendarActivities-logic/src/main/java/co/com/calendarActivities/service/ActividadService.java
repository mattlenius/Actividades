package co.com.calendarActivities.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import co.com.calendarActivities.domain.Actividad;

public interface ActividadService {
	public void save(Actividad actividad)throws Exception;
	public void update(Actividad actividad)throws Exception;
	public void delete(Actividad actividad)throws Exception;
	public Actividad findById(Long id);
	public List<Actividad> findFechasById(Date fechainicio,Date fechaFin,Long id);
	public List<Actividad> findAll();
}
