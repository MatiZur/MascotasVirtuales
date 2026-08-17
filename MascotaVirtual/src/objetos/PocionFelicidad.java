package objetos;

import mascotas.Mascota;

public class PocionFelicidad extends Pocion {

	public PocionFelicidad() {
		super("Poción de felicidad", 20);
	}

	@Override
	public void consumir(Mascota mascota) {
		mascota.modificarFelicidad(30);
	}

}