package utilidades;

public final class Salida {

    public void listar(Listable[] listable){
    	System.out.println();
        for (int i = 0; i < listable.length; i++) {
            System.out.println((i+1)+". " + listable[i].getElemento());
        }
    }

    public int listarYElegir(Listable[] listable, Entrada entrada, boolean cancelable) {
        this.listar(listable);
        System.out.print("Seleccione una opción: ");
        if(cancelable) {
        	return entrada.ingresarEntero(0, listable.length);
        } else {
        	return entrada.ingresarEntero(1, listable.length);
        }
    }
}
