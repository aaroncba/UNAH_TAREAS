import java.util.Arrays;
import java.util.Scanner;
public class calculadora {
	//TAREAS TAMBIEN PUEDEN SER ENCONTRADAS EN: https://github.com/aaroncba/UNAH_TAREAS
	public static void main(String[] args) {
		StartOperation(); 
	}
	
	public static void StartOperation() {
		Scanner input = new Scanner(System.in); 
		Scanner Sinput = new Scanner(System.in); 
		boolean start = true; 
		int option = 0;
		
		do {
			PrintMenu(); 
			try {
				
				option = input.nextInt(); 
			}catch(Exception e) {

				input.nextLine();
			}
			switch(option) {
			case 1: 
				String[] errors = {"Estas son las restricciones de la calculadora: ", "Es posible agregar una \"d\" al final de un numero decimal.", "No es posible hacer que un numero sea negativo, agregar \"-\" al prinicipio de un numero y luego agregar un operador causara un error.", 
						"Ingresar letras va a causar un error.", "Agregar \".d\" va a causar un error"}; 
				for(String error : errors) {
					System.out.println("->" + error);
				}
				break;
			case 2: 
				System.out.print("Ingrese la expresion que desea -> ");
				input.reset();
				String StringToOperate = Sinput.nextLine().replaceAll("\\s", "").toLowerCase();  
				boolean repetir = CheckValidOperation(StringToOperate);
				if(repetir) {
					double Respuesta = OperacionDeDosDigitos(StringToOperate);
					printAnswer(Respuesta);
				}
				break; 
			case 3: 
				System.out.println("Saliendo... Un placer ayudarte ;)");
				start = false; 
				break; 
			default: 
				System.out.println("El valor ingresado es incorrecto, ingrese un valor correcto para el menu.");
				break; 
			}
		}while(start);
		
	}
	
	public static void PrintMenu() {
		System.out.println(); 
		System.out.println("CALCULADORA DE 2 DIGITOS A PARTIR DE UN STRING");
		System.out.println("Menu: ");
		System.out.println("1. Restricciones y uso de la calculadora"); 
		System.out.println("2. Calcular");
		System.out.println("3. Salir"); 
	}
	
	public static boolean CheckValidOperation(String Operacion) {
		//boolean isValid = true; 
		int contador = 0; 
		String Operador = getOperador(Operacion);
		if(Operacion.indexOf(Operador) != Operacion.lastIndexOf(Operador) || Operador.equals("-1")) {
			System.out.println("Ingreso ninguno o pocos signos");
			return false;
		}

		//Este condicional revisa si el operador esta en la primera posicion o si esta en la ultima
		if(Operacion.indexOf(Operador) == 0 || Operacion.indexOf(Operador) == Operacion.length()){
			System.out.println("No es posible ingresar ya que \'" + Operador + "\' esta en la posicion 1 o en la ultima posicion" );
			return false; 
		}
		//Este condicional revisa si hay solo numero a excepcion de x (multiplicar) y d (que este tambien puede servir para double)
		String[] ValoresAceptados = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "x", "d", ".", "-", "+"};
		boolean isSame = false; 
		for(int i = 0; i < Operacion.length(); i++) {
			isSame = false; 
			String Numero = Character.toString(Operacion.charAt(i));
			for(String Valor : ValoresAceptados) {
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
		/*
		 * Si la diferencia entre el primer digito y el operador es de 2, y los valores que estan son .d o d. entonces false
		 * si la diferencia entre el operador y le ultimo valor es de 2, y los valores que estan son .d o d. entonces false
		 * de lo contrario va a ser true
		 * */
		if(Operacion.contains("d.")){
			System.out.println("Se ingreso \"d.\"");
			return false;
		}
		if(Operacion.indexOf(".d") == 0 || (Operacion.indexOf(Operador)+1) == Operacion.indexOf(".d")){
			System.out.println("Se ingreso \".d\" como valor, esto es incorrecto");
			return false;
		}
		return true; 
	}
	
	public static String getOperador(String Operacion){
		String operador = null;
		String[] SignosDeOperacion = {"-", "+", "*", "x", "/"};
		for(String Signo : SignosDeOperacion) {
			if(Operacion.contains(Signo)) {
				operador = Signo;
			}
		}
		if(operador == null) operador = "-1";
		if(operador.equals("x")) operador = "*";
		return operador;
	}
	public static double OperacionDeDosDigitos(String Operacion) {
		double respuesta = 0;
		String[] ValoresDeOperacion;
		try{
			String operador = getOperador(Operacion);
			if(operador.equals("*")) operador = "\\*";
			if(operador.equals("+")) operador = "\\+";
			System.out.println("Este es el operador " + operador);
			ValoresDeOperacion = Operacion.split(operador);
			double valor1, valor2;
			switch (operador){
				case "\\*":
					valor1 = Double.parseDouble(ValoresDeOperacion[0]);
					valor2 = Double.parseDouble(ValoresDeOperacion[1]);
					return valor1 * valor2;
				case "\\+":
					valor1 = Double.parseDouble(ValoresDeOperacion[0]);
					valor2 = Double.parseDouble(ValoresDeOperacion[1]);
					return valor1 + valor2;
				case "-":
					valor1 = Double.parseDouble(ValoresDeOperacion[0]);
					valor2 = Double.parseDouble(ValoresDeOperacion[1]);
					return valor1 - valor2;
				case "/":
					valor1 = Double.parseDouble(ValoresDeOperacion[0]);
					valor2 = Double.parseDouble(ValoresDeOperacion[1]);
					if(valor2 == 0.0)System.out.println("La division entre 0 esta indefinida ojito con eso :)");
					return valor1 / valor2;
			}
		}
		catch(Exception e){
			System.out.println(e.toString());
			System.out.println("Ocurrio un error, comunicarse con el desarrollador");
			return 0.0;
		}
		return respuesta; 
	}


	public static void printAnswer(double respuesta){
		// para print "* Respuesta->" se ocupan 14 *
		String ResEnString = Double.toString(respuesta);
		int cantidadAsteriscos = ResEnString.length();
		System.out.println();
		System.out.print("****************");
		for(int i = 0; i < cantidadAsteriscos; i++){
			System.out.print("*");
		}
		System.out.println();
		System.out.println("* Respuesta-> " + ResEnString + " *");
		System.out.print("****************");
		for(int i = 0; i < cantidadAsteriscos; i++){
			System.out.print("*");
		}
	}
}
