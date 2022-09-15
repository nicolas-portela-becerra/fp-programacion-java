package com.liceolapaz.des.npb;

public class Empleado {
	private String id;
	private String email;
	private String nombre;
	private String apellido;
	private String avatar;
	
	public Empleado(String id, String email, String nombre, String apellido, String avatar) {
		super();
		this.id = id;
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
		this.avatar = avatar;
	}
	
	

	@Override
	public String toString() {
		return "\nEmpleado [id = " + id + ", email = " + email + ", nombre = " + nombre + ", apellido = " + apellido + ", avatar = "
				+ avatar + "]\n";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
}	
