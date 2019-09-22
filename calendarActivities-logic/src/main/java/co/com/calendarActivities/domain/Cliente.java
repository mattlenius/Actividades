package co.com.calendarActivities.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="clie_id")
	@NotNull
	private long clieId;
	@NotNull
	@Pattern(regexp="^[SN]{1}$",message = "Solo se recibe S o N En mayuscula")
	private String activo;
	@NotNull
	@Size(min=5,max=20)
	private String direccion;
	
	@Size(min=5,max=200)
	@Email
	private String email;
	
	@NotNull
	@Size(min=5,max=20)
	private String nombre;
	
	@NotNull
	@Size(min=7,max=11)
	private String telefono;

	//bi-directional many-to-one association to Actividad
	@OneToMany(mappedBy="cliente")
	private List<Actividad> actividads;

	//bi-directional many-to-one association to TipoDocumento
	@ManyToOne
	@JoinColumn(name="tdoc_id")
	private TipoDocumento tipoDocumento;

	public Cliente() {
	}

	public long getClieId() {
		return this.clieId;
	}

	public void setClieId(long clieId) {
		this.clieId = clieId;
	}

	public String getActivo() {
		return this.activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Actividad> getActividads() {
		return this.actividads;
	}

	public void setActividads(List<Actividad> actividads) {
		this.actividads = actividads;
	}

	public Actividad addActividad(Actividad actividad) {
		getActividads().add(actividad);
		actividad.setCliente(this);

		return actividad;
	}

	public Actividad removeActividad(Actividad actividad) {
		getActividads().remove(actividad);
		actividad.setCliente(null);

		return actividad;
	}

	public TipoDocumento getTipoDocumento() {
		return this.tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

}