package com.liceolapaz.des.npb;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
					//Ruta: D:\\DAM\\Programacion\\Ficheros2\\listado.txt
					String ruta = pedirRuta();
					leerFichero(ruta);
				break;
				
				case 2:
					Empleado nuevoEmpleado = crearEmpleado();
					if (nuevoEmpleado != null) {
						String dni = nuevoEmpleado.getDni();
						if (empleados.containsKey(dni)) {
							System.err.println("El empleado con DNI " + dni + " ya existe");
							continue;
						}
						empleados.put(dni, nuevoEmpleado);
						System.out.println(empleados);
					}
				break;
				
				case 3:
					
					
				break;
				
				case 4:
				
				break; 
				
				case 5: 
					
				break;
			}
		}
	}

	private static Empleado crearEmpleado() {
		String dni = pedirDni();
		String nombre = pedirNombre();
		String apellido1 = pedirApellido1();
		String apellido2 = pedirApellido2();
		String dniJefe = pedirDniJefe();
		Date fechaNacimiento = pedirFecha();
		double salario = pedirSalario();
		int numDepartamento = pedirNumDepartamento();
		
		Empleado empleado = new Empleado(dni, nombre, apellido1, apellido2, fechaNacimiento, salario, numDepartamento, dniJefe);
		return empleado;
	}
	
	private static int pedirNumDepartamento() {
		System.out.print("Introduce el numero de departamento: ");
		int numDepartamento = leerInt();
		return numDepartamento;
	}

	private static int leerInt() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	private static double pedirSalario() {
		System.out.print("Introduce el salario: ");
		double salario = leerDouble();
		return salario;
	}
	
	private static Date pedirFecha() {
		System.out.println("Introduce la fecha de nacimiento (dd/MM/yyyy): ");
		String fechaNacimientoString = leerString();
		Date fechaNacimiento = null;
		try {
			fechaNacimiento = new SimpleDateFormat("dd/MM/yyyy").parse(fechaNacimientoString);
		} 
		catch (ParseException e) {
			System.out.println("Formato de fecha incorrecto (dd/MM/yyyy)");
		}
		return fechaNacimiento;
	}

	private static String pedirDniJefe() {
		System.out.print("Introduce dni del jefe: ");
		String dniJefe = leerString();
		return dniJefe;
	}

	private static String pedirApellido2() {
		System.out.print("Introduce segundo apellido: ");
		String apellido2 = leerString();
		return apellido2;
	}

	private static String pedirApellido1() {
		System.out.print("Introduce primer apellido: ");
		String apellido1 = leerString();
		return apellido1;
	}

	private static String pedirNombre() {
		System.out.print("Introduce nombre: ");
		String nombre = leerString();
		return nombre;
	}

	private static String pedirDni() {
		System.out.print("Introduce dni: ");
		String dni = leerString();
		return dni;
	}

	private static double leerDouble() {
		Scanner sc = new Scanner(System.in);
		return sc.nextDouble();
	}

	private static String leerString() {
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}

	private static void leerFichero(String ruta) {
		File fichero = new File(ruta);
		
		if(fichero.isFile()) {
			Scanner lector;
			try {
				lector = new Scanner(fichero);
				if(lector.hasNext()) {
					Date fecha = null;
					String fechaString;
					String hora;
					int numEmpleados;
					
					fechaString = cogerInfoUnEspacio(lector);
					try {
						fecha = new SimpleDateFormat("dd/MM/yyyy").parse(fechaString);
					} 
					catch (ParseException e) {
						System.err.println("La fecha tiene que estar en formato dd/MM/yyyy");
					}
					//System.out.println(fecha);

					hora = cogerInfoUnEspacio(lector);
					//System.out.println(hora);
					
					numEmpleados = Integer.parseInt(cogerInfoTresEspacios(lector));
					//System.out.println(numEmpleados);
					
					for(int i = 1; i < numEmpleados; i++) {
						System.out.println("Empleado " + i);
						lector.nextLine();
						lector.nextLine();
						lector.nextLine();
						String dni, nombre, apellido1, apellido2;
						Date fechaNacimiento = null;
						String fechaNacimientoString;
						float salario;
						int numDepartamento;
						String dniJefe;
						
						dni = cogerInfoUnEspacio(lector);
						//System.out.println(dni);
						
						nombre = cogerInfoUnEspacio(lector);
						//System.out.println(nombre);
						
						apellido1 = cogerInfoDosEspacios(lector);
						//System.out.println(apellido1);
						
						apellido2 = cogerInfoDosEspacios(lector);
						//System.out.println(apellido2);
						
						fechaNacimientoString = cogerInfoTresEspacios(lector);
						try {
							fecha = new SimpleDateFormat("yyyy/MM/dd").parse(fechaNacimientoString);
						}
						catch (ParseException e) {
							System.out.println("La fecha tiene que estar en formato yyyy/MM/dd");
						}
						//System.out.println(fechaNacimiento);
						
						salario = Float.parseFloat(cogerInfoUnEspacio(lector));
						//System.out.println(salario);
						
						numDepartamento = Integer.parseInt(cogerInfoTresEspacios(lector));
						//System.out.println(numDepartamento);
						
						dniJefe = cogerInfoDosEspacios(lector);
						//System.out.println(dniJefe);
						
						Empleado empleado = new Empleado(dni, nombre, apellido1, apellido2, fechaNacimiento, 
															salario, numDepartamento, dniJefe);
						empleados.put(dni, empleado);
					}
				}
			} 
			catch (FileNotFoundException e) {
				System.out.println("Archivo no encontrado");
			}
		}
	}

	private static String cogerInfoTresEspacios(Scanner lector) {
		String linea = lector.nextLine();
		String datos [] = linea.split(" ");
		return datos[3];
	}

	private static String cogerInfoDosEspacios(Scanner lector) {
		String linea = lector.nextLine();
		String datos [] = linea.split(" ");
		return datos[2];
	}

	private static String cogerInfoUnEspacio(Scanner lector) {
		String linea = lector.nextLine();
		String datos [] = linea.split(": ");
		return datos[1];
	}

	private static String pedirRuta() {
		System.out.print("Introduce la ruta del archivo: ");
		Scanner sc = new Scanner (System.in);
		return sc.next();
	}

	private static int pedirOpcion() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	private static void escribirMenu() {
				System.out.println("\nGESTOR DE EMPLEADOS"
						+ "\n1. Leer empleados"
						+ "\n2. Añadir empleado"
						+ "\n3. Eliminar empleado"
						+ "\n4. Modificar empleado"
						+ "\n5. Exportar empleados"
						+ "\n0. Salir");
				System.out.print("Elige una opción: ");
	}

}
