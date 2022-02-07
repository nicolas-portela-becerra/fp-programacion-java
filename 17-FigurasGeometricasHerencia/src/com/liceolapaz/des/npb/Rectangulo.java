package com.liceolapaz.des.npb;

public class Rectangulo implements FiguraGeometrica{
	private double lado;
	private double base;
	
	public Rectangulo(double lado, double base) {
		super();
		this.lado = lado;
		this.base = base;
	}
	
	@Override
	public double CalcularArea() {
		return base * lado;
	}

	@Override
	public double CalcularPerimetro() {
		return base * 2 + lado * 2;
	}

}
