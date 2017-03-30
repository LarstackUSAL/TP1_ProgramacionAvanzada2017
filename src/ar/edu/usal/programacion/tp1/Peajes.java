package ar.edu.usal.programacion.tp1;

public class Peajes {
	
	private String lugar;
	private double importe;
	
	public Peajes() {};
	
	public Peajes(String lugar, double importe) {
		
		this.lugar = lugar;
		this.importe = importe;
		
	};
	
	public String getLugar() {
		
		return lugar;
		
	};
	
	public double getImporte() {
		
		return importe;
		
	};
	
	public void setLugar(String lugar) {
		
		this.lugar = lugar;
		
	};
	
	public void setImporte(double importe) {
		
		this.importe = importe;
		
	};

}
