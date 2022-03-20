package com.liceolapaz.des.npb;

public class Matriz {

	private double matriz [] [];
	
	//Constructor de la clase
	public Matriz(double [][] matriz) {
		super();
		this.matriz = matriz;
	}

	//Mostrar la matriz
	public String toString() {
		String matriz_str = "";
		
		for(int i = 0; i < this.matriz.length; i++) {
			matriz_str += "( ";
			for(int j = 0; j < this.matriz[i].length; j++) {
				
				matriz_str += this.matriz[i][j] + " ";
			}
			matriz_str += ")\n";
		}
		return matriz_str;
	}
	
	//Sumar matriz con otra matriz
	public Matriz sumarMatriz(Matriz operando) {
		Matriz resultado;
		double help [] [] = new double [matriz.length][matriz[0].length];
		
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				help [i][j] = this.matriz[i][j] + operando.getMatriz(i,j);
			}
		}
		resultado = new Matriz(help);
		return resultado;
	}
	
	//Multiplicar matriz con otra matriz
	public Matriz multiplicarMatriz(Matriz operando) {
		//El numero de columnas de la primera matriz(matriz[0].length) y el numero de columnas de la segunda matriz(operando.matriz.length)
		//Condición para poder realizar la multiplicacion
		if(matriz[0].length == operando.matriz.length) {
			Matriz resultado;
			//La matriz resultante de la multiplicacion tiene de dimensiones las filas de la primera matriz y las columnas de la segunda
			double matriz_multiplicada [] [] = new double [matriz.length][operando.matriz[0].length];					
			
			//Bucles para acceder a las posiciones necesarias para la multiplicacion
			for(int i = 0; i < matriz.length; i++) {
				for(int j = 0; j < operando.matriz[0].length; j++) {
					for(int k = 0; k < matriz[0].length; k++) {
						//Aqui es donde se hace la multiplicacion
						matriz_multiplicada [i][j] += matriz[i][k] * operando.getMatriz(k, j);
					}
				}
			}
			resultado = new Matriz(matriz_multiplicada);
			return resultado;
		}
		return null;
	}
	
	//Multiplicar matriz con un numero
	public Matriz multiplicarEscalar(double escalar) {
		Matriz resultado;
		double temp [] [] = new double [matriz.length][matriz[0].length];
		
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				temp [i][j] = this.matriz[i][j] * escalar;
			}
		}
		resultado = new Matriz(temp);
		return resultado;
	}
	
	//Determinante
    public double Determinante() {
        double det = 0;
        double matriz [][] = this.matriz;
        if (matriz.length == 1) {
            return matriz[0][0];
 
        } else {
            for (int j = 0; j < matriz.length; j++) {
                det = det + matriz[0][j] * Cofactor(matriz, 0, j);
            }
        }
 
        return det;
    }
    
    //Subamtriz para el determinante
    public double Cofactor(double matriz[][], int fila, int columna) {
    	
    	//matriz para almacenar la adjunta
        double submatriz[][] = new double[matriz.length - 1][matriz.length - 1];
        //Variables para movernos entre las filas y columnas de la matriz
        int x = 0;
        int y = 0;
        
        //Se recorre la matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
            	//Se comprueba con i y j que no coincida con la posicion de la matriz grande que estamos cogiendo para buscar las matrices adjuntas
                if (i != fila && j != columna) {
                	//Se rellana la submatriz con los elementos que nos interesan de la matriz principal
                    submatriz[x][y] = matriz[i][j];
                    //Se aumenta la Y para almacenar informacion en la siguiente posicion
                    y++;
                    //Cuando se llega al final de la longitud de la columna entra en el IF
                    if (y >= matriz.length - 1) {
                    	//Aumenta la fila a la que va a acceder
                        x++;
                        //Resetea el acceso a las columnas a 0 para rellenar la siguiente fila
                        y = 0;
                    }
                }
            }
        }
        Matriz matriz_submatriz = new Matriz(submatriz);
        //La potencia es parte de la formula para saber si el signo ha de ser positivo o neagativo
        return Math.pow(-1.0, fila + columna) * matriz_submatriz.Determinante();
    }
    
    //Hacer la inversa de una matriz
    public Matriz invertirMatriz() {
    	//Creo las variables que voy a necesitar para hacer la inversa
    	Matriz temp = new Matriz(this.matriz);
    	double aux [] [] = new double [this.matriz.length][this.matriz[0].length];
    	
    	//Hago el determinante porque lo necesitaré luego, para ello necesitaba un objeto de tipo Matriz para llamar a la funcion Determinante
    	double determinante = temp.Determinante();
    	
    	//Recorro la matriz
    	for(int i = 0; i < this.matriz.length; i++) {
    		for(int j = 0; j < this.matriz[0].length; j++) {
    			//Llamando a cofactor estoy creando la matriz de determinantes, cada iteracion el bucle me da un determinante de una submatriz 
    			//que tiene como referencia [i][j] y la coloca en la matriz aux que cree para almacenar la matriz nueva que se va creando
    			aux [i][j] = Cofactor(this.matriz, i, j);
    		}
    	}
    	//Recorro la matriz
    	for(int x = 0; x < aux.length; x++) {
    		for(int y = 0; y < aux[0].length; y++) {
    			//Divido cada posicion de la matriz entre el determinant y coloco el resultado en la posición
    			aux[x][y] = aux[x][y] / determinante;
    		}
    	}
    	//Instancio un objeto de tipo Matriz con el array aux ya divido entre el determinante
    	Matriz resultado = new Matriz(aux);
    	//Devuelvo la Matriz resultado traspuesta
    	//resultado = resultado.Traspuesta();
    	return resultado.Traspuesta();
    }
	
	//Hacer la traspuesta
	public Matriz Traspuesta() {
		double traspuesta [] [] = new double [this.matriz[0].length] [this.matriz.length];
		
		//Recorro la matriz
		for(int i = 0; i < this.matriz.length; i++) {
			for(int j = 0; j < this.matriz[0].length; j++) {
				//Se cambian las filas por las columnas
				traspuesta[j][i] = this.matriz[i][j];
			}
		}
		Matriz resultado = new Matriz(traspuesta);
		return resultado;
	}
	
	//Metodo GETTER para sacar las posiciones de la matriz operando
	public double getMatriz(int i, int j) {
		return matriz [i][j];
	}
}	
	