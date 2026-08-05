package utilidades;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Entrada {
	private Scanner entrada = new Scanner(System.in);

	public String ingresarTexto() {
		String texto = "";
		boolean error;

		do {
			error = false;
			texto = entrada.nextLine();

			if (texto.trim().isEmpty()){
				System.out.print("\nError. El campo esta vacío.\nIngrese nuevamente: ");
				error = true; 
			}
		} while(error);

		return texto;
	}

	public int ingresarEntero(int min, int max) {
		int num = 0;
		boolean error;

		do {
			error = false;
			try {
				num = entrada.nextInt();

				if (num < min || num > max) {
					System.out.println("\nError. El numero ingresado debe estar entre " + min + " y " + max + ".");
					error = true;
				}
			} catch(InputMismatchException e) {
				System.out.println("\nError. El tipo de dato ingresado es incorrecto.");
				error = true;
			} finally {
				entrada.nextLine();

				if (error) {
					System.out.print("Ingrese nuevamente: ");
				}
			}
		} while(error);

		return num;
	}

	public void cerrar() {
		entrada.close();
	}
}