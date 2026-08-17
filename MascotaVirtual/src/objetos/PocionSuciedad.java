package objetos;

import mascotas.Mascota;

public class PocionSuciedad extends Pocion {

	public PocionSuciedad() {
		super("Poción de aseo", 15);
	}

	@Override
	public void consumir(Mascota mascota) {
		mascota.modificarSuciedad(-30);
	}

}