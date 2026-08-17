package objetos;

import mascotas.Mascota;

public class PocionEnergia extends Pocion {

	public PocionEnergia() {
		super("Poción energética", 20);
	}

	@Override
	public void consumir(Mascota mascota) {
		mascota.modificarEnergia(30);
	}

}