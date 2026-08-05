package jugador;

public class Jugador {
	
	private String nombre;
	private Mascota mascota;
	private int dinero = 0;
	
	public Jugador(String nombre, Mascota mascota) {
		this.nombre = nombre;
		this.mascota = mascota;
	}
}