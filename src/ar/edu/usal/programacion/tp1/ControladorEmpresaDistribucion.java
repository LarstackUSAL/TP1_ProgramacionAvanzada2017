package ar.edu.usal.programacion.tp1;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ControladorEmpresaDistribucion {

	public void loadDatosPeones(Peones[] peones) {

		Peones peon0 = new Peones("Juan", "001123456780", 550.0);
		Peones peon1 = new Peones("Pablo", "002123456781", 520.0);
		Peones peon2 = new Peones("Jose", "003123456782", 520.0);
		Peones peon3 = new Peones("Enrique", "004123456783", 400.0);
		Peones peon4 = new Peones("Nico", "005123456784", 400.0);

		peones[0] = peon0;
		peones[1] = peon1;
		peones[2] = peon2;
		peones[3] = peon3;
		peones[4] = peon4;
	}

	public void cargarCamiones(Camiones[] camiones) {

		boolean hayEspacio = true;
		boolean cargarOtro;

		do{
			cargarOtro = false;
			if(Validador.hayEspacioDisponible(camiones)){

				System.out.println();
				System.out.println("INFORMACION CAMION:");
				String patente = Validador.insertString("Ingresar patente: ");
				int anioPatentamiento = Validador.insertAnio("Ingresar año (AAAA): ","TIENE ANTIGUEDAD MAYOR A 3 AÑOS.", 3);
				double capacidad = Validador.insertDouble("Ingresar Capacidad: ", true);

				Camiones camion = new Camiones(patente, anioPatentamiento, capacidad, true);

				Validador.insertarEnArray(camiones, camion);

				System.out.println();
				cargarOtro = Validador.insertBooleanSyN("Cargar datos de otro camion? (s/n): ");

			}else{
				System.out.println("YA SE HA CARGADO LA INFORMACION PARA LOS 10 CAMIONES.");
				hayEspacio = false;
			}
		}while(cargarOtro);
	}

	public void cargarViajes(ArrayList<Viajes> viajesList, Camiones[] camiones, Peones[] peones) {

		boolean cargarOtro;

		do{
			cargarOtro = false;


			if(!Validador.arrayVacio(camiones)){

				System.out.println();
				System.out.println("INFORMACION VIAJE:");

				boolean esLargaDistancia = Validador.insertBooleanSyN("Es un viaje de larga distancia? (s/n): ");

				//Calendar fechaPartida = Validador.insertFecha("FECHA DE PARTIDA");
				Calendar fechaPartida = Calendar.getInstance();

				double peso = Validador.insertDouble("Insertar el peso transportado(Kg): ", true);

				Peones[] peonesViaje = new Peones[EmpresaDistribucion.MAX_PEONES];				
				boolean ingresarPeones = Validador.insertBooleanSyN("Se quieren contratar peones? (s/n): ");
				if(ingresarPeones){

					boolean otroPeon;

					do{
						otroPeon = false;
						for (int i = 0; i < peones.length; i++) {
							System.out.println((i+1) + " - " + peones[i].getNombre() + " - " + peones[i].getCuil());
						}
						System.out.println();
						boolean peonOk;
						do{
							peonOk = false;
							String cuilPeon = Validador.insertString("Insertar CUIL del Peon a contratar: ");

							for (int i = 0; i < peones.length; i++) {

								if(cuilPeon.trim().equals(peones[i].getCuil().trim())){

									Validador.insertarEnArray(peonesViaje, peones[i]);
									System.out.println("SE HA CONTRATADO EL PEON CORRECTAMENTE.");
									peonOk = true;
									break;
								}
							}

							if(!peonOk) System.out.println("CUIL NO EXISTENTE.");

						}while(!peonOk);

						System.out.println();
						otroPeon = Validador.insertBooleanSyN("Contratar otro peon? (s/n): ");

					}while(otroPeon);
				}

				boolean custodiaSatelital = Validador.insertBooleanSyN("Se requiere custodia satelital? (s/n): ");

				double costo = Validador.insertDouble("Ingresar costo basico del viaje: ", true);

				for (int i = 0; i < camiones.length; i++) {

					if(camiones[i]!=null){

						System.out.println((i+1) + " - " + camiones[i].getPatente() + " - " + camiones[i].getCapacidad() 
								+ "Kg - " + (camiones[i].isDisponible() ? "DISPONIBLE" : "EN VIAJE/NO DISPONIBLE"));
					}
				}

				Camiones camionViaje = new Camiones();
				boolean patenteOk;
				boolean disponibleOk;
				boolean capacidadOk;

				do{

					patenteOk = false;
					disponibleOk = false;
					capacidadOk = false;

					String patenteCamion = Validador.insertString("Ingresar Patente Camion: ");

					for (int i = 0; i < camiones.length; i++) {

						if(camiones[i]!=null){

							if(camiones[i].getPatente().trim().equals(patenteCamion)){

								patenteOk = true;

								if(camiones[i].isDisponible()){

									disponibleOk = true;

									if(peso <= camiones[i].getCapacidad()){
										capacidadOk = true;
										camiones[i].setDisponible(false);
										camionViaje = camiones[i];
									}
								}

								break;
							}
						}
					}

					if(!patenteOk) System.out.println("PATENTE NO EXISTENTE.");
					else if(!disponibleOk) System.out.println("CAMION NO DISPONIBLE.");
					else if(!capacidadOk) System.out.println("EL PESO SUPERA LA CAPACIDAD DEL CAMION.");
				}while(!patenteOk || !disponibleOk || !capacidadOk);

				System.out.println();
				boolean ingresarPeajes = Validador.insertBooleanSyN("Se quiere ingresar Peajes? (s/n): ");
				ArrayList<Peajes> peajesList = new ArrayList<Peajes>();

				if(ingresarPeajes){

					boolean otroPeaje;
					do{
						otroPeaje = false;
						peajesList.add(new Peajes(Validador.insertString("Ingresar localidad: "), 
								Validador.insertDouble("Ingresar importe peaje: ", true)));

						otroPeaje = Validador.insertBooleanSyN("Agregar otro peaje? (s/n): ");

					}while(otroPeaje);
				}

				Viajes viaje;


				if(esLargaDistancia){

					double distancia = Validador.insertDouble("Ingresar distancia a recorrer: ", true);

					ArrayList<String> localidades = new ArrayList<>();

					boolean otraLocalidad;					
					do{
						otraLocalidad = false;

						localidades.add(Validador.insertString("Ingresar Localidad visitada: "));

						otraLocalidad = Validador.insertBooleanSyN("Se quiere ingresar otra localidad? (s/n): ");

					}while(otraLocalidad);

					viaje = new ViajesLarga(EmpresaDistribucion.getNextIdViaje(), fechaPartida, peso, peonesViaje, 
							custodiaSatelital, costo, camionViaje, peajesList, distancia, localidades);

				}else{

					boolean esEfectivo = Validador.insertBooleanSyN("Se abonarà en efectivo? (s/n): ");

					viaje = new ViajesCorta(EmpresaDistribucion.getNextIdViaje(), fechaPartida, peso, peonesViaje, 
							custodiaSatelital, costo, camionViaje, peajesList, esEfectivo);

					EmpresaDistribucion.incrementarCantidadViajesCortaDistancia();
				}

				System.out.println("Costo Total: " + viaje.calcularCostoTotal());

				viajesList.add(viaje);

				System.out.println();
				cargarOtro = Validador.insertBooleanSyN("Cargar otro viaje? (s/n): ");

			}else{
				System.out.println("NO SE HAN CARGADO DATOS DE CAMIONES.");
			}
		}while(cargarOtro);		
	}

	public void modificarViaje(ArrayList<Viajes> viajesList, Camiones[] camiones, Peones[] peones) {

		System.out.println("VIAJES: ");
		boolean hayViajes = false;

		for (int i = 0; i < viajesList.size(); i++) {
			System.out.println(viajesList.get(i).getNroViaje());
			hayViajes = true;
		}
		System.out.println();

		if(hayViajes){
			Viajes viajeParaModificar = null;
			boolean viajeOk;
			do{
				viajeOk = false;
				int nroViaje = Validador.insertInt("Insertar Numero Viaje: ", 1, null, false);

				for (int i = 0; i < viajesList.size(); i++) {

					if(nroViaje == viajesList.get(i).getNroViaje()){

						viajeOk = true;
						viajeParaModificar = viajesList.get(i);
						break;
					}
				}

				if(!viajeOk) System.out.println("NO EXISTE EL NUMERO DE VIAJE INGRESADO.");

			}while(!viajeOk);

			boolean modificarCamion = Validador.insertBooleanSyN("Modificar Vehiculo? (s/n): ");

			if(modificarCamion){

				System.out.println("Patente Vehiculo del viaje: " + viajeParaModificar.getVehiculo().getPatente());
				System.out.println();

				boolean hayCamionesDisponibles = false;
				for (int i = 0; i < camiones.length; i++) {

					if(camiones[i]!=null){

						System.out.println((i+1) + " - " + camiones[i].getPatente() + " - " + camiones[i].getCapacidad() 
								+ "Kg - " + (camiones[i].isDisponible() ? "DISPONIBLE" : "EN VIAJE/NO DISPONIBLE"));

						if(camiones[i].isDisponible()) hayCamionesDisponibles = true;
					}
				}

				if(hayCamionesDisponibles){
					Camiones camionViaje = new Camiones();
					boolean patenteOk;
					boolean disponibleOk;
					boolean capacidadOk;

					do{

						patenteOk = false;
						disponibleOk = false;
						capacidadOk = false;

						String patenteCamion = Validador.insertString("Ingresar Patente Camion: ");

						for (int i = 0; i < camiones.length; i++) {

							if(camiones[i]!=null){

								if(camiones[i].getPatente().trim().equals(patenteCamion)){

									patenteOk = true;

									if(camiones[i].isDisponible()){

										disponibleOk = true;

										if(viajeParaModificar.getPeso() <= camiones[i].getCapacidad()){
											capacidadOk = true;
											camiones[i].setDisponible(false);
											camionViaje = camiones[i];
										}
									}

									break;
								}
							}
						}

						if(!patenteOk) System.out.println("PATENTE NO EXISTENTE.");
						else if(!disponibleOk) System.out.println("CAMION NO DISPONIBLE.");
						else if(!capacidadOk) System.out.println("EL PESO SUPERA LA CAPACIDAD DEL CAMION.");
					}while(!patenteOk || !disponibleOk || !capacidadOk);

					viajeParaModificar.setVehiculo(camionViaje);
				}else{

					System.out.println("TODOS LOS CAMIONES ESTAN EN VIAJE/NO DISPONIBLES PARA SER ASIGNADOS.");
				}
			}

			boolean modificarPeones = Validador.insertBooleanSyN("Modificar Peones asignados? (s/n): ");

			if(modificarPeones){

				System.out.println("PEONES ASIGNADOS A ESTE VIAJE:");
				boolean hayPeonesAsignados = false;

				for (int i = 0; i < viajeParaModificar.getPeones().length; i++) {
					if(viajeParaModificar.getPeones()[i]!=null){
						System.out.println((i+1) + " - " + viajeParaModificar.getPeones()[i].getNombre() + " - " + viajeParaModificar.getPeones()[i].getCuil());
						hayPeonesAsignados = true;
					}
				}
				if(!hayPeonesAsignados) System.out.println("No hay peones asignados a este viaje.");
				System.out.println();

				boolean eliminarPeones = Validador.insertBooleanSyN("Se quiere remover algun peon asignado? (s/n): ");
				if(eliminarPeones){

					boolean otroPeon;					
					do{

						boolean peonOk;
						do{
							peonOk = false;
							String cuilPeon = Validador.insertString("Insertar CUIL del Peon a remover: ");

							for (int i = 0; i < viajeParaModificar.getPeones().length; i++) {

								if(viajeParaModificar.getPeones()[i]!=null && (cuilPeon.trim().equals(viajeParaModificar.getPeones()[i].getCuil().trim()))){

									viajeParaModificar.getPeones()[i] = null;
									System.out.println("SE HA REMOVIDO EL PEON CORRECTAMENTE.");
									peonOk = true;
									break;
								}
							}

							if(!peonOk) System.out.println("CUIL NO EXISTENTE.");

						}while(!peonOk);

						System.out.println();
						otroPeon = Validador.insertBooleanSyN("Remover otro peon? (s/n): ");

					}while(otroPeon);
				}

				boolean agregarPeones = Validador.insertBooleanSyN("Se quiere un nuevo peon? (s/n): ");

				if(agregarPeones){

					System.out.println("PEONES DE LA EMPRESA:");

					for (int i = 0; i < viajeParaModificar.getPeones().length; i++) {
						if(peones[i]!=null){
							System.out.println((i+1) + " - " + peones[i].getNombre() + " - " + peones[i].getCuil());
						}
					}
					boolean otroPeon = false;					
					do{
						if(Validador.hayEspacioDisponible(viajeParaModificar.getPeones())){
							otroPeon = false;
							boolean peonOk;
							do{
								peonOk = false;
								String cuilPeon = Validador.insertString("Insertar CUIL del Peon a contratar: ");

								for (int i = 0; i < peones.length; i++) {

									if(cuilPeon.trim().equals(peones[i].getCuil().trim())){

										Validador.insertarEnArray(viajeParaModificar.getPeones(), peones[i]);
										System.out.println("SE HA CONTRATADO EL PEON CORRECTAMENTE.");
										peonOk = true;
										break;
									}
								}

								if(!peonOk) System.out.println("CUIL NO EXISTENTE.");

							}while(!peonOk);

							System.out.println();
							otroPeon = Validador.insertBooleanSyN("Contratar otro peon? (s/n): ");
						}else{
							System.out.println("NO SE PUEDEN ASIGNAR MAS PEONES A ESTE VIAJE.");
						}
					}while(otroPeon);
				}
			}

		}else{

			System.out.println("NO HAY VIAJES DISPONIBLES.");
		}
	}

	public void registrarLlegada(ArrayList<Viajes> viajesList) {
		System.out.println("VIAJES: ");
		boolean hayViajes = false;

		for (int i = 0; i < viajesList.size(); i++) {
			System.out.println(viajesList.get(i).getNroViaje() + " - " + ((viajesList.get(i) instanceof ViajesLarga) ? "LARGA DISTANCIA" : "CORTA DISTANCIA"));
			if(viajesList.get(i) instanceof ViajesLarga) hayViajes = true;
		}
		System.out.println();

		if(hayViajes){
			Viajes viaje = null;
			boolean viajeOk;
			boolean esLargaDistancia;
			do{
				viajeOk = false;
				esLargaDistancia = false;
				int nroViaje = Validador.insertInt("Insertar Numero Viaje: ", 1, null, false);

				for (int i = 0; i < viajesList.size(); i++) {

					if(nroViaje == viajesList.get(i).getNroViaje()){

						viajeOk = true;
						if((viajesList.get(i) instanceof ViajesLarga)){
							viaje = viajesList.get(i);
							esLargaDistancia = true;
						}
						break;
					}
				}

				if(!viajeOk) System.out.println("NO EXISTE EL NUMERO DE VIAJE INGRESADO.");
				else if(!esLargaDistancia) System.out.println("EL VIAJE ES DE CORTA DISTANCIA.");

			}while(!viajeOk || !esLargaDistancia);

			Calendar fechaLlegada = Validador.insertFecha("Ingresar Fecha de llegada: ");
			Validador.insertHora("Ingresar Hora de llegada: ", fechaLlegada);

			((ViajesLarga) viaje).setFechaLlegada(fechaLlegada);
			viaje.getVehiculo().setDisponible(true);

		}else{
			System.out.println("NO HAY VIAJES LARGA DISTANCIA REGISTRADOS.");
		}

	}

	public void mostrarViajesValorAlAzar(ArrayList<Viajes> viajesList) {

		int valorRandom = Validador.generarEnteroRandom(100, 999);

		System.out.println("VALOR GENERADO: " + valorRandom);

		boolean esPrimerResultado = true;
		int cantidadViajesLargaDistanciaPendientes = 0;

		for (int i = 0; i < viajesList.size(); i++) {

			boolean supera = false;
			Viajes viaje = viajesList.get(i);
			double costoFinal = 0;

			if(viaje instanceof ViajesCorta){

				costoFinal = calcularCostoFinal(viaje);				
				if(costoFinal>valorRandom) supera = true;
			}else{

				if(((ViajesLarga) viaje).getFechaLlegada() != null){

					costoFinal = calcularCostoFinal(viaje);					
					if(costoFinal>valorRandom) supera= true;
				}else{

					cantidadViajesLargaDistanciaPendientes++;
				}
			}
			if(supera && esPrimerResultado){

				System.out.println("NUMERO\t\t| FECHA SALIDA\t| PATENTE\t| KILOS\t|\t COSTO TOTAL");
				System.out.println("----------------|---------------|------------------|----------------|---------------");					
				esPrimerResultado = false;
			}
			if(supera){

				System.out.println(viaje.getNroViaje()+"\t|\t "+viaje.getFechaPartida()+"\t|\t "+viaje.getVehiculo().getPatente()
						+"\t|\t "+viaje.getPeso()+"\t|\t "+viaje.calcularCostoTotal());
				System.out.println("\t\t|\t\t|\t\t|\t\t|\t\t");
			}
		}

		if(cantidadViajesLargaDistanciaPendientes>0){

			System.out.println("Se individuaron "+ cantidadViajesLargaDistanciaPendientes + 
					" sin fecha de llegada, por lo tanto no es posible calcular su costo total final.");			
		}
	}

	public void mostrarCantidadViajesCortaDistancia() {
		System.out.println();
		System.out.println("Cantidad de viajes Corta Distancia: " + EmpresaDistribucion.getCantidadViajesCortaDistancia());
	}

	//Comprende peones y peajes.
	public double calcularCostoFinal(Viajes viaje){

		double costoFinal = viaje.calcularCostoTotal();

		int diasViaje = 1;
		if(viaje instanceof ViajesLarga){
			diasViaje = Validador.calcularDiasEntreFechas(viaje.getFechaPartida(), ((ViajesLarga) viaje).getFechaLlegada());
		}

		for(int i=0; i<viaje.getPeones().length; i++){

			costoFinal = costoFinal + (viaje.getPeones()[i].getCosto()*diasViaje); 
		}

		for (int i = 0; i < viaje.getPeajes().size(); i++) {

			costoFinal = costoFinal + (viaje.getPeajes().get(i).getImporte());
		}

		return costoFinal;
	}

	public void mostrarValorCantidadViajesBimestreCheque(ArrayList<Viajes> viajesList) {

		Calendar fechaActual = Calendar.getInstance();
		Calendar fechaBimestre = Calendar.getInstance();
		fechaBimestre.add(Calendar.MONTH, -2);
		double valorTotal = 0.0;
		int cantidadViajesBimestre = 0;

		for (int i = 0; i < viajesList.size(); i++) {

			Viajes viaje = viajesList.get(i);

			if((viaje instanceof ViajesCorta) && !(((ViajesCorta) viaje).isEsEfectivo())){

				if(viaje.getFechaPartida().after(fechaBimestre) && viaje.getFechaPartida().before(fechaActual))
				{
					valorTotal = valorTotal + viaje.calcularCostoTotal();
					cantidadViajesBimestre++;
				}
			}
		}

		DecimalFormat df = new DecimalFormat("0.00");		
		if(cantidadViajesBimestre>0){
			System.out.println("Valor Total Viajes ultimo bimestre: " + df.format(valorTotal));
			System.out.println("Cantidad Viajes ultimo bimestre: " + cantidadViajesBimestre);
		}else{

			System.out.println("NO HUBO VIAJES QUE RESPETAN EL CRITERIO EN EL ULTIMO BIMESTRE.");
		}
	}

	public void mostrarViajePasaronPorLocalidad(ArrayList<Viajes> viajesList) {

		System.out.println();
		String letrasInput = Validador.insertString("Ingresar 3 letras: ");

		for (int i = 0; i < viajesList.size(); i++){

			Viajes viaje = viajesList.get(i);
			boolean localidadOk = false;

			if (viaje instanceof ViajesLarga){
				for (int j= 0; j < ((ViajesLarga)viaje).getLocalidades().size(); j++){

					String localidad = ((ViajesLarga)viaje).getLocalidades().get(j);

					if(letrasInput.charAt(0) == localidad.charAt(0) 
							&& letrasInput.charAt(1) == localidad.charAt(1) 
							&& letrasInput.charAt(2) == localidad.charAt(2)){

						localidadOk = true;
					}
				}

				if(localidadOk){

					System.out.println("Numero Viaje: "+viaje.getNroViaje());

					for (int j = 0; j < viaje.getPeajes().size(); j++){

						Peajes peaje = viaje.getPeajes().get(j);

						System.out.println("PEAJE " + (j+1) + ": ");
						System.out.println("Lugar: " + peaje.getLugar());
						System.out.println("Importe: " + peaje.getImporte());
						System.out.println();
					}

					for (int j = 0; j < viaje.getPeones().length; j++){

						Peones peon = viaje.getPeones()[j];

						System.out.println("PEON " +  (j+1) + ": ");
						System.out.println("Nombre: " +  peon.getNombre());
						System.out.println("Costo: " + peon.getCosto());
					}
				}
			}
		}

	}

	public void mostrarNumerosPatenteNoAsignado(Camiones[] camiones, String[] args) {

		if(args.length>0){
			
			boolean noExisteEnLaBase = false;
			boolean mostroCamion = false;
			
			for (int i = 0; i < args.length; i++) {
				
				String numeroPatente = args[i];
				boolean existeCamion = false;
				
				for (int j = 0; j < camiones.length; j++) {
					
					Camiones camion = camiones[j];
					
					if(camion.getPatente().trim().equals(numeroPatente.trim())){
						
						existeCamion = true;
						if(camion.isDisponible()){
							System.out.println(numeroPatente);
							mostroCamion = true;
						}
						break;
					}
				}
				if(!existeCamion){
					System.out.println("LA PATENTE "+numeroPatente+" NO EXISTE EN NUESTRA BASE.");
					noExisteEnLaBase = true;
				}
			}
			
			if(!noExisteEnLaBase && !mostroCamion) System.out.println("TODOS LOS VEHICULOS FUERON ASIGNADOS.");
		}else{
			System.out.println("NO HAY PARAMETROS INGRESADOS COMO ARGUMENTO.");
		}
	}
}
