package mascotas;

public class Mascota {
	private String nombre;
	private Tipo tipo;
	private int energia = 100;
	private int felicidad = 100;
	private int hambre = 0;
	private int suciedad = 0;
	
	protected Mascota(String nombre, Tipo tipo){
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	public void modificarEnergia(int cantidad) {
	    energia += cantidad;
	    if (energia < 0) {
	    	energia = 0;
	    } else if (energia > 100) {
	    	energia = 100;
	    }
	}
	
	public void modificarFelicidad(int cantidad) {
	    felicidad += cantidad;
	    if (felicidad < 0) {
	    	felicidad = 0;
	    } else if (felicidad > 100) {
	    	felicidad = 100;
	    }
	}
	
	public void modificarHambre(int cantidad) {
	    hambre += cantidad;
	    if (hambre < 0) {
	    	hambre = 0;
	    } else if (hambre > 100) {
	    	hambre = 100;
	    }
	}
	
	public void modificarSuciedad(int cantidad) {
	    suciedad += cantidad;
	    if (suciedad < 0) {
	    	suciedad = 0;
	    } else if (suciedad > 100) {
	    	suciedad = 100;
	    }
	}
	
	public void bañar() {
		int cantidad = 0;
		switch(tipo) {
			case TIERRA:
				cantidad = 25;
				break;
			case FUEGO:
				cantidad = 50;
				break;
			case AGUA:
				cantidad = 100;
				break;
			default:
				System.out.println("Error. Tipo de mascota no encontrado.");
				break;
		}
		suciedad -= cantidad;
		if(suciedad < 0) {
			suciedad = 0;
		}
	}
	
	public void dormir() {
		energia = 100;
		modificarFelicidad(20);
		modificarHambre(20);
		modificarSuciedad(10);
	}
	
	public void mostrarDatos() {
		System.out.println("Mascota: " + nombre);
		System.out.println("Tipo: " + tipo.getNombre());
		System.out.println("Energía: " + energia);
		System.out.println("Felicidad: " + felicidad);
		System.out.println("Hambre: " + hambre);
		System.out.println("Suciedad: " + suciedad);
	}

	public String getNombre() {
		return nombre;
	}
	
	public int getSuciedad() {
		return suciedad;
	}
}