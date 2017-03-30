package ar.edu.usal.programacion.tp1;

public class Peones {
	
	private String nombre;
	private long cuil;
	private double costo;
	
	public Peones() {};
	
	public Peones(String nombre, long cuil, double costo) {
		
		this.nombre = nombre;
		this.cuil = cuil;
		this.costo = costo;
		
	};
	
	public String getNombre() {
		
		return nombre;
		
	};
	
	public long getCuil() {
		
		return cuil;
		
	};
	
	public double getCosto() {
		
		return costo;
		
	};
	
	public void setNombre(String nombre) {
		
		this.nombre = nombre;
		
	};
	
	public void setCuil(long cuil) {
		
		this.cuil = cuil;
		
	};
	
	public void setCosto(double costo) {
		
		this.costo = costo;
		
	};

}
