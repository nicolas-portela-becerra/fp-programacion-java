package com.liceolapaz.des.npb;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Principal {
	private static HashMap<String, Empleado> empleados = new HashMap<>();
	
	public static void main(String[] args) {
		while(true) {
			escribirMenu();
			int opcion = pedirOpcion();
			
			switch(opcion) {
				default:
					System.out.println("Opción no válida");
				break;
				
				case 0:
					System.exit(0);
				break;
				
				case 1:
					//ruta C:\\Users\Nicolas\\Downloads\\usuarios.json
					String ruta = pedirRuta();
					File fichero = new File(ruta);
					if(fichero.isFile()) {
						try {
							Scanner lector = new Scanner(fichero);
							//Elimino las dos primeras lineas porque no contienen infomacion necesaria
							if(lector.hasNext()) {
								lector.nextLine();
								lector.nextLine();
							}
							String id  = "";
							String email = "";
							String nombre = "";
							String apellido = "";
							String avatar = "";
							while(lector.hasNext()){
						
								String linea = lector.nextLine();
								String [] lineaArray = linea.split(": "); 
								id = lineaArray[1].substring(0, lineaArray[1].length()-1);
								System.out.println(id);
								
								linea = lector.nextLine();
								lineaArray = linea.split(": "); 
								email = lineaArray[1].substring(1, lineaArray[1].length()-2);
								System.out.println(email);
								
								linea = lector.nextLine();
								lineaArray = linea.split(": ");
								nombre = lineaArray[1].substring(1, lineaArray[1].length()-2);
								System.out.println(nombre);
								
								linea = lector.nextLine();
								lineaArray = linea.split(": ");
								apellido = lineaArray[1].substring(1, lineaArray[1].length()-2);
								System.out.println(apellido);
								
								linea = lector.nextLine();
								lineaArray = linea.split(": ");
								avatar = lineaArray[1].replace("\"", "");
								System.out.println(avatar);
								
								Empleado empleado = new Empleado(id, email, nombre, apellido, avatar);
								empleados.put(id, empleado);
								
								//Saltar 2 linea que no tienen informacion
								lector.nextLine();
								lector.nextLine();
							}
						} 
						catch (FileNotFoundException e) {
							System.err.println("Archivo no encontrado");
						}
					}
				break;
				
				case 2:
					Empleado nuevoEmpleado = crearEmpleado();
					if(nuevoEmpleado != null) {
						if(empleados.containsKey(nuevoEmpleado.getId())){
							System.err.println("Ya existe ese departamento.");
							continue;
						}
						empleados.put(nuevoEmpleado.getId(), nuevoEmpleado);
					}
				break;
				
				case 3:
					String num = pedirId();
					if(!empleados.containsKey(num)) {
						System.err.println("No existe ese id");
					}
					empleados.remove(num);
					System.out.println("Empleado eliminado.");
				break;
				
				case 4: 
					Empleado EmpleadoModificado = crearEmpleado();
					num = EmpleadoModificado.getId();
					if(!empleados.containsKey(num)) {
						System.out.println("El empleado no existe");
						continue;
					}
					empleados.replace(EmpleadoModificado.getId(), EmpleadoModificado);
					System.out.println(empleados.toString());
				break;
				
				case 5: 
					ruta = pedirRuta();
					exportarEmpleados(ruta);
				break;
				
				case 6:
					System.out.println(empleados.toString());
				break;
			}
		}
		
	}
	private static void exportarEmpleados(String ruta) {
		try {
			FileWriter fw = new FileWriter(ruta);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			String linea = "";
			
			for(Empleado empleados : empleados.values()) {
					linea = "=========================\n";
					pw.print(linea);
					linea = "Id: " + empleados.getId();
					linea = "=========================\n";
					pw.print(linea);
					linea = "Nombre: " + empleados.getNombre() + "\n";
					pw.print(linea);
					linea = "Apellido: " + empleados.getApellido() + "\n";
					pw.print(linea);
					linea = "Correo electronico del empleado: " + empleados.getEmail() + "\n";
					pw.print(linea);
					linea = "Avatar del usuario: " + empleados.getAvatar() + "\n";
					pw.print(linea);

			}
			pw.close();
			bw.close();
			fw.close();
			
		} 
		catch (IOException e) {
			System.out.println("Error al escribir el fichero");
		}
		
		
	}
	private static Empleado crearEmpleado() {
		String id = pedirId();
		String nombre = pedirNombre();
		String apellido = pedirApellido();
		String correo_e = pedirCorreo();
		String avatar = pedirRutaAvatar();
		Empleado departamento = new Empleado(id, nombre, apellido, correo_e, avatar);
		return departamento;
	}
	private static String pedirCorreo() {
		System.out.print("Introduce el correo electrónico: ");
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	private static String pedirRutaAvatar() {
		System.out.print("Introduce la ruta del avatar: ");
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	private static String pedirApellido() {
		System.out.print("Introduce el apellido del empleado: ");
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	private static String pedirNombre() {
		System.out.print("Introduce el nombre del empleado: ");
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	private static String pedirId() {
		System.out.print("Introduce el id del empelado: ");
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	private static String pedirRuta() {
		System.out.print("Introduce la ruta del fichero: ");
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	private static int pedirOpcion() {
		System.out.print("Elige una opción: ");
		Scanner sc = new Scanner (System.in);
		return sc.nextInt();
	}
	private static void escribirMenu() {
		System.out.println("\nGESTOR DE EMPLEADOS"
				+ "\n1. Leer empleados"
				+ "\n2. Añadir empleado"
				+ "\n3. Eliminar empleado"
				+ "\n4. Modificar empleado"
				+ "\n5. Exportar empleados"
				+ "\n6. Mostrar empleados"
				+ "\n0. Salir");
	}

}