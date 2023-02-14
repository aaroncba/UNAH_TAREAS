import java.util.Scanner; 
public class calculadora {

	public static void main(String[] args) {
		Scanner expresion = new Scanner(System.in);
		System.out.println("Ingrese la expresion que desea");
		String StringToOperate = expresion.nextLine().replaceAll("\\s", ""); 
		System.out.println("This is the answer: " + SplitAndOperate(StringToOperate, "\\+", 0));
		/*
		 * TODO
		 * -Pedirle al usuario que agregue los valores
		 * -mediante un string se guardara la expresion del usuario 
		 * -remover los espacios en el string
		 * -dividir la expresion en 2 partes, siguendo este order: suma, resta, multiplicacion, division
		 * -ver si contiene una suma, o resta: entrara en una funcion que tomara como parametro el operador y luego entrara a la lista de strings y va a intentar ver si hay alguna multiplicaion o  division 
		 * -
		 * -> ejemplo
		 * "10 x 0 + 20"
		 * separa por suma, ya que contains("+") == true
		 * String[] values = {"10x0", "20"}
		 * contains("x") or contains("*"), contains("/")
		 * contains("x") == true
		 * String Newvalues = {"10", "0"}
		 * if contain("/") == false and no letter or other values are there
		 * then proceed with the operator
		 * return the multiplication in double
		 * with this double proceed with the sum with 20 in the last value
		 * return 0+20
		 * */
	}
	public static double SplitAndOperate(String StringOperation, String Operator, double operation){ 
		//revisar si StringOperation is valid
		//aqui se va a pasar por defecto la suma 
		//luego divide por la suma 
		//ver el size de la lista y ver si contiene alguna suma o resta 
		String[] listOperation = StringOperation.split(Operator); 
		//System.out.println();
		int count = 0; 
		for(String value : listOperation) {
			System.out.println(value);
			if(value.contains("-")) {
				operation = SplitAndOperate(value, "/", operation); 
			} 
			else if(value.contains("x") || value.contains("*")) {
				String toSend;
				if(value.contains("x")){
					toSend = "x";
				}else {
					toSend = "*";
				}
				
				operation = SplitAndOperate(value, "\\*", 1); 
			}
			else if(value.contains("/")) {
				operation = SplitAndOperate(value, "\\/", 1);
				
				
			} else {
				switch(Operator) {
				case "\\+":
					System.out.println("Entro aqui con " + value + " and pos");
					operation += Double.parseDouble(value);
					System.out.println(operation);
					break; 
				case "\\-":
					operation -= Double.parseDouble(value);
					break; 
				case "\\*":
					operation *= Double.parseDouble(value);
					break; 
				case "\\/":
					System.out.println("Entro // aqui con " + value + " and pos");
					count ++; 
					//operation += Double.parseDouble(value);
					//
						operation /= Double.parseDouble(value);
					
					
					System.out.println(operation);
					break; 
				}
			}
			
		}
		
		return operation; 
	}
		

}
