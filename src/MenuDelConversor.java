import java.util.Scanner;

public class MenuDelConversor {
    Scanner entradaDeDato = new Scanner(System.in);
    ConsultaMonedaApi consulta = new ConsultaMonedaApi();
    ConversionDeMoneda convertirMoneda = new ConversionDeMoneda();
    int opcion = 0;

    public void mostrarMenu() {

    while(true){
        System.out.println("""
                \n***************************************
                Bienvenido al conversor de Monedas :]
                ***************************************
                """);
        System.out.println("Lista de conversiones");
        System.out.println("1) Dolar => Peso Argentino");
        System.out.println("2) Peso Argentino => Dolar");
        System.out.println("3) Dolar => Peso Brasilero");
        System.out.println("4) Yen => Peso Argentino");
        System.out.println("5) Salir");
        System.out.println("******************************\n");

        System.out.print("Elija una opcion valida: ");
        opcion = entradaDeDato.nextInt();

        if(opcion == 5){
            System.out.println("Gracias por usar el conversor de monedas");
            break;
        } else if (opcion>0 && opcion<5) {

        System.out.print("Ingrese el valor que desea convertir: ");
        double cantidad = entradaDeDato.nextDouble();

        String baseCode = "", conversion = "";

        switch (opcion){
            case 1:
                baseCode = "USD";
                conversion = "ARS";
                break;
            case 2:
                baseCode = "ARS";
                conversion = "USD";
                break;
            case 3:
                baseCode = "USD";
                conversion = "BRL";
                break;
            case 4:
                baseCode = "JPY";
                conversion = "ARS";
                break;
            default:
                System.out.println("Opcion no valida de conversion");
                break;
        }
        try{
            Moneda moneda = consulta.busquedaMoneda(baseCode);
            double tasaAConvertir = moneda.conversion_rates().get(conversion);
            double resultado = convertirMoneda.convertir(cantidad,tasaAConvertir);
            System.out.println("El valor " + cantidad + " " + baseCode + " corresponde al valor final de" + " " + resultado  + " "+ conversion);

        }catch (Exception e){
            System.out.println("Error al realizar la conversion..");
        }
        }
        else{
            System.out.println("La opcion ingresada no es valida");
        }
    }
        entradaDeDato.close();
    }

}
