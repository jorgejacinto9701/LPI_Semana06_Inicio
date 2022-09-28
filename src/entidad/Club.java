package entidad;

import java.sql.Date;

public class Club {

	private int idClub;
	private String nombre;
	private Date fechaCreacion;
	private Date fechaRegistro;
	private int estado;
	private Pais pais;
	
	public int getIdClub() {
		return idClub;
	}
	public void setIdClub(int idClub) {
		this.idClub = idClub;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	
	
}
