package ar.edu.usal.programacion.tp1;

public final class Camiones {
	
	private String patente;
	private int anioPatentamiento;
	private double capacidad;
	private boolean disponible;
	
	public Camiones() {};
	
	public Camiones(String patente, int anioPatentamiento, double capacidad, boolean disponible) {
		
		this.patente = patente;
		this.anioPatentamiento = anioPatentamiento;
		this.capacidad = capacidad;
		this.disponible = disponible;
		
	};

	public String getPatente() {
	
		return patente;
		
	};

	public int getAnioPatentamiento() {
		
		return anioPatentamiento;
		
	};

	public double getCapacidad() {
		
		return capacidad;
		
	};

	public boolean isDisponible() {
		
		return disponible;
	
	};

	public void setPatente(String patente) {
		
		this.patente = patente;
		
	};

	public void setAnioPatentamiento(int anioPatentamiento) {
		
		this.anioPatentamiento = anioPatentamiento;
		
	};

	public void setCapacidad(double capacidad) {
		
		this.capacidad = capacidad;
		
	};

	public void setDisponible(boolean disponible) {
		
		this.disponible = disponible;
		
	};

}
