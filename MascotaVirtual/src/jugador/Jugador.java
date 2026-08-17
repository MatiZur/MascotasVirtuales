package jugador;

import java.util.LinkedHashMap;

import mascotas.Mascota;
import objetos.Consumible;
import objetos.Consumibles;

public class Jugador {
	
	private String nombre;
	private Mascota mascota;
	private int dinero = 100;
	private LinkedHashMap<Consumibles, Consumible> inventario = new LinkedHashMap<Consumibles, Consumible>();
	
	public Jugador(String nombre, Mascota mascota) {
		this.nombre = nombre;
		this.mascota = mascota;
	}
	
	public void mostrarDatos() {
		System.out.println("Jugador: " + nombre);
		System.out.println("Dinero: " + dinero);
	}
	
	public boolean mostrarInventario() {
		if(inventario.isEmpty()) {
			System.out.println("El inventario está vacío.");
			return false;
		} else {
			System.out.println();
			for (Consumible consumible : inventario.values()) {
		    	System.out.println(consumible.getElemento());
		    }
			return true;
		}
	}
	
	public void agregarConsumible(Consumibles tipo, Consumible consumible) {
	    if (inventario.containsKey(tipo)) {
	        inventario.get(tipo).aumentarCantidad();
	    } else {
	        inventario.put(tipo, consumible);
	    }
	}
	
	public void sacarConsumible(Consumibles tipo) {
	    if (inventario.containsKey(tipo)) {
	        inventario.get(tipo).restarCantidad();
	        if (inventario.get(tipo).getCantidad() == 0) {
		    	inventario.remove(tipo);
		    }
	    } else {
	        System.out.println("Error. No existe objeto en el inventario.");
	    }
	}
	
	public void consumirObjeto(Consumibles tipo) {
		inventario.get(tipo).consumir(mascota);
		sacarConsumible(tipo);
	}
	
	public void sumarDinero(int cantidad) {
		dinero += cantidad;
	}
	
	public void restarDinero(int cantidad) {
		if(cantidad > dinero) {
			System.out.println("Error. No hay suficiente dinero.");
		} else {
			dinero -= cantidad;
		}
	}

	public Mascota getMascota() {
		return mascota;
	}
	
	public Consumibles[] getInventario() {
	    return inventario.keySet().toArray(new Consumibles[0]);
	}
	
	public int getDinero() {
		return dinero;
	}
}