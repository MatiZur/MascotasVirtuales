package objetos;

import utilidades.Listable;

public enum Consumibles implements Listable{
	PAPAS_FRITAS("Papas Fritas", 5, 2),
	PIZZA("Pizza", 10, 4),
	HAMBURGUESA("Hamburguesa", 30, 10),
	TACOS("Tacos", 45, 20),
	SUSHI("Sushi", 75, 30),
	POCION_ENERGIA("Poción energética", 50, 20),
	POCION_FELICIDAD("Poción de felicidad", 50, 20),
	POCION_HAMBRE("Poción nutritiva", 40, 15),
	POCION_SUCIEDAD("Poción de aseo", 40, 15);
	
	private String nombre;
	private int precioCompra;
	private int precioVenta;
	
	private Consumibles(String nombre, int precioCompra, int precioVenta) {
		this.nombre = nombre;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
	}
	
	public int getPrecioCompra() {
		return precioCompra;
	}
	
	public int getPrecioVenta() {
		return precioVenta;
	}

	@Override
	public String getElemento() {
		return (nombre + " | Precio compra: " + precioCompra + " - Precio venta: " + precioVenta);
	}
}
