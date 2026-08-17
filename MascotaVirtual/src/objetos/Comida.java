package objetos;

import mascotas.Mascota;

public abstract class Comida extends Consumible {

	private int energia;
    private int felicidad;
    private int hambre;
    private int suciedad;

    public Comida(String nombre, int precioVenta, int energia, int felicidad, int hambre, int suciedad) {
        super(nombre, precioVenta);
        this.energia = energia;
        this.felicidad = felicidad;
        this.hambre = hambre;
        this.suciedad = suciedad;
    }

    @Override
    public void consumir(Mascota mascota) {
        mascota.modificarEnergia(energia);
        mascota.modificarFelicidad(felicidad);
        mascota.modificarHambre(hambre);
        mascota.modificarSuciedad(suciedad);
    }

}
