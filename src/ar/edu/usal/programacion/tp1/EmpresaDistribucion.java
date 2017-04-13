package ar.edu.usal.programacion.tp1;

import java.util.ArrayList;
import java.util.Scanner;

public class EmpresaDistribucion {

	public static final int MAX_PEONES = 5;
	public static final int MAX_CAMIONES = 10;

	private static int cantidadViajesCortaDistancia = 0;

	public static void main(String[] args) {

		ControladorEmpresaDistribucion ced = new ControladorEmpresaDistribucion();

		Camiones[] camiones = new Camiones[MAX_CAMIONES];
		Peones[] peones = new Peones[MAX_PEONES];
		ced.loadDatosPeones(peones);

		ArrayList<Viajes> viajesList = new ArrayList();

		Scanner s = new Scanner(System.in);
		boolean salirDelSistema = false;

		do {

			System.out.println();
			System.out.println("Elegir una opcion: ");
			System.out.println("1 - Cargar camiones.");
			System.out.println("2 - Cargar viajes.");
			System.out.println("3 - Modificar viaje.");
			System.out.println("4 - Registrar llegada a destino.");
			System.out.println("5 - Mostrar viajes que superan valor al azar.");		
			System.out.println("6 - Mostrar cantidad de viajes corta distancia.");
			System.out.println("7 - Valor total y cantidad de viajes ultimo bimestre - Cheque.");
			System.out.println("8 - Mostrar viajes que pasaron por una localidad.");
			System.out.println("9 - Mostrar numeros de patente no asignados.");
			System.out.println("10 - Mostrar viajes de cada peon.");
			System.out.println("0 - Salir del sistema.");

			int opcion = 0;

			if(s.hasNextInt()) {

				opcion = s.nextInt();

				switch(opcion) {

				case 1:
					ced.cargarCamiones(camiones);
					break;
				case 2:
					ced.cargarViajes(viajesList, camiones, peones);
					break;
				case 3:
					ced.modificarViaje(viajesList, camiones, peones);
					break;
				case 4:
					ced.registrarLlegada(viajesList);
					break;
				case 5:
					ced.mostrarViajesValorAlAzar(viajesList);
					break;
				case 6:
					ced.mostrarCantidadViajesCortaDistancia();
					break;
				case 7:
					ced.mostrarValorCantidadViajesBimestreCheque(viajesList);
					break;
				case 8:
					ced.mostrarViajePasaronPorLocalidad(viajesList);
					break;
				case 9:
					ced.mostrarNumerosPatenteNoAsignado(viajesList, camiones, args);
					break;
				case 10:
					ced.mostrarViajesDeCadaPeon(peones, viajesList);
					break;
				case 0:
					System.out.println("SALISTE DEL SISTEMA. HASTA LUEGO.");
					salirDelSistema = true;
					break;

				default:
					System.out.println("LA OPCION INGRESADA ES INVALIDA.");
					break;

				}

			} else {
				s.nextLine();
				System.out.println("LA OPCION INGRESADA ES INVALIDA.");

			}

		} while(!salirDelSistema);

		s.close();
	}

	public static int getCantidadViajesCortaDistancia() {
		return cantidadViajesCortaDistancia;
	}

	public static void incrementarCantidadViajesCortaDistancia() {
		cantidadViajesCortaDistancia++;
	}

}
