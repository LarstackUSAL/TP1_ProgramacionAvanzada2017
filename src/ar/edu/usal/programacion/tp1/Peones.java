package ar.edu.usal.programacion.tp1;

public class Peones {
	
	private String nombre;
	private String cuil;
	private double costo;
	private double totalCobrado; 
	
	public Peones() {};
	
	public Peones(String nombre, String cuil, double costo) {
		
		this.nombre = nombre;
		this.cuil = cuil;
		this.costo = costo;
		
	};
	
	public String getNombre() {
		
		return nombre;
		
	};
	
	public double getCosto() {
		
		return costo;
		
	};
	
	public void setNombre(String nombre) {
		
		this.nombre = nombre;
		
	};
	
	public void setCosto(double costo) {
		
		this.costo = costo;
		
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	public double getTotalCobrado() {
		return totalCobrado;
	}

	public void setTotalCobrado(double totalCobrado) {
		this.totalCobrado = totalCobrado;
	};

}
