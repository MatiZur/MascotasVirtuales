package mascotas;

import utilidades.Listable;

public enum Mascotas implements Listable{
	MECCA("Mecca", Tipo.TIERRA),
	KIBO("Kibo", Tipo.FUEGO),
	KOI("Koi", Tipo.AGUA);
	
	private String nombre;
	private Tipo tipo;
	
	private Mascotas(String nombre, Tipo tipo){
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	public Mascota crearMascota() {
		return new Mascota(nombre, tipo);
	}
	
	@Override
	public String getElemento() {
		return (nombre + " - Tipo: " + tipo.getNombre());
	}
}