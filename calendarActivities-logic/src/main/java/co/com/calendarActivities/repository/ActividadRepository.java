package co.com.calendarActivities.repository;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import co.com.calendarActivities.domain.Actividad;

@Repository
public interface ActividadRepository {

	public void save(Actividad actividad);
	public void update(Actividad actividad);
	public void delete(Actividad actividad);
	public Actividad findById(Long id);
	public List<Actividad> findAll();
	public List<Actividad> findFechasById(Date fechainicio,Date fechaFin,Long id);
}
