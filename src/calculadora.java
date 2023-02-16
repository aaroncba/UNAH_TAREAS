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
		//boolean isValid = true; 
		int contador = 0; 
		String Operador = null; 
		String[] SignosDeOperacion = {"-", "+", "*", "x", "/"};
		for(String Signo : SignosDeOperacion) {
			
			if(Operacion.contains(Signo)) {
				//System.out.println("Entro aqui");
				contador++; 
				Operador = Signo;
				if(Operacion.indexOf(Signo) != Operacion.lastIndexOf(Signo)) {
					contador++; 
				}
			} 
		}
		System.out.println(contador); 
		//Este condicional revisa si existe un signo para operar
		if(contador !=1) {
			System.out.println("Ingreso ninguno o pocos signos");
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
				//System.out.println("--valor es " + Valor + " Numero es " + Numero);
				//System.out.println(Valor.equals(Numero) || Numero.equals(Operador));
				//System.out.println("Valor de Operador " + Operador);
				if(Valor.equals(Numero) || Numero.equals(Operador)) {
					isSame = true; 
				}
			}
			if(!isSame) {
				System.out.println("La operacion ingresada no tiene caracteres que son distintos de: " + Arrays.toString(ValoresAceptados));
				return false; 
			}
		}
		
		//Esta condicional va a revisar si el primer valor y el valor que sigue despues del operador es un punto y que solo se contengan 2 puntos.
		
		if(Operacion.contains(".")){
			System.out.println("Entering here...");
			if(Operacion.indexOf(".") != Operacion.lastIndexOf(".")) {
				String dotContained = Operacion.substring(Operacion.indexOf(".") + 1,  Operacion.lastIndexOf("."));
				if(dotContained.contains(".")) {
					System.out.println("La operacion ingresada mas de 2 puntos.");
					return false;
				}
				if(Operacion.indexOf(Operador) == Operacion.length()-2 && Operacion.lastIndexOf(".") == Operacion.length()-1) {
					System.out.println("Se ingreso un punto como valor");
					return false; 
				}
			}
			System.out.println(Operacion.indexOf(Operador));
			System.out.println(Operacion.indexOf("."));
			if(Operacion.indexOf(".") == 0 && Operacion.indexOf(Operador) == 1) {
				System.out.println("Se ingreso un punto como valor");
				return false; 
			}
		}
		//Este condicional va revisar si la "d" se repite mas de una vez y la "d" solo puede estar en 2 posiciones las cuales son: posicion operado - 1 and/or ultima posicion 
	
		if(Operacion.indexOf("d") != Operacion.lastIndexOf("d")) {
			String dContained = Operacion.substring(Operacion.indexOf("d") + 1,  Operacion.lastIndexOf("d")); 
			if(dContained.contains("d")) {
				System.out.println("La operacion ingresada tiene mas de 2 d");
				return false;
			}
			
		}
		
		//este condicional va a revisar que valores como ".d" se puedan agregar
		
		
		return true; 
	}
	
	public static boolean isValueContained() {
		return false; 
	}
	
	
	public static double OperacionDeDosDigitos(String Operacion) {
		double respuesta = 0; 
		
		return respuesta; 
	}

}
