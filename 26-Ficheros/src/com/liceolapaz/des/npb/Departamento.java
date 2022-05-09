package com.liceolapaz.des.npb;

public class Departamento {
	String num_departamento;
	String nombre;
	String nombre_corto;
	int planta;
	String cif_director;
	String correo_e;
	
	public Departamento(String num_departamento, String nombre, String nombre_corto, int planta, String cif_director,
			String correo_e) {
		super();
		this.num_departamento = num_departamento;
		this.nombre = nombre;
		this.nombre_corto = nombre_corto;
		this.planta = planta;
		this.cif_director = cif_director;
		this.correo_e = correo_e;
	}
	
	@Override
	public String toString() {
		return "\nDepartamento [num_departamento=" + num_departamento + ", nombre=" + nombre + ", nombre_corto="
				+ nombre_corto + ", planta=" + planta + ", cif_director=" + cif_director + ", correo_e=" + correo_e
				+ "]\n";
	}


	public String getNum_departamento() {
		return num_departamento;
	}

	public void setNum_departamento(String num_departamento) {
		this.num_departamento = num_departamento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre_corto() {
		return nombre_corto;
	}

	public void setNombre_corto(String nombre_corto) {
		this.nombre_corto = nombre_corto;
	}

	public int getPlanta() {
		return planta;
	}

	public void setPlanta(int planta) {
		this.planta = planta;
	}

	public String getCif_director() {
		return cif_director;
	}

	public void setCif_director(String cif_director) {
		this.cif_director = cif_director;
	}

	public String getCorreo_e() {
		return correo_e;
	}

	public void setCorreo_e(String correo_e) {
		this.correo_e = correo_e;
	}	
	
	
}
