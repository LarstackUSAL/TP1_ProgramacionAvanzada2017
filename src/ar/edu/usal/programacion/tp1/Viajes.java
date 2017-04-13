package ar.edu.usal.programacion.tp1;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class Viajes implements ICostoViaje{
	
	protected int nroViaje;
	protected Calendar fechaPartida;
	protected double peso;
	protected Peones[] peones = new Peones[EmpresaDistribucion.MAX_PEONES];
	protected boolean requiereCustodiaSatelital;
	protected double costo;
	protected Camiones vehiculo;
	protected ArrayList<Peajes> peajes = new ArrayList();
	
	private static int nextIdViaje = 1;
	
	public Viajes() {}

	public Viajes(int nroViaje, Calendar fechaPartida, double peso,
			Peones[] peones, boolean requiereCustodiaSatelital, double costo,
			Camiones vehiculo) {
		
		this.nroViaje = nroViaje;
		this.fechaPartida = fechaPartida;
		this.peso = peso;
		this.peones = peones;
		this.requiereCustodiaSatelital = requiereCustodiaSatelital;
		this.costo = costo;
		this.vehiculo = vehiculo;
	}
	
	public static int getNextIdViaje() {

		int idReturn = nextIdViaje;
		nextIdViaje++;

		return idReturn;
	}
	
	public int getNroViaje() {
		
		return nroViaje;
		
	}

	public Calendar getFechaPartida() {
		
		return fechaPartida;
		
	}

	public double getPeso() {
		
		return peso;
		
	}

	public Peones[] getPeones() {
		
		return peones;
		
	}

	public double getCosto() {
		
		return costo;
		
	}

	public Camiones getVehiculo() {
		
		return vehiculo;
		
	}

	public void setNroViaje(int nroViaje) {
		
		this.nroViaje = nroViaje;
		
	}

	public void setFechaPartida(Calendar fechaPartida) {
		
		this.fechaPartida = fechaPartida;
	
	}

	public void setPeso(double peso) {
		
		this.peso = peso;
		
	}

	public void setPeones(Peones[] peones) {
		
		this.peones = peones;
		
	}

	public void setCosto(double costo) {
		
		this.costo = costo;
		
	}

	public void setVehiculo(Camiones vehiculo) {
		
		this.vehiculo = vehiculo;
		
	}
	
	public ArrayList<Peajes> getPeajes() {
		return peajes;
	}

	public boolean isRequiereCustodiaSatelital() {
		return requiereCustodiaSatelital;
	}

	public void setRequiereCustodiaSatelital(boolean requiereCustodiaSatelital) {
		this.requiereCustodiaSatelital = requiereCustodiaSatelital;
	}

	public abstract double calcularCostoTotal();

	public void agregarPeaje() {
		
		peajes.add(new Peajes(Validador.insertString("Ingresar localidad: "), 
				Validador.insertDouble("Ingresar importe peaje: ", true)));
		
	}

}
