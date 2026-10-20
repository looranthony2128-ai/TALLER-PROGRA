import javax.swing.JOptionPane;

/**
 * Aplicación de prueba de la clase Empleado (entrada de datos con JOptionPane).
 * Crea dos empleados, muestra su salario anual, les da un aumento del 10%
 * y vuelve a mostrar el salario anual.
 */
public class PruebaEmpleado {

    private static final double PORCENTAJE_AUMENTO = 0.10;
    private static final int MESES_POR_ANIO = 12;
    private static final String TITULO = "Prueba de Empleado";

    public static void main(String[] args) {
        Empleado empleado1 = crearEmpleado(1);
        Empleado empleado2 = crearEmpleado(2);

        mostrarSalariosAnuales("Salario anual ANTES del aumento", empleado1, empleado2);

        darAumento(empleado1);
        darAumento(empleado2);

        mostrarSalariosAnuales("Salario anual DESPUÉS del aumento del 10%", empleado1, empleado2);
    }

    private static Empleado crearEmpleado(int numero) {
        String nombre = leerTexto("Empleado " + numero + "\nPrimer nombre:");
        String apellido = leerTexto("Empleado " + numero + "\nApellido paterno:");
        double salario = leerDecimal("Empleado " + numero + "\nSalario mensual:");

        Empleado empleado = new Empleado(nombre, apellido, salario);

        if (empleado.obtenerSalarioMensual() == 0.0) {
            JOptionPane.showMessageDialog(null,
                    "El salario debe ser positivo. No se estableció (queda en 0.00).",
                    "Aviso", JOptionPane.WARNING_MESSAGE);
        }
        return empleado;
    }

    private static void darAumento(Empleado empleado) {
        double nuevoSalario = empleado.obtenerSalarioMensual() * (1 + PORCENTAJE_AUMENTO);
        empleado.establecerSalarioMensual(nuevoSalario);
    }

    private static double calcularSalarioAnual(Empleado empleado) {
        return empleado.obtenerSalarioMensual() * MESES_POR_ANIO;
    }

    private static void mostrarSalariosAnuales(String titulo, Empleado... empleados) {
        StringBuilder mensaje = new StringBuilder(titulo + "\n\n");
        for (Empleado e : empleados) {
            mensaje.append(String.format("%s %s: $%.2f%n",
                    e.obtenerPrimerNombre(), e.obtenerApellidoPaterno(), calcularSalarioAnual(e)));
        }
        JOptionPane.showMessageDialog(null, mensaje.toString(), TITULO, JOptionPane.INFORMATION_MESSAGE);
    }

    /** Pide un texto no vacío. Si se presiona Cancelar, el programa termina. */
    private static String leerTexto(String mensaje) {
        while (true) {
            String texto = JOptionPane.showInputDialog(null, mensaje, TITULO, JOptionPane.QUESTION_MESSAGE);
            if (texto == null) {
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
                System.exit(0);
            }
            if (!texto.trim().isEmpty()) {
                return texto.trim();
            }
            JOptionPane.showMessageDialog(null, "No puede estar vacío.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    /** Repite la pregunta hasta recibir un número válido. Acepta coma o punto decimal. */
    private static double leerDecimal(String mensaje) {
        while (true) {
            try {
                return Double.parseDouble(leerTexto(mensaje).replace(',', '.'));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Escriba un número válido (ej: 1500.50).",
                        "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}