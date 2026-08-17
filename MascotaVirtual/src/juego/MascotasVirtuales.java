package juego;

import jugador.Jugador;
import mascotas.Mascota;
import mascotas.Mascotas;
import objetos.Consumibles;
import objetos.Hamburguesa;
import objetos.PapasFritas;
import objetos.Pizza;
import objetos.PocionEnergia;
import objetos.PocionFelicidad;
import objetos.PocionHambre;
import objetos.PocionSuciedad;
import objetos.Sushi;
import objetos.Tacos;
import utilidades.Entrada;
import utilidades.Salida;

public class MascotasVirtuales {

	private final Entrada entrada = new Entrada();
	private final Salida salida = new Salida();
	
	public void iniciar() {
		System.out.println("¡Bienvenido a Mascotas Virtuales!\n");
		Jugador jugador = crearJugador();
		iniciarJuego(jugador);
	}
	
	private Jugador crearJugador() {
		System.out.print("Ingrese el nombre del jugador: ");
		String nombre = entrada.ingresarTexto();
		Mascota mascota = elegirMascota();
		return new Jugador(nombre, mascota);
	}

	private Mascota elegirMascota() {
		Mascotas[] mascotas = Mascotas.values();
		int opc = salida.listarYElegir(mascotas, entrada, false);
		return mascotas[opc-1].crearMascota();
	}

	private void iniciarJuego(Jugador jugador) {
		boolean fin = false;
		do {
			Menu opc = mostrarMenuYElegir();
			fin = ejecutarAccion(opc, jugador);
		} while(!fin);
		terminar();
	}

	private Menu mostrarMenuYElegir() {
		Menu[] menu = Menu.values();
		int opc = (salida.listarYElegir(menu, entrada, false) - 1);
		return menu[opc];
	}

	private boolean ejecutarAccion(Menu opc, Jugador jugador) {
		switch(opc) {
			case JUGAR:
				System.out.println("\nNi ganas tengo de hacer esta opcion mi rey.");
				break;
			case BAÑAR:
				bañarMascota(jugador);
				break;
			case DORMIR:
				dormir(jugador);
				break;
			case INVENTARIO:
				accederInventario(jugador);
				break;
			case TIENDA:
				accederTienda(jugador);
				break;
			case ESTADISTICAS:
				mostrarEstadisticas(jugador);
				break;
			case SALIR:
				System.out.println("\n¡Adiós!");
				return true;
			default:
				System.out.println("\nError. Opción no encontrada.");
				break;
		}
		return false;
	}

	private void bañarMascota(Jugador jugador) {
		jugador.getMascota().bañar();
		System.out.println("\nBañaste a " + jugador.getMascota().getNombre() + ".");
		System.out.println("Suciedad actual: " + jugador.getMascota().getSuciedad());
	}

	private void dormir(Jugador jugador) {
		jugador.getMascota().dormir();
		System.out.println("\n" + jugador.getMascota().getNombre() + " durmió y está lleno de energía.");
	}

	private void accederInventario(Jugador jugador) {
		if(jugador.mostrarInventario()) {
			System.out.println("\n1. Utilizar");
			System.out.println("2. Vender");
			System.out.println("3. Salir");
			System.out.print("Seleccione una opción: ");
			int opc = entrada.ingresarEntero(1, 3);
			if(opc == 1 || opc == 2) {
				int opcObj = (salida.listarYElegir(jugador.getInventario(), entrada, false) - 1);
				if(opc == 1) {
					jugador.consumirObjeto(jugador.getInventario()[opcObj]);
				} else {
					jugador.sumarDinero(jugador.getInventario()[opcObj].getPrecioVenta());
					jugador.sacarConsumible(jugador.getInventario()[opcObj]);
				}
			} else if (opc == 3) {
				System.out.println("\nSaliendo de la tienda...");
			} else {
				System.out.println("\nError. Opción no encontrada.");
			}
		}
	}

	private void accederTienda(Jugador jugador) {
		Consumibles[] tienda = Consumibles.values();
		int opcObj = (salida.listarYElegir(tienda, entrada, true) - 1);
		if(opcObj == -1) {
			System.out.println("\nCompra cancelada.");
		} else {
			if(tienda[opcObj].getPrecioCompra() > jugador.getDinero()) {
				System.out.println("\nNo tienes el dinero suficiente para comprar este objeto.");
			} else {
				jugador.restarDinero(tienda[opcObj].getPrecioCompra());
				switch (tienda[opcObj]) {
				    case PAPAS_FRITAS:
				        jugador.agregarConsumible(Consumibles.PAPAS_FRITAS, new PapasFritas());
				        break;
				    case PIZZA:
				        jugador.agregarConsumible(Consumibles.PIZZA, new Pizza());
				        break;
				    case HAMBURGUESA:
				        jugador.agregarConsumible(Consumibles.HAMBURGUESA, new Hamburguesa());
				        break;
				    case TACOS:
				        jugador.agregarConsumible(Consumibles.TACOS, new Tacos());
				        break;
				    case SUSHI:
				        jugador.agregarConsumible(Consumibles.SUSHI, new Sushi());
				        break;
				    case POCION_ENERGIA:
				        jugador.agregarConsumible(Consumibles.POCION_ENERGIA, new PocionEnergia());
				        break;
				    case POCION_FELICIDAD:
				        jugador.agregarConsumible(Consumibles.POCION_FELICIDAD, new PocionFelicidad());
				        break;
				    case POCION_HAMBRE:
				        jugador.agregarConsumible(Consumibles.POCION_HAMBRE, new PocionHambre());
				        break;
				    case POCION_SUCIEDAD:
				        jugador.agregarConsumible(Consumibles.POCION_SUCIEDAD, new PocionSuciedad());
				        break;
				    default:
				    	System.out.println("\nError. Consumible no encontrado.");
				    	break;
				}
				System.out.println("\nObjeto comprado exitosamente.");
			}
		}
	}

	private void mostrarEstadisticas(Jugador jugador) {
		System.out.println("\n--- Estadísticas ---");
		jugador.mostrarDatos();
		System.out.println();
		jugador.getMascota().mostrarDatos();
	}

	public void terminar() {
		entrada.cerrar();
	}
}