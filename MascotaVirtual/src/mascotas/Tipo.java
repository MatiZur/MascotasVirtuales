package mascotas;

public enum Tipo {
	TIERRA("Tierra"),
	FUEGO("Fuego"),
	AGUA("Agua");
	
	private String nombre;
	
	private Tipo(String nombre){
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
}