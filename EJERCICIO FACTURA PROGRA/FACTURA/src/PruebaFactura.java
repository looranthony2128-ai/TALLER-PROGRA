import java.util.Scanner;

/**
 * Aplicación de prueba de la clase Factura .
 */
public class PruebaFactura {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println(" FERRETERÍA - NUEVA FACTURA ");
        String numeroPieza = leerTexto(entrada, "Número de pieza: ");
        String descripcion = leerTexto(entrada, "Descripción de la pieza: ");
        int cantidad = leerEntero(entrada, "Cantidad: ");
        double precio = leerDecimal(entrada, "Precio por artículo: ");

        Factura factura = new Factura(numeroPieza, descripcion, cantidad, precio);
        mostrarFactura(factura);

        System.out.println("\n Probando los métodos establecer ");
        factura.establecerCantidad(leerEntero(entrada, "Nueva cantidad: "));
        factura.establecerPrecioPorArticulo(leerDecimal(entrada, "Nuevo precio por artículo: "));
        mostrarFactura(factura);
    }

    private static void mostrarFactura(Factura factura) {
        System.out.println("\nPieza:       " + factura.obtenerNumeroPieza());
        System.out.println("Descripción: " + factura.obtenerDescripcionPieza());
        System.out.println("Cantidad:    " + factura.obtenerCantidad());
        System.out.printf("Precio c/u:  $%.2f%n", factura.obtenerPrecioPorArticulo());
        System.out.printf("MONTO TOTAL: $%.2f%n", factura.obtenerMontoFactura());
    }

    private static String leerTexto(Scanner entrada, String mensaje) {
        System.out.print(mensaje);
        return entrada.nextLine().trim();
    }

    /** Repite la pregunta hasta que se escriba un entero válido. */
    private static int leerEntero(Scanner entrada, String mensaje) {
        while (true) {
            try {
                return Integer.parseInt(leerTexto(entrada, mensaje));
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Escriba un número entero.");
            }
        }
    }

    /** Acepta coma o punto como separador decimal. */
    private static double leerDecimal(Scanner entrada, String mensaje) {
        while (true) {
            try {
                return Double.parseDouble(leerTexto(entrada, mensaje).replace(',', '.'));
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Escriba un número (ej: 12.50).");
            }
        }
    }
}