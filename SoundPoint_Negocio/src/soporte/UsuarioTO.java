package soporte;

import java.sql.Array;

public class UsuarioTO {
	private String nombre;
	private int id;
	private Array estaciones;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Array getEstaciones() {
		return estaciones;
	}
	public void setEstaciones(Array estaciones) {
		this.estaciones = estaciones;
	}
}
