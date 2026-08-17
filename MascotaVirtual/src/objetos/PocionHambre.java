package objetos;

import mascotas.Mascota;

public class PocionHambre extends Pocion {

	public PocionHambre() {
		super("Poción nutritiva", 15);
	}

	@Override
	public void consumir(Mascota mascota) {
		mascota.modificarHambre(-30);
	}

}