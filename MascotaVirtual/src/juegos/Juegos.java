package juegos;

import utilidades.Listable;

public enum Juegos implements Listable{
	CARA_O_CECA("Cara o Ceca"),
	CRAPS("Craps"),
	ADIVINAR_NUMERO("Adivinar el número");
	
	private String nombre;
	
	private Juegos(String nombre) {
		this.nombre = nombre;
	}
	
	public String getElemento() {
		return nombre;
	}
}