package co.com.calendarActivities.dto;

import java.sql.Time;
import java.util.Date;
import java.util.Timer;

public class ActividadDTO {
	
	private long ACTI_ID;
	private String NOMBRE;
	private String DESCRIPCION;
	private Date FECHA;
	private Date HORA_INICIO;
	private Date HORA_FIN;
	private Long CLIE_ID;
	
	
	
	public ActividadDTO() {
		super();
	}



	public long getACTI_ID() {
		return ACTI_ID;
	}



	public void setACTI_ID(long aCTI_ID) {
		ACTI_ID = aCTI_ID;
	}



	public String getNOMBRE() {
		return NOMBRE;
	}



	public void setNOMBRE(String nOMBRE) {
		NOMBRE = nOMBRE;
	}



	public String getDESCRIPCION() {
		return DESCRIPCION;
	}



	public void setDESCRIPCION(String dESCRIPCION) {
		DESCRIPCION = dESCRIPCION;
	}



	public Date getFECHA() {
		return FECHA;
	}



	public void setFECHA(Date fECHA) {
		FECHA = fECHA;
	}



	public Date getHORA_INICIO() {
		return HORA_INICIO;
	}



	public void setHORA_INICIO(Date hORA_INICIO) {
		HORA_INICIO = hORA_INICIO;
	}



	public Date getHORA_FIN() {
		return HORA_FIN;
	}



	public void setHORA_FIN(Date hORA_FIN) {
		HORA_FIN = hORA_FIN;
	}



	public Long getCLIE_ID() {
		return CLIE_ID;
	}



	public void setCLIE_ID(Long cLIE_ID) {
		CLIE_ID = cLIE_ID;
	}



	

}
