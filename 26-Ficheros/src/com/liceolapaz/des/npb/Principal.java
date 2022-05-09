package com.liceolapaz.des.npb;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Principal {
	private static HashMap<String, Departamento> departamentos = new HashMap<>();
	
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
					//ruta D:\\DAM\\Programacion\\26-Ficheros\\departamentos.csv
					String ruta = pedirRuta();
					File fichero = new File(ruta);
					if(fichero.isFile()) {
						try {
							Scanner lector = new Scanner(fichero);
							//Elimino la primera linea porque no contiene infomacion necesaria
							if(lector.hasNext()) {
								lector.nextLine();
							}
							while(lector.hasNext()){
								int planta;
								String num_departamento, nombre, nombre_corto, cif_director, correo_e;
								
								String linea = lector.nextLine();
								String [] lineaArray = linea.split(";"); 
								
								num_departamento = lineaArray[0];
								//System.out.println(num_departamento);
								nombre = lineaArray[1];
								//System.out.println(nombre);
								nombre_corto = lineaArray[2];
								//System.out.println(nombre_corto);
								planta = Integer.parseInt(lineaArray[3]);
								//System.out.println(planta);
								cif_director = lineaArray[4];
								//System.out.println(cif_director);
								correo_e = lineaArray[5];
								//System.out.println(correo_e);
								//System.out.println();
								
								Departamento departamento = new Departamento(num_departamento, nombre, nombre_corto, 
																				planta, cif_director, correo_e);
								departamentos.put(num_departamento, departamento);
							}
						} 
						catch (FileNotFoundException e) {
							System.out.println("Archivo no encontrado");
						}
					}
				break;
				
				case 2:
					Departamento nuevoDepartamento = crearDepartamento();
					if(nuevoDepartamento != null) {
						if(departamentos.containsKey(nuevoDepartamento.getNum_departamento())){
							System.err.println("Ya existe ese departamento.");
							continue;
						}
						departamentos.put(nuevoDepartamento.getNum_departamento(), nuevoDepartamento);
					}
				break;
				
				case 3:
					String num = pedirNumDepartamento();
					if(!departamentos.containsKey(num)) {
						System.err.println("No existe ese nombre");
					}
					departamentos.remove(num);
					System.out.println("Departamento eliminado.");
				break;
				
				case 4: 
					Departamento departamentoModificado = crearDepartamento();
					num = departamentoModificado.getNum_departamento();
					if(!departamentos.containsKey(num)) {
						System.out.println("El departamento no existe");
						continue;
					}
					departamentos.replace(departamentoModificado.getNum_departamento(), departamentoModificado);
					System.out.println(departamentos.toString());
				break;
				
				case 5: 
					ruta = pedirRuta();
					exportarEmpleados(ruta);
				break;
				
				case 6:
					System.out.println(departamentos.toString());
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
			
			for(Departamento departamentos : departamentos.values()) {
					linea = "=========================\n";
					pw.print(linea);
					linea = "Numero de departamento: " + departamentos.getNum_departamento() + "\n";
					pw.print(linea);
					linea = "=========================\n";
					pw.print(linea);
					linea = "Nombre de departamento: " + departamentos.getNombre() + "\n";
					pw.print(linea);
					linea = "Abreviatura del departamento: " + departamentos.getNombre_corto() + "\n";
					pw.print(linea);
					linea = "Planta del departamento: " + departamentos.getPlanta() + "\n";
					pw.print(linea);
					linea = "Cif del director del departamento: " + departamentos.getCif_director() + "\n";
					pw.print(linea);
					linea = "Correo electronico del departamento: " + departamentos.getCorreo_e() + "\n";
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
	private static Departamento crearDepartamento() {
		String num_departamento = pedirNumDepartamento();
		int planta = pedirPlanta();
		String nombre = pedirNombre();
		String nombre_corto = pedirNombreCorto();
		String cif_director = pedirCif();
		String correo_e = pedirCorreo();
		Departamento departamento = new Departamento(num_departamento, nombre, nombre_corto, planta, cif_director, correo_e);
		return departamento;
	}
	private static String pedirCorreo() {
		System.out.print("Introduce el correo electrónico: ");
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	private static String pedirCif() {
		System.out.print("Introduce el CIF del jefe: ");
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	private static String pedirNombreCorto() {
		System.out.print("Introduce el nombre corto del departamento: ");
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	private static String pedirNombre() {
		System.out.print("Introduce el nombre del departamento: ");
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}
	private static int pedirPlanta() {
		System.out.print("Introduce el número de planta: ");
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	private static String pedirNumDepartamento() {
		System.out.print("Introduce el número de departamento: ");
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
				+ "\n1. Leer departamento"
				+ "\n2. Añadir departamento"
				+ "\n3. Eliminar departamento"
				+ "\n4. Modificar departamento"
				+ "\n5. Exportar departamento"
				+ "\n6. Mostrar departamentos"
				+ "\n0. Salir");
	}

}
