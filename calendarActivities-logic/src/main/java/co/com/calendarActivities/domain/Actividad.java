package co.com.calendarActivities.domain;

import java.io.Serializable;
import javax.persistence.*;

import com.sun.istack.NotNull;

import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the actividad database table.
 * 
 */
@Entity
@NamedQuery(name="Actividad.findAll", query="SELECT a FROM Actividad a")
public class Actividad implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="acti_id")
	@NotNull
	private long actiId;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	@NotNull
	private Date fecha;

	@Column(name="hora_fin")
	@NotNull
	private Time horaFin;

	@Column(name="hora_inicio")
	@NotNull
	private Time horaInicio;
	
	@NotNull
	private String nombre;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="clie_id")
	private Cliente cliente;

	public Actividad() {
	}

	public long getActiId() {
		return this.actiId;
	}

	public void setActiId(long actiId) {
		this.actiId = actiId;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Time getHoraFin() {
		return this.horaFin;
	}

	public void setHoraFin(Time horaFin) {
		this.horaFin = horaFin;
	}

	public Time getHoraInicio() {
		return this.horaInicio;
	}

	public void setHoraInicio(Time horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}