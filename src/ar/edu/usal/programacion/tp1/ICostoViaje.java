package ar.edu.usal.programacion.tp1;


public interface ICostoViaje {
	
	double descuentoEfectivo = 0.05;
	double incrementoSuperaKm = 0.015;
	int distanciaMax = 1000;
	int incrementoCadaKm = 150;	
	
	double calcularCostoTotal();
	
}
