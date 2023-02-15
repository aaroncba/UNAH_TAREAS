import java.util.Arrays;
import java.util.Scanner; 
public class calculadora {

	public static void main(String[] args) {
		Scanner expresion = new Scanner(System.in);
		boolean repetir = false; 
		String StringToOperate = null; 
		
		//revisa si hay 1 y solo 1 signo en la string, * y x simbolizan una multiplicacion
		while(!repetir) {
			System.out.println("Ingrese la expresion que desea");
			StringToOperate = expresion.nextLine().replaceAll("\\s", "").toLowerCase();  
			repetir = CheckValidOperation(StringToOperate);
			System.out.println("Valor es " + repetir);
		}	
		System.out.println("Aqui va la suma");
		/*
		 * TODO
		 * -Pedirle al usuario que agregue los valores
		 * -mediante un string se guardara la expresion del usuario 
		 * -remover los espacios en el string
		 * -dividir la expresion en 2 partes, siguendo este order: suma, resta, multiplicacion, division
		 * -ver si contiene una suma, o resta: entrara en una funcion que tomara como parametro el operador y luego entrara a la lista de strings y va a intentar ver si hay alguna multiplicaion o  division 
		 * 
		 * 
		 * -exception when division by 0
		 * */
	}
	
	
	public static boolean CheckValidOperation(String Operacion) {
		boolean isValid = true; 
		int contador = 0; 
		String Operador = null; 
		String[] SignosDeOperacion = {"-", "\\+", "\\*", "x", "/"};
		for(String Signo : SignosDeOperacion) {
			if(Operacion.contains(Signo)) {
				contador++; 
				Operador = Signo;
				if(Operacion.indexOf(Signo) != Operacion.lastIndexOf(Signo)) {
					contador++; 
				}
			} 
		}
		//Este condicional revisa si existe un signo para operar
		if(contador !=1) {
			System.out.println("Ingreso muchos o pocos signos, por favor intente agregar una nueva expresion");
			return false; 
		}
		//Este condicional revisa si el operador esta en la primera posicion o si esta en la ultima
		if(Operacion.indexOf(Operador) == 0 || Operacion.indexOf(Operador) == Operacion.length()){
			System.out.println("No es posible ingresar ya que \'" + Operador + "\' esta en la posicion 1 o en la ultima posicion" );
			return false; 
		}
		//Este condicional revisa si hay solo numero a excepcion de x (multiplicar) y d (que este tambien puede servir para double)
		String[] ValoresAceptados = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "x", "d", "."};
		boolean isSame = false; 
		for(int i = 0; i < Operacion.length(); i++) {
			isSame = false; 
			String Numero = Character.toString(Operacion.charAt(i));
			for(String Valor : ValoresAceptados) {
				System.out.println("--valor es " + Valor + " Numero es " + Numero);
				System.out.println(Valor.equals(Numero));
				if(Valor.equals(Numero)) {
					isSame = true; 
				}
			}
			if(!isSame) {
				System.out.println("La operacion ingresada no tiene caracteres que son distintos de " + Arrays.toString(ValoresAceptados));
				return false; 
			}
		}
		//Este condicional va revisar si la "d" esta en el lugar correcto al igual que "." 
		
		return true; 
	}
	
	
	public static double OperacionDeDosDigitos(String Operacion) {
		double respuesta = 0; 
		
		return respuesta; 
	}

}
