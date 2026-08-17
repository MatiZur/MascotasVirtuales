package objetos;

import mascotas.Mascota;
import utilidades.Listable;

public abstract class Consumible implements Listable{
	private String nombre;
	private int precioVenta;
	private int cantidad = 1;
	
	protected Consumible(String nombre, int precioVenta) {
		this.nombre = nombre;
		this.precioVenta = precioVenta;
	}
	
	public abstract void consumir(Mascota mascota);
	
	public void aumentarCantidad() {
		cantidad++;
	}
	
	public void restarCantidad() {
		cantidad--;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public String getElemento() {
		return (nombre + " x" + cantidad + " - Precio venta: " + precioVenta);
	}
}