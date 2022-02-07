package com.liceolapaz.des.npb;

public class Pentagono implements FiguraGeometrica {
	private double apotema;
	private double lado;
	
	public Pentagono(double apotema, double lado) {
		super();
		this.apotema = apotema;
		this.lado = lado;
	}

	@Override
	public double CalcularArea() {
		return (CalcularPerimetro() * apotema)/2;
	}

	@Override
	public double CalcularPerimetro() {
		return lado * 5;
	}

}
