package ar.edu.usal.programacion.tp1;

public class ViajesCorta extends Viajes {

	private char formaPago;

	public ViajesCorta() {};
	
	public ViajesCorta(char formaPago) {
		
		this.formaPago = formaPago;
		
	};

	public char getFormaPago() {
		
		return formaPago;
		
	};

	public void setFormaPago(char formaPago) {
		
		this.formaPago = formaPago;
		
	};
	
}
