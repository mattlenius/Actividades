package co.com.calendarActivities.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.com.calendarActivities.domain.Actividad;
import co.com.calendarActivities.domain.Cliente;

@Repository
@Scope("singleton")
public class ActividadRepositoryImpl implements ActividadRepository {

	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	@Override
	public void save(Actividad actividad) {
		entityManager.persist(actividad);

	}

	@Override
	public void update(Actividad actividad) {
		entityManager.merge(actividad);

	}

	@Override
	public void delete(Actividad actividad) {
		entityManager.remove(actividad);

	}

	@Override
	public Actividad findById(Long id) {
		return entityManager.find(Actividad.class, id);
	}

	@Override
	public List<Actividad> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Actividad> findFechasById(Date fechainicio, Date fechaFin, Long id) {
		String query="SELECT act FROM Actividad act  "
				+ " WHERE act.fecha>'"
				+ fechainicio
				+ "' and  act.fecha>'"
				+ fechaFin
				+ "' and act.cliente.clieId='"
				+ id
				+"'";
		List<Actividad> losActividad = entityManager.createQuery(query).getResultList();
		return  losActividad;
	}

}
