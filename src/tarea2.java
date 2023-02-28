import java.util.Scanner;
public class tarea2{
    public static void main(String[] args) {
        triangulo('0', 15);
    }

    //3n+1 function || Collatz Function
    /*
    * Esta funcion va a tomar un valor y seguira lo siguente hasta llegar a 1
    * -> n%2 == 0 ->> n/2
    * -> n%2 != 0 ->> 3n+1
    * hacer ciclo hasta llegar a 0
    * */
    public static void collatz(){
        Scanner input = new Scanner (System.in);
        int value = 0;
        boolean exit = false;
        //revisa si el valor ingresado es un numero positivo
        while(!exit){
            try{
                System.out.println("Ingrese un numero para operarlo: ");
                value = input.nextInt();
                if(value > 0) {
                    exit = true;
                }else{
                    System.out.println("Ingrese un valor que este entre 1 e infinito positivo");
                }
            }catch (Exception e){
                System.out.println("Ingrese un valor valido");
                input.nextLine();
            }
        }
        System.out.print(value);
        while(1 != value){
            if(value % 2 == 0){
                value = value / 2;
            }else{
                value = 3 * value + 1;
            }
            System.out.print(", " + value);
        }
        input.close();
    }


    //parrafo function
    /*
    * Esta funcion va a tomar un string y un int como paramentro:
    * Cada linea va a tener un o mas palabras, que su total de letras (incluyendo el espacio) sean el numero que se dio como paramentro pero con la palabra completa
    * Una vez se complete un linea, se va a pasar a la proxima y se hara lo mismo
    * */
    public static void parrafo(String frase, int margen){
        //borra los espacios dobles
        frase = frase.replaceAll("\\s{2,}", " ").trim();
        String[] palabras = frase.split(" ");
        int count = 0;
        String toPrint;
        for(int i = 0; i < palabras.length; i++){
             if(palabras[i].length() < margen){
                 toPrint = palabras[i] + " ";
                 while(i + 1 < palabras.length){
                     if(i + 1  > margen) break;
                     if(palabras[i + 1].length() > margen) break;
                     if((toPrint.length() + palabras[i + 1].length()) > margen) break;
                     i++;
                     toPrint = toPrint + palabras[i] + " ";
                 }
                 System.out.println(toPrint);
             }else{
                 System.out.println(palabras[i]);
             }

        }
    }


    //triangulo function
    /*
    * Esta funcion va a tomar un char y un int (n) como paramentro
    * Lo que hara con esto es un triangulo invertido, la primer fila tendra el tamaño del int que se dio como paramentro mas un espacio entre cada char
    * La siguente fila sera n - el numero de fila, esto nos dira la cantidad de chars que se tienen que agregar, la cantidad de espacios al inicio de la fila se calculan con
    * -> n - (n - numero de fila)
    * Se estara repitiendo esto hasta llegar a 0
    * */
    public static void triangulo(char figura, int base){
        for(int i = 0; i < base; i++){
            for(int a = 0; a < base - (base - i); a++){
                System.out.print(" ");
            }
            for(int b = 0; b < base - i; b++){
                System.out.print(figura + " ");
            }
            System.out.println();
        }
    }
}
