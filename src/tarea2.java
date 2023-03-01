import java.util.Scanner;
public class tarea2{
    /**
     * PROYECTO EN GITHUB:
     * https://github.com/aaroncba/UNAH_TAREAS/tree/main/src
     * AARON ISAAC COLINDRES BARRALAGA
     * #20221002478
     */

    public static void main(String[] args) {
        menu();
    }

    //este es el menu de opciones, donde el usuario puede elegir el metodo que quiera usar.
    public static void menu(){
        System.out.println("Tarea #2");
        Scanner input = new Scanner(System.in);
        String[] menu = {"MENU", "1)FUNCION Collatz", "2)FUNCION Parrafo", "3)FUNCION Triangulo", "4) Salir", "Ingrese un numero entre 1 y 4"};
        int opcion = 0;
        do{
             for(String toPrint : menu){
                 System.out.println(toPrint);
            }

            try{
                opcion = input.nextInt();
                try {
                    switch (opcion) {
                        case 1 -> {
                            System.out.println("FUNCION 3n+1 O FUNCION COLLATZ");
                            collatz();
                        }
                        case 2 -> {
                            System.out.println("FUNCION PARRAFO");
                            input.nextLine();
                            System.out.println("Ingrese el margen que desea para la frase: ");
                            int margen = input.nextInt();
                            input.nextLine();
                            System.out.println("Ingrese la frase que desea: ");
                            String frase = input.nextLine();
                            parrafo(frase, margen);
                        }
                        case 3 -> {
                            System.out.println("FUNCION TRIANGULO");
                            input.nextLine();
                            //figura va a tomar el primer valor del String que se le de.
                            System.out.println("Ingrese un caracter para el triangulo: ");
                            char figura = input.next().charAt(0);
                            input.nextLine();
                            System.out.println("Ingrese la base para el triangulo: ");
                            int base = input.nextInt();
                            triangulo(figura, base);
                        }
                        case 4 -> System.out.println("SALIENDO");
                        default ->{
                            System.out.println("Valor Ingresado fuera de indice. Intente de nuevo, ingrese un numero entre 1 y 4");
                            System.out.println();
                            System.out.println();
                        }
                    }
                } catch (Exception e){
                    System.out.println("ERROR: Ingrese un valor, valido...");
                }
            }catch(Exception e){
                opcion = 0;
                input.nextLine();
                System.out.println("ERROR: Ingrese un valor valido");
                System.out.println();
                System.out.println();
            }

        }while(opcion != 4);
        input.close();
    }

    //3n+1 function || Collatz Function
    /*
    * Esta funcion va a tomar un valor y seguira lo siguente hasta llegar a 1
    * -> n%2 == 0 ->> n/2
    * -> n%2 != 0 ->> 3n+1
    * hacer ciclo hasta llegar a 0
    * */
    public static void collatz(){
        System.out.println("RESTRICCION: Si la ejecucion del codigo acaba en un numero negativo es por la siguiente razon: ");
        System.out.println("Durante la ejecucion del codigo uno de los valores supero el limite de int que es -> " + Integer.MAX_VALUE +
                " esto ocasiona que se empiece desde el punto menor de int que seria -> " + (-Integer.MAX_VALUE) + "\n \n");
        Scanner inputC = new Scanner (System.in);
        int value = 0;
        boolean exit = false;
        //revisa si el valor ingresado es un numero positivo
        while(!exit){
            try{
                System.out.println("Ingrese un numero para operarlo: ");
                value = inputC.nextInt();
                if(value > 0) {
                    exit = true;
                }else{
                    System.out.println("Ingrese un valor que este entre 1 e infinito positivo");
                }
            }catch (Exception e){
                System.out.println("ERROR: Ingrese un valor valido");
                inputC.nextLine();
            }
        }
        System.out.print(value);
        while(1 != value && -5 != value ){
            if(value % 2 == 0){
                value = value / 2;
            }else{
                value = 3 * value + 1;
            }
            System.out.print(", " + value);
        }
        System.out.println();
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
        if(base == 0){
            System.out.println("NO VALIDO: La base tiene que ser mayor de 0");
        }
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


