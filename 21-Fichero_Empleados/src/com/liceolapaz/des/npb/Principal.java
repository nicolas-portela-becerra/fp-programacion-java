package com.liceolapaz.des.npb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Spliterator;

public class Principal {
	private static HashMap<String, Empleado> empleados = new HashMap<>();
	
	public static void main(String[] args) {
		while(true) {
			escribirMenu();
			pedirOpcion();
			int opcion = leerOpcion();
			
			switch(opcion) {
				default:
					System.out.println("Opción no válida");
				break;
				
				case 0:
					System.exit(0);
				break;
				
				//Leer empleados
				case 1:
					String ruta = pedirRuta();
					leerEmpleados(ruta);
				break;
			}
		}
	}
	
	private static void leerEmpleados(String ruta) {
		File fichero = new File(ruta);
		
		if(fichero.isFile()) {
			try {
				Scanner sc = new Scanner (fichero);
				//C:\\Users\\Nicolas\\Downloads\\empleados.sql
				//Como en este caso queremos descartar la primera linea del fichero la leemos con el if y se descarta, luego en el while empezamos a guardar
				if(sc.hasNext()) {
					sc.nextLine();
					while(sc.hasNext()) {
						String linea = sc.nextLine();
						String [] columnas = linea.split(",");
						String dni = columnas[0].substring(2, 11);
						//System.out.println(dni);
						String nombre = columnas[1].substring(2, columnas[1].length()-1);
						//System.out.println(nombre);
						String primerApellido = columnas[2].substring(2, columnas[2].length()-1);
						//System.out.println(primerApellido);
						String segundoApellido = null;
						if(!columnas[3].equalsIgnoreCase(" NULL")) {
							segundoApellido = columnas[3].substring(2, columnas[3].length()-1);
						}
						//System.out.println(segundoApellido);
						String fecha = columnas[4].substring(2, columnas[4].length()-1);
						Date fechaNacimiento = null;
						try {
							fechaNacimiento = new SimpleDateFormat("yyyy/MM/dd").parse(fecha);
						} 
						catch (ParseException e) {
							System.out.println("La fecha no tiene el formato correcto, utiliza: yyyy/MM/dd");
							continue;
						}
						//System.out.println(fechaNacimiento);
						String salarioString = columnas[5].substring(2, columnas[5].length()-1);
						double salario = 0;
						try {
							salario = Double.parseDouble(salarioString);
						} catch (NumberFormatException e) {
							System.out.println("El salario no tiene el formato correcto");
						}
						//System.out.println(salario);
						String stringDepartamento = columnas[6].substring(1);
						int numeroDepartamento = Integer.parseInt(stringDepartamento);
						//System.out.println(numeroDepartamento);
						String dniJefe = null;
						if(!columnas[7].equalsIgnoreCase(" NULL)")) {
							dniJefe = columnas[7].substring(2, columnas[7].length()-2);
						}
						//System.out.println(dniJefe);
						
						Empleado empleado = new Empleado(dni, nombre, primerApellido, segundoApellido, fechaNacimiento, salario, 
															numeroDepartamento, dniJefe);
						//System.out.println(empleado.toString());
						
						//Añadir los empleados al HashMap
						empleados.put(dni, empleado);
					}
				}
			} 
			catch (FileNotFoundException e) {
				System.out.println("Archivo no encontrado " + e);
			}
		}
		else {
			System.out.println("La ruta, " + ruta + "no es un fichero.");
		}			
	}

	private static String pedirRuta() {
		System.out.print("Introduce la ruta del fichero: ");
		Scanner sc = new Scanner (System.in);
		return sc.nextLine();
	}
	private static int leerOpcion() {
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}

	private static void pedirOpcion() {
		System.out.print("Elige una opción: ");
		
	}

	private static void escribirMenu() {
		System.out.println("\nGESTOR DE EMPLEADOS"
				+ "\n1. Leer empleados"
				+ "\n2. Añadir empleado"
				+ "\n3. Eliminar empleado"
				+ "\n4. Modificar empleado"
				+ "\n5. Exportar empleados"
				+ "\n0. Salir");
	}
}
