package com.liceolapaz.des.npb;

public class Triangulo implements FiguraGeometrica {
	private double lado1;
	private double lado2;
	private double lado_base;
	private double altura;
	
	public Triangulo(double lado1, double lado2, double lado_base, double altura) {
		super();
		this.lado1 = lado1;
		this.lado2 = lado2;
		this.lado_base = lado_base;
		this.altura = altura;
	}

	@Override
	public double CalcularArea() {
		return (lado_base * altura)/2;
	}

	@Override
	public double CalcularPerimetro() {
		return lado1 + lado2 + lado_base;
	}

}
