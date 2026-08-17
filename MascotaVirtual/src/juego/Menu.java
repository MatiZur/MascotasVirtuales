package juego;

import utilidades.Listable;

public enum Menu implements Listable{
	JUGAR("Jugar"),
	BAÑAR("Bañar"),
	DORMIR("Dormir"),
	INVENTARIO("Acceder al inventario"),
	TIENDA("Ir a la tienda"),
	ESTADISTICAS("Ver estadísticas"),
	SALIR("Salir");
	
	private String nombre;
	
	private Menu(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String getElemento() {
		return nombre;
	}
}